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

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.jboss.as.console.client.Console;
import org.jboss.as.console.client.domain.model.ServerGroupRecord;
import org.jboss.as.console.client.domain.model.SimpleCallback;
import org.jboss.as.console.client.shared.deployment.DeployCommandExecutor;
import org.jboss.as.console.client.shared.dispatch.impl.DMRResponse;
import org.jboss.as.console.client.shared.model.DeploymentRecord;
import org.jboss.as.console.client.shared.model.DeploymentStore;
import org.jboss.as.console.client.shared.model.ResponseWrapper;
import org.jboss.as.console.client.shared.subsys.RevealStrategy;
import org.jboss.ballroom.client.layout.LHSHighlightEvent;
import org.jboss.ballroom.client.widgets.window.Feedback;
import org.jboss.dmr.client.ModelNode;
import org.picketlink.as.console.client.BeanFactory;
import org.picketlink.as.console.client.NameTokens;
import org.picketlink.as.console.client.shared.subsys.model.Federation;
import org.picketlink.as.console.client.shared.subsys.model.FederationStore;
import org.picketlink.as.console.client.shared.subsys.model.IdentityProvider;
import org.picketlink.as.console.client.shared.subsys.model.ServiceProvider;
import org.picketlink.as.console.client.shared.subsys.model.TrustDomain;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.Place;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.Proxy;

/**
 * <p>
 * The presenter for the PicketLink -> Federation menu item.
 * </p>
 * 
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since 03/01/2011
 */
public class FederationPresenter extends Presenter<FederationPresenter.MyView, FederationPresenter.MyProxy> implements DeployCommandExecutor {

    public interface MyView extends View {
        void setPresenter(FederationPresenter presenter);

        /**
         * <p>
         * Updates the view with federations instances configured in the subsystem.
         * </p>
         * 
         * @param federations
         */
        void updateFederations(List<Federation> federations);

        /**
         * <p>
         * Updates the view with informations about a identity provider.
         * </p>
         * 
         * @param identityProviders
         */
        void updateIdentityProviders(List<IdentityProvider> identityProviders);

        /**
         * <p>
         * Updates the view with informations about service providers.
         * </p>
         * 
         * @param serviceProviders
         */
        void updateServiceProviders(List<ServiceProvider> serviceProviders);

        /**
         * <p>
         * Returns the current selected federation instance.
         * </p>
         * 
         * @return
         */
        Federation getCurrentFederation();

        /**
         * @return
         */
        IdentityProvider getIdentityProvider();

        /**
         * @param result
         */
        void updateTrustDomains(List<TrustDomain> result);
    }

    @ProxyCodeSplit
    @NameToken(NameTokens.FEDERATION)
    public interface MyProxy extends Proxy<FederationPresenter>, Place {
    }

    private final RevealStrategy revealStrategy;
    private final FederationStore federationStore;
    private final DeploymentStore deploymentStore;
    private final BeanFactory beanFactory;
    private List<DeploymentRecord> availableDeployments;

