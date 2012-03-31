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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jboss.as.console.client.Console;
import org.jboss.as.console.client.shared.properties.NewPropertyWizard;
import org.jboss.as.console.client.shared.properties.PropertyEditor;
import org.jboss.as.console.client.shared.properties.PropertyManagement;
import org.jboss.as.console.client.widgets.ContentDescription;
import org.jboss.ballroom.client.widgets.ContentGroupLabel;
import org.jboss.ballroom.client.widgets.ContentHeaderLabel;
import org.jboss.ballroom.client.widgets.tables.DefaultCellTable;
import org.jboss.ballroom.client.widgets.tables.DefaultPager;
import org.jboss.ballroom.client.widgets.tools.ToolButton;
import org.jboss.ballroom.client.widgets.tools.ToolStrip;
import org.jboss.ballroom.client.widgets.window.DefaultWindow;
import org.jboss.ballroom.client.widgets.window.Feedback;
import org.picketlink.as.console.client.shared.subsys.model.GenericFederationEntity;

import com.google.gwt.cell.client.CompositeCell;
import com.google.gwt.cell.client.HasCell;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.IdentityColumn;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.ProvidesKey;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

/**
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 30, 2012
 */
public abstract class AbstractFederationDetailEditor<T extends GenericFederationEntity> implements PropertyManagement {

    protected final Class<T> entityClass;
    protected final FederationPresenter presenter;

    protected DefaultCellTable<T> modelTable;
    protected ListDataProvider<T> modelTableDataProvider;
    protected String domainName;
    protected boolean resourceExists;
    protected ToolButton addModule;

    protected DefaultWindow window;
    protected ContentHeaderLabel headerLabel;

    protected Wizard<T> wizard;
    protected PropertyEditor propertyEditor;
    protected DefaultWindow propertyWindow;
    private String description;

    public AbstractFederationDetailEditor(FederationPresenter presenter, Class<T> entityClass) {
        this.presenter = presenter;
        this.entityClass = entityClass;
    }

    protected abstract String getEntityName();
    protected abstract String getStackElementName();
    protected abstract String getStackName();
    protected abstract Wizard<T> getWizard();
    protected abstract ProvidesKey<T> getKeyProvider();

    protected void setDescription(String description) {
        this.description = description;
    }

    protected abstract void onDelete(T policy);
    
    protected abstract void onUpdate(T model, Map<String, Object> changedValues);
    
    protected abstract boolean onInsert(T entity);

