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
import java.util.Map;

import org.jboss.as.console.client.shared.model.DeploymentRecord;
import org.picketlink.as.console.client.PicketLinkConsoleFramework;
import org.picketlink.as.console.client.shared.subsys.model.FederationWrapper;
import org.picketlink.as.console.client.shared.subsys.model.ServiceProvider;
import org.picketlink.as.console.client.shared.subsys.model.ServiceProviderHandler;
import org.picketlink.as.console.client.shared.subsys.model.ServiceProviderHandlerParameter;
import org.picketlink.as.console.client.shared.subsys.model.ServiceProviderHandlerWrapper;
import org.picketlink.as.console.client.shared.subsys.model.ServiceProviderWrapper;
import org.picketlink.as.console.client.ui.federation.AbstractFederationDetailEditor;
import org.picketlink.as.console.client.ui.federation.FederationPresenter;
import org.picketlink.as.console.client.ui.federation.Wizard;
import org.picketlink.as.console.client.ui.federation.idp.SignatureSupportTabEditor;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.TabPanel;

/**
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 30, 2012
 */
public class ServiceProviderEditor extends AbstractFederationDetailEditor<ServiceProvider> {

    private SignatureSupportTabEditor signatureSupportTabEditor;
    private ServiceProviderHandlersTabEditor handlersTabEditor;
    private ServiceProviderWrapper selectedServiceProvider;

    public ServiceProviderEditor(FederationPresenter presenter) {
        super(presenter, new ServiceProviderTable(presenter), ServiceProvider.class);
    }

    /* (non-Javadoc)
     * @see org.picketlink.as.console.client.ui.federation.AbstractFederationDetailEditor#getEntityName()
     */
    @Override
    public String doGetEntityName() {
        return PicketLinkConsoleFramework.CONSTANTS.common_label_serviceProvider();
    }
    
    /* (non-Javadoc)
     * @see org.picketlink.as.console.client.ui.federation.AbstractFederationDetailEditor#doGetDescription()
     */
    @Override
    protected String doGetDescription() {
        return PicketLinkConsoleFramework.CONSTANTS.subsys_picketlink_service_provider_desc();
    }
    
    /* (non-Javadoc)
     * @see org.picketlink.as.console.client.ui.federation.AbstractFederationDetailEditor#getStackName()
     */
    @Override
    public String doGetTableSectionName() {
        return "Service Providers";
    }
    
    /* (non-Javadoc)
     * @see org.picketlink.as.console.client.ui.federation.AbstractFederationDetailEditor#addDetailsSectionTabs(com.google.gwt.user.client.ui.TabPanel)
     */
    @Override
    protected void addDetailsSectionTabs(TabPanel bottomTabs) {
        bottomTabs.add(getSignatureSupportTabEditor().asWidget(), "Signature Support");
        bottomTabs.add(getHandlerTabEditor().asWidget(), "SAML Handlers");
    }

    private SignatureSupportTabEditor getSignatureSupportTabEditor() {
        if (this.signatureSupportTabEditor == null) {
            this.signatureSupportTabEditor = new ServiceProviderSignatureSupportEditor(getPresenter());
        }

        return this.signatureSupportTabEditor;
    }
    
    private ServiceProviderHandlersTabEditor getHandlerTabEditor() {
        if (this.handlersTabEditor == null) {
            this.handlersTabEditor = new ServiceProviderHandlersTabEditor(getPresenter());
        }

        return this.handlersTabEditor;
    }

    @Override
    protected boolean doInsert(ServiceProvider serviceProvider) {
        if (serviceProvider.getErrorPage() != null && serviceProvider.getErrorPage().trim().isEmpty()) {
            serviceProvider.setErrorPage(null);
        }
        
        if (serviceProvider.getUrl() == null || "".equals(serviceProvider.getUrl().trim())) {
            serviceProvider.setUrl("http://localhost:8080/" + serviceProvider.getName().replaceAll(".war", "") + "/");
        }
        
        getPresenter().getFederationManager().onCreateServiceProvider(serviceProvider);
        return true;
    }
    
