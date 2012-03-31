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

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.jboss.as.console.client.Console;
import org.jboss.as.console.client.shared.properties.PropertyRecord;
import org.jboss.ballroom.client.widgets.tables.DefaultCellTable;
import org.picketlink.as.console.client.PicketLinkConsoleFramework;
import org.picketlink.as.console.client.shared.subsys.model.ServiceProvider;
import org.picketlink.as.console.client.ui.federation.AbstractFederationEditor;
import org.picketlink.as.console.client.ui.federation.FederationPresenter;

import com.google.gwt.user.cellview.client.TextColumn;

/**
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 30, 2012
 */
public class ServiceProviderEditor extends AbstractFederationEditor<ServiceProvider> {

    public ServiceProviderEditor(FederationPresenter presenter) {
        super(presenter, ServiceProvider.class);
        setDescription(PicketLinkConsoleFramework.CONSTANTS.subsys_picketlink_service_provider_desc());
    }

    @Override
    public String getEntityName() {
        return PicketLinkConsoleFramework.CONSTANTS.common_label_serviceProvider();
    }

    @Override
    public String getStackElementName() {
        return "Service Provider";
    }

    @Override
    public String getStackName() {
        return "Service Providers";
    }

    @Override
    protected void saveData(ServiceProvider identityProvider) {
        presenter.onCreateServiceProvider(identityProvider);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.picketlink.as.console.client.ui.federation.idp.AbstractFederationDetailEditor#onDelete(org.picketlink.as.console.
     * client.shared.subsys.model.GenericFederationEntity)
     */
    @Override
    protected void onDelete(ServiceProvider identityProvider) {
        this.presenter.onRemoveServiceProvider(identityProvider);
    }

    /**
     * @param changedValues
     */
    public void onUpdate(Map<String, Object> changedValues) {
        this.presenter.onUpdateServiceProvider(getCurrentSelection(), changedValues);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.picketlink.as.console.client.ui.federation.idp.AbstractFederationDetailEditor#addCustomColumns(org.jboss.ballroom
     * .client.widgets.tables.DefaultCellTable)
     */
    @Override
    protected void addCustomColumns(DefaultCellTable<ServiceProvider> attributesTable) {
        TextColumn<ServiceProvider> aliasColumn = new TextColumn<ServiceProvider>() {
            @Override
            public String getValue(ServiceProvider record) {
                return record.getName();
            }
        };

        attributesTable.addColumn(aliasColumn, Console.CONSTANTS.common_label_name());
    }

    @Override
    public Wizard<ServiceProvider> getWizard() {
        List<String> flagValues = new LinkedList<String>();
        flagValues.add("required");
        flagValues.add("requisite");
        flagValues.add("sufficient");
        flagValues.add("optional");

        return new NewServiceProviderWizard(this, entityClass, flagValues, presenter, "service-provider", "login-modules");
    }

    /**
     * @param name
     * @param modules
     * @param resourceExists
     */
    public void setServiceProviders(String name, List<ServiceProvider> modules, boolean resourceExists) {
        setData(getPresenter().getView().getCurrentFederation().getName(), modules, resourceExists);
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
}