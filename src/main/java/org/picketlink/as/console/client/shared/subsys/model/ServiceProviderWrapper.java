package org.picketlink.as.console.client.shared.subsys.model;

import java.util.ArrayList;
import java.util.List;

public class ServiceProviderWrapper {

    private ServiceProvider serviceProvider;
    private List<ServiceProviderHandlerWrapper> handlers;

    public ServiceProviderWrapper(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }
    
    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public List<ServiceProviderHandlerWrapper> getHandlers() {
        if (this.handlers == null) {
            this.handlers = new ArrayList<ServiceProviderHandlerWrapper>();
        }

        return this.handlers;
    }

    public void addHandler(ServiceProviderHandlerWrapper handler) {
        getHandlers().add(handler);
    }

}