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
import org.picketlink.as.console.client.shared.subsys.model.ServiceProviderHandler;
import org.picketlink.as.console.client.shared.subsys.model.ServiceProviderHandlerWrapper;
import org.picketlink.as.console.client.shared.subsys.model.ServiceProviderWrapper;
import org.picketlink.as.console.client.ui.federation.AbstractModelElementTable;
import org.picketlink.as.console.client.ui.federation.FederationPresenter;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SelectionChangeEvent.Handler;
import com.google.gwt.view.client.SingleSelectionModel;

/**
 * <p>
 * A table widget to be used to show the trusted domains.
 * </p>
 * 
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 19, 2012
 */
public class ServiceProviderHandlerTable extends AbstractModelElementTable<ServiceProviderHandler> {

    private ServiceProviderWrapper selectedServiceProvider;
    private ServiceProviderHandler selectedHandler;
    private ServiceProviderHandlerParameterTable parametersTable;
    private FederationPresenter presenter;
    private ServiceProviderHandlersTabEditor handlersTabEditor;
    
    /*
     * (non-Javadoc)
     * 
     * @see org.picketlink.as.console.client.ui.federation.AbstractModelElementTable#doGetKey(java.lang.Object)
     */
    @Override
    protected Object doGetKey(ServiceProviderHandler item) {
        return item.getClassName();
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
    protected void doAddConlumns(CellTable table) {
        createNameColumn(table);

        this.getCellTable().setSelectionModel(createSelectionModel());
    }

    private SingleSelectionModel<ServiceProviderHandler> createSelectionModel() {
        final SingleSelectionModel<ServiceProviderHandler> selectionModel = new SingleSelectionModel<ServiceProviderHandler>();

        Handler selectionHandler = new SelectionChangeEvent.Handler() {

            @Override
            public void onSelectionChange(com.google.gwt.view.client.SelectionChangeEvent event) {
                SingleSelectionModel<ServiceProviderHandler> selection = (SingleSelectionModel<ServiceProviderHandler>) event.getSource();
                selectedHandler = selection.getSelectedObject();
                List<ServiceProviderHandlerWrapper> handlers = selectedServiceProvider.getHandlers();
                
                for (ServiceProviderHandlerWrapper handlerWrapper : handlers) {
                    if (handlerWrapper.getHandler().getClassName().equals(selectedHandler.getClassName())) {
                        parametersTable.getDataProvider().setList(handlerWrapper.getParameters());
                    }
                }
                
                handlersTabEditor.doUpdateSelection(selectedHandler);
            }

        };

        selectionModel.addSelectionChangeHandler(selectionHandler);
        return selectionModel;
    }

    private void createNameColumn(CellTable table) {
        TextColumn<ServiceProviderHandler> nameColumn = new TextColumn<ServiceProviderHandler>() {
            @Override
            public String getValue(ServiceProviderHandler record) {
                return record.getClassName();
            }
        };

        table.addColumn(nameColumn, Console.CONSTANTS.common_label_name());
    }
    
    /**
     * @return the selectedTrustedDomain
     */
    public ServiceProviderHandler getSelectedHandler() {
        return selectedHandler;
    }
    
    public void setParametersTable(ServiceProviderHandlerParameterTable parametersTable) {
        this.parametersTable = parametersTable;
    }
    
    public void setPresenter(FederationPresenter presenter) {
        this.presenter = presenter;
    }
    
    public void setSelectedServiceProvider(ServiceProviderWrapper selectedServiceProvider) {
        this.selectedServiceProvider = selectedServiceProvider;
    }
    
    public void setHandlersTabEditor(ServiceProviderHandlersTabEditor handlersTabEditor) {
        this.handlersTabEditor = handlersTabEditor;
    }
}
