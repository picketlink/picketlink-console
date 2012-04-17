/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2012, Red Hat, Inc., and individual contributors
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

package org.picketlink.as.console.client.shared.subsys.model;

import static org.jboss.dmr.client.ModelDescriptionConstants.ADD;
import static org.jboss.dmr.client.ModelDescriptionConstants.ADDRESS;
import static org.jboss.dmr.client.ModelDescriptionConstants.OP;
import static org.jboss.dmr.client.ModelDescriptionConstants.OUTCOME;
import static org.jboss.dmr.client.ModelDescriptionConstants.READ_CHILDREN_RESOURCES_OPERATION;
import static org.jboss.dmr.client.ModelDescriptionConstants.REMOVE;
import static org.jboss.dmr.client.ModelDescriptionConstants.RESULT;
import static org.jboss.dmr.client.ModelDescriptionConstants.SUCCESS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.jboss.as.console.client.domain.model.SimpleCallback;
import org.jboss.as.console.client.shared.dispatch.DispatchAsync;
import org.jboss.as.console.client.shared.dispatch.impl.DMRAction;
import org.jboss.as.console.client.shared.dispatch.impl.DMRResponse;
import org.jboss.as.console.client.shared.model.ModelAdapter;
import org.jboss.as.console.client.shared.model.ResponseWrapper;
import org.jboss.as.console.client.shared.subsys.Baseadress;
import org.jboss.as.console.client.shared.subsys.security.model.SecurityDomain;
import org.jboss.as.console.client.widgets.forms.AddressBinding;
import org.jboss.as.console.client.widgets.forms.ApplicationMetaData;
import org.jboss.as.console.client.widgets.forms.BeanMetaData;
import org.jboss.as.console.client.widgets.forms.EntityAdapter;
import org.jboss.dmr.client.ModelDescriptionConstants;
import org.jboss.dmr.client.ModelNode;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * <p>
 * Implementation of {@link FederationStore}.
 * </p>
 * 
 * @author<a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 14, 2012
 */
public class FederationStoreImpl implements FederationStore {

    private final DispatchAsync dispatcher;
    private final ApplicationMetaData metaData;
    private final EntityAdapter<Federation> federationAdapter;
    private final EntityAdapter<KeyStore> keyStoreAdapter;
    private final EntityAdapter<IdentityProvider> identityProviderAdapter;
    private final EntityAdapter<ServiceProvider> serviceProviderAdapter;
    private final EntityAdapter<TrustDomain> trustDomainAdapter;
    
    private final EntityAdapter<SecurityDomain> securityDomainAdapter;

    private final Baseadress baseadress;
    private final BeanMetaData federationMetaData;
    private final BeanMetaData keyStoreMetaData;
    private final BeanMetaData identityProviderMetaData;
    private final BeanMetaData serviceProviderMetaData;
    private final BeanMetaData trustDomainMetaData;
    private final BeanMetaData securityDomainMetaData;
    

    @Inject
    public FederationStoreImpl(DispatchAsync dispatcher, ApplicationMetaData propertyMetaData, Baseadress baseadress) {
        this.dispatcher = dispatcher;
        this.metaData = propertyMetaData;
        this.baseadress = baseadress;
        this.federationMetaData = metaData.getBeanMetaData(Federation.class);
        this.keyStoreMetaData = metaData.getBeanMetaData(KeyStore.class);
        this.identityProviderMetaData = metaData.getBeanMetaData(IdentityProvider.class);
        this.serviceProviderMetaData = metaData.getBeanMetaData(ServiceProvider.class);
        this.trustDomainMetaData = metaData.getBeanMetaData(TrustDomain.class);
        this.federationAdapter = new EntityAdapter<Federation>(Federation.class, propertyMetaData);
        this.keyStoreAdapter = new EntityAdapter<KeyStore>(KeyStore.class, propertyMetaData);
        this.identityProviderAdapter = new EntityAdapter<IdentityProvider>(IdentityProvider.class, propertyMetaData);
        this.serviceProviderAdapter = new EntityAdapter<ServiceProvider>(ServiceProvider.class, propertyMetaData);
        this.trustDomainAdapter = new EntityAdapter<TrustDomain>(TrustDomain.class, propertyMetaData);
        this.securityDomainAdapter = new EntityAdapter<SecurityDomain>(SecurityDomain.class, propertyMetaData);
        this.securityDomainMetaData = metaData.getBeanMetaData(SecurityDomain.class);
    }

