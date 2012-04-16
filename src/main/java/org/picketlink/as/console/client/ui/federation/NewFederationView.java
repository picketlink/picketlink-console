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
import java.util.EnumSet;
import java.util.List;

import org.jboss.as.console.client.Console;
import org.jboss.as.console.client.shared.dispatch.DispatchAsync;
import org.jboss.as.console.client.shared.model.DeploymentRecord;
import org.jboss.as.console.client.shared.viewframework.AbstractEntityView;
import org.jboss.as.console.client.shared.viewframework.EntityEditor;
import org.jboss.as.console.client.shared.viewframework.EntityToDmrBridge;
import org.jboss.as.console.client.shared.viewframework.EntityToDmrBridgeImpl;
import org.jboss.as.console.client.shared.viewframework.FrameworkButton;
import org.jboss.as.console.client.widgets.forms.ApplicationMetaData;
import org.jboss.as.console.client.widgets.pages.PagedView;
import org.jboss.ballroom.client.widgets.forms.Form;
import org.jboss.ballroom.client.widgets.forms.FormAdapter;
import org.jboss.ballroom.client.widgets.tables.DefaultCellTable;
import org.jboss.ballroom.client.widgets.tabs.FakeTabPanel;
import org.picketlink.as.console.client.PicketLinkConsoleFramework;
import org.picketlink.as.console.client.shared.subsys.model.Federation;
import org.picketlink.as.console.client.shared.subsys.model.IdentityProvider;
import org.picketlink.as.console.client.shared.subsys.model.IdentityProviderWrapper;
import org.picketlink.as.console.client.shared.subsys.model.KeyStore;
import org.picketlink.as.console.client.shared.subsys.model.ServiceProvider;
import org.picketlink.as.console.client.shared.subsys.model.TrustDomain;
import org.picketlink.as.console.client.ui.federation.idp.IdentityProviderEditor;
import org.picketlink.as.console.client.ui.federation.sp.ServiceProviderEditor;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

/**
 * <p>
 * The view for the PicketLink -> Federation menu item.
 * </p>
 * 
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 14, 2012
 */
public class NewFederationView extends AbstractEntityView<Federation> implements FederationPresenter.MyView {

    private EntityToDmrBridgeImpl<Federation> bridge;
    private FederationPresenter presenter;
    private PagedView pages;
    private IdentityProviderEditor identityProviderEditor;
    private String selectedFederation;
    private FederationTable federationsTable;
    private ServiceProviderEditor serviceProviderEditor;
    private NewFederationDetails federationDetails;

    /**
     * @param beanType
     * @param propertyMetaData
     */
    @Inject
    public NewFederationView(ApplicationMetaData propertyMetaData, DispatchAsync dispatchAsync) {
        super(Federation.class, propertyMetaData, EnumSet.of(FrameworkButton.EDIT_SAVE));
        bridge = new EntityToDmrBridgeImpl<Federation>(propertyMetaData, Federation.class, this, dispatchAsync);
    }

    @Override
    public Widget createWidget() {

        pages = new PagedView();

        Widget domainList = createDomainList(PicketLinkConsoleFramework.MESSAGES.federationSectionDescription());

        pages.addPage(Console.CONSTANTS.common_label_back(), domainList);
        pages.addPage(getIdentityProviderEditor().doGetEntityName(), getIdentityProviderEditor().asWidget());
        pages.addPage(getServiceProviderEditor().doGetEntityName(), getServiceProviderEditor().asWidget());

        // default page
        pages.showPage(0);

        // ---

        LayoutPanel layout = new LayoutPanel();

        // Top Most Tab
        FakeTabPanel titleBar = new FakeTabPanel(getEntityDisplayName());
        layout.add(titleBar);

        Widget pagesWidget = pages.asWidget();
        layout.add(pagesWidget);

        layout.setWidgetTopHeight(titleBar, 0, Style.Unit.PX, 40, Style.Unit.PX);
        layout.setWidgetTopHeight(pagesWidget, 40, Style.Unit.PX, 100, Style.Unit.PCT);
        
        this.federationsTable.addSelectionChangeHandler();

        return layout;
    }

    /**
     * @return
     */
    private IdentityProviderEditor getIdentityProviderEditor() {
        if (this.identityProviderEditor == null) {
            this.identityProviderEditor = new IdentityProviderEditor(this.presenter);
        }

        return this.identityProviderEditor;
    }

    private ServiceProviderEditor getServiceProviderEditor() {
        if (this.serviceProviderEditor == null) {
            this.serviceProviderEditor = new ServiceProviderEditor(this.presenter);
        }

        return this.serviceProviderEditor;
    }

