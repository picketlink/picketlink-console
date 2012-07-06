package org.picketlink.as.console.client.ui.federation.idp;

import java.util.Map;

import org.jboss.as.console.client.widgets.forms.FormToolStrip;
import org.jboss.ballroom.client.widgets.forms.CheckBoxItem;
import org.jboss.ballroom.client.widgets.forms.Form;
import org.picketlink.as.console.client.shared.subsys.model.IdentityProvider;
import org.picketlink.as.console.client.ui.federation.AsyncHelpText;
import org.picketlink.as.console.client.ui.federation.FederationPresenter;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class EncryptionSupportTabEditor {

    private Form<IdentityProvider> form;
    private FederationPresenter presenter;
    
    private CheckBoxItem encryptItem;
    private IdentityProvider entity;
    private HTML errorMessage;

    public EncryptionSupportTabEditor(FederationPresenter presenter) {
        this.presenter = presenter;
    }
    
    public Widget asWidget() {
        VerticalPanel panel = new VerticalPanel();

        panel.setStyleName("fill-layout-width");
        
        new AsyncHelpText("identity-provider", new String[] {"encrypt"}, this.presenter, panel, false);
        
        addForm(panel);

        return panel;
    }

    /**
     * @param panel
     */
    private void addForm(VerticalPanel panel) {
        this.form = new Form<IdentityProvider>(IdentityProvider.class);
        
        errorMessage = new HTML();
        
        errorMessage.setStyleName("error-panel");
        
        panel.add(errorMessage);
        
        FormToolStrip<IdentityProvider> toolStrip = new FormToolStrip<IdentityProvider>(this.form, new FormToolStrip.FormCallback<IdentityProvider>() {
            @Override
            public void onSave(Map<String, Object> changeset) {
                IdentityProvider updatedIdentityProvider = form.getUpdatedEntity();
                
                entity.setSupportsSignatures(updatedIdentityProvider.isSupportsSignatures());
                
                getPresenter().getFederationManager().onUpdateIdentityProvider(entity, changeset);
            }

            @Override
            public void onDelete(IdentityProvider entity) {
            }
        });

        toolStrip.providesDeleteOp(false);
        
        panel.add(toolStrip.asWidget());

        this.form.setEnabled(false);

        this.encryptItem = new CheckBoxItem("encrypt","Encrypt SAML Assertions");

        this.form.setFields(encryptItem);
        
        panel.add(this.form.asWidget());
    }

    private void enableDisableFields() {
        if (getPresenter().getCurrentFederation() != null) {
            if (getPresenter().getCurrentFederation().getKeyStores().isEmpty()) {
                errorMessage.setHTML("This configuration is disabled because the current federation does not support encryption.");
            } else {
                errorMessage.setHTML("");
            }
            
            if (getPresenter().getCurrentFederation().getKeyStores().isEmpty()) {
                this.encryptItem.setEnabled(false);
            } else {
                this.encryptItem.setEnabled(true);
            }
        }
    }

    public void setEntity(IdentityProvider entity) {
        this.entity = entity;
        this.form.edit(entity);
        encryptItem.setValue(entity.isEncrypt());
        enableDisableFields();
    }
    
    protected FederationPresenter getPresenter() {
        return presenter;
    }

}