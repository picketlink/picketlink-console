package org.picketlink.as.console.client.ui.federation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jboss.as.console.client.Console;
import org.jboss.as.console.client.domain.model.SimpleCallback;
import org.jboss.as.console.client.shared.model.ResponseWrapper;
import org.jboss.as.console.client.shared.subsys.security.model.SecurityDomain;
import org.picketlink.as.console.client.PicketLinkConsoleFramework;
import org.picketlink.as.console.client.shared.subsys.model.Federation;
import org.picketlink.as.console.client.shared.subsys.model.FederationStore;
import org.picketlink.as.console.client.shared.subsys.model.FederationWrapper;
import org.picketlink.as.console.client.shared.subsys.model.IdentityProvider;
import org.picketlink.as.console.client.shared.subsys.model.IdentityProviderHandler;
import org.picketlink.as.console.client.shared.subsys.model.IdentityProviderHandlerParameter;
import org.picketlink.as.console.client.shared.subsys.model.KeyStore;
import org.picketlink.as.console.client.shared.subsys.model.SAMLConfiguration;
import org.picketlink.as.console.client.shared.subsys.model.SecurityTokenService;
import org.picketlink.as.console.client.shared.subsys.model.ServiceProvider;
import org.picketlink.as.console.client.shared.subsys.model.ServiceProviderHandler;
import org.picketlink.as.console.client.shared.subsys.model.ServiceProviderHandlerParameter;
import org.picketlink.as.console.client.shared.subsys.model.TrustDomain;
import org.picketlink.as.console.client.ui.federation.idp.AddIdentityProviderEvent;
import org.picketlink.as.console.client.ui.federation.idp.RemoveIdentityProviderEvent;
import org.picketlink.as.console.client.ui.federation.sp.AddServiceProviderEvent;
import org.picketlink.as.console.client.ui.federation.sp.RemoveServiceProviderEvent;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;

public class FederationManager {

    private final FederationStore federationStore;
    private final DeploymentManager deploymentManager;
    private final EventBus eventBus;

    private FederationPresenter presenter;

    private Map<String, FederationWrapper> federations = new HashMap<String, FederationWrapper>();