    public void loadSecurityDomains(final SimpleCallback<List<SecurityDomain>> callback) {
        AddressBinding address = securityDomainMetaData.getAddress();
        ModelNode operation = address.asSubresource(baseadress.getAdress());
        operation.get(OP).set(READ_CHILDREN_RESOURCES_OPERATION);
        operation.get(ModelDescriptionConstants.RECURSIVE).set(true);
        
        dispatcher.execute(new DMRAction(operation), new AsyncCallback<DMRResponse>() {
            @Override
            public void onFailure(Throwable caught) {
                callback.onFailure(caught);
            }

            @Override
            public void onSuccess(DMRResponse result) {
                ModelNode response = result.get();

                if (response.isFailure()) {
                    callback.onFailure(new RuntimeException(response.getFailureDescription()));
                } else {
                    List<SecurityDomain> securityDomains = new ArrayList<SecurityDomain>();
                    
                    for (ModelNode securityDomainNode : response.get(RESULT).asList()) {
                        SecurityDomain securityDomain = securityDomainAdapter.fromDMR(securityDomainNode);
                        
                        securityDomains.add(securityDomain);
                    }
                    
                    callback.onSuccess(securityDomains);
                }
            }
        });        
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see
     * org.picketlink.as.console.client.shared.subsys.model.FederationStore#createFederation(org.picketlink.as.console.client
     * .shared.subsys.model.Federation, com.google.gwt.user.client.rpc.AsyncCallback)
     */
    @Override
    public void createFederation(final Federation federation, final AsyncCallback<ResponseWrapper<Boolean>> callback) {
        AddressBinding address = federationMetaData.getAddress();
        ModelNode addressModel = address.asResource(baseadress.getAdress(), federation.getName());

        ModelNode operation = federationAdapter.fromEntity(federation);
        operation.get(OP).set(ADD);
        operation.get(ADDRESS).set(addressModel.get(ADDRESS));

        dispatcher.execute(new DMRAction(operation), new SimpleCallback<DMRResponse>() {

            @Override
            public void onFailure(Throwable caught) {
                callback.onFailure(caught);
            }

            @Override
            public void onSuccess(DMRResponse result) {
                ModelNode modelNode = result.get();
                boolean wasSuccessful = modelNode.get(OUTCOME).asString().equals(SUCCESS);

                callback.onSuccess(new ResponseWrapper<Boolean>(wasSuccessful, modelNode));
            }
        });
    }
    
