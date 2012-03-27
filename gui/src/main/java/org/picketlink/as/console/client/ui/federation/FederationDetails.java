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

import org.jboss.as.console.client.shared.help.FormHelpPanel;
import org.jboss.as.console.client.shared.subsys.Baseadress;
import org.jboss.as.console.client.shared.viewframework.builder.FormLayout;
import org.jboss.as.console.client.widgets.ContentDescription;
import org.jboss.ballroom.client.widgets.ContentGroupLabel;
import org.jboss.ballroom.client.widgets.forms.Form;
import org.jboss.ballroom.client.widgets.forms.TextBoxItem;
import org.jboss.ballroom.client.widgets.forms.TextItem;
import org.jboss.ballroom.client.widgets.tools.ToolButton;
import org.jboss.ballroom.client.widgets.tools.ToolStrip;
import org.jboss.dmr.client.ModelNode;
import org.picketlink.as.console.client.shared.subsys.model.Federation;
import org.picketlink.as.console.client.shared.subsys.model.TrustDomain;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * <p>
 * This class defines the widget to be displayed to show the general informations about a selected federation instance.
 * </p>
 * 
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 14, 2012
 */
public class FederationDetails {

    private Form<Federation> form;
    private Form<TrustDomain> trustDomainForm;
    private TrustDomainTable trustDomainTable;
    private FederationPresenter presenter;

    public FederationDetails(CellTable<Federation> table, FederationPresenter presenter) {
        this.form = new Form<Federation>(Federation.class);
        this.form.setNumColumns(2);
        this.form.bind(table);
        this.presenter = presenter;
    }

    public Widget asWidget() {
        VerticalPanel detailPanel = new VerticalPanel();
        detailPanel.setStyleName("fill-layout-width");

        final TextItem aliasItem = new TextItem("alias", "Alias");

        form.setFields(aliasItem);
        
        form.setEnabled(false);
        
        final FormHelpPanel helpPanel = createHelpPanel();

        detailPanel.add(new FormLayout().setHelp(helpPanel).setForm(form).build());
        
        VerticalPanel trustDomainsHeader = new VerticalPanel();
        
        trustDomainsHeader.setStyleName("fill-layout-width");
        
        trustDomainsHeader.add(new ContentGroupLabel("Trusted Domains"));

        this.trustDomainForm = new Form<TrustDomain>(TrustDomain.class);
        
        this.trustDomainForm.setFields(new TextBoxItem("name", "Name"));
        
        trustDomainsHeader.add(this.trustDomainForm.asWidget());

        ToolStrip trustDomainTools = new ToolStrip();
        
        ToolButton addTrustedDomainBtn = new ToolButton("Add");
        
        addTrustedDomainBtn.addClickHandler(new ClickHandler() {
            
            @Override
            public void onClick(ClickEvent event) {
                presenter.onCreateTrustDomain(trustDomainForm.getUpdatedEntity());
            }
        });

        trustDomainTools.addToolButtonRight(addTrustedDomainBtn);

        ToolButton removeTrustedDomainBtn = new ToolButton("Remove");
        
        removeTrustedDomainBtn.addClickHandler(new ClickHandler() {
            
            @Override
            public void onClick(ClickEvent event) {
                presenter.onRemoveTrustDomain(getTrustDomainTable().getSelectedTrustedDomain());
            }
        });

        trustDomainTools.addToolButtonRight(removeTrustedDomainBtn);

        trustDomainTools.setStyleName("fill-layout-width");
        
        trustDomainsHeader.add(trustDomainTools);
        
        trustDomainsHeader.add(new ContentDescription(""));
        
        detailPanel.add(trustDomainsHeader);
        detailPanel.add(getTrustDomainTable().asWidget());

        return detailPanel;
    }

    /**
     * <p>
     * Creates a instance of {@link FormHelpPanel} to show descriptions about the federation. 
     * </p>
     * 
     * @return
     */
    private FormHelpPanel createHelpPanel() {
        final FormHelpPanel helpPanel = new FormHelpPanel(new FormHelpPanel.AddressCallback() {
            @Override
            public ModelNode getAddress() {
                ModelNode address = Baseadress.get();
                address.add("subsystem", "picketlink");
                address.add("federation", "*");
                return address;
            }
        }, form);
        
        return helpPanel;
    }
    
    public TrustDomainTable getTrustDomainTable() {
        if (this.trustDomainTable == null) {
            this.trustDomainTable = new TrustDomainTable();
        }

        return this.trustDomainTable;
    }

}
