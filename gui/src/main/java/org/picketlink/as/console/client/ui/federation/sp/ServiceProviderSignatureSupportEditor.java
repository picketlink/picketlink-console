package org.picketlink.as.console.client.ui.federation.sp;

import java.util.Map;

import org.picketlink.as.console.client.shared.subsys.model.ServiceProvider;
import org.picketlink.as.console.client.ui.federation.FederationPresenter;
import org.picketlink.as.console.client.ui.federation.idp.SignatureSupportTabEditor;

public class ServiceProviderSignatureSupportEditor extends SignatureSupportTabEditor<ServiceProvider> {

    public ServiceProviderSignatureSupportEditor(FederationPresenter presenter) {
        super(presenter);
    }

    @Override
    protected void doUpdateEntity(Map changeset) {
        getPresenter().getFederationManager().onUpdateServiceProvider(getEntity(), changeset);        
    }
    
    /* (non-Javadoc)
     * @see org.picketlink.as.console.client.ui.federation.idp.SignatureSupportTabEditor#getEntityClass()
     */
    @Override
    protected Class<ServiceProvider> getEntityClass() {
        return ServiceProvider.class;
    }

    /* (non-Javadoc)
     * @see org.picketlink.as.console.client.ui.federation.idp.SignatureSupportTabEditor#doGetSupportsSignatureLabel()
     */
    @Override
    protected String doGetSupportsSignatureLabel() {
        return "Supports Signature or Encryption";
    }
}
