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

import org.picketlink.as.console.client.PicketLinkConsoleFramework;
import org.picketlink.as.console.client.shared.subsys.model.ServiceProvider;
import org.picketlink.as.console.client.ui.core.AbstractWizardView;
import org.picketlink.as.console.client.ui.federation.FederationPresenter;

import com.google.gwt.user.client.ui.DeckPanel;

/**
 * <p>
 * A wizard to be used when creating a new service provider configuration.
 * </p>
 * 
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 19, 2012
 */
public class NewServiceProviderWizard extends AbstractWizardView<FederationPresenter, ServiceProvider>{

    private NewServiceProviderWizardStep1 newServiceProviderWizardStep1;
    private ServiceProviderTable serviceProviderTable;

    public NewServiceProviderWizard(ServiceProviderTable serviceProviders,
            FederationPresenter presenter) {
        super(PicketLinkConsoleFramework.CONSTANTS.common_label_serviceProvider(), presenter);
        this.serviceProviderTable = serviceProviders;
    }
    
    /* (non-Javadoc)
     * @see org.picketlink.as.console.client.ui.federation.AbstractWizardView#doAddSteps(com.google.gwt.user.client.ui.DeckPanel)
     */
    @Override
    protected void doAddSteps(DeckPanel deck) {
        deck.add(new NewServiceProviderWizardStep1(this, this.getPresenter()).asWidget());
    }

    /**
     * @return
     */
    /* (non-Javadoc)
     * @see org.picketlink.as.console.client.ui.federation.WizardView#onSave(java.lang.Object)
     */
    @Override
    public void onSave(ServiceProvider updatedEntity) {
        this.getPresenter().onCreateServiceProvider(updatedEntity);        
    }
    
    /**
     * @return the serviceProviderTable
     */
    public ServiceProviderTable getServiceProviderTable() {
        return serviceProviderTable;
    }
}
