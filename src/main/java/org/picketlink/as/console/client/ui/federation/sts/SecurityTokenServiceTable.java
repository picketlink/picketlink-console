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

package org.picketlink.as.console.client.ui.federation.sts;

import org.jboss.as.console.client.Console;
import org.jboss.as.console.client.shared.model.DeploymentRecord;
import org.jboss.as.console.client.widgets.tables.TextLinkCell;
import org.jboss.ballroom.client.widgets.icons.Icons;
import org.picketlink.as.console.client.shared.subsys.model.SecurityTokenService;
import org.picketlink.as.console.client.ui.federation.AbstractModelElementTable;
import org.picketlink.as.console.client.ui.federation.FederationPresenter;

import com.google.gwt.cell.client.ActionCell;
import com.google.gwt.cell.client.ImageResourceCell;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;

/**
 * <p>
 * A table widget to be used to show the trusted domains.
 * </p>
 * 
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 19, 2012
 */
public class SecurityTokenServiceTable extends AbstractModelElementTable<SecurityTokenService> {
    
    private FederationPresenter presenter;

    public SecurityTokenServiceTable(FederationPresenter presenter) {
        this.presenter = presenter;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.picketlink.as.console.client.ui.federation.AbstractModelElementTable#doGetKey(java.lang.Object)
     */
    @Override
    protected Object doGetKey(SecurityTokenService item) {
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
        TextColumn<SecurityTokenService> aliasColumn = new TextColumn<SecurityTokenService>() {
            @Override
            public String getValue(SecurityTokenService record) {
                return record.getName();
            }
        };

        table.addColumn(aliasColumn, Console.CONSTANTS.common_label_name());
        table.addColumn(makeEnabledColumn(), Console.CONSTANTS.common_label_enabled());
        
        Column<SecurityTokenService, SecurityTokenService> reloadColumn = new Column<SecurityTokenService, SecurityTokenService>(new TextLinkCell<SecurityTokenService>(
                "Restart", new ActionCell.Delegate<SecurityTokenService>() {
                    @Override
                    public void execute(SecurityTokenService securityTokenService) {
                        presenter.getDeploymentManager().restartSecurityTokenService(securityTokenService);
                        presenter.loadDeployments();
                    }
                })) {
            @Override
            public SecurityTokenService getValue(SecurityTokenService domain) {
                return domain;
            }
        };
        
        table.addColumn(reloadColumn, "Option");
    }
    
    private Column makeEnabledColumn() {
        return new Column<DeploymentRecord, ImageResource>(new ImageResourceCell()) {

            @Override
            public ImageResource getValue(DeploymentRecord deployment) {

                ImageResource res = null;

                if (deployment.isEnabled()) {
                    res = Icons.INSTANCE.status_good();
                } else {
                    res = Icons.INSTANCE.status_bad();
                }

                return res;
            }
        };
    }

}