    @Inject
    public FederationPresenter(final EventBus eventBus, BeanFactory beanFactory, final MyView view, final MyProxy proxy,
            final PlaceManager placeManager, RevealStrategy revealStrategy, FederationStore federationStore,
            DeploymentStore deploymentStore) {
        super(eventBus, view, proxy);
        this.revealStrategy = revealStrategy;
        this.federationStore = federationStore;
        this.deploymentStore = deploymentStore;
        this.beanFactory = beanFactory;
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

    /*
     * (non-Javadoc)
     * 
     * @see com.gwtplatform.mvp.client.HandlerContainerImpl#onBind()
     */
    @Override
    protected void onBind() {
        super.onBind();
        loadDeployments();
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
        loadFederations();
    }

    /**
     * @return the availableDeployments
     */
    public List<DeploymentRecord> getAvailableDeployments() {
        return this.availableDeployments;
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
                getView().updateFederations(result);
                loadIdentityProvider(getView().getCurrentFederation());
            }
        });
    }

    public void loadDeployments() {
        // load deployments
        deploymentStore.loadDeploymentContent(new SimpleCallback<List<DeploymentRecord>>() {

            @Override
            public void onSuccess(List<DeploymentRecord> result) {
                availableDeployments = result;
            }
        });
    }

    /**
     * <p>
     * Loads the federation instances from the subsystem.
     * </p>
     */
    public void loadIdentityProvider(Federation federation) {
        this.federationStore.loadIdentityProviders(federation, new SimpleCallback<List<IdentityProvider>>() {
            @Override
            public void onSuccess(List<IdentityProvider> result) {
                getView().updateIdentityProviders(result);
                loadTrustDomain();
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
    public void loadServiceProviders(Federation federation) {
        this.federationStore.loadServiceProviders(federation, new SimpleCallback<List<ServiceProvider>>() {
            @Override
            public void onSuccess(List<ServiceProvider> result) {
                getView().updateServiceProviders(result);
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
    public void loadTrustDomain() {
        if (getView().getIdentityProvider() != null) {
            this.federationStore.loadTrustDomains(getView().getCurrentFederation(), getView().getIdentityProvider(), new SimpleCallback<List<TrustDomain>>() {
                @Override
                public void onSuccess(List<TrustDomain> result) {
                    getView().updateTrustDomains(result);
                }
            });
        } else {
            getView().updateTrustDomains(Collections.EMPTY_LIST);
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
                    Console.info(Console.MESSAGES.added("Federation ") + federation.getAlias());
                    loadFederations();
                } else
                    Console.error(Console.MESSAGES.addingFailed("Federation " + federation.getAlias()), result.getResponse()
                            .toString());
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
                    Console.info(Console.MESSAGES.deleted("Federation ") + federation.getAlias());
                } else {
                    Console.error(Console.MESSAGES.deletionFailed("Federation ") + federation.getAlias());
                }

                loadFederations();
            }
        });
    }
    
    /**
     * @param updatedEntity
     */
    public void onRemoveTrustDomain(final TrustDomain trustDomain) {
        this.federationStore.deleteTrustDomain(getView().getCurrentFederation(), getView().getIdentityProvider(), trustDomain, new SimpleCallback<Boolean>() {
            @Override
            public void onSuccess(Boolean success) {

                if (success) {
                    Console.info(Console.MESSAGES.deleted("Trusted Domain ") + trustDomain.getName());
                } else {
                    Console.error(Console.MESSAGES.deletionFailed("Trusted Domain ") + trustDomain.getName());
                }

                loadFederations();
            }
        });
    }
    
    /**
     * @param serviceProvider
     */
    public void onRemoveServiceProvider(final ServiceProvider serviceProvider) {
        this.federationStore.deleteServiceProvider(getView().getCurrentFederation(), serviceProvider, new SimpleCallback<Boolean>() {
            @Override
            public void onSuccess(Boolean success) {

                if (success) {
                    Console.info(Console.MESSAGES.deleted("Service Provider ") + serviceProvider.getAlias());
                } else {
                    Console.error(Console.MESSAGES.deletionFailed("Service Provider ") + serviceProvider.getAlias());
                }

                loadFederations();
            }
        });
        this.restartServiceProvider(serviceProvider);
    }


    /**
     * @return
     */
    public BeanFactory getBeanFactory() {
        return this.beanFactory;
    }

    /**
     * <p>
     * Creates an identity provider instance fiven a federation.
     * </p>
     * 
     * @param changeset
     */
    public void onCreateIdentityProvider(final IdentityProvider identityProvider) {
        this.federationStore.createIdentityProvider(this.getView().getCurrentFederation(), identityProvider,
                new SimpleCallback<ResponseWrapper<Boolean>>() {

                    @Override
                    public void onSuccess(ResponseWrapper<Boolean> result) {
                        if (result.getUnderlying()) {
                            Console.info(Console.MESSAGES.added("Identity Provider ") + identityProvider.getAlias());
                            loadFederations();
                        } else
                            Console.error(Console.MESSAGES.addingFailed("Identity Provider " + identityProvider.getAlias()),
                                    result.getResponse().toString());
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
                                Console.info(Console.MESSAGES.saved("Identity Provider " + identityProvider.getAlias()));
                            else
                                Console.error(Console.MESSAGES.saveFailed("Identity Provider ") + identityProvider.getAlias(),
                                        response.getResponse().toString());

                            loadIdentityProvider(getView().getCurrentFederation());
                        }

                    });
            restartIdentityProvider(identityProvider);
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
                            Console.info(Console.MESSAGES.added("Service Provider ") + serviceProvider.getAlias());
                            loadFederations();
                        } else
                            Console.error(Console.MESSAGES.addingFailed("Service Provider " + serviceProvider.getAlias()),
                                    result.getResponse().toString());
                    }
                });
        this.restartServiceProvider(serviceProvider);
    }
    
    /**
     * @param updatedEntity
     */
    public void onCreateTrustDomain(final TrustDomain trustDomain) {
        this.federationStore.createTrustDomain(this.getView().getCurrentFederation(), this.getView().getIdentityProvider(), trustDomain,
                new SimpleCallback<ResponseWrapper<Boolean>>() {

                    @Override
                    public void onSuccess(ResponseWrapper<Boolean> result) {
                        if (result.getUnderlying()) {
                            Console.info(Console.MESSAGES.added("Trust Domain ") + trustDomain.getName());
                            loadFederations();
                        } else
                            Console.error(Console.MESSAGES.addingFailed("Trust Domain " + trustDomain.getName()),
                                    result.getResponse().toString());
                    }
                });
        loadTrustDomain();
        restartIdentityProvider(getView().getIdentityProvider());
    }

    
    public void restartIdentityProvider(IdentityProvider identityProvider) {
        identityProvider.setName(identityProvider.getAlias());
        identityProvider.setRuntimeName(identityProvider.getAlias());
        
        this.enableDisableDeployment(identityProvider);
    }

    public void restartServiceProvider(ServiceProvider serviceProvider) {
        serviceProvider.setName(serviceProvider.getAlias());
        serviceProvider.setRuntimeName(serviceProvider.getAlias());
        
        this.enableDisableDeployment(serviceProvider);
    }

    public void enableDisableDeployment(final DeploymentRecord record) {

        final PopupPanel loading = Feedback.loading(
                Console.CONSTANTS.common_label_plaseWait(),
                Console.CONSTANTS.common_label_requestProcessed(),
                new Feedback.LoadingCallback() {
                    @Override
                    public void onCancel() {

                    }
                });
        
        record.setEnabled(true);
        
        deploymentStore.enableDisableDeployment(record, new SimpleCallback<DMRResponse>() {

            @Override
            public void onSuccess(DMRResponse response) {
                loading.hide();

                ModelNode result = response.get();

                if(result.isFailure())
                {
                    Console.error(Console.MESSAGES.modificationFailed("Deployment "+record.getRuntimeName()), result.getFailureDescription());
                }
                else
                {
                    Console.info(Console.MESSAGES.modified("Deployment "+record.getRuntimeName()));
                }
            }
        });
        
        record.setEnabled(false);
        
        deploymentStore.enableDisableDeployment(record, new SimpleCallback<DMRResponse>() {

            @Override
            public void onSuccess(DMRResponse response) {
                loading.hide();

                ModelNode result = response.get();

                if(result.isFailure())
                {
                    Console.error(Console.MESSAGES.modificationFailed("Deployment "+record.getRuntimeName()), result.getFailureDescription());
                }
                else
                {
                    Console.info(Console.MESSAGES.modified("Deployment "+record.getRuntimeName()));
                }
            }
        });

    }

    /* (non-Javadoc)
     * @see org.jboss.as.console.client.shared.deployment.DeployCommandExecutor#addToServerGroup(org.jboss.as.console.client.shared.model.DeploymentRecord, boolean, java.lang.String[])
     */
    @Override
    public void addToServerGroup(DeploymentRecord record, boolean enable, String... selectedGroups) {
        
    }
    
    /* (non-Javadoc)
     * @see org.jboss.as.console.client.shared.deployment.DeployCommandExecutor#getPossibleGroupAssignments(org.jboss.as.console.client.shared.model.DeploymentRecord)
     */
    @Override
    public List<ServerGroupRecord> getPossibleGroupAssignments(DeploymentRecord record) {
        return null;
    }
    
    /* (non-Javadoc)
     * @see org.jboss.as.console.client.shared.deployment.DeployCommandExecutor#promptForGroupSelections(org.jboss.as.console.client.shared.model.DeploymentRecord)
     */
    @Override
    public void promptForGroupSelections(DeploymentRecord record) {
        
    }
    
    /* (non-Javadoc)
     * @see org.jboss.as.console.client.shared.deployment.DeployCommandExecutor#removeContent(org.jboss.as.console.client.shared.model.DeploymentRecord)
     */
    @Override
    public void removeContent(DeploymentRecord record) {
        
    }
    
    /* (non-Javadoc)
     * @see org.jboss.as.console.client.shared.deployment.DeployCommandExecutor#removeDeploymentFromGroup(org.jboss.as.console.client.shared.model.DeploymentRecord)
     */
    @Override
    public void removeDeploymentFromGroup(DeploymentRecord record) {

    }

}
