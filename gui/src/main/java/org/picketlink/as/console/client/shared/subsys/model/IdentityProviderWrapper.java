package org.picketlink.as.console.client.shared.subsys.model;

import java.util.ArrayList;
import java.util.List;

public class IdentityProviderWrapper {

    private IdentityProvider identityProvider;
    private List<TrustDomain> trustDomains;
    private ArrayList<IdentityProviderHandlerWrapper> handlers;

    public IdentityProviderWrapper(IdentityProvider identityProvider) {
        this.identityProvider = identityProvider;
    }
    
    public IdentityProvider getIdentityProvider() {
        return identityProvider;
    }

    public void setIdentityProvider(IdentityProvider identityProvider) {
        this.identityProvider = identityProvider;
    }

    public List<TrustDomain> getTrustDomains() {
        if (this.trustDomains == null) {
            this.trustDomains = new ArrayList<TrustDomain>();
        }

        return this.trustDomains;
    }

    public void addTrustDomain(TrustDomain trustDomain) {
        getTrustDomains().add(trustDomain);
    }

    public List<IdentityProviderHandlerWrapper> getHandlers() {
        if (this.handlers == null) {
            this.handlers = new ArrayList<IdentityProviderHandlerWrapper>();
        }

        return this.handlers;
    }

    public void addHandler(IdentityProviderHandlerWrapper handler) {
        getHandlers().add(handler);
    }

}