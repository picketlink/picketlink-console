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

import java.util.ArrayList;
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
import org.picketlink.as.console.client.ui.federation.FederationPresenter;
import org.picketlink.as.console.client.ui.federation.AbstractFederationWizard;
import org.picketlink.as.console.client.ui.federation.Wizard;

/**
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 30, 2012
 */
public class NewServiceProviderWizard<T extends GenericFederationEntity> extends AbstractFederationWizard<T> implements Wizard<T> {

    private ComboBoxItem aliasesItem;
    private List<ServiceProvider> serviceProviders;

    public NewServiceProviderWizard(AbstractFederationDetailEditor<T> editor, Class<T> cls, FederationPresenter presenter, String type) {
        super(editor, cls, presenter, type, "alias", "url", "postBinding");
    }

    @Override
    protected FormItem<?>[] doGetCustomFields() {
        aliasesItem = new ComboBoxItem("name", "Name");

        if (!isDialogue()) {
            aliasesItem.setEnabled(false);
            aliasesItem.setRequired(false);
        } else {
            aliasesItem.setRequired(true);    
        }
        

        updateAliasItems();

        FormItem<?>[] formItems = new FormItem<?>[] { aliasesItem,
                new TextBoxItem("url", PicketLinkConsoleFramework.CONSTANTS.common_label_URL(), true),
                new CheckBoxItem("postBinding", PicketLinkConsoleFramework.CONSTANTS.common_label_postBinding()), };

        return formItems;
    }

    /**
     * @param result
     */
    public void setServiceProviders(List<ServiceProvider> result) {
        updateAliasItems();
        this.serviceProviders = result;
    }

    private void updateAliasItems() {
        List<DeploymentRecord> availableIdentityProviders = new ArrayList<DeploymentRecord>();

        if (this.serviceProviders != null && !this.serviceProviders.isEmpty()) {
            for (DeploymentRecord serviceProvider : serviceProviders) {
                for (DeploymentRecord deploymentRecord : this.getPresenter().getAvailableDeployments()) {
                    if (!serviceProvider.getName().equals(deploymentRecord.getName())) {
                        availableIdentityProviders.add(deploymentRecord);
                    }
                }
            }
        } else {
            availableIdentityProviders.addAll(this.getPresenter().getAvailableDeployments());
        }

        String[] aliases = new String[availableIdentityProviders.size()];

        for (int i = 0; i < availableIdentityProviders.size(); i++) {
            aliases[i] = availableIdentityProviders.get(i).getName();
        }

        aliasesItem.setValueMap(aliases);

        if (this.getServiceProviderEditor().getCurrentSelection() != null) {
            aliasesItem.setValue(this.getServiceProviderEditor().getCurrentSelection().getName());
        }
    }

    public ServiceProviderEditor getServiceProviderEditor() {
        return (ServiceProviderEditor) this.getEditor();
    }

}
