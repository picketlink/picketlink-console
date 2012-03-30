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

import org.jboss.as.console.client.Console;
import org.picketlink.as.console.client.PicketLinkConsoleFramework;
import org.picketlink.as.console.client.shared.subsys.model.ServiceProvider;
import org.picketlink.as.console.client.ui.core.AbstractModelElementTable;
import org.picketlink.as.console.client.ui.federation.FederationPresenter;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SelectionChangeEvent.Handler;
import com.google.gwt.view.client.SingleSelectionModel;

/**
 * <p>
 * A table widget to be used to show service providers.
 * </p>
 * 
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 19, 2012
 */
public class ServiceProviderTable extends AbstractModelElementTable<ServiceProvider> {

    private FederationPresenter presenter;
    private ServiceProvider selectedServiceProvider;
    
    public ServiceProviderTable(FederationPresenter presenter) {
        this.presenter = presenter;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.picketlink.as.console.client.ui.federation.AbstractModelElementTable#doGetKey(java.lang.Object)
     */
    @Override
    protected Object doGetKey(ServiceProvider item) {
        return item.getAlias();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.picketlink.as.console.client.ui.federation.AbstractModelElementTable#doAddConlumns(org.jboss.ballroom.client.widgets
     * .tables.DefaultCellTable)
     */
    @SuppressWarnings("unchecked")
    @Override
    protected void doAddConlumns(CellTable federationTable) {
        TextColumn<ServiceProvider> aliasColumn = new TextColumn<ServiceProvider>() {
            @Override
            public String getValue(ServiceProvider record) {
                return record.getAlias();
            }
        };

        federationTable.addColumn(aliasColumn, Console.CONSTANTS.common_label_name());

        TextColumn<ServiceProvider> urlColumn = new TextColumn<ServiceProvider>() {
            @Override
            public String getValue(ServiceProvider record) {
                return record.getUrl();
            }
        };

        federationTable.addColumn(aliasColumn, PicketLinkConsoleFramework.CONSTANTS.common_label_URL());

        TextColumn<ServiceProvider> bindingColumn = new TextColumn<ServiceProvider>() {
            @Override
            public String getValue(ServiceProvider record) {
                return String.valueOf(record.isPostBinding());
            }
        };

        federationTable.addColumn(bindingColumn, PicketLinkConsoleFramework.CONSTANTS.common_label_postBinding());

        final SingleSelectionModel<ServiceProvider> selectionModel = new SingleSelectionModel<ServiceProvider>();

        Handler selectionHandler = new SelectionChangeEvent.Handler() {

            @Override
            public void onSelectionChange(com.google.gwt.view.client.SelectionChangeEvent event) {
                SingleSelectionModel<ServiceProvider> selection = (SingleSelectionModel<ServiceProvider>) event.getSource();
                
                selectedServiceProvider = selection.getSelectedObject();
            }

        };

        selectionModel.addSelectionChangeHandler(selectionHandler);
        // cellTable.setSelectionEnabled(true);
        this.getCellTable().setSelectionModel(selectionModel);
    }
    
    /* (non-Javadoc)
     * @see org.picketlink.as.console.client.ui.federation.AbstractModelElementTable#setList(java.util.List)
     */
    @Override
    public void setList(List<ServiceProvider> items) {
        for (ServiceProvider serviceProvider : items) {
            serviceProvider.setName(serviceProvider.getAlias());
            serviceProvider.setRuntimeName(serviceProvider.getRuntimeName());
            serviceProvider.setEnabled(true);
        }
        
        super.setList(items);
    }
    
    /**
     * @return the selectedServiceProvider
     */
    public ServiceProvider getSelectedServiceProvider() {
        return selectedServiceProvider;
    }

}
