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

import java.util.List;

import org.jboss.as.console.client.shared.model.DeploymentRecord;
import org.jboss.ballroom.client.widgets.forms.CheckBoxItem;
import org.jboss.ballroom.client.widgets.forms.ComboBoxItem;
import org.jboss.ballroom.client.widgets.forms.FormItem;
import org.jboss.ballroom.client.widgets.forms.TextBoxItem;
import org.picketlink.as.console.client.PicketLinkConsoleFramework;
import org.picketlink.as.console.client.shared.subsys.model.GenericFederationEntity;
import org.picketlink.as.console.client.ui.federation.AbstractFederationDetailEditor;
import org.picketlink.as.console.client.ui.federation.FederationPresenter;
import org.picketlink.as.console.client.ui.federation.AbstractFederationWizard;
import org.picketlink.as.console.client.ui.federation.Wizard;

/**
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 30, 2012
 */
public class NewIdentityProviderWizard<T extends GenericFederationEntity> extends AbstractFederationWizard<T> implements Wizard<T> {

    private ComboBoxItem aliasesItem;

    public NewIdentityProviderWizard(AbstractFederationDetailEditor<T> editor, Class<T> cls, FederationPresenter presenter, String type) {
        super(editor, cls, presenter, type, "alias", "url", "signOutgoingMessages", "ignoreIncomingSignatures");
    }

    @Override
    protected FormItem<?>[] doGetCustomFields() {
        getAliasItem().setRequired(true);
        
        
        updateAliasItems();
        
        if (!isDialogue()) {
            getAliasItem().setEnabled(false);
            getAliasItem().setRequired(false);
        }

        CheckBoxItem checkBoxItem = new CheckBoxItem("signOutgoingMessages",
                PicketLinkConsoleFramework.CONSTANTS.common_label_signOutgoingMessages());
        
        checkBoxItem.setEnabled(false);
        
        FormItem<?>[] formItems = new FormItem<?>[] {
                getAliasItem(),
                new TextBoxItem("url", PicketLinkConsoleFramework.CONSTANTS.common_label_identityURL(), true),
                checkBoxItem,
                new CheckBoxItem("ignoreIncomingSignatures",
                        PicketLinkConsoleFramework.CONSTANTS.common_label_ignoreIncomingSignatures()) };

        return formItems;
    }

    /**
     * @return
     */
    private ComboBoxItem getAliasItem() {
        if (this.aliasesItem == null) {
            this.aliasesItem = new ComboBoxItem("name", "Alias");
        }

        return this.aliasesItem;
    }

    private void updateAliasItems() {
        if (getPresenter().getAvailableDeployments() == null) {
            return;
        }
        
        List<DeploymentRecord> availableDeployments = getPresenter().getAvailableDeployments();
        
        String[] aliases = new String[availableDeployments.size()];
        
        for (int i = 0; i < availableDeployments.size(); i++) {
            aliases[i] = availableDeployments.get(i).getName();
        }

        getAliasItem().setValueMap(aliases);
        
        if (this.getIdentityProviderEditor().getCurrentSelection() != null) {
            getAliasItem().setValue(this.getIdentityProviderEditor().getCurrentSelection().getName());            
        }
    }
    
    public IdentityProviderEditor getIdentityProviderEditor() {
        return (IdentityProviderEditor) this.getEditor();
    }

}
