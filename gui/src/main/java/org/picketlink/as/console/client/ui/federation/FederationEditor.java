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

import java.util.List;

import org.jboss.as.console.client.Console;
import org.jboss.as.console.client.widgets.ContentDescription;
import org.jboss.ballroom.client.widgets.ContentGroupLabel;
import org.jboss.ballroom.client.widgets.ContentHeaderLabel;
import org.jboss.ballroom.client.widgets.tools.ToolButton;
import org.jboss.ballroom.client.widgets.tools.ToolStrip;
import org.jboss.ballroom.client.widgets.window.Feedback;
import org.picketlink.as.console.client.shared.subsys.model.Federation;
import org.picketlink.as.console.client.shared.subsys.model.IdentityProvider;
import org.picketlink.as.console.client.shared.subsys.model.ServiceProvider;
import org.picketlink.as.console.client.shared.subsys.model.TrustDomain;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

/**
 * <p>
 * This class defines the widget to be displayed when the Federation option is selected from the menu.
 * </p>
 * <p>
 * It defines the layout for the federation configuration main page.
 * </p>
 * 
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 14, 2012
 */
public class FederationEditor {

    private static final String EDITOR_DESCRIPTION = "The PicketLink Federation provides the configurations for IDPs and SPs given a federation configuration.";
    private static final String EDITOR_LABEL_TEXT = "Federation";

    private FederationPresenter presenter;
    private FederationDetails federationDetails;
    private IdentityProviderDetails identityProviderDetails;
    private ServiceProviderDetails serviceProviderDetails;

    private WizardView newFederationWizard;

    private FederationTable federationTable;

    public FederationEditor(FederationPresenter presenter) {
        this.presenter = presenter;
    }

    /**
     * <p>
     * Creates the widget for this component.
     * </p>
     * 
     * @return
     */
    public Widget asWidget() {
        LayoutPanel layout = new LayoutPanel();

        VerticalPanel vpanel = new VerticalPanel();

        vpanel.setStyleName("rhs-content-panel");

        ScrollPanel scroll = new ScrollPanel(vpanel);

        layout.add(scroll);

        layout.setWidgetTopHeight(scroll, 0, Style.Unit.PX, 100, Style.Unit.PCT);

        vpanel.add(new ContentHeaderLabel(EDITOR_LABEL_TEXT));
        vpanel.add(new ContentDescription(EDITOR_DESCRIPTION));

        addTableWidgets(vpanel);
        addSelectionWidgets(vpanel);

        return layout;
    }

    /**
     * <p>
     * Adds the widgets to be displayed when a item is selected from the table.
     * </p>
     * 
     * @param vpanel
     * @return
     */
    private void addSelectionWidgets(VerticalPanel vpanel) {
        vpanel.add(new ContentGroupLabel("Federation Details"));

        TabPanel bottomPanel = new TabPanel();

        bottomPanel.setStyleName("default-tabpanel");

        bottomPanel.add(getFederationDetails().asWidget(), "General");
        bottomPanel.add(getIdentityProvidersDetails().asWidget(), "Identity Provider");
        bottomPanel.add(getServiceProviderDetails().asWidget(), "Service Providers");
        bottomPanel.selectTab(0);

        addSelectionChangeHandler();

        vpanel.add(bottomPanel);
    }

    /**
     * @return
     */
    private ServiceProviderDetails getServiceProviderDetails() {
        if (this.serviceProviderDetails == null) {
            this.serviceProviderDetails = new ServiceProviderDetails(this.presenter);
        }

        return this.serviceProviderDetails;
    }