    /* (non-Javadoc)
     * @see org.picketlink.as.console.client.shared.subsys.model.FederationStore#createKeyStore(org.picketlink.as.console.client.shared.subsys.model.Federation, org.picketlink.as.console.client.shared.subsys.model.KeyStore, org.jboss.as.console.client.domain.model.SimpleCallback)
     */
    @Override
    public void createKeyStore(Federation federation, KeyStore keyStore, final SimpleCallback<ResponseWrapper<Boolean>> callback) {
        AddressBinding address = keyStoreMetaData.getAddress();
        ModelNode addressModel = address.asResource(baseadress.getAdress(), federation.getName(), keyStore.getSignKeyAlias());

        ModelNode operation = keyStoreAdapter.fromEntity(keyStore);
        operation.get(OP).set(ADD);
        operation.get(ADDRESS).set(addressModel.get(ADDRESS));

        dispatcher.execute(new DMRAction(operation), new SimpleCallback<DMRResponse>() {

            @Override
            public void onFailure(Throwable caught) {
                callback.onFailure(caught);
            }

            @Override
            public void onSuccess(DMRResponse result) {
                ModelNode modelNode = result.get();
                boolean wasSuccessful = modelNode.get(OUTCOME).asString().equals(SUCCESS);

                callback.onSuccess(new ResponseWrapper<Boolean>(wasSuccessful, modelNode));
            }
        });
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.picketlink.as.console.client.shared.subsys.model.FederationStore#createIdentityProvider(org.picketlink.as.console
     * .client.shared.subsys.model.IdentityProvider, org.jboss.as.console.client.domain.model.SimpleCallback)
     */
    @Override
    public void createIdentityProvider(Federation federation, final IdentityProvider identityProvider,
            final SimpleCallback<ResponseWrapper<Boolean>> callback) {
        AddressBinding address = identityProviderMetaData.getAddress();
        ModelNode addressModel = address.asResource(baseadress.getAdress(), federation.getName(), identityProvider.getName());

        ModelNode operation = identityProviderAdapter.fromEntity(identityProvider);
        operation.get(OP).set(ADD);
        operation.get(ADDRESS).set(addressModel.get(ADDRESS));

        dispatcher.execute(new DMRAction(operation), new SimpleCallback<DMRResponse>() {

            @Override
            public void onFailure(Throwable caught) {
                callback.onFailure(caught);
            }

            @Override
            public void onSuccess(DMRResponse result) {
                ModelNode modelNode = result.get();
                boolean wasSuccessful = modelNode.get(OUTCOME).asString().equals(SUCCESS);

                callback.onSuccess(new ResponseWrapper<Boolean>(wasSuccessful, modelNode));
            }
        });
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.picketlink.as.console.client.shared.subsys.model.FederationStore#createServiceProvider(org.picketlink.as.console.
     * client.shared.subsys.model.Federation, org.picketlink.as.console.client.shared.subsys.model.ServiceProvider,
     * org.jboss.as.console.client.domain.model.SimpleCallback)
     */
    @Override
    public void createServiceProvider(Federation federation, final ServiceProvider serviceProvider,
            final SimpleCallback<ResponseWrapper<Boolean>> callback) {
        AddressBinding address = serviceProviderMetaData.getAddress();
        ModelNode addressModel = address.asResource(baseadress.getAdress(), federation.getName(), serviceProvider.getName());

        ModelNode operation = serviceProviderAdapter.fromEntity(serviceProvider);
        operation.get(OP).set(ADD);
        operation.get(ADDRESS).set(addressModel.get(ADDRESS));

        dispatcher.execute(new DMRAction(operation), new SimpleCallback<DMRResponse>() {

            @Override
            public void onFailure(Throwable caught) {
                callback.onFailure(caught);
            }

            @Override
            public void onSuccess(DMRResponse result) {
                ModelNode modelNode = result.get();
                boolean wasSuccessful = modelNode.get(OUTCOME).asString().equals(SUCCESS);

                callback.onSuccess(new ResponseWrapper<Boolean>(wasSuccessful, modelNode));
            }
        });
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.picketlink.as.console.client.shared.subsys.model.FederationStore#createTrustDomain(org.picketlink.as.console.client
     * .shared.subsys.model.Federation, org.picketlink.as.console.client.shared.subsys.model.TrustDomain,
     * org.jboss.as.console.client.domain.model.SimpleCallback)
     */
    @Override
    public void createTrustDomain(Federation federation, IdentityProvider identityProvider, TrustDomain trustDomain,
            final SimpleCallback<ResponseWrapper<Boolean>> callback) {
        AddressBinding address = trustDomainMetaData.getAddress();
        ModelNode addressModel = address.asResource(baseadress.getAdress(), federation.getName(), identityProvider.getName(),
                trustDomain.getName());

        ModelNode operation = trustDomainAdapter.fromEntity(trustDomain);
        operation.get(OP).set(ADD);
        operation.get(ADDRESS).set(addressModel.get(ADDRESS));

        dispatcher.execute(new DMRAction(operation), new SimpleCallback<DMRResponse>() {

            @Override
            public void onFailure(Throwable caught) {
                callback.onFailure(caught);
            }

            @Override
            public void onSuccess(DMRResponse result) {
                ModelNode modelNode = result.get();
                boolean wasSuccessful = modelNode.get(OUTCOME).asString().equals(SUCCESS);

                callback.onSuccess(new ResponseWrapper<Boolean>(wasSuccessful, modelNode));
            }
        });
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.picketlink.as.console.client.shared.subsys.model.FederationStore#updateIdentityProvider(org.picketlink.as.console
     * .client.shared.subsys.model.Federation, java.util.Map, org.jboss.as.console.client.domain.model.SimpleCallback)
     */
    @Override
    public void updateIdentityProvider(Federation federation, IdentityProvider identityProvider,
            Map<String, Object> changedValues, final SimpleCallback<ResponseWrapper<Boolean>> callback) {
        AddressBinding address = this.identityProviderMetaData.getAddress();
        ModelNode addressModel = address.asResource(baseadress.getAdress(), federation.getName(), identityProvider.getName());
        ModelNode operation = this.identityProviderAdapter.fromChangeset(changedValues, addressModel);

        dispatcher.execute(new DMRAction(operation), new AsyncCallback<DMRResponse>() {

            @Override
            public void onFailure(Throwable caught) {
                callback.onFailure(caught);
            }

            @Override
            public void onSuccess(DMRResponse result) {

                callback.onSuccess(ModelAdapter.wrapBooleanResponse(result));
            }
        });
    }
    
