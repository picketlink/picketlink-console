package org.picketlink.as.console.client.ui.federation.sp;

import org.picketlink.as.console.client.shared.subsys.model.ServiceProvider;

import com.google.gwt.event.shared.EventHandler;

public interface ChangedServiceProviderHandler extends EventHandler {

    void onAddServiceProvider(ServiceProvider serviceProvider);

    void onRemoveServiceProvider(ServiceProvider serviceProvider);
    
}
