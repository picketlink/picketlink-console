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
    private final EntityAdapter<KeyStore> keyProviderAdapter;
    private final EntityAdapter<SAMLConfiguration> samlConfigurationAdapter;
    private final EntityAdapter<IdentityProvider> identityProviderAdapter;
    private final EntityAdapter<SecurityTokenService> securityTokenServiceAdapter;
    private final EntityAdapter<ServiceProvider> serviceProviderAdapter;
    private final EntityAdapter<TrustDomain> trustDomainAdapter;
    private final EntityAdapter<IdentityProviderHandler> identityProviderHandlerAdapter;
    private final EntityAdapter<IdentityProviderHandlerParameter> identityProviderHandlerParameterAdapter;
    private final EntityAdapter<ServiceProviderHandler> serviceProviderHandlerAdapter;
    private final EntityAdapter<ServiceProviderHandlerParameter> serviceProviderHandlerParameterAdapter;
    
    private final EntityAdapter<SecurityDomain> securityDomainAdapter;

    private final Baseadress baseadress;
    private final BeanMetaData federationMetaData;
    private final BeanMetaData keyProviderMetaData;
    private final BeanMetaData samlConfigurationMetaData;
    private final BeanMetaData identityProviderMetaData;
    private final BeanMetaData securityTokenServiceMetaData;
    private final BeanMetaData serviceProviderMetaData;
    private final BeanMetaData trustDomainMetaData;
    private final BeanMetaData securityDomainMetaData;
    private final BeanMetaData identityProviderHandlerMetaData;
    private final BeanMetaData identityProviderHandlerParameterMetaData;
    private final BeanMetaData serviceProviderHandlerMetaData;
    private final BeanMetaData serviceProviderHandlerParameterMetaData;
    

    @Inject
    public FederationStoreImpl(DispatchAsync dispatcher, ApplicationMetaData propertyMetaData, Baseadress baseadress) {
        this.dispatcher = dispatcher;
        this.metaData = propertyMetaData;
        this.baseadress = baseadress;
        this.federationMetaData = metaData.getBeanMetaData(Federation.class);
        this.keyProviderMetaData = metaData.getBeanMetaData(KeyStore.class);
        this.samlConfigurationMetaData = metaData.getBeanMetaData(SAMLConfiguration.class);
        this.identityProviderMetaData = metaData.getBeanMetaData(IdentityProvider.class);
        this.securityTokenServiceMetaData = metaData.getBeanMetaData(SecurityTokenService.class);
        this.serviceProviderMetaData = metaData.getBeanMetaData(ServiceProvider.class);
        this.trustDomainMetaData = metaData.getBeanMetaData(TrustDomain.class);
        this.federationAdapter = new EntityAdapter<Federation>(Federation.class, propertyMetaData);
        this.keyProviderAdapter = new EntityAdapter<KeyStore>(KeyStore.class, propertyMetaData);
        this.samlConfigurationAdapter = new EntityAdapter<SAMLConfiguration>(SAMLConfiguration.class, propertyMetaData);
        this.identityProviderAdapter = new EntityAdapter<IdentityProvider>(IdentityProvider.class, propertyMetaData);
        this.securityTokenServiceAdapter = new EntityAdapter<SecurityTokenService>(SecurityTokenService.class, propertyMetaData);
        this.serviceProviderAdapter = new EntityAdapter<ServiceProvider>(ServiceProvider.class, propertyMetaData);
        this.trustDomainAdapter = new EntityAdapter<TrustDomain>(TrustDomain.class, propertyMetaData);
        this.identityProviderHandlerAdapter = new EntityAdapter<IdentityProviderHandler>(IdentityProviderHandler.class, propertyMetaData);
        this.identityProviderHandlerParameterAdapter = new EntityAdapter<IdentityProviderHandlerParameter>(IdentityProviderHandlerParameter.class, propertyMetaData);
        this.serviceProviderHandlerAdapter = new EntityAdapter<ServiceProviderHandler>(ServiceProviderHandler.class, propertyMetaData);
        this.serviceProviderHandlerParameterAdapter = new EntityAdapter<ServiceProviderHandlerParameter>(ServiceProviderHandlerParameter.class, propertyMetaData);
        this.securityDomainAdapter = new EntityAdapter<SecurityDomain>(SecurityDomain.class, propertyMetaData);
        this.securityDomainMetaData = metaData.getBeanMetaData(SecurityDomain.class);
        this.identityProviderHandlerMetaData = metaData.getBeanMetaData(IdentityProviderHandler.class);
        this.identityProviderHandlerParameterMetaData = metaData.getBeanMetaData(IdentityProviderHandlerParameter.class);
        this.serviceProviderHandlerMetaData = metaData.getBeanMetaData(ServiceProviderHandler.class);
        this.serviceProviderHandlerParameterMetaData = metaData.getBeanMetaData(ServiceProviderHandlerParameter.class);
    }

    @Override
    public void reloadIdentityProvider(Federation federation, IdentityProvider identityProvider) {
        AddressBinding address = identityProviderMetaData.getAddress();
        ModelNode addressModel = address.asResource(baseadress.getAdress(), federation.getName(), identityProvider.getName());

        ModelNode operation = identityProviderAdapter.fromEntity(identityProvider);
        operation.get(OP).set("reload");
        operation.get(ADDRESS).set(addressModel.get(ADDRESS));

        dispatcher.execute(new DMRAction(operation), new SimpleCallback<DMRResponse>() {

            @Override
            public void onFailure(Throwable caught) {
                System.out.println(caught);
            }

            @Override
            public void onSuccess(DMRResponse result) {
                System.out.println(result);
            }
        });
    }

    @Override
    public void reloadServiceProvider(Federation federation, ServiceProvider serviceProvider) {
        AddressBinding address = serviceProviderMetaData.getAddress();
        ModelNode addressModel = address.asResource(baseadress.getAdress(), federation.getName(), serviceProvider.getName());

        ModelNode operation = serviceProviderAdapter.fromEntity(serviceProvider);
        operation.get(OP).set("reload");
        operation.get(ADDRESS).set(addressModel.get(ADDRESS));

        dispatcher.execute(new DMRAction(operation), new SimpleCallback<DMRResponse>() {

            @Override
            public void onFailure(Throwable caught) {
                System.out.println(caught);
            }

            @Override
            public void onSuccess(DMRResponse result) {
                System.out.println(result);
            }
        });
    }

    @Override
    public void reloadKeyProvider(Federation federation, KeyStore keyProvider) {
        AddressBinding address = keyProviderMetaData.getAddress();
        ModelNode addressModel = address.asResource(baseadress.getAdress(), federation.getName(), keyProvider.getName());

        ModelNode operation = keyProviderAdapter.fromEntity(keyProvider);
        operation.get(OP).set("reload");
        operation.get(ADDRESS).set(addressModel.get(ADDRESS));

        dispatcher.execute(new DMRAction(operation), new SimpleCallback<DMRResponse>() {

            @Override
            public void onFailure(Throwable caught) {
                System.out.println(caught);
            }

            @Override
            public void onSuccess(DMRResponse result) {
                System.out.println(result);
            }
        });
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
        AddressBinding address = keyProviderMetaData.getAddress();
        ModelNode addressModel = address.asResource(baseadress.getAdress(), federation.getName(), keyStore.getSignKeyAlias());

        ModelNode operation = keyProviderAdapter.fromEntity(keyStore);
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
    
    @Override
    public void createSecurityTokenService(FederationWrapper federation, SecurityTokenService securityTokenService,
            final SimpleCallback<ResponseWrapper<Boolean>> callback) {
        AddressBinding address = securityTokenServiceMetaData.getAddress();
        ModelNode addressModel = address.asResource(baseadress.getAdress(), federation.getName(), securityTokenService.getName());

        ModelNode operation = securityTokenServiceAdapter.fromEntity(securityTokenService);
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
        AddressBinding address = this.keyProviderMetaData.getAddress();
        ModelNode addressModel = address.asResource(baseadress.getAdress(), federation.getName(), keyStore.getSignKeyAlias());
        ModelNode operation = this.keyProviderAdapter.fromChangeset(changedValues, addressModel);

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
    
    @Override
    public void deleteSecurityTokenService(FederationWrapper federation, SecurityTokenService securityTokenService,
            final SimpleCallback<Boolean> callback) {
        AddressBinding address = this.securityTokenServiceMetaData.getAddress();
        ModelNode addressModel = address.asResource(baseadress.getAdress(), federation.getName(), securityTokenService.getName());

        ModelNode operation = securityTokenServiceAdapter.fromEntity(securityTokenService);
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
        AddressBinding address = this.keyProviderMetaData.getAddress();
        ModelNode addressModel = address.asResource(baseadress.getAdress(), federation.getName(), keyStore.getSignKeyAlias());

        ModelNode operation = keyProviderAdapter.fromEntity(keyStore);
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
                            List<KeyStore> keyStores = keyProviderAdapter.fromDMRList(federationNode.asProperty().getValue().get("key-store").asList());
                            
                            wrapper.getKeyStores().addAll(keyStores);
                        }
                        
                        if (federationNode.asProperty().getValue().get("saml").isDefined()) {
                            List<SAMLConfiguration> samlConfigs = samlConfigurationAdapter.fromDMRList(federationNode.asProperty().getValue().get("saml").asList());
                            
                            wrapper.setSAMLConfiguration(samlConfigs.get(0));
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

                                if (idpNode.asProperty().getValue().get("handler").isDefined()) {
                                    for (ModelNode handlerNode : idpNode.asProperty().getValue().get("handler").asList()) {
                                        IdentityProviderHandler handlers = identityProviderHandlerAdapter.fromDMR(handlerNode);
                                        IdentityProviderHandlerWrapper handlerWrapper = new IdentityProviderHandlerWrapper(handlers);
                                        
                                        if (handlerNode.asProperty().getValue().get("handler-parameter").isDefined()) {
                                            for (ModelNode handlerParameterNode : handlerNode.asProperty().getValue().get("handler-parameter").asList()) {
                                                IdentityProviderHandlerParameter handlerParameter = identityProviderHandlerParameterAdapter.fromDMR(handlerParameterNode);
                                                
                                                handlerWrapper.addParameter(handlerParameter);
                                            }
                                        }
                                        
                                        idpWrapper.addHandler(handlerWrapper);
                                    }
                                }

                                wrapper.addIdentityProvider(idpWrapper);
                            }
                        }
                        
                        if (federationNode.asProperty().getValue().get("security-token-service").isDefined()) {
                            for (ModelNode idpNode : federationNode.asProperty().getValue().get("security-token-service").asList()) {
                                SecurityTokenService idpWrapper = securityTokenServiceAdapter.fromDMR(idpNode);
                                
                                wrapper.addSecurityTokenService(idpWrapper);
                            }
                        }

                        if (federationNode.asProperty().getValue().get("service-provider").isDefined()) {
                            for (ModelNode spNode : federationNode.asProperty().getValue().get("service-provider").asList()) {
                                ServiceProviderWrapper spWrapper = new ServiceProviderWrapper(serviceProviderAdapter.fromDMR(spNode));
                                
                                if (spNode.asProperty().getValue().get("handler").isDefined()) {
                                    for (ModelNode handlerNode : spNode.asProperty().getValue().get("handler").asList()) {
                                        ServiceProviderHandler handlers = serviceProviderHandlerAdapter.fromDMR(handlerNode);
                                        ServiceProviderHandlerWrapper handlerWrapper = new ServiceProviderHandlerWrapper(handlers);
                                        
                                        if (handlerNode.asProperty().getValue().get("handler-parameter").isDefined()) {
                                            for (ModelNode handlerParameterNode : handlerNode.asProperty().getValue().get("handler-parameter").asList()) {
                                                ServiceProviderHandlerParameter handlerParameter = serviceProviderHandlerParameterAdapter.fromDMR(handlerParameterNode);
                                                
                                                handlerWrapper.addParameter(handlerParameter);
                                            }
                                        }
                                        
                                        spWrapper.addHandler(handlerWrapper);
                                    }
                                }

                                wrapper.addServiceProvider(spWrapper);
                            }
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
        AddressBinding address = this.keyProviderMetaData.getAddress();

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
                    List<KeyStore> keyStores = keyProviderAdapter.fromDMRList(response.get(RESULT).asList());
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
    
    /* (non-Javadoc)
     * @see org.picketlink.as.console.client.shared.subsys.model.FederationStore#createIdentityProviderHandler(org.picketlink.as.console.client.shared.subsys.model.FederationWrapper, org.picketlink.as.console.client.shared.subsys.model.IdentityProvider, org.picketlink.as.console.client.shared.subsys.model.IdentityProviderHandler, org.jboss.as.console.client.domain.model.SimpleCallback)
     */
    @Override
    public void createIdentityProviderHandler(FederationWrapper currentFederation, IdentityProvider identityProvider,
            IdentityProviderHandler newHandler, final SimpleCallback<ResponseWrapper<Boolean>> callback) {
        AddressBinding address = identityProviderHandlerMetaData.getAddress();
        ModelNode addressModel = address.asResource(baseadress.getAdress(), currentFederation.getName(), identityProvider.getName(),
                newHandler.getClassName());

        ModelNode operation = identityProviderHandlerAdapter.fromEntity(newHandler);
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
     * @see org.picketlink.as.console.client.shared.subsys.model.FederationStore#deleteIdentityProviderHandler(org.picketlink.as.console.client.shared.subsys.model.FederationWrapper, org.picketlink.as.console.client.shared.subsys.model.IdentityProvider, org.picketlink.as.console.client.shared.subsys.model.IdentityProviderHandler, org.jboss.as.console.client.domain.model.SimpleCallback)
     */
    @Override
    public void deleteIdentityProviderHandler(FederationWrapper federation, IdentityProvider identityProvider,
            IdentityProviderHandler removedTrustedDomain, final SimpleCallback<Boolean> callback) {
        AddressBinding address = this.identityProviderHandlerMetaData.getAddress();
        ModelNode addressModel = address.asResource(baseadress.getAdress(), federation.getName(), identityProvider.getName(),
                removedTrustedDomain.getClassName());

        ModelNode operation = identityProviderHandlerAdapter.fromEntity(removedTrustedDomain);
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
     * @see org.picketlink.as.console.client.shared.subsys.model.FederationStore#createIdentityProviderHandlerParameter(org.picketlink.as.console.client.shared.subsys.model.FederationWrapper, org.picketlink.as.console.client.shared.subsys.model.IdentityProvider, org.picketlink.as.console.client.shared.subsys.model.IdentityProviderHandlerParameter, org.jboss.as.console.client.domain.model.SimpleCallback)
     */
    @Override
    public void createIdentityProviderHandlerParameter(FederationWrapper federation, IdentityProvider identityProvider, IdentityProviderHandler handler,
            IdentityProviderHandlerParameter newHandlerParameter, final SimpleCallback<ResponseWrapper<Boolean>> callback) {
        AddressBinding address = identityProviderHandlerParameterMetaData.getAddress();
        ModelNode addressModel = address.asResource(baseadress.getAdress(), federation.getName(), identityProvider.getName(),
                handler.getClassName(), newHandlerParameter.getName());

        ModelNode operation = identityProviderHandlerParameterAdapter.fromEntity(newHandlerParameter);
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
     * @see org.picketlink.as.console.client.shared.subsys.model.FederationStore#deleteIdentityProviderHandlerParameter(org.picketlink.as.console.client.shared.subsys.model.FederationWrapper, org.picketlink.as.console.client.shared.subsys.model.IdentityProvider, org.picketlink.as.console.client.shared.subsys.model.IdentityProviderHandlerParameter, org.jboss.as.console.client.domain.model.SimpleCallback)
     */
    @Override
    public void deleteIdentityProviderHandlerParameter(FederationWrapper federation, IdentityProvider identityProvider,IdentityProviderHandler handler,
            IdentityProviderHandlerParameter removedHandlerParameter, final SimpleCallback<Boolean> callback) {
        AddressBinding address = this.identityProviderHandlerParameterMetaData.getAddress();
        ModelNode addressModel = address.asResource(baseadress.getAdress(), federation.getName(), identityProvider.getName(), handler.getClassName(),
                removedHandlerParameter.getName());

        ModelNode operation = identityProviderHandlerParameterAdapter.fromEntity(removedHandlerParameter);
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

    @Override
    public void createServiceProviderHandler(FederationWrapper currentFederation, ServiceProvider serviceProvider,
            ServiceProviderHandler newTrustedDomain, final SimpleCallback<ResponseWrapper<Boolean>> callback) {
        AddressBinding address = serviceProviderHandlerMetaData.getAddress();
        ModelNode addressModel = address.asResource(baseadress.getAdress(), currentFederation.getName(), serviceProvider.getName(),
                newTrustedDomain.getClassName());

        ModelNode operation = serviceProviderHandlerAdapter.fromEntity(newTrustedDomain);
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
     * @see org.picketlink.as.console.client.shared.subsys.model.FederationStore#deleteServiceProviderHandler(org.picketlink.as.console.client.shared.subsys.model.FederationWrapper, org.picketlink.as.console.client.shared.subsys.model.ServiceProvider, org.picketlink.as.console.client.shared.subsys.model.ServiceProviderHandler, org.jboss.as.console.client.domain.model.SimpleCallback)
     */
    @Override
    public void deleteServiceProviderHandler(FederationWrapper currentFederation, ServiceProvider serviceProvider,
            ServiceProviderHandler removedTrustedDomain, final SimpleCallback<Boolean> callback) {
        AddressBinding address = this.serviceProviderHandlerMetaData.getAddress();
        ModelNode addressModel = address.asResource(baseadress.getAdress(), currentFederation.getName(), serviceProvider.getName(),
                removedTrustedDomain.getClassName());

        ModelNode operation = serviceProviderHandlerAdapter.fromEntity(removedTrustedDomain);
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

    @Override
    public void createServiceProviderHandlerParameter(FederationWrapper currentFederation, ServiceProvider serviceProvider,
            ServiceProviderHandler selectedHandler, ServiceProviderHandlerParameter newHandlerParameter,
            final SimpleCallback<ResponseWrapper<Boolean>> callback) {
        AddressBinding address = serviceProviderHandlerParameterMetaData.getAddress();
        ModelNode addressModel = address.asResource(baseadress.getAdress(), currentFederation.getName(), serviceProvider.getName(),
                selectedHandler.getClassName(), newHandlerParameter.getName());

        ModelNode operation = serviceProviderHandlerParameterAdapter.fromEntity(newHandlerParameter);
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

    @Override
    public void deleteServiceProviderHandlerParameter(FederationWrapper currentFederation, ServiceProvider serviceProvider,
            ServiceProviderHandler selectedHandler, ServiceProviderHandlerParameter removedHandlerParameter,
            final SimpleCallback<Boolean> callback) {
        AddressBinding address = this.serviceProviderHandlerParameterMetaData.getAddress();
        ModelNode addressModel = address.asResource(baseadress.getAdress(), currentFederation.getName(), serviceProvider.getName(), selectedHandler.getClassName(),
                removedHandlerParameter.getName());

        ModelNode operation = serviceProviderHandlerParameterAdapter.fromEntity(removedHandlerParameter);
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

    @Override
    public void createSAMLConfiguration(FederationWrapper currentFederation, SAMLConfiguration updatedEntity,
            final SimpleCallback<ResponseWrapper<Boolean>> callback) {
        AddressBinding address = samlConfigurationMetaData.getAddress();
        ModelNode addressModel = address.asResource(baseadress.getAdress(), currentFederation.getName(), currentFederation.getName() + "-saml");

        ModelNode operation = samlConfigurationAdapter.fromEntity(updatedEntity);
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

    @Override
    public void deleteSAMLConfiguration(FederationWrapper currentFederation, SAMLConfiguration samlConfig,
            final SimpleCallback<ResponseWrapper<Boolean>> callback) {
        AddressBinding address = this.samlConfigurationMetaData.getAddress();
        ModelNode addressModel = address.asResource(baseadress.getAdress(), currentFederation.getName(), currentFederation.getName() + "-saml");

        ModelNode operation = samlConfigurationAdapter.fromEntity(samlConfig);
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
                callback.onSuccess(new ResponseWrapper<Boolean>(wasSuccessful, modelNode));
            }
        });
    }
}
