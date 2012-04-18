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

import org.jboss.as.console.client.Console;
import org.jboss.as.console.client.widgets.ContentDescription;
import org.jboss.ballroom.client.widgets.forms.Form;
import org.jboss.ballroom.client.widgets.forms.TextBoxItem;
import org.jboss.ballroom.client.widgets.tools.ToolButton;
import org.jboss.ballroom.client.widgets.tools.ToolStrip;
import org.jboss.ballroom.client.widgets.window.Feedback;
import org.picketlink.as.console.client.PicketLinkConsoleFramework;
import org.picketlink.as.console.client.shared.subsys.model.IdentityProvider;
import org.picketlink.as.console.client.shared.subsys.model.TrustDomain;
import org.picketlink.as.console.client.ui.federation.FederationPresenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 31, 2012
 */
public class TrustedDomainTabEditor {

    private Form<TrustDomain> trustDomainForm;
    private TrustDomainTable trustDomainTable;
    private FederationPresenter presenter;
    private IdentityProvider identityProvider;
    private ToolButton removeTrustedDomainBtn;
    private ToolButton addTrustedDomainBtn;

    public TrustedDomainTabEditor(FederationPresenter presenter) {
        this.presenter = presenter;
    }
    
    public Widget asWidget() {
        // adds the trust domain section
        VerticalPanel trustDomainsHeader = new VerticalPanel();

        trustDomainsHeader.setStyleName("fill-layout-width");

        addTrustDomainForm(trustDomainsHeader);
        addTrustDomainActions(trustDomainsHeader);
        addTrustDomainTable(trustDomainsHeader);

        return trustDomainsHeader;
    }

    /**
     * @param detailPanel
     */
    private void addTrustDomainTable(VerticalPanel detailPanel) {
        detailPanel.add(getTrustDomainTable().asWidget());
    }

    /**
     * @param detailPanel
     * @param trustDomainsHeader
     */
    private void addTrustDomainActions(VerticalPanel trustDomainsHeader) {
        ToolStrip trustDomainTools = new ToolStrip();

        addTrustedDomainBtn = new ToolButton(Console.CONSTANTS.common_label_add());

        addTrustedDomainBtn.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                if (identityProvider == null) {
                    Window.alert(PicketLinkConsoleFramework.MESSAGES.identityProviderNotConfigured());
                } else {
                    TrustDomain newTrustedDomain = trustDomainForm.getUpdatedEntity();
                    
                    if (newTrustedDomain != null
                            && !newTrustedDomain.getName().trim().isEmpty()) {
                        presenter.getFederationManager().onCreateTrustDomain(identityProvider, newTrustedDomain);
                        getTrustDomainTable().getDataProvider().getList().add(newTrustedDomain);
                        showRestartDialog();
                    } else {
                        Window.alert(PicketLinkConsoleFramework.MESSAGES.invalidTrustedDomain());
                    }
                    
                    trustDomainForm.clearValues();
                }
            }
        });

        trustDomainTools.addToolButtonRight(addTrustedDomainBtn);

        removeTrustedDomainBtn = new ToolButton(Console.CONSTANTS.common_label_delete());

        removeTrustedDomainBtn.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                final TrustDomain removedTrustedDomain = getTrustDomainTable().getSelectedTrustedDomain();
                
                Feedback.confirm(
                        Console.MESSAGES.deleteTitle(PicketLinkConsoleFramework.CONSTANTS.common_label_trustDomain()),
                        Console.MESSAGES.deleteConfirm(removedTrustedDomain.getName()),
                        new Feedback.ConfirmationHandler() {
                            @Override
                            public void onConfirmation(boolean isConfirmed) {
                                if (isConfirmed) {
                                    presenter.getFederationManager().onRemoveTrustDomain(identityProvider, removedTrustedDomain);
                                    getTrustDomainTable().getDataProvider().getList().remove(removedTrustedDomain);
                                    showRestartDialog();
                                }
                            }
                        });
                
                trustDomainForm.clearValues();
            }
        });

        trustDomainTools.addToolButtonRight(removeTrustedDomainBtn);

        trustDomainTools.setStyleName("fill-layout-width");

        trustDomainsHeader.add(trustDomainTools);

        trustDomainsHeader.add(new ContentDescription(""));
    }

    /**
     * @param trustDomainsHeader
     */
    private void addTrustDomainForm(VerticalPanel trustDomainsHeader) {
        this.trustDomainForm = new Form<TrustDomain>(TrustDomain.class);

        TextBoxItem domainName = new TextBoxItem("name", PicketLinkConsoleFramework.CONSTANTS.common_label_domainName());

        domainName.setRequired(true);

        this.trustDomainForm.setFields(domainName);

        trustDomainsHeader.add(this.trustDomainForm.asWidget());
    }

    public TrustDomainTable getTrustDomainTable() {
        if (this.trustDomainTable == null) {
            this.trustDomainTable = new TrustDomainTable();
        }

        return this.trustDomainTable;
    }

    private void showRestartDialog() {
        if (Window.confirm("Changes would be applied after a restart. Do you want to do it now ?")) {
            presenter.getDeploymentManager().restartIdentityProvider(identityProvider);
        }        
    }
    
    /**
     * @param identityProvider
     */
    public void setIdentityProvider(IdentityProvider identityProvider) {
        if (identityProvider == null || identityProvider.isExternal()) {
            this.trustDomainForm.setEnabled(false);
            this.addTrustedDomainBtn.setEnabled(false);
            this.removeTrustedDomainBtn.setEnabled(false);
        } else {
            this.trustDomainForm.setEnabled(true);
            this.addTrustedDomainBtn.setEnabled(true);
            this.removeTrustedDomainBtn.setEnabled(true);
        }
        
        this.identityProvider = identityProvider;
    }

}
