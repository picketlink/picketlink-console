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

package org.picketlink.as.console.client.ui.federation.keystore;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import org.picketlink.as.console.client.shared.subsys.model.KeyStore;
import org.picketlink.as.console.client.ui.federation.AbstractModelElementTable;
import org.picketlink.as.console.client.ui.federation.FederationPresenter;

/**
 * <p>
 * A table widget to be used to show the identity providers.
 * </p>
 * 
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 19, 2012
 */
public class KeyStoreTable extends AbstractModelElementTable<KeyStore> {

    private FederationPresenter presenter;

    public KeyStoreTable(FederationPresenter presenter) {
        this.presenter = presenter;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.picketlink.as.console.client.ui.federation.AbstractModelElementTable#doGetKey(java.lang.Object)
     */
    @Override
    protected Object doGetKey(KeyStore item) {
        return item.getUrl();
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
        TextColumn<KeyStore> urlColumn = new TextColumn<KeyStore>() {
            @Override
            public String getValue(KeyStore record) {
                return record.getUrl();
            }
        };

        table.addColumn(urlColumn, "Url");

        TextColumn<KeyStore> relativeToColumn = new TextColumn<KeyStore>() {
            @Override
            public String getValue(KeyStore record) {
                return record.getRelativeTo();
            }
        };

        table.addColumn(relativeToColumn, "Relative To");

        TextColumn<KeyStore> signKeyColumn = new TextColumn<KeyStore>() {
            @Override
            public String getValue(KeyStore record) {
                return record.getSignKeyAlias();
            }
        };

        table.addColumn(signKeyColumn, "Sign Key");
    }
}
