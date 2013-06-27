package org.picketlink.as.console.client.shared.subsys.model;

import java.util.ArrayList;
import java.util.List;

public class IdentityProviderHandlerWrapper {

    private IdentityProviderHandler handler;
    private List<IdentityProviderHandlerParameter> parameters;

    public IdentityProviderHandlerWrapper(IdentityProviderHandler handler) {
        this.handler = handler;
    }
    
    public IdentityProviderHandler getHandler() {
        return handler;
    }

    public List<IdentityProviderHandlerParameter> getParameters() {
        if (this.parameters == null) {
            this.parameters = new ArrayList<IdentityProviderHandlerParameter>();
        }

        return this.parameters;
    }

    public void addParameter(IdentityProviderHandlerParameter parameter) {
        getParameters().add(parameter);
    }
}