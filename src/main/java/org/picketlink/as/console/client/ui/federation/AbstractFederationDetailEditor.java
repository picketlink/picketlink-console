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
import java.util.Map;

import org.jboss.as.console.client.Console;
import org.jboss.as.console.client.widgets.ContentDescription;
import org.jboss.ballroom.client.widgets.ContentGroupLabel;
import org.jboss.ballroom.client.widgets.ContentHeaderLabel;
import org.jboss.ballroom.client.widgets.tables.DefaultPager;
import org.jboss.ballroom.client.widgets.tools.ToolButton;
import org.jboss.ballroom.client.widgets.tools.ToolStrip;
import org.jboss.ballroom.client.widgets.window.DefaultWindow;
import org.jboss.ballroom.client.widgets.window.Feedback;
import org.picketlink.as.console.client.shared.subsys.model.GenericFederationEntity;

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
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 30, 2012
 */
public abstract class AbstractFederationDetailEditor<T extends GenericFederationEntity> {

    private final Class<T> entityClass;
    private final FederationPresenter presenter;
    private final AbstractModelElementTable<T> table;

    private ToolButton addModule;
    private DefaultWindow window;
    private ContentHeaderLabel headerLabel;

    private Wizard<T> wizard;

    public AbstractFederationDetailEditor(FederationPresenter presenter, AbstractModelElementTable<T> table,
            Class<T> entityClass) {
        this.presenter = presenter;
        this.entityClass = entityClass;
        this.table = table;
        configureTable();
    }

    /**
     * <p>
     * Subclasses should return the name of the entity being used (Eg.: Identity Provider, Service Provider, etc). This name
     * will be used in wizards and in the editor itself to show the name of the entity being configured.
     * </p>
     * 
     * @return
     */
    protected abstract String doGetEntityName();

    /**
     * <p>
     * Subclasses should return the name of the tables section (Eg.: Identity Providers, Service Providers, etc).
     * </p>
     * 
     * @return
     */
    protected abstract String doGetTableSectionName();

    /**
     * <p>
     * Subclasses should override to provide the description for this editor.
     * </p>
     * 
     * @return
     */
    protected abstract String doGetDescription();

    /**
     * <p>
     * Subclasses should override to create a @ Wizard} instance to be used to edit and create new elements.
     * </p>
     * 
     * @return
     */
    protected abstract Wizard<T> doCreateWizard();

    /**
     * <p>
     * Subclasses should override to handle delete events.
     * </p>
     * 
     * @param policy
     */
    protected abstract void doDelete(T policy);

    /**
     * <p>
     * Subclasses should override to handle update events.
     * </p>
     * 
     * @param model
     * @param changedValues
     */
    protected abstract void doUpdate(T model, Map<String, Object> changedValues);

    /**
     * <p>
     * Subclasses should override to handle insert events.
     * </p>
     * 
     * @param entity
     * @return
     */
    protected abstract boolean doInsert(T entity);

