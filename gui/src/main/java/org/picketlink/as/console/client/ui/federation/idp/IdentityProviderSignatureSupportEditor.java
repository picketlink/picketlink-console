package org.picketlink.as.console.client.ui.federation.idp;

import java.util.Map;

import org.picketlink.as.console.client.i18n.PicketLinkUIConstants;
import org.picketlink.as.console.client.shared.subsys.model.IdentityProvider;
import org.picketlink.as.console.client.ui.federation.FederationPresenter;

public class IdentityProviderSignatureSupportEditor extends SignatureSupportTabEditor<IdentityProvider> {

    public IdentityProviderSignatureSupportEditor(FederationPresenter presenter, PicketLinkUIConstants uiConstants) {
        super(presenter, uiConstants);
    }

    @Override
    protected void doUpdateEntity(Map changeset) {
        getPresenter().getFederationManager().onUpdateIdentityProvider(getEntity(), changeset);        
    }

    /* (non-Javadoc)
     * @see org.picketlink.as.console.client.ui.federation.idp.SignatureSupportTabEditor#getEntityClass()
     */
    @Override
    protected Class<IdentityProvider> getEntityClass() {
        return IdentityProvider.class;
    }

}
