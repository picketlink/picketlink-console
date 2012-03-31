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
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.jboss.as.console.client.Console;
import org.jboss.as.console.client.domain.model.ServerGroupRecord;
import org.jboss.as.console.client.domain.model.SimpleCallback;
import org.jboss.as.console.client.shared.deployment.DeployCommandExecutor;
import org.jboss.as.console.client.shared.dispatch.DispatchAsync;
import org.jboss.as.console.client.shared.dispatch.impl.DMRAction;
import org.jboss.as.console.client.shared.dispatch.impl.DMRResponse;
import org.jboss.as.console.client.shared.model.DeploymentRecord;
import org.jboss.as.console.client.shared.model.DeploymentStore;
import org.jboss.as.console.client.shared.model.ResponseWrapper;
import org.jboss.as.console.client.shared.subsys.Baseadress;
import org.jboss.as.console.client.shared.subsys.RevealStrategy;
import org.jboss.as.console.client.shared.subsys.security.SecurityDomainsPresenter.DescriptionCallBack;
import org.jboss.as.console.client.shared.subsys.security.model.AbstractAuthData;
import org.jboss.as.console.client.shared.viewframework.NamedEntity;
import org.jboss.ballroom.client.layout.LHSHighlightEvent;
import org.jboss.ballroom.client.widgets.window.Feedback;
import org.jboss.dmr.client.ModelDescriptionConstants;
import org.jboss.dmr.client.ModelNode;
import org.picketlink.as.console.client.BeanFactory;
import org.picketlink.as.console.client.NameTokens;
import org.picketlink.as.console.client.PicketLinkConsoleFramework;
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
public class FederationPresenter extends Presenter<FederationPresenter.MyView, FederationPresenter.MyProxy> implements
        DeployCommandExecutor {

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

        /**
         * 
         */
        void initialLoad();

        /**
         * @param selectedFederation
         */
        void setSelectedFederation(String selectedFederation);

        void loadFederation(String alias);

        /**
         * @param name
         * @param modules
         * @param resourceExists
         */
        void setIdentityProviders(String name, List<IdentityProvider> modules, boolean resourceExists);

        /**
         * @param string 
         * @param result
         * @param b 
         */
        void setServiceProviders(String string, List<ServiceProvider> result, boolean b);

        /**
         * @param result
         */
        void setTrustedDomains(List<TrustDomain> result);
    }

    @ProxyCodeSplit
    @NameToken(NameTokens.FEDERATION)
    public interface MyProxy extends Proxy<FederationPresenter>, Place {
    }

    private final RevealStrategy revealStrategy;
    private final FederationStore federationStore;
    private final DeploymentStore deploymentStore;
    private final BeanFactory beanFactory;
    private final PlaceManager placeManager;
    private final DispatchAsync dispatcher;

    private List<DeploymentRecord> availableDeployments;
    private String selectedFederation;

    @Inject
    public FederationPresenter(final EventBus eventBus, BeanFactory beanFactory, final MyView view, final MyProxy proxy,
            final PlaceManager placeManager, RevealStrategy revealStrategy, FederationStore federationStore,
            DeploymentStore deploymentStore, DispatchAsync dispatcher) {
        super(eventBus, view, proxy);
        this.revealStrategy = revealStrategy;
        this.federationStore = federationStore;
        this.deploymentStore = deploymentStore;
        this.beanFactory = beanFactory;
        this.placeManager = placeManager;
        this.dispatcher = dispatcher;
        loadDeployments();
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
//        loadDeployments();
//        loadFederations();
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
        getView().setSelectedFederation(this.selectedFederation);
        getView().initialLoad();
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
                if (!result.isEmpty()) {
                    loadIdentityProvider(result.get(0));
                    loadServiceProviders(result.get(0));
                }
            }
        });
    }

    /**
     * <p>
     * Load all available deployments. This deployments will me used during the configuration of Identity Providers and Service
     * Providers.
     * </p>
     */
    public void loadDeployments() {
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
    public void loadIdentityProvider(final Federation federation) {
        if (federation == null) {
            getView().updateIdentityProviders(null);
            getView().updateTrustDomains(Collections.EMPTY_LIST);
            getView().updateServiceProviders(Collections.EMPTY_LIST);
            return;
        }

        this.federationStore.loadIdentityProviders(federation, new SimpleCallback<List<IdentityProvider>>() {
            @Override
            public void onSuccess(List<IdentityProvider> result) {
                if (!result.isEmpty()) {
                    getView().setIdentityProviders(federation.getName(), result, !result.isEmpty());
                    loadTrustDomain(federation, result.get(0));
                } else {
                    getView().setIdentityProviders(federation.getName(), Collections.EMPTY_LIST, !result.isEmpty());
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
                getView().setServiceProviders(federation.getName(), result, !result.isEmpty());
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
            getView().setTrustedDomains(Collections.EMPTY_LIST);
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
        this.restartIdentityProvider(identityProvider);
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
        restartIdentityProvider(identityProvider);
    }

    public void restartIdentityProvider(IdentityProvider identityProvider) {
        identityProvider.setName(identityProvider.getName());
        identityProvider.setRuntimeName(identityProvider.getName());

        this.enableDisableDeployment(identityProvider);
    }

    public void restartServiceProvider(ServiceProvider serviceProvider) {
        serviceProvider.setName(serviceProvider.getName());
        serviceProvider.setRuntimeName(serviceProvider.getName());

        this.enableDisableDeployment(serviceProvider);
    }

    public void enableDisableDeployment(final DeploymentRecord record) {

        final PopupPanel loading = Feedback.loading(Console.CONSTANTS.common_label_plaseWait(),
                Console.CONSTANTS.common_label_requestProcessed(), new Feedback.LoadingCallback() {
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

                if (result.isFailure()) {
                    Console.error(Console.MESSAGES.modificationFailed("Deployment " + record.getRuntimeName()),
                            result.getFailureDescription());
                } else {
                    Console.info(Console.MESSAGES.modified("Deployment " + record.getRuntimeName()));
                }
            }
        });

        record.setEnabled(false);

        deploymentStore.enableDisableDeployment(record, new SimpleCallback<DMRResponse>() {

            @Override
            public void onSuccess(DMRResponse response) {
                loading.hide();

                ModelNode result = response.get();

                if (result.isFailure()) {
                    Console.error(Console.MESSAGES.modificationFailed("Deployment " + record.getRuntimeName()),
                            result.getFailureDescription());
                } else {
                    Console.info(Console.MESSAGES.modified("Deployment " + record.getRuntimeName()));
                }
            }
        });

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
    public BeanFactory getBeanFactory() {
        return this.beanFactory;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.jboss.as.console.client.shared.deployment.DeployCommandExecutor#addToServerGroup(org.jboss.as.console.client.shared
     * .model.DeploymentRecord, boolean, java.lang.String[])
     */
    @Override
    public void addToServerGroup(DeploymentRecord record, boolean enable, String... selectedGroups) {

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.jboss.as.console.client.shared.deployment.DeployCommandExecutor#getPossibleGroupAssignments(org.jboss.as.console.
     * client.shared.model.DeploymentRecord)
     */
    @Override
    public List<ServerGroupRecord> getPossibleGroupAssignments(DeploymentRecord record) {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.jboss.as.console.client.shared.deployment.DeployCommandExecutor#promptForGroupSelections(org.jboss.as.console.client
     * .shared.model.DeploymentRecord)
     */
    @Override
    public void promptForGroupSelections(DeploymentRecord record) {

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.jboss.as.console.client.shared.deployment.DeployCommandExecutor#removeContent(org.jboss.as.console.client.shared.
     * model.DeploymentRecord)
     */
    @Override
    public void removeContent(DeploymentRecord record) {

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.jboss.as.console.client.shared.deployment.DeployCommandExecutor#removeDeploymentFromGroup(org.jboss.as.console.client
     * .shared.model.DeploymentRecord)
     */
    @Override
    public void removeDeploymentFromGroup(DeploymentRecord record) {

    }

    /**
     * @return
     */
    public PlaceManager getPlaceManager() {
        return this.placeManager;
    }

    public void getDescription(String type, final DescriptionCallBack callback) {
        ModelNode operation = createOperation(ModelDescriptionConstants.READ_RESOURCE_DESCRIPTION_OPERATION);
        operation.get(ModelDescriptionConstants.ADDRESS).add("federation", "*");
        operation.get(ModelDescriptionConstants.ADDRESS).add(type, "*");

        this.dispatcher.execute(new DMRAction(operation), new SimpleCallback<DMRResponse>() {
            @Override
            public void onSuccess(DMRResponse result) {
                ModelNode response = result.get();
                List<ModelNode> resList = response.get(ModelDescriptionConstants.RESULT).asList();
                if (resList.size() == 0)
                    return;

                callback.setDescription(resList.get(0).get(ModelDescriptionConstants.RESULT));
            }
        });
    }

    private ModelNode createOperation(String operator) {
        ModelNode operation = new ModelNode();
        operation.get(ModelDescriptionConstants.OP).set(operator);
        operation.get(ModelDescriptionConstants.ADDRESS).set(Baseadress.get());
        operation.get(ModelDescriptionConstants.ADDRESS).add(ModelDescriptionConstants.SUBSYSTEM, "picketlink")
                .add("federation");
        return operation;
    }

    /**
     * @param currentSelection
     */
    public void updateFederationSelection(final Federation currentSelection) {
        // load sub-elements which are not automatically loaded by the framework
        // ModelNode operation = createOperation(ModelDescriptionConstants.READ_RESOURCE_OPERATION);
        // operation.get(ModelDescriptionConstants.ADDRESS).add("federation", currentSelection.getName());
        // operation.get(ModelDescriptionConstants.RECURSIVE).set(true);
        //
        // dispatcher.execute(new DMRAction(operation), new SimpleCallback<DMRResponse>() {
        // @Override
        // public void onSuccess(DMRResponse result) {
        // ModelNode response = result.get();
        // ModelNode model = response.get(ModelDescriptionConstants.RESULT);
        //
        // loadGeneric(model, currentSelection, null, "identity-provider", "alias", IdentityProvider.class,
        // new CustomLoadHandler<IdentityProvider>() {
        // @Override
        // public void readFromModel(ModelNode n, IdentityProvider object) {
        // }
        //
        // @Override
        // public void setInView(List<IdentityProvider> modules, boolean resourceExists) {
        // getView().setIdentityProviders(currentSelection.getName(), modules, resourceExists);
        // }
        // });
        //
        // }
        // });
        getView().setSelectedFederation(currentSelection.getName());
        loadIdentityProvider(currentSelection);
        loadServiceProviders(currentSelection);
    }

    private <T extends NamedEntity> void loadGeneric(ModelNode model, Federation domain, IdentityProvider identityProvider,
            String type, String attrName, Class<T> cls, CustomLoadHandler<T> customHandler) {
        List<T> modules = new ArrayList<T>();
        boolean resourceExists = false;
        if (model.hasDefined(type)) {
            ModelNode subModel = model.get(type);
            resourceExists = subModel.isDefined();

            if (resourceExists) {
                for (ModelNode node : subModel.asList()) {
                    T pm = this.beanFactory.create(cls).as();

                    pm.setName(node.asProperty().getValue().get("alias").asString());
                    customHandler.readFromModel(node, pm);

                    modules.add(pm);
                }
            }
        }

        customHandler.setInView(modules, resourceExists);
    }

    private static class CustomAuthSaveFieldhandler<P extends AbstractAuthData> extends CustomSaveHandler<P> {
        @Override
        public void setInModel(ModelNode n, P object) {
            n.get("flag").set(object.getFlag());
        }
    }

    private interface CustomLoadHandler<P> {
        void readFromModel(ModelNode n, P object);

        void setInView(List<P> modules, boolean resourceExists);
    }

    private static class CustomSaveHandler<P> {
        void setInModel(ModelNode n, P object) {
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
            restartServiceProvider(currentSelection);
        }
    }

}
