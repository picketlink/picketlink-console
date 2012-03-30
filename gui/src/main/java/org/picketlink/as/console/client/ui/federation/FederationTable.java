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

import org.jboss.as.console.client.Console;
import org.picketlink.as.console.client.PicketLinkConsoleFramework;
import org.picketlink.as.console.client.shared.subsys.model.Federation;
import org.picketlink.as.console.client.ui.core.AbstractModelElementTable;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;

/**
 * <p>
 * This class defines the widget to be displayed for the table of federations.
 * </p>
 * 
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 14, 2012
 */public class FederationTable extends AbstractModelElementTable<Federation> {

    /* (non-Javadoc)
     * @see org.picketlink.as.console.client.ui.federation.AbstractModelElementTable#doGetKey(java.lang.Object)
     */
    @Override
    protected Object doGetKey(Federation item) {
        return item.getAlias();
    }

    /* (non-Javadoc)
     * @see org.picketlink.as.console.client.ui.federation.AbstractModelElementTable#doAddConlumns(org.jboss.ballroom.client.widgets.tables.DefaultCellTable)
     */
    @SuppressWarnings("unchecked")
    @Override
    protected void doAddConlumns(CellTable federationTable) {
        TextColumn<Federation> aliasColumn = new TextColumn<Federation>() {
            @Override
            public String getValue(Federation record) {
                return record.getAlias();
            }
        };

        federationTable.addColumn(aliasColumn, Console.CONSTANTS.common_label_name());        
    }

}