    public Widget asWidget() {

        VerticalPanel vpanel = new VerticalPanel();
        vpanel.setStyleName("rhs-content-panel");

        createModelTable();

        headerLabel = new ContentHeaderLabel("TITLE HERE");
        vpanel.add(headerLabel);
        vpanel.add(new ContentDescription(description));

        vpanel.add(new ContentGroupLabel(getStackName()));
        
        wizard = getWizard();
        
        createTableTools(vpanel);

        addCustomColumns(modelTable);

        List<HasCell<T, T>> actionCells = new ArrayList<HasCell<T,T>>();
        IdentityColumn<T> actionColumn = new IdentityColumn<T>(new CompositeCell(actionCells));
        modelTable.addColumn(actionColumn, "");

        vpanel.add(modelTable);

        // -------

        DefaultPager pager = new DefaultPager();
        pager.setDisplay(modelTable);
        vpanel.add(pager);

        // -------


        propertyEditor = new PropertyEditor(this, true);
        propertyEditor.setHideButtons(false);

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
        
        modelTable.setSelectionModel(ssm);

        vpanel.add(new ContentGroupLabel("Details"));

        TabPanel bottomTabs = new TabPanel();
        bottomTabs.setStyleName("default-tabpanel");
        
        bottomTabs.add(wizard.asWidget(), "Attributes");
        
        addTabs(bottomTabs);
        
        vpanel.add(bottomTabs);
        bottomTabs.selectTab(0);

        // -------

        ScrollPanel scroll = new ScrollPanel(vpanel);

        LayoutPanel layout = new LayoutPanel();
        layout.add(scroll);
        layout.setWidgetTopHeight(scroll, 0, Style.Unit.PX, 100, Style.Unit.PCT);

        return layout;
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
                openWizard(null);
            }
        });
        addModule.ensureDebugId(Console.DEBUG_CONSTANTS.debug_label_add_abstractDomainDetailEditor());
        tableTools.addToolButtonRight(addModule);
        tableTools.addToolButtonRight(
                new ToolButton(Console.CONSTANTS.common_label_delete(), new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent event) {

                        final T policy = getCurrentSelection();
                        Feedback.confirm(
                                Console.MESSAGES.deleteTitle(getEntityName()),
                                Console.MESSAGES.deleteConfirm(policy.getName()),
                                new Feedback.ConfirmationHandler() {
                                    @Override
                                    public void onConfirmation(boolean isConfirmed) {
                                        if (isConfirmed) {
                                            modelTableDataProvider.getList().remove(policy);
                                            onDelete(policy);
                                            wizard.clearValues();
                                        }
                                    }
                                });
                    }
                })
        );
        
        vpanel.add(tableTools);
    }

    /**
     * 
     */
    private void createModelTable() {
        modelTable = new DefaultCellTable<T>(4);

        modelTable.getElement().setAttribute("style", "margin-top:5px;");
        modelTableDataProvider = new ListDataProvider<T>();
        modelTableDataProvider.addDataDisplay(modelTable);
    }

    /**
     * @param bottomTabs
     */
    protected void addTabs(TabPanel bottomTabs) {
        
    }
    
    protected void doUpdateSelection(T policy) {
        
    }


    public T getCurrentSelection() {
        return ((SingleSelectionModel<T>) modelTable.getSelectionModel()).getSelectedObject();
    }


    protected void addCustomColumns(DefaultCellTable<T> attributesTable) {
        // by default no custom columns are needed
    }

    public void setData(String federationName, List<T> newList, boolean resourceExists) {
        this.domainName = federationName;
        this.resourceExists = resourceExists;

        this.headerLabel.setText("Federation: "+ federationName);

        List<T> list = modelTableDataProvider.getList();
        list.clear();
        list.addAll(newList);

        if(!list.isEmpty())
        {
            modelTable.getSelectionModel().setSelected(list.get(0), true);
        }
        else if(wizard!=null) // loading happens before asWidget() is invoked
        {
            wizard.clearValues();
        }
    }

    protected void openWizard(T editedObject) {
        Wizard<T> wizard = getWizard();
        wizard.setIsDialogue(true);

        if (wizard == null)
            return;

        window = new DefaultWindow(
                (editedObject == null ? Console.CONSTANTS.common_label_add() : Console.CONSTANTS.common_label_edit()) + " " +
                        getStackElementName());
        window.setWidth(480);
        window.setHeight(400);
        window.setWidget(wizard.asWidget());

        if (editedObject != null) wizard.edit(editedObject);

        window.setGlassEnabled(true);
        window.center();
    }

    public void closeWizard() {
        if (window != null)
            window.hide();
    }

    public void addAttribute(T policy) {
        if (onInsert(policy)) {
            modelTableDataProvider.getList().add(policy);
            // This combination seems to consistently update the details view
            modelTable.getSelectionModel().setSelected(policy, true);
            SelectionChangeEvent.fire(modelTable.getSelectionModel());
        }
    }

    public interface Wizard<T> {
        void edit(T object);
        Widget asWidget();
        Wizard setIsDialogue(boolean b);
        void clearValues();
    }

    @Override
    public void launchNewPropertyDialoge(String reference) {

        propertyWindow = new DefaultWindow(Console.MESSAGES.createTitle("Module Option"));
        propertyWindow.setWidth(320);
        propertyWindow.setHeight(240);

        propertyWindow.setWidget(
                new NewPropertyWizard(this, "", false).asWidget()
        );

        propertyWindow.setGlassEnabled(true);
        propertyWindow.center();
    }

    @Override
    public void closePropertyDialoge() {
        propertyWindow.hide();
    }

    /**
     * @return the presenter
     */
    public FederationPresenter getPresenter() {
        return this.presenter;
    }
    
    /**
     * @return the attributesTable
     */
    public DefaultCellTable<T> getAttributesTable() {
        return modelTable;
    }
    
    /**
     * @return the attributesProvider
     */
    public ListDataProvider<T> getAttributesProvider() {
        return modelTableDataProvider;
    }
    
    /**
     * @return the addModule
     */
    public ToolButton getAddModule() {
        return addModule;
    }
}
