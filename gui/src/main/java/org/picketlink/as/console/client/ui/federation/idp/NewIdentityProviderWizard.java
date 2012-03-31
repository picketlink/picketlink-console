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

import java.util.ArrayList;
import java.util.List;

import org.jboss.as.console.client.shared.model.DeploymentRecord;
import org.jboss.as.console.client.shared.properties.PropertyManagement;
import org.jboss.ballroom.client.widgets.forms.CheckBoxItem;
import org.jboss.ballroom.client.widgets.forms.ComboBoxItem;
import org.jboss.ballroom.client.widgets.forms.FormItem;
import org.jboss.ballroom.client.widgets.forms.TextBoxItem;
import org.picketlink.as.console.client.PicketLinkConsoleFramework;
import org.picketlink.as.console.client.shared.subsys.model.GenericFederationEntity;
import org.picketlink.as.console.client.shared.subsys.model.ServiceProvider;
import org.picketlink.as.console.client.ui.federation.AbstractFederationEditor;
import org.picketlink.as.console.client.ui.federation.FederationPresenter;
import org.picketlink.as.console.client.ui.federation.GenericFederationWizard;
import org.picketlink.as.console.client.ui.federation.AbstractFederationDetailEditor.Wizard;

/**
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 30, 2012
 */
public class NewIdentityProviderWizard<T extends GenericFederationEntity> extends GenericFederationWizard<T> implements
        PropertyManagement, Wizard<T> {

    private ComboBoxItem aliasesItem;
    private List<ServiceProvider> serviceProviders;

    public NewIdentityProviderWizard(AbstractFederationEditor<T> editor, Class<T> cls, List<String> flagChoices,
            FederationPresenter presenter, String type, String moduleAttrName) {
        super(editor, cls, presenter, type, moduleAttrName, "alias", "url", "signOutgoingMessages", "ignoreIncomingSignatures");
    }

    @Override
    protected FormItem<?>[] getCustomFields() {
        getAliasItem().setRequired(true);
        
        updateAliasItems();

        FormItem<?>[] formItems = new FormItem<?>[] {
                getAliasItem(),
                new TextBoxItem("url", PicketLinkConsoleFramework.CONSTANTS.common_label_identityURL(), true),
                new CheckBoxItem("signOutgoingMessages",
                        PicketLinkConsoleFramework.CONSTANTS.common_label_signOutgoingMessages()),
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

    /**
     * @param result
     */
    public void setServiceProviders(List<ServiceProvider> result) {
        this.serviceProviders = result;
    }
    
    private void updateAliasItems() {
        List<DeploymentRecord> availableIdentityProviders = new ArrayList<DeploymentRecord>();
        
        if (this.serviceProviders != null && !this.serviceProviders.isEmpty()) {
            for (DeploymentRecord serviceProvider : serviceProviders) {
                for (DeploymentRecord deploymentRecord : this.getEditor().getPresenter().getAvailableDeployments()) {
                    if (!serviceProvider.getName().equals(deploymentRecord.getName())) {
                        availableIdentityProviders.add(deploymentRecord);
                    }
                }
            }
        } else {
            availableIdentityProviders.addAll(this.getEditor().getPresenter().getAvailableDeployments());
        }
        
        String[] aliases = new String[availableIdentityProviders.size()];
        
        for (int i = 0; i < availableIdentityProviders.size(); i++) {
            aliases[i] = availableIdentityProviders.get(i).getName();
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