    /**
     * Configures the table. This method adds a {@link SingleSelectionModel} instance to handle selection events.
     */
    private void configureTable() {
        final SingleSelectionModel<T> ssm = new SingleSelectionModel<T>();
        ssm.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
            @Override
            public void onSelectionChange(SelectionChangeEvent event) {
                T modelSelection = ssm.getSelectedObject();

                if (modelSelection == null) // Can this actually happen?
                {
                    return;
                }

                wizard.edit(modelSelection);
                doUpdateSelection(modelSelection);

            }
        });

        table.getCellTable().setSelectionModel(ssm);
    }

    public Widget asWidget() {
        VerticalPanel vpanel = new VerticalPanel();
        vpanel.setStyleName("rhs-content-panel");

        // adds the page title
        headerLabel = new ContentHeaderLabel("TITLE HERE");
        vpanel.add(headerLabel);

        // adds the page description
        vpanel.add(new ContentDescription(doGetDescription()));

        // adds the tables section name
        vpanel.add(new ContentGroupLabel(doGetTableSectionName()));

        // adds the add and remove buttons above the table
        createTableTools(vpanel);

        // adds the table
        vpanel.add(table.getCellTable());

        DefaultPager pager = new DefaultPager();
        pager.setDisplay(table.getCellTable());
        vpanel.add(pager);

        createDetailsSection(vpanel);

        // -------

        ScrollPanel scroll = new ScrollPanel(vpanel);

        LayoutPanel layout = new LayoutPanel();
        layout.add(scroll);
        layout.setWidgetTopHeight(scroll, 0, Style.Unit.PX, 100, Style.Unit.PCT);

        return layout;
    }

    private void createDetailsSection(VerticalPanel vpanel) {
        // adds the title for the details section
        vpanel.add(new ContentGroupLabel("Details"));

        // adds the tabs for the details section
        TabPanel bottomTabs = new TabPanel();
        bottomTabs.setStyleName("default-tabpanel");

        wizard = doCreateWizard();

        bottomTabs.add(wizard.asWidget(), "Attributes");

        addDetailsSectionTabs(bottomTabs);

        vpanel.add(bottomTabs);
        bottomTabs.selectTab(0);
    }

    /**
     * @param vpanel
     */
    private void createTableTools(VerticalPanel vpanel) {
        ToolStrip tableTools = new ToolStrip();

        addModule = new ToolButton(Console.CONSTANTS.common_label_add());
        addModule.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                launchWizard(null);
            }
        });
        addModule.ensureDebugId(Console.DEBUG_CONSTANTS.debug_label_add_abstractDomainDetailEditor());
        tableTools.addToolButtonRight(addModule);
        tableTools.addToolButtonRight(new ToolButton(Console.CONSTANTS.common_label_delete(), new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {

                final T policy = getCurrentSelection();
                Feedback.confirm(Console.MESSAGES.deleteTitle(doGetEntityName()),
                        Console.MESSAGES.deleteConfirm(policy.getName()), new Feedback.ConfirmationHandler() {
                            @Override
                            public void onConfirmation(boolean isConfirmed) {
                                if (isConfirmed) {
                                    table.getDataProvider().getList().remove(policy);
                                    table.getCellTable().getSelectionModel().setSelected(null, true);
                                    doDelete(policy);
                                    wizard.clearValues();
                                }
                            }
                        });
            }
        }));

        vpanel.add(tableTools);
    }

    /**
     * <p>
     * Subclasses can override this method to create more tabs for the details section.
     * </p>
     * 
     * @param bottomTabs
     */
    protected void addDetailsSectionTabs(TabPanel bottomTabs) {

    }

    /**
     * Subclasses can override this method be notified when a table selection is made.
     * 
     * @param policy
     */
    protected void doUpdateSelection(T policy) {

    }

    public T getCurrentSelection() {
        return ((SingleSelectionModel<T>) table.getCellTable().getSelectionModel()).getSelectedObject();
    }

    public void setData(String federationName, List<T> newList) {
        this.headerLabel.setText("Federation: " + federationName);

        List<T> list = table.getDataProvider().getList();
        list.clear();
        list.addAll(newList);

        if (!list.isEmpty()) {
            table.getCellTable().getSelectionModel().setSelected(list.get(0), true);
        } else if (wizard != null) // loading happens before asWidget() is invoked
        {
            wizard.clearValues();
        }
    }

    /**
     * <p>
     * This methods lunchs the wizard to let users add a new element.
     * </p>
     * 
     * @param editedObject
     */
    private void launchWizard(T editedObject) {
        Wizard<T> wizard = doCreateWizard();
        wizard.setIsDialogue(true);

        if (wizard == null)
            return;

        window = new DefaultWindow((editedObject == null ? Console.CONSTANTS.common_label_add()
                : Console.CONSTANTS.common_label_edit())
                + " " + doGetEntityName());
        
        window.setWidth(480);
        window.setHeight(400);
        window.setWidget(wizard.asWidget());

        if (editedObject != null)
            wizard.edit(editedObject);

        window.setGlassEnabled(true);
        window.center();
    }

    public void closeWizard() {
        if (window != null)
            window.hide();
    }

    /**
     * <p>
     * This method is called when a new configuration is saved from the wizard.
     * This is a callback method invoked by the configured wizard.
     * </p>
     * 
     * @param policy
     */
    public void doSaveWizard(T policy) {
        if (doInsert(policy)) {
            table.getDataProvider().getList().add(policy);
            table.getCellTable().getSelectionModel().setSelected(policy, true);
            SelectionChangeEvent.fire(table.getCellTable().getSelectionModel());
        }
    }

    /**
     * @return the presenter
     */
    protected FederationPresenter getPresenter() {
        return this.presenter;
    }

    /**
     * <p>
     * Disables the Add button, avoiding to create new elements.
     * </p>
     */
    protected void disableAddButton() {
        this.addModule.setEnabled(false);
    }

    /**
     * <p>
     * Enables the Add button, avoiding to create new elements.
     * </p>
     */
    protected void enableAddButton() {
        this.addModule.setEnabled(true);
    }
    
    protected Class<T> getEntityClass() {
        return entityClass;
    }
}