    /* (non-Javadoc)
     * @see org.picketlink.as.console.client.shared.subsys.model.FederationStore#updateKeyStore(org.picketlink.as.console.client.shared.subsys.model.Federation, org.picketlink.as.console.client.shared.subsys.model.KeyStore, java.util.Map, org.jboss.as.console.client.domain.model.SimpleCallback)
     */
    @Override
    public void updateKeyStore(Federation federation, KeyStore keyStore, Map<String, Object> changedValues,
            final SimpleCallback<ResponseWrapper<Boolean>> callback) {
        AddressBinding address = this.keyStoreMetaData.getAddress();
        ModelNode addressModel = address.asResource(baseadress.getAdress(), federation.getName(), keyStore.getSignKeyAlias());
        ModelNode operation = this.keyStoreAdapter.fromChangeset(changedValues, addressModel);

        dispatcher.execute(new DMRAction(operation), new AsyncCallback<DMRResponse>() {

            @Override
            public void onFailure(Throwable caught) {
                callback.onFailure(caught);
            }

            @Override
            public void onSuccess(DMRResponse result) {
                callback.onSuccess(ModelAdapter.wrapBooleanResponse(result));
            }
        });
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.picketlink.as.console.client.shared.subsys.model.FederationStore#updateServiceProvider(org.picketlink.as.console.
     * client.shared.subsys.model.Federation, org.picketlink.as.console.client.shared.subsys.model.ServiceProvider,
     * java.util.Map, org.jboss.as.console.client.domain.model.SimpleCallback)
     */
    @Override
    public void updateServiceProvider(final Federation federation, final ServiceProvider serviceProvider,
            Map<String, Object> changedValues, final SimpleCallback<ResponseWrapper<Boolean>> callback) {
        AddressBinding address = this.serviceProviderMetaData.getAddress();
        ModelNode addressModel = address.asResource(baseadress.getAdress(), federation.getName(), serviceProvider.getName());
        ModelNode operation = this.serviceProviderAdapter.fromChangeset(changedValues, addressModel);

        dispatcher.execute(new DMRAction(operation), new AsyncCallback<DMRResponse>() {

            @Override
            public void onFailure(Throwable caught) {
                callback.onFailure(caught);
            }

            @Override
            public void onSuccess(DMRResponse result) {

                callback.onSuccess(ModelAdapter.wrapBooleanResponse(result));
            }
        });
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.picketlink.as.console.client.shared.subsys.model.FederationStore#deleteFederation(org.picketlink.as.console.client
     * .shared.subsys.model.Federation, org.jboss.as.console.client.domain.model.SimpleCallback)
     */
    @Override
    public void deleteFederation(Federation federation, final SimpleCallback<Boolean> callback) {
        AddressBinding address = this.federationMetaData.getAddress();
        ModelNode addressModel = address.asResource(baseadress.getAdress(), federation.getName());

        ModelNode operation = federationAdapter.fromEntity(federation);
        operation.get(OP).set(REMOVE);
        operation.get(ADDRESS).set(addressModel.get(ADDRESS));

        dispatcher.execute(new DMRAction(operation), new SimpleCallback<DMRResponse>() {

            @Override
            public void onFailure(Throwable caught) {
                callback.onFailure(caught);
            }

            @Override
            public void onSuccess(DMRResponse result) {
                ModelNode modelNode = result.get();
                boolean wasSuccessful = modelNode.get(OUTCOME).asString().equals(SUCCESS);
                callback.onSuccess(wasSuccessful);
            }
        });
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.picketlink.as.console.client.shared.subsys.model.FederationStore#deleteTrustDomain(org.picketlink.as.console.client
     * .shared.subsys.model.Federation, org.picketlink.as.console.client.shared.subsys.model.IdentityProvider,
     * org.jboss.as.console.client.domain.model.SimpleCallback)
     */
    @Override
    public void deleteTrustDomain(Federation federation, IdentityProvider identityProvider, TrustDomain trustDomain,
            final SimpleCallback<Boolean> callback) {
        AddressBinding address = this.trustDomainMetaData.getAddress();
        ModelNode addressModel = address.asResource(baseadress.getAdress(), federation.getName(), identityProvider.getName(),
                trustDomain.getName());

        ModelNode operation = trustDomainAdapter.fromEntity(trustDomain);
        operation.get(OP).set(REMOVE);
        operation.get(ADDRESS).set(addressModel.get(ADDRESS));

        dispatcher.execute(new DMRAction(operation), new SimpleCallback<DMRResponse>() {

            @Override
            public void onFailure(Throwable caught) {
                callback.onFailure(caught);
            }

            @Override
            public void onSuccess(DMRResponse result) {
                ModelNode modelNode = result.get();
                boolean wasSuccessful = modelNode.get(OUTCOME).asString().equals(SUCCESS);
                callback.onSuccess(wasSuccessful);
            }
        });
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.picketlink.as.console.client.shared.subsys.model.FederationStore#deleteServiceProvider(org.picketlink.as.console.
     * client.shared.subsys.model.Federation, org.picketlink.as.console.client.shared.subsys.model.ServiceProvider,
     * org.jboss.as.console.client.domain.model.SimpleCallback)
     */
    @Override
    public void deleteServiceProvider(Federation federation, ServiceProvider serviceProvider,
            final SimpleCallback<Boolean> callback) {
        AddressBinding address = this.serviceProviderMetaData.getAddress();
        ModelNode addressModel = address.asResource(baseadress.getAdress(), federation.getName(), serviceProvider.getName());

        ModelNode operation = serviceProviderAdapter.fromEntity(serviceProvider);
        operation.get(OP).set(REMOVE);
        operation.get(ADDRESS).set(addressModel.get(ADDRESS));

        dispatcher.execute(new DMRAction(operation), new SimpleCallback<DMRResponse>() {

            @Override
            public void onFailure(Throwable caught) {
                callback.onFailure(caught);
            }

            @Override
            public void onSuccess(DMRResponse result) {
                ModelNode modelNode = result.get();
                boolean wasSuccessful = modelNode.get(OUTCOME).asString().equals(SUCCESS);
                callback.onSuccess(wasSuccessful);
            }
        });
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.picketlink.as.console.client.shared.subsys.model.FederationStore#deleteIdentityProvider(org.picketlink.as.console
     * .client.shared.subsys.model.Federation, org.picketlink.as.console.client.shared.subsys.model.IdentityProvider,
     * org.jboss.as.console.client.domain.model.SimpleCallback)
     */
    @Override
    public void deleteIdentityProvider(Federation federation, IdentityProvider identityProvider,
            final SimpleCallback<Boolean> callback) {
        AddressBinding address = this.identityProviderMetaData.getAddress();
        ModelNode addressModel = address.asResource(baseadress.getAdress(), federation.getName(), identityProvider.getName());

        ModelNode operation = identityProviderAdapter.fromEntity(identityProvider);
        operation.get(OP).set(REMOVE);
        operation.get(ADDRESS).set(addressModel.get(ADDRESS));

        dispatcher.execute(new DMRAction(operation), new SimpleCallback<DMRResponse>() {

            @Override
            public void onFailure(Throwable caught) {
                callback.onFailure(caught);
            }

            @Override
            public void onSuccess(DMRResponse result) {
                ModelNode modelNode = result.get();
                boolean wasSuccessful = modelNode.get(OUTCOME).asString().equals(SUCCESS);
                callback.onSuccess(wasSuccessful);
            }
        });
    }
    
