package org.picketlink.as.console.client.shared.subsys.model;

import java.util.ArrayList;
import java.util.List;

public class ServiceProviderHandlerWrapper {

    private ServiceProviderHandler handler;
    private List<ServiceProviderHandlerParameter> parameters;

    public ServiceProviderHandlerWrapper(ServiceProviderHandler handler) {
        this.handler = handler;
    }
    
    public ServiceProviderHandler getHandler() {
        return handler;
    }

    public List<ServiceProviderHandlerParameter> getParameters() {
        if (this.parameters == null) {
            this.parameters = new ArrayList<ServiceProviderHandlerParameter>();
        }

        return this.parameters;
    }

    public void addParameter(ServiceProviderHandlerParameter parameter) {
        getParameters().add(parameter);
    }
}