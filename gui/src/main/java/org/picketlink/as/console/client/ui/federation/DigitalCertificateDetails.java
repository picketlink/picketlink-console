/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2012, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.picketlink.as.console.client.ui.federation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jboss.as.console.client.widgets.forms.FormToolStrip;
import org.jboss.ballroom.client.widgets.forms.Form;
import org.jboss.ballroom.client.widgets.forms.PasswordBoxItem;
import org.jboss.ballroom.client.widgets.forms.TextBoxItem;
import org.picketlink.as.console.client.shared.subsys.model.KeyStore;
import org.picketlink.as.console.client.shared.subsys.model.ServiceProvider;
import org.picketlink.as.console.client.shared.subsys.model.ServiceProviderWrapper;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 30, 2012
 */
public class DigitalCertificateDetails {

    private TextBoxItem signKeyAliasItem;
    private final Form<KeyStore> form;
    private final FederationPresenter presenter;
    private boolean hasKeyStore;
    
    /**
     * @param presenter
     */
    public DigitalCertificateDetails(FederationPresenter presenter) {
        form = new Form<KeyStore>(KeyStore.class);
        this.presenter = presenter;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.google.gwt.user.client.ui.IsWidget#asWidget()
     */
    public Widget asWidget() {
        VerticalPanel layout = new VerticalPanel();

        layout.setStyleName("fill-layout");

        TextBoxItem aliasItem = new TextBoxItem("url", "KeyStore Location");
        
        aliasItem.getInputElement().getStyle().setWidth(300, Unit.PX);
        
        PasswordBoxItem passwdItem = new PasswordBoxItem("passwd", "KeyStore Password");
        
        passwdItem.getInputElement().getStyle().setWidth(150, Unit.PX);
        
        signKeyAliasItem = new TextBoxItem("signKeyAlias", "Singning Key Alias");
        
        signKeyAliasItem.getInputElement().getStyle().setWidth(150, Unit.PX);
        
        PasswordBoxItem signKeyPasswdItem = new PasswordBoxItem("signKeyPasswd", "Singning Key Password");
        
        signKeyPasswdItem.getInputElement().getStyle().setWidth(150, Unit.PX);
        
        form.setFields(aliasItem, passwdItem, signKeyAliasItem, signKeyPasswdItem);
        
        form.setEnabled(false);
        
        FormToolStrip<KeyStore> toolStrip = new FormToolStrip<KeyStore>(form, new FormToolStrip.FormCallback<KeyStore>() {
            @Override
            public void onSave(Map<String, Object> changeset) {
                if (!hasKeyStore) {
                    presenter.getFederationManager().onCreateKeyStore(form.getUpdatedEntity());
                    hasKeyStore = true;
                } else {
                    presenter.getFederationManager().onUpdateKeyStore(form.getUpdatedEntity(), changeset);
                }
                
                form.edit(form.getUpdatedEntity());
            }

            @Override
            public void onDelete(KeyStore keyStore) {
                if (hasKeyStore) {
                    presenter.getFederationManager().onRemoveKeyStore(keyStore);
                    form.clearValues();
                    hasKeyStore = false;
                    form.edit(presenter.getBeanFactory().keyStore().as());
                    signKeyAliasItem.setEnabled(true);
                    
                    if (presenter.getCurrentFederation().getIdentityProvider() != null) {
                        presenter.getCurrentFederation().getIdentityProvider().getIdentityProvider().setSupportsSignatures(true);
                        
                        HashMap<String, Object> changedValues = new HashMap<String, Object>();
                        
                        changedValues.put("supportsSignatures", "false");
                        
                        presenter.getFederationManager().onUpdateIdentityProvider(presenter.getCurrentFederation().getIdentityProvider().getIdentityProvider(), changedValues);
                        
                        List<ServiceProviderWrapper> serviceProviders = presenter.getCurrentFederation().getServiceProviders();
                        
                        for (ServiceProviderWrapper serviceProvider : serviceProviders) {
                            presenter.getFederationManager().onUpdateServiceProvider(serviceProvider.getServiceProvider(), changedValues);
                            
                        }
                    }
                } else {
                    Window.alert("You must save before removing.");
                }
            }
        });
        
        toolStrip.providesDeleteOp(true);
        form.edit(this.presenter.getBeanFactory().keyStore().as());

        layout.add(toolStrip.asWidget());
        layout.add(form.asWidget());

        return layout;
    }

    public void setKeyStore(KeyStore keyStore) {
        this.hasKeyStore = keyStore != null;
        
        if (keyStore != null) {
            this.signKeyAliasItem.setEnabled(false);
            form.edit(keyStore);
        } else {
            form.clearValues();
            form.edit(this.presenter.getBeanFactory().keyStore().as());
        }
    }

}
