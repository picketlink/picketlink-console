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

import org.jboss.as.console.client.Console;
import org.jboss.as.console.client.shared.model.DeploymentRecord;
import org.jboss.as.console.client.shared.subsys.Baseadress;
import org.jboss.ballroom.client.widgets.forms.CheckBoxItem;
import org.jboss.ballroom.client.widgets.forms.ComboBoxItem;
import org.jboss.ballroom.client.widgets.forms.Form;
import org.jboss.ballroom.client.widgets.forms.TextBoxItem;
import org.jboss.dmr.client.ModelNode;
import org.picketlink.as.console.client.PicketLinkConsoleFramework;
import org.picketlink.as.console.client.shared.subsys.model.ServiceProvider;
import org.picketlink.as.console.client.ui.core.AbstractWizardStep;
import org.picketlink.as.console.client.ui.federation.FederationPresenter;

/**
 * <p>
 * The first step during the wizard to create a new federation instance.
 * </p>
 * 
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 19, 2012
 */
public class NewServiceProviderWizardStep1 extends AbstractWizardStep<ServiceProvider> {

    private List<DeploymentRecord> deployments;
    private FederationPresenter presenter;
    private ComboBoxItem aliasesItem;

    public NewServiceProviderWizardStep1(NewServiceProviderWizard wizard, FederationPresenter presenter) {
        super(Console.MESSAGES.createTitle(PicketLinkConsoleFramework.CONSTANTS.common_label_serviceProvider()), wizard, ServiceProvider.class);
        this.presenter = presenter;
    }
    
    /* (non-Javadoc)
     * @see org.picketlink.as.console.client.ui.federation.AbstractWizardStep#doAddFormItems(org.jboss.ballroom.client.widgets.forms.Form)
     */
    @Override
    protected void doAddFormItems(Form<ServiceProvider> form) {
        aliasesItem = new ComboBoxItem("alias", PicketLinkConsoleFramework.CONSTANTS.common_label_alias());
        
        aliasesItem.setRequired(true);

        updateAliasItems();
        
        addFormItem(aliasesItem);
        addFormItem(new TextBoxItem("url", PicketLinkConsoleFramework.CONSTANTS.common_label_URL()));
        addFormItem(new CheckBoxItem("postBinding", PicketLinkConsoleFramework.CONSTANTS.common_label_postBinding()));
    }
    
    /* (non-Javadoc)
     * @see org.picketlink.as.console.client.ui.federation.AbstractWizardStep#doGetHelpAddress()
     */
    protected ModelNode doGetHelpAddress() {
        ModelNode address = Baseadress.get();
        address.add("subsystem", "picketlink");
        address.add("federation", "*");
        address.add("service-provider", "*");
        return address;
    }
    
    /**
     * 
     */
    private void updateAliasItems() {
        List<DeploymentRecord> availableIdentityProviders = new ArrayList<DeploymentRecord>();
        
        if (this.presenter.getView().getIdentityProvider() != null) {
            for (DeploymentRecord deploymentRecord : this.presenter.getAvailableDeployments()) {
                if (!this.presenter.getView().getIdentityProvider().getAlias().equals(deploymentRecord.getName())) {
                    NewServiceProviderWizard wizard = (NewServiceProviderWizard) getWizard();
                    
                    
                    if (wizard.getServiceProviderTable().getDataProvider().getList() != null && !wizard.getServiceProviderTable().getDataProvider().getList().isEmpty()) {
                        for (ServiceProvider serviceProvider : wizard.getServiceProviderTable().getDataProvider().getList()) {
                            if (serviceProvider.getAlias().equals(deploymentRecord.getName())) {
                                deploymentRecord = null;
                                break;
                            }
                        }
                    }
                    
                    if (deploymentRecord != null) {
                        availableIdentityProviders.add(deploymentRecord);
                    }
                }
            }
        } else {
            availableIdentityProviders.addAll(this.presenter.getAvailableDeployments());
        }
        
        String[] aliases = new String[availableIdentityProviders.size()];
        
        for (int i = 0; i < availableIdentityProviders.size(); i++) {
            aliases[i] = availableIdentityProviders.get(i).getName();
        }

        aliasesItem.setValueMap(aliases);
    }


}
