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

import com.google.gwt.cell.client.ActionCell;
import com.google.gwt.cell.client.ImageResourceCell;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import org.jboss.as.console.client.Console;
import org.jboss.as.console.client.shared.deployment.model.DeploymentRecord;
import org.jboss.as.console.client.widgets.tables.TextLinkCell;
import org.jboss.ballroom.client.widgets.icons.Icons;
import org.picketlink.as.console.client.shared.subsys.model.IdentityProvider;
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
public class IdentityProviderTable extends AbstractModelElementTable<IdentityProvider> {
    
    private FederationPresenter presenter;

    public IdentityProviderTable(FederationPresenter presenter) {
        this.presenter = presenter;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.picketlink.as.console.client.ui.federation.AbstractModelElementTable#doGetKey(java.lang.Object)
     */
    @Override
    protected Object doGetKey(IdentityProvider item) {
        return item.getName();
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
        TextColumn<IdentityProvider> aliasColumn = new TextColumn<IdentityProvider>() {
            @Override
            public String getValue(IdentityProvider record) {
                if (record.isExternal()) {
                    return "Remote Identity Provider (" + record.getUrl() + ")";
                }
                
                return record.getName();
            }
        };

        table.addColumn(aliasColumn, Console.CONSTANTS.common_label_name());
        
        table.addColumn(makeEnabledColumn(), Console.CONSTANTS.common_label_enabled());
        
        Column<IdentityProvider, IdentityProvider> reloadColumn = new Column<IdentityProvider, IdentityProvider>(new TextLinkCell<IdentityProvider>(
                "Restart", new ActionCell.Delegate<IdentityProvider>() {
                    @Override
                    public void execute(IdentityProvider identityProvider) {
                        if (!identityProvider.isExternal()) {
                            presenter.getDeploymentManager().restartIdentityProvider(identityProvider);
                            presenter.loadDeployments();
                            presenter.getFederationManager().loadAllFederations();
                        } else {
                            Console.info("You can not restart external Identity Providers.");
                        }
                    }
                })) {
            @Override
            public IdentityProvider getValue(IdentityProvider domain) {
                return domain;
            }
        };
        
        table.addColumn(reloadColumn, "Option");
    }
    
    private Column makeEnabledColumn() {
        return new Column<DeploymentRecord, ImageResource>(new ImageResourceCell()) {

            @Override
            public ImageResource getValue(DeploymentRecord deployment) {
                IdentityProvider idp = (IdentityProvider) deployment;
                
                ImageResource res = null;

                if (idp.isEnabled() || idp.isExternal()) {
                    res = Icons.INSTANCE.status_good();
                } else {
                    res = Icons.INSTANCE.status_bad();
                }

                return res;
            }
        };
    }

}