    /* (non-Javadoc)
     * @see org.picketlink.as.console.client.shared.subsys.model.FederationStore#deleteKeyStore(org.picketlink.as.console.client.shared.subsys.model.Federation, org.picketlink.as.console.client.shared.subsys.model.KeyStore, org.jboss.as.console.client.domain.model.SimpleCallback)
     */
    @Override
    public void deleteKeyStore(Federation federation, KeyStore keyStore, final SimpleCallback<Boolean> callback) {
        AddressBinding address = this.keyStoreMetaData.getAddress();
        ModelNode addressModel = address.asResource(baseadress.getAdress(), federation.getName(), keyStore.getSignKeyAlias());

        ModelNode operation = keyStoreAdapter.fromEntity(keyStore);
        operation.get(OP).set(REMOVE);
        operation.get(ADDRESS).set(addressModel.get(ADDRESS));

        dispatcher.execute(new DMRAction(operation), new SimpleCallback<DMRResponse>() {

            @Override
            public void onFailure(Throwable caught) {
                callback.onFailure(caught);
            }

            @Override
            public void onSuccess(DMRResponse result) {
                ModelNode modelNode = result.get();
                boolean wasSuccessful = modelNode.get(OUTCOME).asString().equals(SUCCESS);
                callback.onSuccess(wasSuccessful);
            }
        });
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.picketlink.as.console.client.shared.subsys.model.FederationStore#loadFederations(com.google.gwt.user.client.rpc.
     * AsyncCallback)
     */
    @Override
    public void loadFederations(final AsyncCallback<List<Federation>> callback) {
        AddressBinding address = federationMetaData.getAddress();
        ModelNode operation = address.asSubresource(baseadress.getAdress());
        operation.get(OP).set(READ_CHILDREN_RESOURCES_OPERATION);

        dispatcher.execute(new DMRAction(operation), new AsyncCallback<DMRResponse>() {
            @Override
            public void onFailure(Throwable caught) {
                callback.onFailure(caught);
            }

            @Override
            public void onSuccess(DMRResponse result) {
                ModelNode response = result.get();

                if (response.isFailure()) {
                    callback.onFailure(new RuntimeException(response.getFailureDescription()));
                } else {
                    List<Federation> datasources = federationAdapter.fromDMRList(response.get(RESULT).asList());
                    callback.onSuccess(datasources);
                }
            }
        });
    }

