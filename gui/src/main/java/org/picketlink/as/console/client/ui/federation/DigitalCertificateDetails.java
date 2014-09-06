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

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import org.jboss.as.console.client.Console;
import org.jboss.as.console.client.domain.model.SimpleCallback;
import org.jboss.as.console.client.widgets.forms.FormToolStrip;
import org.jboss.ballroom.client.widgets.forms.Form;
import org.jboss.ballroom.client.widgets.forms.PasswordBoxItem;
import org.jboss.ballroom.client.widgets.forms.TextBoxItem;
import org.jboss.ballroom.client.widgets.tools.ToolButton;
import org.picketlink.as.console.client.i18n.PicketLinkUIConstants;
import org.picketlink.as.console.client.shared.subsys.model.KeyStore;
import org.picketlink.as.console.client.shared.subsys.model.KeyStoreWrapper;
import org.picketlink.as.console.client.shared.subsys.model.ServiceProviderWrapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 30, 2012
 */
public class DigitalCertificateDetails {

    private final PicketLinkUIConstants uiConstants;
    private TextBoxItem signKeyAliasItem;
    private final Form<KeyStore> form;
    private final FederationPresenter presenter;
    private boolean hasKeyStore;
    private ToolButton deleteButton;
    private KeyEditor keyEditor;

    /**
     * @param presenter
     * @param uiConstants
     */
    public DigitalCertificateDetails(FederationPresenter presenter, PicketLinkUIConstants uiConstants) {
        form = new Form<KeyStore>(KeyStore.class);
        this.presenter = presenter;
        this.uiConstants = uiConstants;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.google.gwt.user.client.ui.IsWidget#asWidget()
     */
    public Widget asWidget() {
        VerticalPanel layout = new VerticalPanel();

        layout.setStyleName("rhs-content-panel");

        TextBoxItem pathItem = new TextBoxItem("url", "KeyStore Path");
        
        pathItem.getInputElement().getStyle().setWidth(300, Unit.PX);

        final TextBoxItem relativeToItem = new TextBoxItem("relativeTo", "Path Relative To");

        relativeToItem.getInputElement().getStyle().setWidth(300, Unit.PX);
        relativeToItem.setRequired(false);

        PasswordBoxItem passwdItem = new PasswordBoxItem("passwd", "KeyStore Password");
        
        passwdItem.getInputElement().getStyle().setWidth(150, Unit.PX);
        
        signKeyAliasItem = new TextBoxItem("signKeyAlias", "Signing Key Alias");
        
        signKeyAliasItem.getInputElement().getStyle().setWidth(150, Unit.PX);
        
        PasswordBoxItem signKeyPasswdItem = new PasswordBoxItem("signKeyPasswd", "Signing Key Password");
        
        signKeyPasswdItem.getInputElement().getStyle().setWidth(150, Unit.PX);
        
        form.setFields(pathItem, relativeToItem, passwdItem, signKeyAliasItem, signKeyPasswdItem);
        
        form.setEnabled(false);
        
        FormToolStrip<KeyStore> toolStrip = new FormToolStrip<KeyStore>(form, new FormToolStrip.FormCallback<KeyStore>() {
            @Override
            public void onSave(Map<String, Object> changeset) {
                if (presenter.getCurrentFederation() == null) {
                    Window.alert("You must select a federation first.");
                }

                KeyStore updatedEntity = form.getUpdatedEntity();

                if (relativeToItem.getValue() != null && relativeToItem.getValue().isEmpty()) {
                    updatedEntity.setRelativeTo(null);
                }

                if (!hasKeyStore) {
                    presenter.getFederationManager().onCreateKeyStore(updatedEntity, new SimpleCallback<Boolean>() {
                        @Override
                        public void onSuccess(Boolean aBoolean) {
                            hasKeyStore = aBoolean;
                            deleteButton.setEnabled(true);
                        }
                    });
                } else {
                    presenter.getFederationManager().onUpdateKeyStore(updatedEntity, changeset);
                }
                
                form.edit(updatedEntity);
            }

            @Override
            public void onDelete(KeyStore keyStore) {

            }
        });

        this.deleteButton = new ToolButton(Console.CONSTANTS.common_label_delete());

        deleteButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                if (hasKeyStore) {
                    presenter.getFederationManager().onRemoveKeyStore(form.getEditedEntity());
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

        toolStrip.addToolButtonRight(deleteButton);
        this.deleteButton.setEnabled(false);

        form.edit(this.presenter.getBeanFactory().keyStore().as());

        layout.add(toolStrip.asWidget());
        layout.add(form.asWidget());

        layout.add(getKeyEditor().asWidget());

        return layout;
    }

    private KeyEditor getKeyEditor() {
        if (this.keyEditor == null) {
            this.keyEditor = new KeyEditor(this.presenter, this.uiConstants);
        }

        return this.keyEditor;
    }

    public void setKeyStore(KeyStoreWrapper keyStore) {
        this.hasKeyStore = keyStore != null;
        
        if (keyStore != null) {
            this.signKeyAliasItem.setEnabled(false);
            this.deleteButton.setEnabled(true);
            form.edit(keyStore.getKeyStore());
            getKeyEditor().setEnabled(true);
            getKeyEditor().getKeyTable().setList(keyStore.getKeys());
        } else {
            form.clearValues();
            this.signKeyAliasItem.setEnabled(true);
            this.deleteButton.setEnabled(false);
            form.edit(this.presenter.getBeanFactory().keyStore().as());
            getKeyEditor().setEnabled(false);
        }
    }
}
