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
import org.jboss.as.console.client.shared.viewframework.Columns;
import org.jboss.as.console.client.widgets.tables.TextLinkCell;
import org.jboss.ballroom.client.widgets.forms.FormAdapter;
import org.picketlink.as.console.client.i18n.PicketLinkUIConstants;
import org.picketlink.as.console.client.shared.subsys.model.Federation;

import com.google.gwt.cell.client.ActionCell;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

/**
 * <p>
 * A table widget to be used to show the trusted domains.
 * </p>
 * 
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 19, 2012
 */
public class FederationTable extends AbstractModelElementTable<Federation> {

    private final FederationPresenter presenter;
    private final PicketLinkUIConstants uiConstants;
    private Federation selectedFederation;
    private FormAdapter<Federation> federationDetails;

    public FederationTable(FederationPresenter presenter, FormAdapter<Federation> federationDetails,
            final PicketLinkUIConstants uiConstants) {
        this.presenter = presenter;
        this.federationDetails = federationDetails;
        this.uiConstants = uiConstants;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.picketlink.as.console.client.ui.federation.AbstractModelElementTable#doGetKey(java.lang.Object)
     */
    @Override
    protected Object doGetKey(Federation item) {
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
        Column<Federation, Federation> option = new Column<Federation, Federation>(new TextLinkCell<Federation>(
                Console.CONSTANTS.common_label_view(), new ActionCell.Delegate<Federation>() {
                    @Override
                    public void execute(Federation selection) {
                        presenter.getPlaceManager().revealPlace(
                                new PlaceRequest(org.picketlink.as.console.client.NameTokens.FEDERATION).with("name",
                                        selection.getName()));
                    }
                })) {
            @Override
            public Federation getValue(Federation domain) {
                return domain;
            }
        };

        table.addColumn(new Columns.NameColumn(), uiConstants.common_label_alias());
        table.addColumn(option, "Option");
    }

    public Federation getSelectedFederation() {
        return this.selectedFederation;
    }

    public void addSelectionChangeHandler() {
        SingleSelectionModel<Federation> selectionModel = new SingleSelectionModel<Federation>();
        
        getCellTable().setSelectionModel(selectionModel);
        
        selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
            @Override
            public void onSelectionChange(SelectionChangeEvent event) {
                Federation selectedObject = ((SingleSelectionModel<Federation>) event.getSource()).getSelectedObject();
                selectedFederation = selectedObject;
                // updates the details section form
                federationDetails.edit(selectedObject);
                
                // load and update other informations for the selected federation
                presenter.updateFederationSelection(selectedObject);
            }
        });
    }
    
}