    public void loadIdentityProviders(Federation federation, final AsyncCallback<List<IdentityProvider>> callback) {
        AddressBinding address = this.identityProviderMetaData.getAddress();

        ModelNode operation = address.asSubresource(federation.getName());
        operation.get(OP).set(READ_CHILDREN_RESOURCES_OPERATION);

        dispatcher.execute(new DMRAction(operation), new AsyncCallback<DMRResponse>() {
            @Override
            public void onFailure(Throwable caught) {
                callback.onFailure(caught);
            }

            @Override
            public void onSuccess(DMRResponse result) {
                ModelNode response = result.get();

                if (response.isFailure()) {
                    callback.onFailure(new RuntimeException(response.getFailureDescription()));
                } else {
                    List<IdentityProvider> datasources = identityProviderAdapter.fromDMRList(response.get(RESULT).asList());
                    callback.onSuccess(datasources);
                }
            }
        });
    }
    
    @Override
    public void loadConfiguration(final SimpleCallback<Map<String, FederationWrapper>> callback) {
        AddressBinding address = federationMetaData.getAddress();
        ModelNode operation = address.asSubresource(baseadress.getAdress());
        operation.get(OP).set(READ_CHILDREN_RESOURCES_OPERATION);
        operation.get(ModelDescriptionConstants.RECURSIVE).set(true);
        
        dispatcher.execute(new DMRAction(operation), new AsyncCallback<DMRResponse>() {
            @Override
            public void onFailure(Throwable caught) {
                callback.onFailure(caught);
            }

            @Override
            public void onSuccess(DMRResponse result) {
                ModelNode response = result.get();

                if (response.isFailure()) {
                    callback.onFailure(new RuntimeException(response.getFailureDescription()));
                } else {
                    Map<String, FederationWrapper> federations = new HashMap<String, FederationWrapper>();
                    
                    for (ModelNode federationNode : response.get(RESULT).asList()) {
                        Federation federation = federationAdapter.fromDMR(federationNode);
                        FederationWrapper wrapper = new FederationWrapper(federation);
                        
                        if (federationNode.asProperty().getValue().get("key-store").isDefined()) {
                            List<KeyStore> keyStores = keyStoreAdapter.fromDMRList(federationNode.asProperty().getValue().get("key-store").asList());
                            
                            wrapper.getKeyStores().addAll(keyStores);
                        }

                        if (federationNode.asProperty().getValue().get("identity-provider").isDefined()) {
                            for (ModelNode idpNode : federationNode.asProperty().getValue().get("identity-provider").asList()) {
                                IdentityProviderWrapper idpWrapper = new IdentityProviderWrapper(identityProviderAdapter.fromDMR(idpNode));
                                
                                if (idpNode.asProperty().getValue().get("trust-domain").isDefined()) {
                                    for (ModelNode keyStoreNode : idpNode.asProperty().getValue().get("trust-domain").asList()) {
                                        TrustDomain trustDomain = trustDomainAdapter.fromDMR(keyStoreNode);
                                        
                                        idpWrapper.addTrustDomain(trustDomain);
                                    }
                                }
                                
                                wrapper.addIdentityProvider(idpWrapper);
                            }
                        }

                        if (federationNode.asProperty().getValue().get("service-provider").isDefined()) {
                            List<ServiceProvider> serviceProviders = serviceProviderAdapter.fromDMRList(federationNode.asProperty().getValue().get("service-provider").asList());
                            
                            wrapper.getServiceProviders().addAll(serviceProviders);
                        }
                        
                        federations.put(federation.getName(), wrapper);
                        
                        callback.onSuccess(federations);
                    }
                }
            }
        });        
    }


