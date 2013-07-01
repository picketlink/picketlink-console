package org.picketlink.as.console.client.ui.federation.idp;

import org.picketlink.as.console.client.shared.subsys.model.IdentityProvider;

import com.google.gwt.event.shared.EventHandler;

public interface ChangedIdentityProviderHandler extends EventHandler {

    void onAddIdentityProvider(IdentityProvider identityProvider);

    void onRemoveIdentityProvider(IdentityProvider identityProvider);
    
}
