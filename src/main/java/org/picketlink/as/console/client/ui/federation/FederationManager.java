package org.picketlink.as.console.client.ui.federation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jboss.as.console.client.Console;
import org.jboss.as.console.client.domain.model.SimpleCallback;
import org.jboss.as.console.client.shared.model.DeploymentRecord;
import org.jboss.as.console.client.shared.model.ResponseWrapper;
import org.picketlink.as.console.client.PicketLinkConsoleFramework;
import org.picketlink.as.console.client.shared.subsys.model.Federation;
import org.picketlink.as.console.client.shared.subsys.model.FederationStore;
import org.picketlink.as.console.client.shared.subsys.model.IdentityProvider;
import org.picketlink.as.console.client.shared.subsys.model.KeyStore;
import org.picketlink.as.console.client.shared.subsys.model.ServiceProvider;
import org.picketlink.as.console.client.shared.subsys.model.TrustDomain;

import com.google.inject.Inject;

public class FederationManager {

    private final FederationStore federationStore;
    private final DeploymentManager deploymentManager;
    
    private FederationPresenter presenter;
    
    @Inject
    public FederationManager(FederationStore federationStore, DeploymentManager deploymentManager) {
        this.federationStore = federationStore;
        this.deploymentManager = deploymentManager;
    }
    
    /**
     * <p>
     * Loads all the federation configurations from the subsystem. This includes idps, sps, etc.
     * </p>
     */
    private void loadAllFederationConfiguration() {
        this.federationStore.loadFederations(new SimpleCallback<List<Federation>>() {

            @Override
            public void onSuccess(List<Federation> result) {
                if (!result.isEmpty()) {
                    Federation federation = result.get(0);
                    
                    loadIdentityProvider(federation);
                    loadServiceProviders(federation);
                }
            }
        });
    }
    
    /**
     * <p>
     * Loads the identity provider instances from the subsystem.
     * </p>
     */
    public void loadIdentityProvider(final Federation federation) {
        this.federationStore.loadIdentityProviders(federation, new SimpleCallback<List<IdentityProvider>>() {
            @Override
            public void onSuccess(List<IdentityProvider> result) {
                if (result.isEmpty()) {
                    clearValues(federation);
                    return;
                }
                
                IdentityProvider identityProvider = result.get(0);
                
                // if the idp application is deployed populate the view, otherwise remove it from the subsystem and clear the view.
                if (isDeployed(identityProvider)) {
                    presenter.getView().setIdentityProviders(federation.getName(), result);
                    loadTrustDomain(federation, identityProvider);
                } else {
                    onRemoveIdentityProvider(identityProvider);
                    clearValues(federation);
                }
            }

            private void clearValues(final Federation federation) {
                presenter.getView().setIdentityProviders(federation.getName(), new ArrayList());
                loadTrustDomain(federation, null);
            }

            /**
             * <p>
             * Checks if the idp application is deployed in the AS.
             * </p>
             * 
             * @param identityProvider
             * @return
             */
            private boolean isDeployed(IdentityProvider identityProvider) {
                boolean isDeployed = false;
                
                for (DeploymentRecord deployment : presenter.getAvailableDeployments()) {
                    if (deployment.getName().equals(identityProvider.getName())) {
                        isDeployed = true;
                        break;
                    }
                }
                
                return isDeployed;
            }
        });
    }
    
