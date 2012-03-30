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

package org.picketlink.as.console.client.ui.core;

import java.util.List;

import org.jboss.ballroom.client.widgets.tables.DefaultCellTable;
import org.jboss.ballroom.client.widgets.tables.DefaultPager;
import org.picketlink.as.console.client.shared.subsys.model.Federation;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.ProvidesKey;

/**
 * <p>
 * Abstract class to be used to create tables.
 * </p>
 * 
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 19, 2012
 */
public abstract class AbstractModelElementTable<T> {

    private static final int PAGE_SIZE = 5;
    private DefaultCellTable<T> dataTable;
    private ListDataProvider<T> dataProvider;

    public Widget asWidget() {
        VerticalPanel layout = new VerticalPanel();
        layout.setStyleName("fill-layout-width");

        layout.add(getCellTable());

        DefaultPager pager = new DefaultPager();
        
        pager.setDisplay(getCellTable());
        
        layout.add(pager);

        return layout;
    }

    /**
     * Returns a instance of {@link DefaultCellTable} used to list federation instances.
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    public DefaultCellTable<T> getCellTable() {
        if (this.dataTable == null) {
            this.dataTable = new DefaultCellTable<T>(
                    PAGE_SIZE,
                    new ProvidesKey<T>() {
                        @Override
                        public Object getKey(T item) {
                            return doGetKey(item);
                        }
                    });
            doAddConlumns(this.dataTable);
        }

        return this.dataTable;
    }

    /**
     * <p>
     * Callback method to get the key for this table.
     * </p>
     * 
     * @param item
     * @return
     */
    protected abstract Object doGetKey(T item);
    
    /**
     * <p>
     * Callback method to add columns to the table.
     * </p>
     * 
     * @param federationTable2
     */
    protected abstract void doAddConlumns(CellTable federationTable);

    /**
     * Returns a instance of {@link ListDataProvider} to be used to manipulate table items.
     * 
     * @return
     */
    public ListDataProvider<T> getDataProvider() {
        if (this.dataProvider == null) {
            this.dataProvider = new ListDataProvider<T>();
            this.dataProvider.addDataDisplay(getCellTable());
        }

        return this.dataProvider;
    }
    
    /**
     * @param datasources
     */
    public void setList(List<T> items) {
        this.getDataProvider().setList(items);
    }

}