    @Override
    protected boolean onLunchWizard() {
        if (this.getPresenter().getIdentityProvider() == null) {
            Window.alert("Please, configure an Identity Provider first.");
            return false;
        }
        
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.picketlink.as.console.client.ui.federation.idp.AbstractFederationDetailEditor#onDelete(org.picketlink.as.console.
     * client.shared.subsys.model.GenericFederationEntity)
     */
    @Override
    protected void doDelete(ServiceProvider serviceProvider) {
        this.getPresenter().getFederationManager().onRemoveServiceProvider(serviceProvider);
    }

    /* (non-Javadoc)
     * @see org.picketlink.as.console.client.ui.federation.AbstractFederationDetailEditor#doUpdate(org.picketlink.as.console.client.shared.subsys.model.GenericFederationEntity, java.util.Map)
     */
    public void doUpdate(ServiceProvider serviceProvider, Map<String, Object> changedValues) {
        this.getPresenter().getFederationManager().onUpdateServiceProvider(serviceProvider, changedValues);
    }

    /* (non-Javadoc)
     * @see org.picketlink.as.console.client.ui.federation.AbstractFederationDetailEditor#getWizard()
     */
    @Override
    public Wizard<ServiceProvider> doCreateWizard() {
        return new NewServiceProviderWizard(this, getEntityClass(), getPresenter(), "service-provider");
    }

    public void updateDeployments(List<DeploymentRecord> deployments) {
        if (getWizard() != null) {
            ((NewServiceProviderWizard) getWizard()).updateAliasItems();
        }
    }

    public void updateServiceProviders(FederationWrapper federation) {
        getBottomTabs().selectTab(0);
        
        if (federation.getIdentityProvider() == null && !federation.getServiceProviders().isEmpty()) {
            addErrorMessage("You have Service Providers configured but there is no IDP for them.");
        } else {
            removeErrorMessage();
        }
        
        List<ServiceProvider> serviceProviders = new ArrayList<ServiceProvider>();
        
        for (ServiceProviderWrapper serviceProviderWrapper : federation.getServiceProviders()) {
            serviceProviders.add(serviceProviderWrapper.getServiceProvider());
        }
        
        setData(federation, serviceProviders);
        
        if (!federation.getServiceProviders().isEmpty()) {
            updateSelectedServiceProvider(getCurrentSelection());
            getSignatureSupportTabEditor().setIdentityProvider(getCurrentSelection());
            getHandlerTabEditor().setServiceProvider(this.selectedServiceProvider);
            
            ArrayList<ServiceProviderHandler> handlersList = new ArrayList<ServiceProviderHandler>();
            
            for (ServiceProviderHandlerWrapper handler : this.selectedServiceProvider.getHandlers()) {
                handlersList.add(handler.getHandler());
            }
            
            getHandlerTabEditor().getHandlerTable().getDataProvider().setList(handlersList);
        }
    }
    
    /* (non-Javadoc)
     * @see org.picketlink.as.console.client.ui.federation.AbstractFederationDetailEditor#doUpdateSelection(org.picketlink.as.console.client.shared.subsys.model.GenericFederationEntity)
     */
    @Override
    protected void doUpdateSelection(ServiceProvider serviceProvider) {
        updateSelectedServiceProvider(serviceProvider);
        getHandlerTabEditor().setServiceProvider(this.selectedServiceProvider);
        ArrayList<ServiceProviderHandler> handlersList = new ArrayList<ServiceProviderHandler>();
        
        for (ServiceProviderHandlerWrapper handler : this.selectedServiceProvider.getHandlers()) {
            handlersList.add(handler.getHandler());
        }
        
        getHandlerTabEditor().getHandlerTable().getDataProvider().setList(handlersList);
        getHandlerTabEditor().getHandlerParameterTable().getDataProvider().setList(new ArrayList<ServiceProviderHandlerParameter>());
    }

    private void updateSelectedServiceProvider(ServiceProvider serviceProvider) {
        for (ServiceProviderWrapper serviceProviderWrapper : getPresenter().getCurrentFederation().getServiceProviders()) {
            if (serviceProviderWrapper.getServiceProvider().getName().equals(serviceProvider.getName())) {
                this.selectedServiceProvider = serviceProviderWrapper;
                break;
            }
        }
    }
}