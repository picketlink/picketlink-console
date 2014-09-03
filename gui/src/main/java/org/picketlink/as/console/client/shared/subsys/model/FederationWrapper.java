package org.picketlink.as.console.client.shared.subsys.model;

import java.util.ArrayList;
import java.util.List;

public class FederationWrapper implements Federation {

    private Federation federation;

    private List<IdentityProviderWrapper> identityProviders;
    private List<ServiceProviderWrapper> serviceProviders;

    private List<KeyStore> keyStores;

    private ArrayList<SAMLConfiguration> samlConfigurations;

    private SAMLConfiguration samlConfiguration;

    public FederationWrapper(Federation federation) {
        this.federation = federation;
    }
    
    public IdentityProviderWrapper getIdentityProvider() {
        IdentityProviderWrapper identityProvider = null;
        
        if (!this.getIdentityProviders().isEmpty()) {
            identityProvider = this.getIdentityProviders().get(0);
        }
        
        return identityProvider;
    }
    
    public List<IdentityProviderWrapper> getIdentityProviders() {
        if (this.identityProviders == null) {
            this.identityProviders = new ArrayList<IdentityProviderWrapper>();
        }

        return this.identityProviders;
    }

    public List<ServiceProviderWrapper> getServiceProviders() {
        if (this.serviceProviders == null) {
            this.serviceProviders = new ArrayList<ServiceProviderWrapper>();
        }

        return this.serviceProviders;
    }

    public void addIdentityProvider(IdentityProviderWrapper identityProvider) {
        this.getIdentityProviders().add(identityProvider);
    }
    
    public void addServiceProvider(ServiceProviderWrapper serviceProvider) {
        this.getServiceProviders().add(serviceProvider);
    }

    public List<KeyStore> getKeyStores() {
        if (this.keyStores == null) {
            this.keyStores = new ArrayList<KeyStore>();
        }

        return this.keyStores;
    }

    public String getName() {
        return federation.getName();
    }

    public void setName(String alias) {
        federation.setName(alias);
    }

    public SAMLConfiguration getSAMLConfiguration() {
        return this.samlConfiguration;
    }
    
    public void setSAMLConfiguration(SAMLConfiguration samlConfiguration) {
        this.samlConfiguration = samlConfiguration;
    }
    
    
}