    /**
     * <p>
     * Loads the federation instances from the subsystem.
     * </p>
     */
    public void loadKeyStore(final Federation federation) {
        this.federationStore.loadKeyStore(federation, new SimpleCallback<List<KeyStore>>() {
            @Override
            public void onSuccess(List<KeyStore> result) {
                if (!result.isEmpty()) {
                    presenter.getView().setKeyStore(federation.getName(), result.get(0));
                } else {
                    presenter.getView().setKeyStore(federation.getName(), null);
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
            public void onSuccess(List<ServiceProvider> serviceProviders) {
                removeUndeployedServiceProviders(serviceProviders);
                presenter.getView().setServiceProviders(federation.getName(), serviceProviders);
            }

            /**
             * <p>
             * Check if the service providers are deployed in the AS. If not remove them from the subsystem.
             * </p>
             * 
             * @param serviceProviders
             */
            private void removeUndeployedServiceProviders(List<ServiceProvider> serviceProviders) {
                List<ServiceProvider> toRemove = new ArrayList<ServiceProvider>();
                
                for (ServiceProvider serviceProvider : new ArrayList<ServiceProvider>(serviceProviders)) {
                    boolean isDeployed = false;

                    for (DeploymentRecord deployment : presenter.getAvailableDeployments()) {
                        if (deployment.getName().equals(serviceProvider.getName())) {
                            isDeployed = true;
                            break;
                        }
                    }
                    
                    if (!isDeployed) {
                        serviceProviders.remove(serviceProvider);
                        toRemove.add(serviceProvider);
                    }
                }
                
                for (ServiceProvider serviceProvider : toRemove) {
                    onRemoveServiceProvider(serviceProvider);                        
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
     * 
     * @param federation
     */
    public void loadTrustDomain(Federation federation, IdentityProvider identityProvider) {
        if (identityProvider != null) {
            this.federationStore.loadTrustDomains(federation, identityProvider, new SimpleCallback<List<TrustDomain>>() {
                @Override
                public void onSuccess(List<TrustDomain> result) {
                    presenter.getView().setTrustedDomains(result);
                }
            });
        } else {
            presenter.getView().setTrustedDomains(new ArrayList<TrustDomain>());
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
                    loadAllFederationConfiguration();
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

                loadAllFederationConfiguration();
            }
        });
    }

    /**
     * <p>
     * Creates a keystore configuration.
     * </p>
     * 
     * @param federation
     */
    public void onCreateKeyStore(KeyStore keyStore) {
        this.federationStore.createKeyStore(presenter.getView().getCurrentFederation(), keyStore,
                new SimpleCallback<ResponseWrapper<Boolean>>() {

                    @Override
                    public void onSuccess(ResponseWrapper<Boolean> result) {
                        if (result.getUnderlying()) {
                            Console.info(Console.MESSAGES.added(PicketLinkConsoleFramework.getConstants()
                                    .common_label_key_store()));
                            loadAllFederationConfiguration();
                        } else
                            Console.error(Console.MESSAGES.addingFailed(PicketLinkConsoleFramework.getConstants()
                                    .common_label_key_store()));
                    }
                });
    }
    
    public void onUpdateKeyStore(KeyStore updatedEntity, final Map<String, Object> changedValues) {
        if (changedValues.size() > 0) {
            this.federationStore.updateKeyStore(presenter.getView().getCurrentFederation(), updatedEntity, changedValues,
                    new SimpleCallback<ResponseWrapper<Boolean>>() {
                        @Override
                        public void onSuccess(ResponseWrapper<Boolean> response) {
                            if (response.getUnderlying())
                                Console.info(Console.MESSAGES.saved(PicketLinkConsoleFramework.getConstants()
                                        .common_label_key_store()));
                            else
                                Console.error(Console.MESSAGES.saveFailed(PicketLinkConsoleFramework.getConstants()
                                        .common_label_key_store()));

                            loadIdentityProvider(presenter.getView().getCurrentFederation());
                        }

                    });
        }
    }
    
    /**
     * <p>
     * Removes the selected keystore instance from the subsystem.
     * </p>
     * @param keyStore
     */
    public void onRemoveKeyStore(KeyStore keyStore) {
        this.federationStore.deleteKeyStore(presenter.getView().getCurrentFederation(), keyStore, new SimpleCallback<Boolean>() {
            @Override
            public void onSuccess(Boolean success) {
                if (success) {
                    Console.info(Console.MESSAGES.deleted(PicketLinkConsoleFramework.getConstants().common_label_key_store()));
                } else {
                    Console.error(Console.MESSAGES.deletionFailed(PicketLinkConsoleFramework.getConstants().common_label_key_store()));
                }

                loadAllFederationConfiguration();
            }
        });        
    }
    
    /**
     * @param identityProvider
     * @param updatedEntity
     */
    public void onCreateTrustDomain(IdentityProvider identityProvider, final TrustDomain trustDomain) {
        this.federationStore.createTrustDomain(this.presenter.getView().getCurrentFederation(), identityProvider, trustDomain,
                new SimpleCallback<ResponseWrapper<Boolean>>() {

                    @Override
                    public void onSuccess(ResponseWrapper<Boolean> result) {
                        if (result.getUnderlying()) {
                            Console.info(Console.MESSAGES.added(PicketLinkConsoleFramework.getConstants()
                                    .common_label_trustDomain() + " ")
                                    + trustDomain.getName());
                            loadAllFederationConfiguration();
                        } else
                            Console.error(
                                    Console.MESSAGES.addingFailed(PicketLinkConsoleFramework.getConstants()
                                            .common_label_trustDomain() + " "), result.getResponse().toString());
                    }
                });
    }

    /**
     * @param updatedEntity
     */
    public void onRemoveTrustDomain(IdentityProvider identityProvider, final TrustDomain trustDomain) {
        this.federationStore.deleteTrustDomain(presenter.getView().getCurrentFederation(), identityProvider, trustDomain,
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

                        loadAllFederationConfiguration();
                    }
                });
    }
    
    /**
     * @param currentSelection
     * @param changedValues
     */
    public void onUpdateServiceProvider(final ServiceProvider currentSelection, Map<String, Object> changedValues) {
        if (changedValues.size() > 0) {
            this.federationStore.updateServiceProvider(presenter.getView().getCurrentFederation(), currentSelection, changedValues,
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

                            loadIdentityProvider(presenter.getView().getCurrentFederation());
                        }

                    });
        }
    }

    /**
     * @param serviceProvider
     */
    public void onCreateServiceProvider(final ServiceProvider serviceProvider) {
        this.federationStore.createServiceProvider(this.presenter.getView().getCurrentFederation(), serviceProvider,
                new SimpleCallback<ResponseWrapper<Boolean>>() {
                    @Override
                    public void onSuccess(ResponseWrapper<Boolean> result) {
                        if (result.getUnderlying()) {
                            Console.info(Console.MESSAGES.added(PicketLinkConsoleFramework.getConstants()
                                    .common_label_serviceProvider() + " ")
                                    + serviceProvider.getName());
                            loadAllFederationConfiguration();
                        } else
                            Console.error(Console.MESSAGES.addingFailed(PicketLinkConsoleFramework.getConstants()
                                    .common_label_serviceProvider() + " " + serviceProvider.getName()), result.getResponse()
                                    .toString());
                    }
                });
        this.deploymentManager.restartServiceProvider(serviceProvider);
    }
    
    /**
     * @param serviceProvider
     */
    public void onRemoveServiceProvider(final ServiceProvider serviceProvider) {
        this.federationStore.deleteServiceProvider(presenter.getView().getCurrentFederation(), serviceProvider,
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

                        loadAllFederationConfiguration();
                    }
                });
        this.deploymentManager.restartServiceProvider(serviceProvider);
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
        this.federationStore.createIdentityProvider(this.presenter.getView().getCurrentFederation(), identityProvider,
                new SimpleCallback<ResponseWrapper<Boolean>>() {
                    @Override
                    public void onSuccess(ResponseWrapper<Boolean> result) {
                        if (result.getUnderlying()) {
                            Console.info(Console.MESSAGES.added(PicketLinkConsoleFramework.getConstants()
                                    .common_label_identityProvider() + " ")
                                    + identityProvider.getName());
                            loadAllFederationConfiguration();
                        } else
                            Console.error(Console.MESSAGES.addingFailed(PicketLinkConsoleFramework.getConstants()
                                    .common_label_identityProvider() + " " + identityProvider.getName()), result.getResponse()
                                    .toString());
                    }
                });

        this.deploymentManager.restartIdentityProvider(identityProvider);
    }

    /**
     * @param identityProvider
     */
    public void onRemoveIdentityProvider(final IdentityProvider identityProvider) {
        this.federationStore.deleteIdentityProvider(presenter.getView().getCurrentFederation(), identityProvider,
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

                        loadAllFederationConfiguration();
                        deploymentManager.restartIdentityProvider(identityProvider);
                    }
                });
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
            this.federationStore.updateIdentityProvider(presenter.getView().getCurrentFederation(), identityProvider, changedValues,
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

                            loadIdentityProvider(presenter.getView().getCurrentFederation());
                        }

                    });
        }
    }

    public void setPresenter(FederationPresenter federationPresenter) {
        this.presenter = federationPresenter;
    }

}
