package org.picketlink.as.console.client.ui.federation.idp;

import org.picketlink.as.console.client.shared.subsys.model.IdentityProvider;

import com.google.gwt.event.shared.GwtEvent;

public class RemoveIdentityProviderEvent extends GwtEvent<ChangedIdentityProviderHandler> {
    
    public static Type<ChangedIdentityProviderHandler> TYPE = new Type<ChangedIdentityProviderHandler>();
    private final IdentityProvider identityProvider;
    
    public RemoveIdentityProviderEvent(IdentityProvider identityProvider) {
        this.identityProvider = identityProvider;
    }
    
    /* (non-Javadoc)
     * @see com.google.gwt.event.shared.GwtEvent#dispatch(com.google.gwt.event.shared.EventHandler)
     */
    @Override
    protected void dispatch(ChangedIdentityProviderHandler handler) {
        handler.onRemoveIdentityProvider(this.identityProvider);
    }

    /* (non-Javadoc)
     * @see com.google.gwt.event.shared.GwtEvent#getAssociatedType()
     */
    @Override
    public com.google.gwt.event.shared.GwtEvent.Type<ChangedIdentityProviderHandler> getAssociatedType() {
        return TYPE;
    }
    
}