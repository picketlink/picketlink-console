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

import java.util.List;
import java.util.Map;

import org.jboss.as.console.client.domain.model.SimpleCallback;
import org.jboss.as.console.client.shared.model.ResponseWrapper;
import org.jboss.as.console.client.shared.subsys.security.model.SecurityDomain;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * <p>This interface defines the methods that can be used to manipulate the {@link Federation} model.</p>
 * 
 * @author Pedro Silva
 * @since Mar 14, 2012
 */
public interface FederationStore {
    
    void loadSecurityDomains(final SimpleCallback<List<SecurityDomain>> simpleCallback);
    
    /**
     * Loads all federation configurations.
     * 
     * @param callback
     */
    void loadFederations(AsyncCallback<List<Federation>> callback);
    
    /**
     * <p>
     * Loads the identity providers configurations given a federation instance.
     * </p>
     * 
     * @param federation
     * @param callback
     */
    void loadIdentityProviders(Federation federation, final AsyncCallback<List<IdentityProvider>> callback);

    /**
     * <p>
     * Loads the keystore configuration given a federation instance.
     * </p>
     * 
     * @param federation
     * @param simpleCallback
     */
    void loadKeyStore(Federation federation, SimpleCallback<List<KeyStore>> simpleCallback);
    
    /**
     * <p>
     * Loads the service providers configurations given a federation instance.
     * </p>
     * 
     * @param federation
     * @param simpleCallback
     */
    void loadServiceProviders(Federation federation, SimpleCallback<List<ServiceProvider>> simpleCallback);

    /**
     * <p>
     * Create a new federation element configuration in the subsystem.
     * </p>
     * 
     * @param datasource
     * @param callback
     */
    void createFederation(Federation federation, AsyncCallback<ResponseWrapper<Boolean>> callback);
    
    /**
     * <p>
     * Create a new keystore element configuration in the subsystem.
     * </p>
     * 
     * @param keyStore
     * @param simpleCallback
     */
    void createKeyStore(Federation federation, KeyStore keyStore, SimpleCallback<ResponseWrapper<Boolean>> simpleCallback);

    /**
     * <p>
     * Deletes a federation element configuration from the subsystem.
     * </p>
     * 
     * @param federation
     * @param simpleCallback
     */
    void deleteFederation(Federation federation, SimpleCallback<Boolean> simpleCallback);

    /**
     * @param identityProvider
     * @param simpleCallback
     */
    void createIdentityProvider(Federation federation, IdentityProvider identityProvider, SimpleCallback<ResponseWrapper<Boolean>> simpleCallback);

    /**
     * @param federation
     * @param changedValues
     * @param simpleCallback
     */
    void updateIdentityProvider(Federation federation, IdentityProvider identityProvider, Map<String, Object> changedValues,
            SimpleCallback<ResponseWrapper<Boolean>> simpleCallback);

    /**
     * @param currentFederation
     * @param serviceProvider
     * @param simpleCallback
     */
    void createServiceProvider(Federation currentFederation, ServiceProvider serviceProvider,
            SimpleCallback<ResponseWrapper<Boolean>> simpleCallback);

    /**
     * @param currentFederation
     * @param trustDomain
     * @param simpleCallback
     */
    void createTrustDomain(Federation currentFederation, IdentityProvider identityProvider, TrustDomain trustDomain,
            SimpleCallback<ResponseWrapper<Boolean>> simpleCallback);

    /**
     * @param currentFederation
     * @param identityProvider
     * @param simpleCallback
     */
    void loadTrustDomains(Federation currentFederation, IdentityProvider identityProvider,
            SimpleCallback<List<TrustDomain>> simpleCallback);

    /**
     * @param currentFederation
     * @param identityProvider
     * @param simpleCallback
     */
    void deleteTrustDomain(Federation currentFederation, IdentityProvider identityProvider, TrustDomain trustDomain,
            SimpleCallback<Boolean> callback);

