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

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.jboss.as.console.client.Console;
import org.jboss.as.console.client.shared.properties.PropertyRecord;
import org.jboss.ballroom.client.widgets.tables.DefaultCellTable;
import org.picketlink.as.console.client.PicketLinkConsoleFramework;
import org.picketlink.as.console.client.shared.subsys.model.IdentityProvider;
import org.picketlink.as.console.client.shared.subsys.model.ServiceProvider;
import org.picketlink.as.console.client.shared.subsys.model.TrustDomain;
import org.picketlink.as.console.client.ui.federation.AbstractFederationEditor;
import org.picketlink.as.console.client.ui.federation.FederationPresenter;

import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.TabPanel;

/**
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 30, 2012
 */
public class IdentityProviderEditor extends AbstractFederationEditor<IdentityProvider> {

    private TrustedDomainTabEditor trustedDomainTabEditor;

    public IdentityProviderEditor(FederationPresenter presenter) {
        super(presenter, IdentityProvider.class);
        setDescription(PicketLinkConsoleFramework.CONSTANTS.subsys_picketlink_identity_provider_desc());
    }

    @Override
    public String getEntityName() {
        return PicketLinkConsoleFramework.CONSTANTS.common_label_identityProvider();
    }

    @Override
    public String getStackElementName() {
        return "Identity Provider";
    }

    @Override
    public String getStackName() {
        return "Identity Providers";
    }

    @Override
    protected boolean onInsert(IdentityProvider identityProvider) {
        presenter.onCreateIdentityProvider(identityProvider);
        return true;
    }

    /* (non-Javadoc)
     * @see org.picketlink.as.console.client.ui.federation.AbstractFederationDetailEditor#addTabs(com.google.gwt.user.client.ui.TabPanel)
     */
    @Override
    protected void addTabs(TabPanel bottomTabs) {
        bottomTabs.add(getTrustedDomainTabEditor().asWidget(), "Trusted Domains");
    }

    /**
     * @return
     */
    private TrustedDomainTabEditor getTrustedDomainTabEditor() {
        if (this.trustedDomainTabEditor == null) {
            this.trustedDomainTabEditor = new TrustedDomainTabEditor(presenter);
        }

        return this.trustedDomainTabEditor;
    }
    
    /* (non-Javadoc)
     * @see org.picketlink.as.console.client.ui.federation.AbstractFederationDetailEditor#doUpdateSelection(org.picketlink.as.console.client.shared.subsys.model.GenericFederationEntity)
     */
    @Override
    protected void doUpdateSelection(IdentityProvider policy) {
        getTrustedDomainTabEditor().setIdentityProvider(policy);
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see
     * org.picketlink.as.console.client.ui.federation.idp.AbstractFederationDetailEditor#onDelete(org.picketlink.as.console.
     * client.shared.subsys.model.GenericFederationEntity)
     */
    @Override
    protected void onDelete(IdentityProvider identityProvider) {
        this.presenter.onRemoveIdentityProvider(identityProvider);
        getAddModule().setEnabled(true);
    }

    /**
     * @param changedValues
     */
    public void onUpdate(IdentityProvider identityProvider, Map<String, Object> changedValues) {
        this.presenter.onUpdateIdentityProvider(identityProvider, changedValues);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.picketlink.as.console.client.ui.federation.idp.AbstractFederationDetailEditor#addCustomColumns(org.jboss.ballroom
     * .client.widgets.tables.DefaultCellTable)
     */
    @Override
    protected void addCustomColumns(DefaultCellTable<IdentityProvider> attributesTable) {
        TextColumn<IdentityProvider> aliasColumn = new TextColumn<IdentityProvider>() {
            @Override
            public String getValue(IdentityProvider record) {
                return record.getName();
            }
        };

        attributesTable.addColumn(aliasColumn, Console.CONSTANTS.common_label_name());
    }

    @Override
    public Wizard<IdentityProvider> getWizard() {
        List<String> flagValues = new LinkedList<String>();
        flagValues.add("required");
        flagValues.add("requisite");
        flagValues.add("sufficient");
        flagValues.add("optional");

        return new NewIdentityProviderWizard(this, entityClass, flagValues, presenter, "identity-provider", "login-modules");
    }

    /**
     * @param federations
     */
    public void updateIdentityProviders(List<IdentityProvider> federations) {
        if (getPresenter().getView().getCurrentFederation() != null) {
            setData(getPresenter().getView().getCurrentFederation().getName(), federations, resourceExists);
        }
    }

    /**
     * @param name
     * @param modules
     * @param resourceExists
     */
    public void setIdentityProviders(String name, List<IdentityProvider> modules, boolean resourceExists) {
        setData(name, modules, resourceExists);
        getAddModule().setEnabled(modules.isEmpty());
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.jboss.as.console.client.shared.properties.PropertyManagement#onCreateProperty(java.lang.String,
     * org.jboss.as.console.client.shared.properties.PropertyRecord)
     */
    @Override
    public void onCreateProperty(String reference, PropertyRecord prop) {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.jboss.as.console.client.shared.properties.PropertyManagement#onDeleteProperty(java.lang.String,
     * org.jboss.as.console.client.shared.properties.PropertyRecord)
     */
    @Override
    public void onDeleteProperty(String reference, PropertyRecord prop) {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.jboss.as.console.client.shared.properties.PropertyManagement#onChangeProperty(java.lang.String,
     * org.jboss.as.console.client.shared.properties.PropertyRecord)
     */
    @Override
    public void onChangeProperty(String reference, PropertyRecord prop) {
        // TODO Auto-generated method stub

    }

    /**
     * @param result
     */
    public void setTrustedDomains(List<TrustDomain> result) {
        this.getTrustedDomainTabEditor().getTrustDomainTable().getDataProvider().setList(result);
    }

    /**
     * @param serviceProviders
     */
    public void setServicesProviders(List<ServiceProvider> serviceProviders) {
        ((NewIdentityProviderWizard<IdentityProvider>) getWizard()).setServiceProviders(serviceProviders);
    }
}