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

package org.picketlink.as.console.client.ui.federation;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SelectionChangeEvent.Handler;
import com.google.gwt.view.client.SingleSelectionModel;
import org.jboss.as.console.client.Console;
import org.picketlink.as.console.client.shared.subsys.model.Key;

/**
 * <p>
 * A table widget to be used to show the trusted domains.
 * </p>
 * 
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 19, 2012
 */
public class KeyTable extends AbstractModelElementTable<Key> {

    private Key selectedKey;
    
    /*
     * (non-Javadoc)
     * 
     * @see org.picketlink.as.console.client.ui.federation.AbstractModelElementTable#doGetKey(java.lang.Object)
     */
    @Override
    protected Object doGetKey(Key item) {
        return item.getName();
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
        createHostCollumn(table);

        this.getCellTable().setSelectionModel(createSelectionModel());
    }

    private SingleSelectionModel<Key> createSelectionModel() {
        final SingleSelectionModel<Key> selectionModel = new SingleSelectionModel<Key>();

        Handler selectionHandler = new Handler() {

            @Override
            public void onSelectionChange(SelectionChangeEvent event) {
                SingleSelectionModel<Key> selection = (SingleSelectionModel<Key>) event.getSource();
                
                selectedKey = selection.getSelectedObject();
            }

        };

        selectionModel.addSelectionChangeHandler(selectionHandler);

        return selectionModel;
    }

    private void createNameColumn(CellTable table) {
        TextColumn<Key> nameColumn = new TextColumn<Key>() {
            @Override
            public String getValue(Key record) {
                return record.getName();
            }
        };

        table.addColumn(nameColumn, Console.CONSTANTS.common_label_name());
    }
    
    private void createHostCollumn(CellTable table) {
        TextColumn<Key> nameColumn = new TextColumn<Key>() {
            @Override
            public String getValue(Key record) {
                return record.getHost();
            }
        };

        table.addColumn(nameColumn, "Host");
    }
    
    /**
     * @return the selectedTrustedDomain
     */
    public Key getSelectedTrustedDomain() {
        return this.selectedKey;
    }
}
