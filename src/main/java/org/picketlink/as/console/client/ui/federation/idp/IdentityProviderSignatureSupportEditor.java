package org.picketlink.as.console.client.ui.federation.idp;

import java.util.Map;

import org.picketlink.as.console.client.shared.subsys.model.IdentityProvider;
import org.picketlink.as.console.client.ui.federation.FederationPresenter;

public class IdentityProviderSignatureSupportEditor extends SignatureSupportTabEditor<IdentityProvider> {

    public IdentityProviderSignatureSupportEditor(FederationPresenter presenter) {
        super(presenter);
    }

    @Override
    protected void doUpdateEntity(Map changeset) {
        getPresenter().getFederationManager().onUpdateIdentityProvider(getIdentityProvider(), changeset);        
    }

    /* (non-Javadoc)
     * @see org.picketlink.as.console.client.ui.federation.idp.SignatureSupportTabEditor#getEntityClass()
     */
    @Override
    protected Class<IdentityProvider> getEntityClass() {
        return IdentityProvider.class;
    }

}
