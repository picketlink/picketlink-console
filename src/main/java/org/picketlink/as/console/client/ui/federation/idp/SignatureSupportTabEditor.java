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

package org.picketlink.as.console.client.ui.federation.idp;

import java.util.Map;

import org.jboss.as.console.client.widgets.forms.FormToolStrip;
import org.jboss.ballroom.client.widgets.forms.CheckBoxItem;
import org.jboss.ballroom.client.widgets.forms.Form;
import org.picketlink.as.console.client.PicketLinkConsoleFramework;
import org.picketlink.as.console.client.shared.subsys.model.IdentityProvider;
import org.picketlink.as.console.client.ui.federation.FederationPresenter;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 31, 2012
 */
public class SignatureSupportTabEditor {

    private Form<IdentityProvider> identityProviderForm;
    private FederationPresenter presenter;
    
    private CheckBoxItem signOutgoingMessages;
    private CheckBoxItem ignoreIncomingSignature;
    private IdentityProvider identityProvider;
    private HTML errorMessage;

    public SignatureSupportTabEditor(FederationPresenter presenter) {
        this.presenter = presenter;
    }
    
    public Widget asWidget() {
        // adds the key store section
        VerticalPanel keyStoreHeader = new VerticalPanel();

        keyStoreHeader.setStyleName("fill-layout-width");

        addIdentityProviderForm(keyStoreHeader);

        return keyStoreHeader;
    }

    /**
     * @param identityProviderHeader
     */
    private void addIdentityProviderForm(VerticalPanel identityProviderHeader) {
        this.identityProviderForm = new Form<IdentityProvider>(IdentityProvider.class);
        
        errorMessage = new HTML();
        
        errorMessage.setStyleName("error-panel");
        
        identityProviderHeader.add(errorMessage);
        
        FormToolStrip<IdentityProvider> toolStrip = new FormToolStrip<IdentityProvider>(this.identityProviderForm, new FormToolStrip.FormCallback<IdentityProvider>() {
            @Override
            public void onSave(Map<String, Object> changeset) {
                getPresenter().getFederationManager().onUpdateIdentityProvider(identityProvider, changeset);
            }

            @Override
            public void onDelete(IdentityProvider entity) {
            }
        });

        toolStrip.providesDeleteOp(false);
        
        identityProviderHeader.add(toolStrip.asWidget());

        this.identityProviderForm.setEnabled(false);

        signOutgoingMessages = new CheckBoxItem("signOutgoingMessages",
                PicketLinkConsoleFramework.CONSTANTS.common_label_signOutgoingMessages());

        ignoreIncomingSignature = new CheckBoxItem("ignoreIncomingSignatures",
                PicketLinkConsoleFramework.CONSTANTS.common_label_ignoreIncomingSignatures());

        this.identityProviderForm.setFields(signOutgoingMessages, ignoreIncomingSignature);
        
        identityProviderHeader.add(this.identityProviderForm.asWidget());
    }

    private void enableDisableSignatureSupportFields() {
        if (getPresenter().getCurrentFederation() != null) {
            if (getPresenter().getCurrentFederation().getKeyStores().isEmpty()) {
                errorMessage.setHTML("These configurations are disabled because the current federation does not support signatures.");
            } else {
                errorMessage.setHTML("");
            }
            
            if (getPresenter().getCurrentFederation().getKeyStores().isEmpty()) {
                signOutgoingMessages.setEnabled(false);
                ignoreIncomingSignature.setEnabled(false);
                
            } else {
                signOutgoingMessages.setEnabled(true);
                ignoreIncomingSignature.setEnabled(true);
            }
        }
    }

    /**
     * @param identityProvider
     */
    public void setIdentityProvider(IdentityProvider identityProvider) {
        this.identityProvider = identityProvider;
        this.identityProviderForm.edit(identityProvider);
        enableDisableSignatureSupportFields();
    }
    
    private FederationPresenter getPresenter() {
        return presenter;
    }

}
