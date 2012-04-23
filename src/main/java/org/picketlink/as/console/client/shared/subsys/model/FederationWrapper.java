package org.picketlink.as.console.client.shared.subsys.model;

import java.util.ArrayList;
import java.util.List;

public class FederationWrapper implements Federation {

    private Federation federation;

    private List<IdentityProviderWrapper> identityProviders;
    private List<ServiceProvider> serviceProviders;

    private List<KeyStore> keyStores;

    public List<SecurityTokenService> securityTokenServices;

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

    public List<ServiceProvider> getServiceProviders() {
        if (this.serviceProviders == null) {
            this.serviceProviders = new ArrayList<ServiceProvider>();
        }

        return this.serviceProviders;
    }

    public List<SecurityTokenService> getSecurityTokenServices() {
        if (this.securityTokenServices == null) {
            this.securityTokenServices = new ArrayList<SecurityTokenService>();
        }

        return this.securityTokenServices;
    }
    
    public void addIdentityProvider(IdentityProviderWrapper identityProvider) {
        this.getIdentityProviders().add(identityProvider);
    }
    
    public void addServiceProvider(ServiceProvider serviceProvider) {
        this.getServiceProviders().add(serviceProvider);
    }

    public void addSecurityTokenService(SecurityTokenService securityTokenService) {
        this.getSecurityTokenServices().add(securityTokenService);
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
    
    
}