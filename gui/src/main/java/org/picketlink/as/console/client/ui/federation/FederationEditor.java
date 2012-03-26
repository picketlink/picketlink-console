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
import org.jboss.as.console.client.shared.subsys.jca.DataSourcePresenter;
import org.jboss.as.console.client.shared.subsys.jca.wizard.NewDatasourceWizard;
import org.jboss.as.console.client.widgets.ContentDescription;
import org.jboss.ballroom.client.widgets.ContentGroupLabel;
import org.jboss.ballroom.client.widgets.ContentHeaderLabel;
import org.jboss.ballroom.client.widgets.tools.ToolButton;
import org.jboss.ballroom.client.widgets.tools.ToolStrip;
import org.jboss.ballroom.client.widgets.window.DefaultWindow;
import org.jboss.ballroom.client.widgets.window.Feedback;
import org.picketlink.as.console.client.BeanFactory;
import org.picketlink.as.console.client.shared.subsys.model.Federation;
import org.picketlink.as.console.client.shared.subsys.model.IdentityProvider;
import org.picketlink.as.console.client.shared.subsys.model.ServiceProvider;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.SimplePanel;
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

    /**
     * 
     */
    private static final String EDITOR_DESCRIPTION = "The PicketLink Federation provides the configurations for IDPs and SPs given a federation configuration.";

    private static final String EDITOR_LABEL_TEXT = "Federation";

    private FederationPresenter presenter;
    private FederationTable federationTable;
    private FederationDetails federationDetails;

    private IdentityProviderDetails identityProviderDetails;

    private ServiceProviderDetails serviceProviderDetails;

    private DefaultWindow window;

    private BeanFactory beanFactory;

    public FederationEditor(FederationPresenter presenter, BeanFactory beanFactory) {
        this.presenter = presenter;
        this.beanFactory = beanFactory;
    }

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
        vpanel.add(new ContentGroupLabel(Console.CONSTANTS.common_label_selection()));
        
        TabPanel bottomPanel = new TabPanel();

        bottomPanel.setStyleName("default-tabpanel");

        bottomPanel.add(getFederationDetails().asWidget(), "General");
        bottomPanel.add(getIdentityProvidersDetails().asWidget(), "Identity Provider");
        bottomPanel.add(getServiceProviderDetails().asWidget(), "Service Providers");
        bottomPanel.add(new SimplePanel(), "Digital Certificates");
        bottomPanel.selectTab(0);
        
        addSelectionChangeHandler();

        vpanel.add(bottomPanel);
    }

    /**
     * @return
     */
    private ServiceProviderDetails getServiceProviderDetails() {
        if (this.serviceProviderDetails == null) {
            this.serviceProviderDetails = new ServiceProviderDetails();
        }

        return this.serviceProviderDetails;
    }

    /**
     * <p>
     * Adds a {@link SelectionChangeEvent.Handler} to handle selection from the table.
     * This method must be called after the <code>addSelectionWidgets</code>.
     * </p>
     */
    private void addSelectionChangeHandler() {
        SingleSelectionModel<Federation> selectionModel = (SingleSelectionModel<Federation>) this.getFederationTable()
                .getCellTable().getSelectionModel();

        selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
            @Override
            public void onSelectionChange(SelectionChangeEvent event) {
                getFederationDetails().setEnabled(false);
                presenter.loadIdentityProvider(((SingleSelectionModel<Federation>) event.getSource()).getSelectedObject());
                presenter.loadServiceProviders(((SingleSelectionModel<Federation>) event.getSource()).getSelectedObject());
            }
        });
    }

    /**
     * Adds the widgtes related with the table from which items can be selected, addes or removed.
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
    @SuppressWarnings("unchecked")
    private FederationDetails getFederationDetails() {
        if (this.federationDetails == null) {
            this.federationDetails = new FederationDetails(this.presenter);
            this.federationDetails.bind(getFederationTable().getCellTable());
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
                lunchNewFederationWizard();
            }
        });
    }

    private void lunchNewFederationWizard() {
        window = new DefaultWindow(Console.MESSAGES.createTitle("Federation"));
        window.setWidth(480);
        window.setHeight(450);

        window.setWidget(
                new NewFederationWizard(this.presenter, this).asWidget()
        );

        window.setGlassEnabled(true);
        window.center();
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

                final Federation currentSelection = getFederationDetails().getCurrentSelection();

                if (currentSelection != null) {
                    Feedback.confirm(Console.MESSAGES.deleteTitle(EDITOR_LABEL_TEXT),
                            Console.MESSAGES.deleteConfirm("Federation " + currentSelection.getAlias()),
                            new Feedback.ConfirmationHandler() {
                                @Override
                                public void onConfirmation(boolean isConfirmed) {
                                    if (isConfirmed) {
                                        presenter.onDelete(currentSelection);
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
     * Updates the table wich the federation instances are listed.
     * 
     * @param datasources
     */
    public void updateFederations(List<Federation> datasources) {
        getFederationTable().getDataProvider().setList(datasources);
        getFederationTable().getCellTable().selectDefaultEntity();
    }

    /**
     * Returns a instance of the table to be used to show the federation instances.
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
     * @param identityProviders
     */
    public void updateIdentityProviders(List<IdentityProvider> identityProviders) {
        this.getIdentityProvidersDetails().updateIdentityProvider(identityProviders);
    }

    /**
     * @param result
     */
    public void updateServiceProviders(List<ServiceProvider> result) {
        this.getServiceProviderDetails().updateServiceProviders(result);
    }

    /**
     * 
     */
    public void closeDialogue() {
        window.hide();
    }

    /**
     * @return the beanFactory
     */
    public BeanFactory getBeanFactory() {
        return this.beanFactory;
    }
}