    /**
     * @param currentFederation
     * @param serviceProvider
     * @param simpleCallback
     */
    void deleteServiceProvider(Federation currentFederation, ServiceProvider serviceProvider,
            SimpleCallback<Boolean> simpleCallback);

    /**
     * @param currentFederation
     * @param identityProvider
     * @param simpleCallback
     */
    void deleteIdentityProvider(Federation currentFederation, IdentityProvider identityProvider,
            SimpleCallback<Boolean> simpleCallback);

    /**
     * @param currentFederation
     * @param currentSelection
     * @param changedValues
     * @param simpleCallback
     */
    void updateServiceProvider(Federation currentFederation, ServiceProvider currentSelection,
            Map<String, Object> changedValues, SimpleCallback<ResponseWrapper<Boolean>> simpleCallback);

    void updateKeyStore(Federation currentFederation, KeyStore updatedEntity, Map<String, Object> changedValues,
            SimpleCallback<ResponseWrapper<Boolean>> simpleCallback);

    void deleteKeyStore(Federation federation, KeyStore keyStore, SimpleCallback<Boolean> simpleCallback);

    void loadConfiguration(SimpleCallback<Map<String, FederationWrapper>> callback);

    void createIdentityProviderHandler(FederationWrapper currentFederation, IdentityProvider identityProvider,
            IdentityProviderHandler newHandler, SimpleCallback<ResponseWrapper<Boolean>> simpleCallback);

    void deleteIdentityProviderHandler(FederationWrapper currentFederation, IdentityProvider identityProvider,
            IdentityProviderHandler removedTrustedDomain, SimpleCallback<Boolean> simpleCallback);

    void createIdentityProviderHandlerParameter(FederationWrapper currentFederation, IdentityProvider identityProvider,IdentityProviderHandler handler,
            IdentityProviderHandlerParameter newHandlerParameter, SimpleCallback<ResponseWrapper<Boolean>> simpleCallback);

    void deleteIdentityProviderHandlerParameter(FederationWrapper currentFederation, IdentityProvider identityProvider,IdentityProviderHandler handler,
            IdentityProviderHandlerParameter removedHandlerParameter, SimpleCallback<Boolean> simpleCallback);

    void createServiceProviderHandler(FederationWrapper currentFederation, ServiceProvider serviceProvider,
            ServiceProviderHandler newTrustedDomain, SimpleCallback<ResponseWrapper<Boolean>> simpleCallback);

    void deleteServiceProviderHandler(FederationWrapper currentFederation, ServiceProvider serviceProvider,
            ServiceProviderHandler removedTrustedDomain, SimpleCallback<Boolean> simpleCallback);

    void createServiceProviderHandlerParameter(FederationWrapper currentFederation, ServiceProvider serviceProvider,
            ServiceProviderHandler selectedHandler, ServiceProviderHandlerParameter newHandlerParameter,
            SimpleCallback<ResponseWrapper<Boolean>> simpleCallback);

    void deleteServiceProviderHandlerParameter(FederationWrapper currentFederation, ServiceProvider serviceProvider,
            ServiceProviderHandler selectedHandler, ServiceProviderHandlerParameter removedHandlerParameter,
            SimpleCallback<Boolean> simpleCallback);

    void createSAMLConfiguration(FederationWrapper currentFederation, SAMLConfiguration updatedEntity,
            SimpleCallback<ResponseWrapper<Boolean>> simpleCallback);

    void deleteSAMLConfiguration(FederationWrapper currentFederation, SAMLConfiguration samlConfig,
            SimpleCallback<ResponseWrapper<Boolean>> simpleCallback);

    void updateSAMLConfiguration(FederationWrapper currentFederation, SAMLConfiguration updatedEntity,
            Map<String, Object> changedValues, SimpleCallback<ResponseWrapper<Boolean>> simpleCallback);

}
