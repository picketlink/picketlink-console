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

package org.picketlink.as.console.client.ui.federation.sp;

import java.util.List;

import org.jboss.as.console.client.shared.model.DeploymentRecord;
import org.jboss.ballroom.client.widgets.forms.CheckBoxItem;
import org.jboss.ballroom.client.widgets.forms.ComboBoxItem;
import org.jboss.ballroom.client.widgets.forms.FormItem;
import org.jboss.ballroom.client.widgets.forms.TextBoxItem;
import org.picketlink.as.console.client.PicketLinkConsoleFramework;
import org.picketlink.as.console.client.shared.subsys.model.GenericFederationEntity;
import org.picketlink.as.console.client.shared.subsys.model.ServiceProvider;
import org.picketlink.as.console.client.ui.federation.AbstractFederationDetailEditor;
import org.picketlink.as.console.client.ui.federation.AbstractFederationWizard;
import org.picketlink.as.console.client.ui.federation.FederationPresenter;
import org.picketlink.as.console.client.ui.federation.Wizard;

/**
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 30, 2012
 */
public class NewServiceProviderWizard<T extends GenericFederationEntity> extends AbstractFederationWizard<T> implements Wizard<T> {

    private ComboBoxItem aliasesItem;
    private ComboBoxItem deploymentsItem;
    private ComboBoxItem securityDomainsItem;

    public NewServiceProviderWizard(AbstractFederationDetailEditor<T> editor, Class<T> cls, FederationPresenter presenter, String type) {
        super(editor, cls, presenter, type, "alias", "url", "postBinding", "security-domain");
    }

    @Override
    protected FormItem<?>[] doGetCustomFields() {
        ComboBoxItem aliasItem = null;
        
        if (!isDialogue()) {
            this.deploymentsItem = new ComboBoxItem("name", "Alias");
            aliasItem = this.deploymentsItem;
            updateAliasComboBox(aliasItem, this.getPresenter().getAllDeployments());
            aliasItem.setEnabled(false);
            aliasItem.setRequired(false);
        } else {
            aliasItem = getAliasItem();
            aliasItem.setRequired(true);
            updateAliasItems();
        }
        
        this.securityDomainsItem =  new ComboBoxItem("securityDomain", "Security Domain");
        
        if (this.getPresenter().getSecurityDomains() != null) {
            String[] securityDomains = new String[this.getPresenter().getSecurityDomains().size()];

            for (int i = 0; i < this.getPresenter().getSecurityDomains().size(); i++) {
                securityDomains[i] = this.getPresenter().getSecurityDomains().get(i).getName();
            }
            
            securityDomainsItem.setValueMap(securityDomains);
        }
        
        FormItem<?>[] formItems = new FormItem<?>[] { aliasItem, securityDomainsItem,
                new TextBoxItem("url", PicketLinkConsoleFramework.CONSTANTS.common_label_URL(), true),
                new CheckBoxItem("postBinding", PicketLinkConsoleFramework.CONSTANTS.common_label_postBinding()), };

        return formItems;
    }

    /**
     * @param result
     */
    public void setServiceProviders(List<ServiceProvider> result) {
        updateAliasItems();
        updateSecurityDomains();
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

    public void updateAliasItems() {
        if (this.deploymentsItem != null) {
            updateAliasComboBox(this.deploymentsItem, this.getPresenter().getAllDeployments());            
        }
        updateAliasComboBox(getAliasItem(), this.getPresenter().getAvailableDeployments());
    }

    private void updateAliasComboBox(ComboBoxItem aliasItem, List<DeploymentRecord> deployments) {
        if (getPresenter().getAllDeployments() == null) {
            return;
        }
        
        String[] aliases = new String[deployments.size()];
        
        for (int i = 0; i < deployments.size(); i++) {
            aliases[i] = deployments.get(i).getName();
        }

        aliasItem.setValueMap(aliases);
        
        if (!isDialogue()) {
            if (this.getServiceProviderEditor().getCurrentSelection() != null) {
                aliasItem.setValue(this.getServiceProviderEditor().getCurrentSelection().getName());            
            }
        }
    }

    public ServiceProviderEditor getServiceProviderEditor() {
        return (ServiceProviderEditor) this.getEditor();
    }
    
    private void updateSecurityDomains() {
        if (this.getPresenter().getSecurityDomains() != null && this.securityDomainsItem != null) {
            String[] securityDomains = new String[this.getPresenter().getSecurityDomains().size()];

            for (int i = 0; i < this.getPresenter().getSecurityDomains().size(); i++) {
                securityDomains[i] = this.getPresenter().getSecurityDomains().get(i).getName();
            }
            
            securityDomainsItem.setValueMap(securityDomains);
        }
        
        if (!isDialogue()) {
            if (this.getServiceProviderEditor().getCurrentSelection() != null) {
                securityDomainsItem.setValue(this.getServiceProviderEditor().getCurrentSelection().getSecurityDomain());
            }
        }

    }

}
