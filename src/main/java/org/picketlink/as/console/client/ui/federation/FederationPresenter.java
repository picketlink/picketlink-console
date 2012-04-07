/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2006, Red Hat Middleware LLC, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.picketlink.as.console.client.ui.federation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jboss.as.console.client.Console;
import org.jboss.as.console.client.domain.model.SimpleCallback;
import org.jboss.as.console.client.shared.BeanFactory;
import org.jboss.as.console.client.shared.dispatch.DispatchAsync;
import org.jboss.as.console.client.shared.model.DeploymentRecord;
import org.jboss.as.console.client.shared.model.ResponseWrapper;
import org.jboss.as.console.client.shared.subsys.RevealStrategy;
import org.jboss.as.console.spi.Subsystem;
import org.jboss.ballroom.client.layout.LHSHighlightEvent;
import org.picketlink.as.console.client.NameTokens;
import org.picketlink.as.console.client.PicketLinkConsoleFramework;
import org.picketlink.as.console.client.shared.subsys.model.Federation;
import org.picketlink.as.console.client.shared.subsys.model.FederationStore;
import org.picketlink.as.console.client.shared.subsys.model.IdentityProvider;
import org.picketlink.as.console.client.shared.subsys.model.ServiceProvider;
import org.picketlink.as.console.client.shared.subsys.model.TrustDomain;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.Place;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.Proxy;

/**
 * <p>
 * The presenter for the PicketLink -> Federation menu item.
 * </p>
 * 
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since 03/01/2011
 */
public class FederationPresenter extends Presenter<FederationPresenter.MyView, FederationPresenter.MyProxy> implements DeploymentCallback {

    public interface MyView extends View {
        void setPresenter(FederationPresenter presenter);

        /**
         * <p>
         * Returns the current selected federation instance.
         * </p>
         * 
         * @return
         */
        Federation getCurrentFederation();

        /**
         * 
         */
        void initialLoad();

        /**
         * @param selectedFederation
         */
        void setSelectedFederation(String selectedFederation);

        /**
         * @param name
         * @param modules
         * @param resourceExists
         */
        void setIdentityProviders(String name, List<IdentityProvider> modules);

        /**
         * @param string 
         * @param result
         * @param b 
         */
        void setServiceProviders(String string, List<ServiceProvider> result);

        /**
         * @param result
         */
        void setTrustedDomains(List<TrustDomain> result);
    }

    @ProxyCodeSplit
    @NameToken(NameTokens.FEDERATION)
    @Subsystem(name="Federation", group = "PicketLink", key="logging")
    public interface MyProxy extends Proxy<FederationPresenter>, Place {
    }

    private final RevealStrategy revealStrategy;
    private final FederationStore federationStore;
    private final DeploymentManager deploymentManager;
    private final PlaceManager placeManager;
    private final DispatchAsync dispatcher;

    private List<DeploymentRecord> availableDeployments;
    private String selectedFederation;

    @Inject
    public FederationPresenter(final EventBus eventBus, BeanFactory beanFactory, final MyView view, final MyProxy proxy,
            final PlaceManager placeManager, RevealStrategy revealStrategy, FederationStore federationStore,
            DeploymentManager deploymentManager, DispatchAsync dispatcher) {
        super(eventBus, view, proxy);
        this.revealStrategy = revealStrategy;
        this.federationStore = federationStore;
        this.deploymentManager = deploymentManager;
        this.placeManager = placeManager;
        this.dispatcher = dispatcher;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.gwtplatform.mvp.client.PresenterWidget#onReveal()
     */
    @Override
    protected void onReveal() {
        super.onReveal();
        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
            @Override
            public void execute() {
                fireEvent(new LHSHighlightEvent("unused", "PicketLink", "profiles"));
            }
        });
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.gwtplatform.mvp.client.Presenter#revealInParent()
     */
    @Override
    protected void revealInParent() {
        this.revealStrategy.revealInParent(this);
    }