    @Inject
    public FederationManager(FederationStore federationStore, DeploymentManager deploymentManager, EventBus eventBus) {
        this.federationStore = federationStore;
        this.deploymentManager = deploymentManager;
        this.eventBus = eventBus;
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
                    loadAllFederations();
                    Console.info(Console.MESSAGES.added(PicketLinkConsoleFramework.getConstants().common_label_federation()
                            + " ")
                            + federation.getName());
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
                    loadAllFederations();
                    Console.info(Console.MESSAGES.deleted(PicketLinkConsoleFramework.getConstants().common_label_federation()
                            + " ")
                            + federation.getName());
                } else {
                    Console.error(Console.MESSAGES.deletionFailed(PicketLinkConsoleFramework.getConstants()
                            .common_label_federation() + " ")
                            + federation.getName());
                }
            }
        });
        this.presenter.loadDeployments();
    }

    /**
     * <p>
     * Creates a keystore configuration.
     * </p>
     * 
     * @param federation
     */
    public void onCreateKeyStore(KeyStore keyStore) {
        this.federationStore.createKeyStore(presenter.getCurrentFederation(), keyStore,
                new SimpleCallback<ResponseWrapper<Boolean>>() {

                    @Override
                    public void onSuccess(ResponseWrapper<Boolean> result) {
                        if (result.getUnderlying()) {
                            Console.info(Console.MESSAGES.added(PicketLinkConsoleFramework.getConstants()
                                    .common_label_key_store()));
                        } else
                            Console.error(Console.MESSAGES.addingFailed(PicketLinkConsoleFramework.getConstants()
                                    .common_label_key_store()));
                    }
                });
    }

    public void onUpdateKeyStore(KeyStore updatedEntity, final Map<String, Object> changedValues) {
        if (changedValues.size() > 0) {
            this.federationStore.updateKeyStore(presenter.getCurrentFederation(), updatedEntity, changedValues,
                    new SimpleCallback<ResponseWrapper<Boolean>>() {
                        @Override
                        public void onSuccess(ResponseWrapper<Boolean> response) {
                            if (response.getUnderlying())
                                Console.info(Console.MESSAGES.saved(PicketLinkConsoleFramework.getConstants()
                                        .common_label_key_store()));
                            else
                                Console.error(Console.MESSAGES.saveFailed(PicketLinkConsoleFramework.getConstants()
                                        .common_label_key_store()));
                        }

                    });
            this.federationStore.reloadKeyProvider(this.presenter.getCurrentFederation(), updatedEntity);
        }
    }

    /**
     * <p>
     * Removes the selected keystore instance from the subsystem.
     * </p>
     * 
     * @param keyStore
     */
    public void onRemoveKeyStore(KeyStore keyStore) {
        this.federationStore.deleteKeyStore(presenter.getCurrentFederation(), keyStore, new SimpleCallback<Boolean>() {
            @Override
            public void onSuccess(Boolean success) {
                if (success) {
                    Console.info(Console.MESSAGES.deleted(PicketLinkConsoleFramework.getConstants().common_label_key_store()));
                } else {
                    Console.error(Console.MESSAGES.deletionFailed(PicketLinkConsoleFramework.getConstants()
                            .common_label_key_store()));
                }
            }
        });
        this.federationStore.reloadKeyProvider(presenter.getCurrentFederation(), keyStore);
    }

    /**
     * @param identityProvider
     * @param updatedEntity
     */
    public void onCreateTrustDomain(IdentityProvider identityProvider, final TrustDomain trustDomain) {
        this.federationStore.createTrustDomain(this.presenter.getCurrentFederation(), identityProvider, trustDomain,
                new SimpleCallback<ResponseWrapper<Boolean>>() {

                    @Override
                    public void onSuccess(ResponseWrapper<Boolean> result) {
                        if (result.getUnderlying()) {
                            Console.info(Console.MESSAGES.added(PicketLinkConsoleFramework.getConstants()
                                    .common_label_trustDomain() + " ")
                                    + trustDomain.getName());
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
        this.federationStore.deleteTrustDomain(presenter.getCurrentFederation(), identityProvider, trustDomain,
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
                    }
                });
    }

    /**
     * @param serviceProvider
     * @param changedValues
     */
    public void onUpdateServiceProvider(final ServiceProvider serviceProvider, Map<String, Object> changedValues) {
        if (changedValues.size() > 0) {
            this.federationStore.updateServiceProvider(presenter.getCurrentFederation(), serviceProvider, changedValues,
                    new SimpleCallback<ResponseWrapper<Boolean>>() {
                        @Override
                        public void onSuccess(ResponseWrapper<Boolean> response) {
                            if (response.getUnderlying()) {
                                loadAllFederations();
                                Console.info(Console.MESSAGES.saved(PicketLinkConsoleFramework.getConstants()
                                        .common_label_serviceProvider() + " " + serviceProvider.getName()));
                            } else {
                                Console.error(
                                        Console.MESSAGES.saveFailed(PicketLinkConsoleFramework.getConstants()
                                                .common_label_serviceProvider() + " ")
                                                + serviceProvider.getName(), response.getResponse().toString());
                            }
                        }

                    });
            this.federationStore.reloadServiceProvider(this.presenter.getCurrentFederation(), serviceProvider);
        }
    }

    /**
     * @param serviceProvider
     */
    public void onCreateServiceProvider(final ServiceProvider serviceProvider) {
        this.federationStore.createServiceProvider(this.presenter.getCurrentFederation(), serviceProvider,
                new SimpleCallback<ResponseWrapper<Boolean>>() {
                    @Override
                    public void onSuccess(ResponseWrapper<Boolean> result) {
                        if (result.getUnderlying()) {
                            loadAllFederations();
                            Console.info(Console.MESSAGES.added(PicketLinkConsoleFramework.getConstants()
                                    .common_label_serviceProvider() + " ")
                                    + serviceProvider.getName());
                        } else
                            Console.error(Console.MESSAGES.addingFailed(PicketLinkConsoleFramework.getConstants()
                                    .common_label_serviceProvider() + " " + serviceProvider.getName()), result.getResponse()
                                    .toString());
                    }
                });
        this.federationStore.reloadServiceProvider(this.presenter.getCurrentFederation(), serviceProvider);
        this.eventBus.fireEvent(new AddServiceProviderEvent(serviceProvider));
    }

    /**
     * @param serviceProvider
     */
    public void onRemoveServiceProvider(final ServiceProvider serviceProvider) {
        this.federationStore.deleteServiceProvider(presenter.getCurrentFederation(), serviceProvider,
                new SimpleCallback<Boolean>() {
                    @Override
                    public void onSuccess(Boolean success) {
                        if (success) {
                            loadAllFederations();
                            Console.info(Console.MESSAGES.deleted(PicketLinkConsoleFramework.getConstants()
                                    .common_label_serviceProvider() + " ")
                                    + serviceProvider.getName());
                            deploymentManager.restartServiceProvider(serviceProvider);
                        } else {
                            Console.error(Console.MESSAGES.deletionFailed(PicketLinkConsoleFramework.getConstants()
                                    .common_label_serviceProvider() + " ")
                                    + serviceProvider.getName());
                        }
                    }
                });
        this.eventBus.fireEvent(new RemoveServiceProviderEvent(serviceProvider));
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
        this.federationStore.createIdentityProvider(this.presenter.getCurrentFederation(), identityProvider,
                new SimpleCallback<ResponseWrapper<Boolean>>() {
                    @Override
                    public void onSuccess(ResponseWrapper<Boolean> result) {
                        if (result.getUnderlying()) {
                            loadAllFederations();
                            Console.info(Console.MESSAGES.added(PicketLinkConsoleFramework.getConstants()
                                    .common_label_identityProvider() + " ")
                                    + identityProvider.getName());
                            federationStore.reloadIdentityProvider(presenter.getCurrentFederation(), identityProvider);
                        } else
                            Console.error(Console.MESSAGES.addingFailed(PicketLinkConsoleFramework.getConstants()
                                    .common_label_identityProvider() + " " + identityProvider.getName()), result.getResponse()
                                    .toString());
                    }
                });
        this.federationStore.reloadIdentityProvider(this.presenter.getCurrentFederation(), identityProvider);
        this.eventBus.fireEvent(new AddIdentityProviderEvent(identityProvider));
    }

    /**
     * @param identityProvider
     */
    public void onRemoveIdentityProvider(final IdentityProvider identityProvider) {
        this.federationStore.deleteIdentityProvider(presenter.getCurrentFederation(), identityProvider,
                new SimpleCallback<Boolean>() {
                    @Override
                    public void onSuccess(Boolean success) {
                        if (success) {
                            loadAllFederations();
                            Console.info(Console.MESSAGES.deleted(PicketLinkConsoleFramework.getConstants()
                                    .common_label_identityProvider() + " ")
                                    + identityProvider.getName());
                            deploymentManager.restartIdentityProvider(identityProvider);
                        } else {
                            Console.error(Console.MESSAGES.deletionFailed(PicketLinkConsoleFramework.getConstants()
                                    .common_label_identityProvider() + " ")
                                    + identityProvider.getName());
                        }
                    }
                });
        this.eventBus.fireEvent(new RemoveIdentityProviderEvent(identityProvider));
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
            this.federationStore.updateIdentityProvider(presenter.getCurrentFederation(), identityProvider, changedValues,
                    new SimpleCallback<ResponseWrapper<Boolean>>() {
                        @Override
                        public void onSuccess(ResponseWrapper<Boolean> response) {
                            if (response.getUnderlying()) {
                                loadAllFederations();
                                Console.info(Console.MESSAGES.saved(PicketLinkConsoleFramework.getConstants()
                                        .common_label_identityProvider() + " " + identityProvider.getName()));
                                federationStore.reloadIdentityProvider(presenter.getCurrentFederation(), identityProvider);
                            } else {
                                Console.error(
                                        Console.MESSAGES.saveFailed(PicketLinkConsoleFramework.getConstants()
                                                .common_label_identityProvider() + " ")
                                                + identityProvider.getName(), response.getResponse().toString());
                            }
                        }

                    });
        }
    }

    public void setPresenter(FederationPresenter federationPresenter) {
        this.presenter = federationPresenter;
    }

    public void loadAllFederations() {
        this.federationStore.loadConfiguration(new SimpleCallback<Map<String, FederationWrapper>>() {
            @Override
            public void onSuccess(Map<String, FederationWrapper> result) {
                if (result.isEmpty()) {
                    return;
                }

                federations = result;
                presenter.loadDeployments();
            }
        });
    }

    public Map<String, FederationWrapper> getFederations() {
        return this.federations;
    }

    public void loadAllSecurityDomains(final FederationPresenter federationPresenter) {
        this.federationStore.loadSecurityDomains(new SimpleCallback<List<SecurityDomain>>() {
            @Override
            public void onSuccess(List<SecurityDomain> result) {
                if (result.isEmpty()) {
                    return;
                }
                federationPresenter.onLoadSecurityDomains(result);
            }
        });
    }

    public void onCreateSecurityTokenService(final SecurityTokenService securitytokenService) {
        this.federationStore.createSecurityTokenService(this.presenter.getCurrentFederation(), securitytokenService,
                new SimpleCallback<ResponseWrapper<Boolean>>() {
                    @Override
                    public void onSuccess(ResponseWrapper<Boolean> result) {
                        if (result.getUnderlying()) {
                            loadAllFederations();
                            Console.info(Console.MESSAGES.added(PicketLinkConsoleFramework.getConstants()
                                    .common_label_securityTokenService() + " ")
                                    + securitytokenService.getName());
                        } else
                            Console.error(Console.MESSAGES.addingFailed(PicketLinkConsoleFramework.getConstants()
                                    .common_label_securityTokenService() + " " + securitytokenService.getName()), result
                                    .getResponse().toString());
                    }
                });
    }

    public void onUpdateSecurityTokenService(SecurityTokenService securityTokenService, Map<String, Object> changedValues) {

    }

    public void onRemoveSecurityTokenService(final SecurityTokenService securityTokenService) {
        this.federationStore.deleteSecurityTokenService(presenter.getCurrentFederation(), securityTokenService,
                new SimpleCallback<Boolean>() {
                    @Override
                    public void onSuccess(Boolean success) {
                        if (success) {
                            loadAllFederations();
                            Console.info(Console.MESSAGES.deleted(PicketLinkConsoleFramework.getConstants()
                                    .common_label_securityTokenService() + " ")
                                    + securityTokenService.getName());
                        } else {
                            Console.error(Console.MESSAGES.deletionFailed(PicketLinkConsoleFramework.getConstants()
                                    .common_label_securityTokenService() + " ")
                                    + securityTokenService.getName());
                        }
                    }
                });
    }

    public void onCreateIdentityProviderHandler(IdentityProvider identityProvider, final IdentityProviderHandler newHandler) {
        this.federationStore.createIdentityProviderHandler(this.presenter.getCurrentFederation(), identityProvider, newHandler,
                new SimpleCallback<ResponseWrapper<Boolean>>() {

                    @Override
                    public void onSuccess(ResponseWrapper<Boolean> result) {
                        if (result.getUnderlying()) {
                            Console.info(Console.MESSAGES.added("Handler" + newHandler.getClassName()));
                        } else
                            Console.error(
                                    Console.MESSAGES.addingFailed("Handler" + newHandler.getClassName()), result.getResponse().toString());
                    }
                });
    }

    /**
     * @param identityProvider
     * @param removedTrustedDomain
     */
    public void onRemoveIdentityProviderHandler(IdentityProvider identityProvider, final IdentityProviderHandler removedTrustedDomain) {
        this.federationStore.deleteIdentityProviderHandler(presenter.getCurrentFederation(), identityProvider, removedTrustedDomain,
                new SimpleCallback<Boolean>() {
                    @Override
                    public void onSuccess(Boolean success) {
                        if (success) {
                            Console.info(Console.MESSAGES.deleted("Handler" + removedTrustedDomain.getClassName()));
                        } else {
                            Console.error(Console.MESSAGES.deletionFailed("Handler" + removedTrustedDomain.getClassName()));
                        }
                    }
                });
    }

    public void onCreateIdentityProviderHandlerParameter(IdentityProvider identityProvider,IdentityProviderHandler handler,
            final IdentityProviderHandlerParameter newHandlerParameter) {
        this.federationStore.createIdentityProviderHandlerParameter(this.presenter.getCurrentFederation(), identityProvider, handler, newHandlerParameter,
                new SimpleCallback<ResponseWrapper<Boolean>>() {

                    @Override
                    public void onSuccess(ResponseWrapper<Boolean> result) {
                        if (result.getUnderlying()) {
                            Console.info(Console.MESSAGES.added("Handler Parameter" + newHandlerParameter.getName()));
                        } else
                            Console.error(
                                    Console.MESSAGES.addingFailed("Handler Parameter" + newHandlerParameter.getName()), result.getResponse().toString());
                    }
                });
    }

    public void onRemoveIdentityProviderHandlerParameter(IdentityProvider identityProvider,IdentityProviderHandler handler,
            final IdentityProviderHandlerParameter removedHandlerParameter) {
        this.federationStore.deleteIdentityProviderHandlerParameter(presenter.getCurrentFederation(), identityProvider, handler, removedHandlerParameter,
                new SimpleCallback<Boolean>() {
                    @Override
                    public void onSuccess(Boolean success) {
                        if (success) {
                            Console.info(Console.MESSAGES.deleted("Handler Parameter" + removedHandlerParameter.getName()));
                        } else {
                            Console.error(Console.MESSAGES.deletionFailed("Handler Parameter" + removedHandlerParameter.getName()));
                        }
                    }
                });        
    }

    public void onCreateServiceProviderHandler(ServiceProvider serviceProvider, final ServiceProviderHandler newTrustedDomain) {
        this.federationStore.createServiceProviderHandler(this.presenter.getCurrentFederation(), serviceProvider, newTrustedDomain,
                new SimpleCallback<ResponseWrapper<Boolean>>() {

                    @Override
                    public void onSuccess(ResponseWrapper<Boolean> result) {
                        if (result.getUnderlying()) {
                            Console.info(Console.MESSAGES.added("Handler" + newTrustedDomain.getClassName()));
                        } else
                            Console.error(
                                    Console.MESSAGES.addingFailed("Handler" + newTrustedDomain.getClassName()), result.getResponse().toString());
                    }
                });
    }

    public void onRemoveServiceProviderHandler(ServiceProvider serviceProvider, final ServiceProviderHandler removedTrustedDomain) {
        this.federationStore.deleteServiceProviderHandler(presenter.getCurrentFederation(), serviceProvider, removedTrustedDomain,
                new SimpleCallback<Boolean>() {
                    @Override
                    public void onSuccess(Boolean success) {
                        if (success) {
                            Console.info(Console.MESSAGES.deleted("Handler" + removedTrustedDomain.getClassName()));
                        } else {
                            Console.error(Console.MESSAGES.deletionFailed("Handler" + removedTrustedDomain.getClassName()));
                        }
                    }
                });
    }

    public void onCreateServiceProviderHandlerParameter(ServiceProvider serviceProvider,
            ServiceProviderHandler selectedHandler, final ServiceProviderHandlerParameter newHandlerParameter) {
        this.federationStore.createServiceProviderHandlerParameter(this.presenter.getCurrentFederation(), serviceProvider, selectedHandler, newHandlerParameter,
                new SimpleCallback<ResponseWrapper<Boolean>>() {

                    @Override
                    public void onSuccess(ResponseWrapper<Boolean> result) {
                        if (result.getUnderlying()) {
                            Console.info(Console.MESSAGES.added("Handler Parameter" + newHandlerParameter.getName()));
                        } else
                            Console.error(
                                    Console.MESSAGES.addingFailed("Handler Parameter" + newHandlerParameter.getName()), result.getResponse().toString());
                    }
                });
    }

    public void onRemoveServiceProviderHandlerParameter(ServiceProvider serviceProvider,
            ServiceProviderHandler selectedHandler, final ServiceProviderHandlerParameter removedHandlerParameter) {
        this.federationStore.deleteServiceProviderHandlerParameter(presenter.getCurrentFederation(), serviceProvider, selectedHandler, removedHandlerParameter,
                new SimpleCallback<Boolean>() {
                    @Override
                    public void onSuccess(Boolean success) {
                        if (success) {
                            Console.info(Console.MESSAGES.deleted("Handler Parameter" + removedHandlerParameter.getName()));
                        } else {
                            Console.error(Console.MESSAGES.deletionFailed("Handler Parameter" + removedHandlerParameter.getName()));
                        }
                    }
                });        
    }

    public void onCreateSAMLConfiguration(SAMLConfiguration updatedEntity) {
        this.federationStore.createSAMLConfiguration(presenter.getCurrentFederation(), updatedEntity,
                new SimpleCallback<ResponseWrapper<Boolean>>() {

                    @Override
                    public void onSuccess(ResponseWrapper<Boolean> result) {
                        if (result.getUnderlying()) {
                            Console.info(Console.MESSAGES.added("SAML Configuration"));
                        } else
                            Console.error(Console.MESSAGES.addingFailed("SAML Configuration"));
                    }
                });
    }

    public void onRemoveKeyStore(SAMLConfiguration samlConfig) {
        this.federationStore.deleteSAMLConfiguration(presenter.getCurrentFederation(), samlConfig,
                new SimpleCallback<ResponseWrapper<Boolean>>() {

                    @Override
                    public void onSuccess(ResponseWrapper<Boolean> result) {
                        if (result.getUnderlying()) {
                            Console.info(Console.MESSAGES.deleted("SAML Configuration"));
                        } else
                            Console.error(Console.MESSAGES.deletionFailed("SAML Configuration"));
                    }
                });
    }
}