    private Widget createDomainList(String description) {
        VerticalPanel panel = new VerticalPanel();
        panel.setStyleName("rhs-content-panel");

        ScrollPanel scrollPanel = new ScrollPanel(panel);

        entityEditor = makeEntityEditor();
        entityEditor.setDescription(description);
        
        Widget editorWidget = entityEditor.setIncludeTools(true).asWidget();

        panel.add(editorWidget);

        return scrollPanel;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.picketlink.as.console.client.ui.federation.FederationPresenter.MyView#getCurrentFederation()
     */
    @Override
    public Federation getCurrentFederation() {
        return this.federationsTable.getSelectedFederation();
    }

    /* (non-Javadoc)
     * @see org.picketlink.as.console.client.ui.federation.FederationPresenter.MyView#updateDeployments(java.util.List)
     */
    public void updateDeployments(List<DeploymentRecord> deployments) {
        getIdentityProviderEditor().updateDeployments(deployments);
        getServiceProviderEditor().updateDeployments(deployments);
    }
    
    @Override
    public void refresh() {
        super.refresh();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.picketlink.as.console.client.ui.federation.FederationPresenter.MyView#setIdentityProviders(java.lang.String,
     * java.util.List, boolean)
     */
    @Override
    public void setIdentityProviders(String name, List<IdentityProviderWrapper> identityProviders) {
        List<IdentityProvider> list = new ArrayList<IdentityProvider>();
        List<TrustDomain> trustDomains = new ArrayList<TrustDomain>();
        
        for (IdentityProviderWrapper identityProvider : identityProviders) {
            list.add(identityProvider.getIdentityProvider());
            
            trustDomains.addAll(identityProvider.getTrustDomains());
        }

        getIdentityProviderEditor().setIdentityProviders(name, list);
        getIdentityProviderEditor().setTrustedDomains(trustDomains);
    }
    
    @Override
    public void setKeyStore(String name, KeyStore keyStore) {
        this.federationDetails.setKeyStore(keyStore);
    }

    @Override
    public void setServiceProviders(String name, List<ServiceProvider> serviceProviders) {
        getServiceProviderEditor().setServiceProviders(name, serviceProviders);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.picketlink.as.console.client.ui.federation.FederationPresenter.MyView#setTrustedDomains(java.util.List)
     */
    @Override
    public void setTrustedDomains(List<TrustDomain> result) {
        getIdentityProviderEditor().setTrustedDomains(result);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.picketlink.as.console.client.ui.federation.FederationPresenter.MyView#setPresenter(org.picketlink.as.console.client
     * .ui.federation.FederationPresenter)
     */
    @Override
    public void setPresenter(FederationPresenter presenter) {
        this.presenter = presenter;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.jboss.as.console.client.shared.viewframework.AbstractEntityView#getEntityBridge()
     */
    @Override
    public EntityToDmrBridge<Federation> getEntityBridge() {
        return this.bridge;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.jboss.as.console.client.shared.viewframework.AbstractEntityView#makeEntityEditor()
     */
    @Override
    protected EntityEditor<Federation> makeEntityEditor() {
        return super.makeEntityEditor().setIncludeTools(true);
    }

    protected FormAdapter<Federation> makeEditEntityDetailsForm() {
        if (this.federationDetails == null) {
            this.federationDetails = new NewFederationDetails(this.presenter);
        }

        return this.federationDetails;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.jboss.as.console.client.shared.viewframework.AbstractEntityView#makeEntityTable()
     */
    @Override
    protected DefaultCellTable<Federation> makeEntityTable() {
        this.federationsTable = new FederationTable(this.presenter, this.federationDetails);
        return this.federationsTable.getCellTable();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.picketlink.as.console.client.ui.federation.FederationPresenter.MyView#setSelectedFederation(java.lang.String)
     */
    @Override
    public void setSelectedFederation(String alias) {
        this.selectedFederation = alias;
        
        if (selectedFederation != null) {
            pages.showPage(1);
            bridge.loadEntities(alias);
        } else {
            pages.showPage(0);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.jboss.as.console.client.shared.viewframework.AbstractEntityView#makeAddEntityForm()
     */
    @Override
    protected FormAdapter<Federation> makeAddEntityForm() {
        Form<Federation> form = new Form(Federation.class);
        form.setNumColumns(1);
        form.setFields(formMetaData.findAttribute("name").getFormItemForAdd());
        return form;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.jboss.as.console.client.shared.viewframework.AbstractEntityView#getEntityDisplayName()
     */
    @Override
    protected String getEntityDisplayName() {
        return PicketLinkConsoleFramework.CONSTANTS.common_label_federation();
    }

}