    @Override
    public void prepareFromRequest(PlaceRequest request) {
        super.prepareFromRequest(request);
        this.selectedFederation = request.getParameter("name", null);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.gwtplatform.mvp.client.HandlerContainerImpl#onBind()
     */
    @Override
    protected void onBind() {
        super.onBind();
        this.deploymentManager.loadDeployments(this);
        getView().setPresenter(this);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.gwtplatform.mvp.client.PresenterWidget#onReset()
     */
    @Override
    protected void onReset() {
        super.onReset();
        getView().initialLoad();
        getView().setSelectedFederation(this.selectedFederation);
    }

    /**
     * <p>
     * Loads the federation instances from the subsystem.
     * </p>
     */
    private void loadFederations() {
        this.federationStore.loadFederations(new SimpleCallback<List<Federation>>() {

            @Override
            public void onSuccess(List<Federation> result) {
                if (!result.isEmpty()) {
                    loadIdentityProvider(result.get(0));
                    loadServiceProviders(result.get(0));
                }
            }
        });
    }

    /**
     * <p>
     * Loads the federation instances from the subsystem.
     * </p>
     */
    public void loadIdentityProvider(final Federation federation) {
        this.federationStore.loadIdentityProviders(federation, new SimpleCallback<List<IdentityProvider>>() {
            @Override
            public void onSuccess(List<IdentityProvider> result) {
                if (!result.isEmpty()) {
                    getView().setIdentityProviders(federation.getName(), result);
                    loadTrustDomain(federation, result.get(0));
                } else {
                    getView().setIdentityProviders(federation.getName(), new ArrayList());
                    loadTrustDomain(federation, null);
                }
            }
        });
    }

    /**
     * <p>
     * Loads the service providers instances from the subsystem, given a selected federation instance.
     * </p>
     * 
     * @param federation
     */
    public void loadServiceProviders(final Federation federation) {
        this.federationStore.loadServiceProviders(federation, new SimpleCallback<List<ServiceProvider>>() {
            @Override
            public void onSuccess(List<ServiceProvider> result) {
                getView().setServiceProviders(federation.getName(), result);
            }
        });
    }

    /**
     * <p>
     * Loads the service providers instances from the subsystem, given a selected federation instance.
     * </p>
     * @param federation 
     * 
     * @param federation
     */
    public void loadTrustDomain(Federation federation, IdentityProvider identityProvider) {
        if (identityProvider != null) {
            this.federationStore.loadTrustDomains(federation, identityProvider,
                    new SimpleCallback<List<TrustDomain>>() {
                        @Override
                        public void onSuccess(List<TrustDomain> result) {
                            getView().setTrustedDomains(result);
                        }
                    });
        } else {
            getView().setTrustedDomains(new ArrayList());
        }
    }

    /**
     * <p>
     * Creates the given federation instance in the subsystem.
     * </p>
     * 
     * @param federation
     */
    public void onCreateFederation(final Federation federation) {
        this.federationStore.createFederation(federation, new SimpleCallback<ResponseWrapper<Boolean>>() {

            @Override
            public void onSuccess(ResponseWrapper<Boolean> result) {
                if (result.getUnderlying()) {
                    Console.info(Console.MESSAGES.added(PicketLinkConsoleFramework.getConstants().common_label_federation()
                            + " ")
                            + federation.getName());
                    loadFederations();
                } else
                    Console.error(
                            Console.MESSAGES.addingFailed(PicketLinkConsoleFramework.getConstants().common_label_federation()
                                    + " " + federation.getName()), result.getResponse().toString());
            }
        });
    }

    /**
     * <p>
     * Removes the selected federation instance from the subsystem.
     * </p>
     * 
     * @param federation
     */
    public void onRemoveFederation(final Federation federation) {
        this.federationStore.deleteFederation(federation, new SimpleCallback<Boolean>() {
            @Override
            public void onSuccess(Boolean success) {
                if (success) {
                    Console.info(Console.MESSAGES.deleted(PicketLinkConsoleFramework.getConstants().common_label_federation()
                            + " ")
                            + federation.getName());
                } else {
                    Console.error(Console.MESSAGES.deletionFailed(PicketLinkConsoleFramework.getConstants()
                            .common_label_federation() + " ")
                            + federation.getName());
                }

                loadFederations();
            }
        });
    }

    /**
     * @param updatedEntity
     */
    public void onRemoveTrustDomain(IdentityProvider identityProvider, final TrustDomain trustDomain) {
        this.federationStore.deleteTrustDomain(getView().getCurrentFederation(), identityProvider, trustDomain,
                new SimpleCallback<Boolean>() {
                    @Override
                    public void onSuccess(Boolean success) {
                        if (success) {
                            Console.info(Console.MESSAGES.deleted(PicketLinkConsoleFramework.getConstants()
                                    .common_label_trustDomain() + " ")
                                    + trustDomain.getName());
                        } else {
                            Console.error(Console.MESSAGES.deletionFailed(PicketLinkConsoleFramework.getConstants()
                                    .common_label_trustDomain() + " ")
                                    + trustDomain.getName());
                        }

                        loadFederations();
                    }
                });
    }

    /**
     * @param serviceProvider
     */
    public void onRemoveServiceProvider(final ServiceProvider serviceProvider) {
        this.federationStore.deleteServiceProvider(getView().getCurrentFederation(), serviceProvider,
                new SimpleCallback<Boolean>() {
                    @Override
                    public void onSuccess(Boolean success) {
                        if (success) {
                            Console.info(Console.MESSAGES.deleted(PicketLinkConsoleFramework.getConstants()
                                    .common_label_serviceProvider() + " ")
                                    + serviceProvider.getName());
                        } else {
                            Console.error(Console.MESSAGES.deletionFailed(PicketLinkConsoleFramework.getConstants()
                                    .common_label_serviceProvider() + " ")
                                    + serviceProvider.getName());
                        }

                        loadFederations();
                    }
                });
        this.restartServiceProvider(serviceProvider);
    }

    /**
     * <p>
     * Creates an identity provider instance fiven a federation.
     * </p>
     * 
     * @param resourceExists
     * 
     * @param changeset
     */
    public void onCreateIdentityProvider(final IdentityProvider identityProvider) {
        this.federationStore.createIdentityProvider(this.getView().getCurrentFederation(), identityProvider,
                new SimpleCallback<ResponseWrapper<Boolean>>() {
                    @Override
                    public void onSuccess(ResponseWrapper<Boolean> result) {
                        if (result.getUnderlying()) {
                            Console.info(Console.MESSAGES.added(PicketLinkConsoleFramework.getConstants()
                                    .common_label_identityProvider() + " ")
                                    + identityProvider.getName());
                            loadFederations();
                        } else
                            Console.error(Console.MESSAGES.addingFailed(PicketLinkConsoleFramework.getConstants()
                                    .common_label_identityProvider() + " " + identityProvider.getName()), result.getResponse()
                                    .toString());
                    }
                });

        this.restartIdentityProvider(identityProvider);
    }

    /**
     * @param identityProvider
     */
    public void onRemoveIdentityProvider(final IdentityProvider identityProvider) {
        this.federationStore.deleteIdentityProvider(getView().getCurrentFederation(), identityProvider,
                new SimpleCallback<Boolean>() {
                    @Override
                    public void onSuccess(Boolean success) {
                        if (success) {
                            Console.info(Console.MESSAGES.deleted(PicketLinkConsoleFramework.getConstants()
                                    .common_label_identityProvider() + " ")
                                    + identityProvider.getName());
                        } else {
                            Console.error(Console.MESSAGES.deletionFailed(PicketLinkConsoleFramework.getConstants()
                                    .common_label_identityProvider() + " ")
                                    + identityProvider.getName());
                        }

                        loadFederations();
                    }
                });
        this.restartIdentityProvider(identityProvider);
    }

    /**
     * <p>
     * Updates an identity provider instance fiven a federation.
     * </p>
     * 
     * @param changedValues
     */
    public void onUpdateIdentityProvider(final IdentityProvider identityProvider, final Map<String, Object> changedValues) {
        if (changedValues.size() > 0) {
            this.federationStore.updateIdentityProvider(getView().getCurrentFederation(), identityProvider, changedValues,
                    new SimpleCallback<ResponseWrapper<Boolean>>() {
                        @Override
                        public void onSuccess(ResponseWrapper<Boolean> response) {
                            if (response.getUnderlying())
                                Console.info(Console.MESSAGES.saved(PicketLinkConsoleFramework.getConstants()
                                        .common_label_identityProvider() + " " + identityProvider.getName()));
                            else
                                Console.error(
                                        Console.MESSAGES.saveFailed(PicketLinkConsoleFramework.getConstants()
                                                .common_label_identityProvider() + " ")
                                                + identityProvider.getName(), response.getResponse().toString());

                            loadIdentityProvider(getView().getCurrentFederation());
                        }

                    });
        }
    }
    
    /**
     * @param currentSelection
     * @param changedValues
     */
    public void onUpdateServiceProvider(final ServiceProvider currentSelection, Map<String, Object> changedValues) {
        if (changedValues.size() > 0) {
            this.federationStore.updateServiceProvider(getView().getCurrentFederation(), currentSelection, changedValues,
                    new SimpleCallback<ResponseWrapper<Boolean>>() {
                        @Override
                        public void onSuccess(ResponseWrapper<Boolean> response) {
                            if (response.getUnderlying())
                                Console.info(Console.MESSAGES.saved(PicketLinkConsoleFramework.getConstants()
                                        .common_label_serviceProvider() + " " + currentSelection.getName()));
                            else
                                Console.error(
                                        Console.MESSAGES.saveFailed(PicketLinkConsoleFramework.getConstants()
                                                .common_label_serviceProvider() + " ")
                                                + currentSelection.getName(), response.getResponse().toString());

                            loadIdentityProvider(getView().getCurrentFederation());
                        }

                    });
        }
    }

    /**
     * @param serviceProvider
     */
    public void onCreateServiceProvider(final ServiceProvider serviceProvider) {
        this.federationStore.createServiceProvider(this.getView().getCurrentFederation(), serviceProvider,
                new SimpleCallback<ResponseWrapper<Boolean>>() {
                    @Override
                    public void onSuccess(ResponseWrapper<Boolean> result) {
                        if (result.getUnderlying()) {
                            Console.info(Console.MESSAGES.added(PicketLinkConsoleFramework.getConstants()
                                    .common_label_serviceProvider() + " ")
                                    + serviceProvider.getName());
                            loadFederations();
                        } else
                            Console.error(Console.MESSAGES.addingFailed(PicketLinkConsoleFramework.getConstants()
                                    .common_label_serviceProvider() + " " + serviceProvider.getName()), result.getResponse()
                                    .toString());
                    }
                });
        this.restartServiceProvider(serviceProvider);
    }

    /**
     * @param identityProvider 
     * @param updatedEntity
     */
    public void onCreateTrustDomain(IdentityProvider identityProvider, final TrustDomain trustDomain) {
        this.federationStore.createTrustDomain(this.getView().getCurrentFederation(), identityProvider,
                trustDomain, new SimpleCallback<ResponseWrapper<Boolean>>() {

                    @Override
                    public void onSuccess(ResponseWrapper<Boolean> result) {
                        if (result.getUnderlying()) {
                            Console.info(Console.MESSAGES.added(PicketLinkConsoleFramework.getConstants()
                                    .common_label_trustDomain() + " ")
                                    + trustDomain.getName());
                            loadFederations();
                        } else
                            Console.error(
                                    Console.MESSAGES.addingFailed(PicketLinkConsoleFramework.getConstants()
                                            .common_label_trustDomain() + " "), result.getResponse().toString());
                    }
                });
    }

    public void restartIdentityProvider(IdentityProvider identityProvider) {
        identityProvider.setName(identityProvider.getName());
        identityProvider.setRuntimeName(identityProvider.getName());

        this.deploymentManager.enableDisableDeployment(identityProvider);
    }

    public void restartServiceProvider(ServiceProvider serviceProvider) {
        serviceProvider.setName(serviceProvider.getName());
        serviceProvider.setRuntimeName(serviceProvider.getName());

        this.deploymentManager.enableDisableDeployment(serviceProvider);
    }

    /**
     * @return the availableDeployments
     */
    public List<DeploymentRecord> getAvailableDeployments() {
        return this.availableDeployments;
    }

    /**
     * @return
     */
    public PlaceManager getPlaceManager() {
        return this.placeManager;
    }

    /**
     * @param currentSelection
     */
    public void updateFederationSelection(final Federation currentSelection) {
        loadIdentityProvider(currentSelection);
        loadServiceProviders(currentSelection);
    }

    /* (non-Javadoc)
     * @see org.picketlink.as.console.client.ui.federation.DeploymentCallback#onLoadDeployments(java.util.List)
     */
    @Override
    public void onLoadDeployments(List<DeploymentRecord> deployments) {
        this.availableDeployments = deployments;
    }

    public DispatchAsync getDispatchAsync() {
        return this.dispatcher;
    }

}