    /**
     * <p>
     * Adds a {@link SelectionChangeEvent.Handler} to handle selection from the table. This method must be called after the
     * <code>addSelectionWidgets</code>.
     * </p>
     */
    private void addSelectionChangeHandler() {
        SingleSelectionModel<Federation> selectionModel = (SingleSelectionModel<Federation>) getFederationTable().getCellTable().getSelectionModel();

        selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
            @SuppressWarnings("unchecked")
            @Override
            public void onSelectionChange(SelectionChangeEvent event) {
                presenter.loadIdentityProvider(((SingleSelectionModel<Federation>) event.getSource()).getSelectedObject());
                presenter.loadServiceProviders(((SingleSelectionModel<Federation>) event.getSource()).getSelectedObject());
            }
        });
    }

    /**
     * Returns the selected federation instance from the table.
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    public Federation getCurrentFederation() {
        if (this.getFederationTable().getDataProvider().getList().isEmpty()) {
            this.getFederationTable().getCellTable().getSelectionModel().setSelected(null, false);
        } else {
            SingleSelectionModel<Federation> selectionModel = (SingleSelectionModel<Federation>) this.getFederationTable()
                    .getCellTable().getSelectionModel();

            if (selectionModel.getSelectedObject() == null && !this.getFederationTable().getDataProvider().getList().isEmpty()) {
                selectionModel.setSelected(this.getFederationTable().getDataProvider().getList().get(0), true);
            } else {
                return selectionModel.getSelectedObject();
            }
        }
        
        return null;
    }

    /**
     * Adds the widgtes related with the table from which items can be selected, added or removed.
     * 
     * @param vpanel
     */
    private void addTableWidgets(VerticalPanel vpanel) {
        vpanel.add(new ContentGroupLabel(Console.MESSAGES.available("Federations")));
        vpanel.add(createTopLevelActions().asWidget());
        vpanel.add(this.getFederationTable().asWidget());
    }

    /**
     * @return
     */
    private FederationDetails getFederationDetails() {
        if (this.federationDetails == null) {
            this.federationDetails = new FederationDetails(getFederationTable().getCellTable(), this.presenter);
        }

        return this.federationDetails;
    }

    /**
     * @return
     */
    private IdentityProviderDetails getIdentityProvidersDetails() {
        if (this.identityProviderDetails == null) {
            this.identityProviderDetails = new IdentityProviderDetails(this.presenter);
        }

        return this.identityProviderDetails;
    }

    /**
     * <p>
     * Creates the top level actions that can be used to maintain the federation table items.
     * Basically add and remove federation instances.
     * </p>
     * 
     * @return
     */
    private ToolStrip createTopLevelActions() {
        ToolStrip topLevelTools = new ToolStrip();

        topLevelTools.addToolButtonRight(createAddFederationButton());
        topLevelTools.addToolButtonRight(createDeleteFederationButton());

        return topLevelTools;
    }

    /**
     * <p>
     * Creates a instance of {@link ToolButton} to add federation instances from the table.
     * </p>
     * 
     * @return
     */
    private ToolButton createAddFederationButton() {
        return new ToolButton(Console.CONSTANTS.common_label_add(), new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                getNewFederationWizard().lunch();
            }
        });
    }

    /**
     * <p>
     * Creates a instance of {@link ToolButton} to delete federation instances from the table.
     * </p>
     * 
     * @return
     */
    private ToolButton createDeleteFederationButton() {
        ClickHandler clickHandler = new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {

                final Federation currentSelection = getCurrentFederation();

                if (currentSelection != null) {
                    Feedback.confirm(Console.MESSAGES.deleteTitle(EDITOR_LABEL_TEXT),
                            Console.MESSAGES.deleteConfirm("Federation " + currentSelection.getAlias()),
                            new Feedback.ConfirmationHandler() {
                                @Override
                                public void onConfirmation(boolean isConfirmed) {
                                    if (isConfirmed) {
                                        presenter.onRemoveFederation(currentSelection);
                                    }
                                }
                            });
                }
            }
        };

        ToolButton deleteBtn = new ToolButton(Console.CONSTANTS.common_label_delete());

        deleteBtn.addClickHandler(clickHandler);

        return deleteBtn;
    }

    /**
     * <p>
     * Updates the table from which the federation instances are listed.
     * </p>
     * 
     * @param federations
     */
    public void updateFederations(List<Federation> federations) {
        getFederationTable().setList(federations);
        getFederationTable().getCellTable().selectDefaultEntity();
    }

    /**
     * <p>
     * Updates the informations about a identity provider for a selected federation instance.
     * </p>
     * 
     * @param identityProviders
     */
    public void updateIdentityProviders(IdentityProvider identityProvider) {
        this.getIdentityProvidersDetails().updateIdentityProvider(identityProvider);
        this.getServiceProviderDetails().setIdentityProvider(identityProvider);
    }

    /**
     * <p>
     * Updates the informations about service providers for a selected federation instance.
     * </p>
     * 
     * @param result
     */
    public void updateServiceProviders(List<ServiceProvider> result) {
        this.getServiceProviderDetails().updateServiceProviders(result);
        this.getIdentityProvidersDetails().setServiceProviders(result);
    }
    
    /**
     * <p>
     * Updates the informations about the trusted domains.
     * </p>
     * 
     * @param result
     */
    public void updateTrustDomains(List<TrustDomain> result) {
        this.getFederationDetails().getTrustDomainTable().setList(result);
        getFederationDetails().getTrustDomainTable().getCellTable().selectDefaultEntity();
    }


    /**
     * Returns a instance of the table used to show the federation instances.
     * 
     * @return
     */
    private FederationTable getFederationTable() {
        if (this.federationTable == null) {
            this.federationTable = new FederationTable();
        }

        return this.federationTable;
    }

    /**
     * @return the newFederationWizard
     */
    public WizardView getNewFederationWizard() {
        if (this.newFederationWizard == null) {
            this.newFederationWizard = new NewFederationWizard(this.presenter);
        }

        return this.newFederationWizard;
    }

    /**
     * @return
     */
    public IdentityProvider getIdentityProvider() {
        return this.getIdentityProvidersDetails().getIdentityProvider();
    }

}
