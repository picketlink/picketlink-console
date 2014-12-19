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

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SelectionChangeEvent.Handler;
import com.google.gwt.view.client.SingleSelectionModel;
import org.picketlink.as.console.client.shared.subsys.model.IdentityProviderHandler;
import org.picketlink.as.console.client.shared.subsys.model.IdentityProviderHandlerParameter;
import org.picketlink.as.console.client.shared.subsys.model.IdentityProviderHandlerWrapper;
import org.picketlink.as.console.client.shared.subsys.model.IdentityProviderWrapper;
import org.picketlink.as.console.client.ui.federation.AbstractModelElementTable;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * A table widget to be used to show the trusted domains.
 * </p>
 *
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 19, 2012
 */
public class IdentityProviderHandlerTable extends AbstractModelElementTable<IdentityProviderHandler> {

    private IdentityProviderHandler selectedHandler;
    private IdentityProviderHandlerParameterTable parametersTable;
    private IdentityProviderHandlersTabEditor handlersTabEditor;
    private IdentityProviderWrapper selectedIdentityProvider;

    /*
     * (non-Javadoc)
     *
     * @see org.picketlink.as.console.client.ui.federation.AbstractModelElementTable#doGetKey(java.lang.Object)
     */
    @Override
    protected Object doGetKey(IdentityProviderHandler item) {
        return item.getClassName();
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * org.picketlink.as.console.client.ui.federation.AbstractModelElementTable#doAddColumns(org.jboss.ballroom.client.widgets
     * .tables.DefaultCellTable)
     */
    @SuppressWarnings("unchecked")
    @Override
    protected void doAddColumns(CellTable table) {
        addNameColumn(table);
        addTypeColumn(table);
        this.getCellTable().setSelectionModel(createSelectionModel());
    }

    private void addTypeColumn(CellTable table) {
        TextColumn<IdentityProviderHandler> codeColumn = new TextColumn<IdentityProviderHandler>() {
            @Override
            public String getValue(IdentityProviderHandler record) {
                String code = record.getCode();

                if (code != null && !code.trim().isEmpty()) {
                    return code + " (Code)";
                }

                return record.getClassName();
            }
        };

        table.addColumn(codeColumn, "Type");
    }

    private void addNameColumn(CellTable table) {
        TextColumn<IdentityProviderHandler> nameColumn = new TextColumn<IdentityProviderHandler>() {
            @Override
            public String getValue(IdentityProviderHandler record) {
                return record.getName();
            }
        };

        table.addColumn(nameColumn, "Name");
    }

    private SingleSelectionModel<IdentityProviderHandler> createSelectionModel() {
        final SingleSelectionModel<IdentityProviderHandler> selectionModel = new SingleSelectionModel<IdentityProviderHandler>();

        Handler selectionHandler = new SelectionChangeEvent.Handler() {

            @Override
            public void onSelectionChange(com.google.gwt.view.client.SelectionChangeEvent event) {
                SingleSelectionModel<IdentityProviderHandler> selection = (SingleSelectionModel<IdentityProviderHandler>) event.getSource();
                selectedHandler = selection.getSelectedObject();
                List<IdentityProviderHandlerWrapper> handlers = selectedIdentityProvider.getHandlers();

                for (IdentityProviderHandlerWrapper handlerWrapper : handlers) {
                    if (handlerWrapper.getHandler().getClassName().equals(selectedHandler.getClassName())) {
                        parametersTable.getDataProvider().setList(handlerWrapper.getParameters());
                    }
                }

                handlersTabEditor.doUpdateSelection(selectedHandler);
                handlersTabEditor.enableDisableHandlerParameterActions(true);
            }

        };

        selectionModel.addSelectionChangeHandler(selectionHandler);
        return selectionModel;
    }

    /**
     * @return the selectedTrustedDomain
     */
    public IdentityProviderHandler getSelectedHandler() {
        return selectedHandler;
    }

    public void setParametersTable(IdentityProviderHandlerParameterTable parametersTable) {
        this.parametersTable = parametersTable;
    }

    public void setHandlersTabEditor(IdentityProviderHandlersTabEditor handlersTabEditor) {
        this.handlersTabEditor = handlersTabEditor;
    }

    public void setSelectedIdentityProvider(IdentityProviderWrapper selectedIdentityProvider) {
        this.selectedIdentityProvider = selectedIdentityProvider;

        if (this.selectedIdentityProvider == null) {
            this.parametersTable.getDataProvider().setList(new ArrayList<IdentityProviderHandlerParameter>());
            handlersTabEditor.enableDisableHandlerParameterActions(false);
        }
    }
}