    /* (non-Javadoc)
     * @see org.picketlink.as.console.client.shared.subsys.model.FederationStore#loadKeyStore(org.picketlink.as.console.client.shared.subsys.model.Federation, org.jboss.as.console.client.domain.model.SimpleCallback)
     */
    @Override
    public void loadKeyStore(Federation federation, final SimpleCallback<List<KeyStore>> callback) {
        AddressBinding address = this.keyStoreMetaData.getAddress();

        ModelNode operation = address.asSubresource(federation.getName());
        operation.get(OP).set(READ_CHILDREN_RESOURCES_OPERATION);

        dispatcher.execute(new DMRAction(operation), new AsyncCallback<DMRResponse>() {
            @Override
            public void onFailure(Throwable caught) {
                callback.onFailure(caught);
            }

            @Override
            public void onSuccess(DMRResponse result) {
                ModelNode response = result.get();

                if (response.isFailure()) {
                    callback.onFailure(new RuntimeException(response.getFailureDescription()));
                } else {
                    List<KeyStore> keyStores = keyStoreAdapter.fromDMRList(response.get(RESULT).asList());
                    callback.onSuccess(keyStores);
                }
            }
        });
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see
     * org.picketlink.as.console.client.shared.subsys.model.FederationStore#loadServiceProviders(org.picketlink.as.console.client
     * .shared.subsys.model.Federation, org.jboss.as.console.client.domain.model.SimpleCallback)
     */
    @Override
    public void loadServiceProviders(Federation federation, final SimpleCallback<List<ServiceProvider>> callback) {
        AddressBinding address = this.serviceProviderMetaData.getAddress();

        ModelNode operation = address.asSubresource(federation.getName());
        operation.get(OP).set(READ_CHILDREN_RESOURCES_OPERATION);

        dispatcher.execute(new DMRAction(operation), new AsyncCallback<DMRResponse>() {
            @Override
            public void onFailure(Throwable caught) {
                callback.onFailure(caught);
            }

            @Override
            public void onSuccess(DMRResponse result) {
                ModelNode response = result.get();

                if (response.isFailure()) {
                    callback.onFailure(new RuntimeException(response.getFailureDescription()));
                } else {
                    List<ServiceProvider> datasources = serviceProviderAdapter.fromDMRList(response.get(RESULT).asList());
                    callback.onSuccess(datasources);
                }
            }
        });
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.picketlink.as.console.client.shared.subsys.model.FederationStore#loadTrustDomains(org.picketlink.as.console.client
     * .shared.subsys.model.Federation, org.picketlink.as.console.client.shared.subsys.model.IdentityProvider,
     * org.jboss.as.console.client.domain.model.SimpleCallback)
     */
    @Override
    public void loadTrustDomains(Federation federation, IdentityProvider identityProvider,
            final SimpleCallback<List<TrustDomain>> callback) {
        AddressBinding address = this.trustDomainMetaData.getAddress();

        ModelNode operation = address.asSubresource(federation.getName(), identityProvider.getName());
        operation.get(OP).set(READ_CHILDREN_RESOURCES_OPERATION);

        dispatcher.execute(new DMRAction(operation), new AsyncCallback<DMRResponse>() {
            @Override
            public void onFailure(Throwable caught) {
                callback.onFailure(caught);
            }

            @Override
            public void onSuccess(DMRResponse result) {
                ModelNode response = result.get();

                if (response.isFailure()) {
                    callback.onFailure(new RuntimeException(response.getFailureDescription()));
                } else {
                    List<TrustDomain> datasources = trustDomainAdapter.fromDMRList(response.get(RESULT).asList());
                    callback.onSuccess(datasources);
                }
            }
        });
    }

}
