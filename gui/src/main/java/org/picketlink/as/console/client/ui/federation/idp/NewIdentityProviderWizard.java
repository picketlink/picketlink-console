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

import org.jboss.as.console.client.shared.deployment.model.DeploymentRecord;
import org.jboss.ballroom.client.widgets.forms.CheckBoxItem;
import org.jboss.ballroom.client.widgets.forms.ComboBoxItem;
import org.jboss.ballroom.client.widgets.forms.FormItem;
import org.jboss.ballroom.client.widgets.forms.TextBoxItem;
import org.jboss.ballroom.client.widgets.forms.TextItem;
import org.picketlink.as.console.client.i18n.PicketLinkUIConstants;
import org.picketlink.as.console.client.shared.subsys.model.GenericFederationEntity;
import org.picketlink.as.console.client.ui.federation.AbstractFederationDetailEditor;
import org.picketlink.as.console.client.ui.federation.AbstractFederationWizard;
import org.picketlink.as.console.client.ui.federation.FederationPresenter;
import org.picketlink.as.console.client.ui.federation.Wizard;

import java.util.List;

/**
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 30, 2012
 */
public class NewIdentityProviderWizard<T extends GenericFederationEntity> extends AbstractFederationWizard<T> implements
        Wizard<T> {

    private ComboBoxItem nameItem;
    private TextItem editNameItem;
    private ComboBoxItem deploymentsItem;
    private CheckBoxItem externalIDP;
    private CheckBoxItem strictPostBinding;
    private ComboBoxItem securityDomainsItem;
    private PicketLinkUIConstants uiConstants;


    public NewIdentityProviderWizard(AbstractFederationDetailEditor<T> editor, Class<T> cls, FederationPresenter presenter,
            String type, PicketLinkUIConstants uiConstants) {
        super(editor, cls, presenter, type, "name", "security-domain", "url","strict-post-binding", "attribute-manager", "role-generator");
        this.uiConstants = uiConstants;
    }

    @Override
    protected FormItem<?>[] doGetCustomFields() {
        ComboBoxItem nameItem = null;

        if (!isDialogue()) {
            this.deploymentsItem = new ComboBoxItem("name", this.uiConstants.common_label_name());
            nameItem = this.deploymentsItem;
            updateAliasComboBox(nameItem, this.getPresenter().getAllDeployments());
            nameItem.setEnabled(false);
            nameItem.setRequired(false);
        } else {
            nameItem = getAliasItem();
            nameItem.setRequired(true);
            updateNameItems();
        }

        FormItem<?>[] formItems = null;

        securityDomainsItem =  new ComboBoxItem("securityDomain", "Security Domain");
        
        updateSecurityDomains();

        strictPostBinding = new CheckBoxItem("strictPostBinding", "Strict Post Binding");
        strictPostBinding.setEnabled(true);
        
        if (isDialogue()) {
            externalIDP = new CheckBoxItem("external", "Is external?") {
                @Override
                protected void doValueChange() {
                    if (getValue() != null && getValue()) {
                        getAliasItem().setEnabled(false);
                        getAliasItem().setRequired(false);
                        securityDomainsItem.setEnabled(false);
                        securityDomainsItem.setRequired(false);
                        strictPostBinding.setEnabled(false);
                        strictPostBinding.setRequired(false);
                    } else {
                        getAliasItem().setEnabled(true);
                        getAliasItem().setRequired(true);
                        securityDomainsItem.setEnabled(true);
                        securityDomainsItem.setRequired(true);
                        strictPostBinding.setEnabled(true);
                        strictPostBinding.setRequired(true);
                    }
                }
            };

            formItems = new FormItem<?>[] { externalIDP, nameItem, securityDomainsItem, new TextBoxItem("url", uiConstants.common_label_URL(), false)};
        } else {
            editNameItem = new TextItem("name", "Name");
            editNameItem.setEnabled(false);
            formItems = new FormItem<?>[] {editNameItem, securityDomainsItem, new TextBoxItem("url", uiConstants.common_label_URL(), true), strictPostBinding};
        }

        return formItems;
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
            if (this.getIdentityProviderEditor().getCurrentSelection() != null) {
                securityDomainsItem.setValue(this.getIdentityProviderEditor().getCurrentSelection().getSecurityDomain());
            }
        }

    }

    /**
     * @return
     */
    private ComboBoxItem getAliasItem() {
        if (this.nameItem == null) {
            this.nameItem = new ComboBoxItem("name", "Name");
        }

        return this.nameItem;
    }

    public void updateNameItems() {
        if (getPresenter().getIdentityProvider() != null) {
            boolean isHosted = !getPresenter().getIdentityProvider().getIdentityProvider().isExternal();
            
            this.strictPostBinding.setEnabled(isHosted);
        }
        
        if (this.deploymentsItem != null) {
            updateAliasComboBox(this.deploymentsItem, this.getPresenter().getAllDeployments());
        }

        updateAliasComboBox(getAliasItem(), this.getPresenter().getAvailableDeployments());

        if (getPresenter().getIdentityProvider() != null && getPresenter().getIdentityProvider().getIdentityProvider() != null
                && getPresenter().getIdentityProvider().getIdentityProvider().isExternal()) {
            editNameItem.setEnabled(false);
            securityDomainsItem.setEnabled(false);
        }
        
        updateSecurityDomains();
    }

    private void updateAliasComboBox(ComboBoxItem nameItem, List<DeploymentRecord> deployments) {
        if (getPresenter().getAllDeployments() == null) {
            return;
        }

        String[] names = new String[deployments.size()];

        for (int i = 0; i < deployments.size(); i++) {
            names[i] = deployments.get(i).getName();
        }

        nameItem.setValueMap(names);

        if (!isDialogue()) {
            if (this.getIdentityProviderEditor().getCurrentSelection() != null) {
                nameItem.setValue(this.getIdentityProviderEditor().getCurrentSelection().getName());
            }
        }
    }

    public IdentityProviderEditor getIdentityProviderEditor() {
        return (IdentityProviderEditor) this.getEditor();
    }

    public boolean isExternalIDP() {
        return this.externalIDP != null && this.externalIDP.getValue();
    }

}
