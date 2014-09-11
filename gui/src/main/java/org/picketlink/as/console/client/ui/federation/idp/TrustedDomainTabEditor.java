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

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import org.jboss.as.console.client.Console;
import org.jboss.as.console.client.widgets.ContentDescription;
import org.jboss.ballroom.client.widgets.tools.ToolButton;
import org.jboss.ballroom.client.widgets.tools.ToolStrip;
import org.jboss.ballroom.client.widgets.window.Feedback;
import org.picketlink.as.console.client.i18n.PicketLinkUIConstants;
import org.picketlink.as.console.client.i18n.PicketLinkUIMessages;
import org.picketlink.as.console.client.shared.subsys.model.IdentityProvider;
import org.picketlink.as.console.client.shared.subsys.model.TrustDomain;
import org.picketlink.as.console.client.ui.federation.FederationPresenter;

/**
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 31, 2012
 */
public class TrustedDomainTabEditor {

    private TrustDomainTable trustDomainTable;
    private FederationPresenter presenter;
    private IdentityProvider identityProvider;
    private ToolButton removeTrustedDomainBtn;
    private ToolButton addTrustedDomainBtn;
    private PicketLinkUIConstants uiConstants;
    private PicketLinkUIMessages uiMessages;


    public TrustedDomainTabEditor(FederationPresenter presenter,
            PicketLinkUIConstants uiConstants, PicketLinkUIMessages uiMessages) {
        this.presenter = presenter;
        this.uiConstants = uiConstants;
        this.uiMessages = uiMessages;
    }
    
    public Widget asWidget() {
        // adds the trust domain section
        VerticalPanel trustDomainsHeader = new VerticalPanel();

        trustDomainsHeader.setStyleName("fill-layout-width");

        addTrustDomainActions(trustDomainsHeader);
        addTrustDomainTable(trustDomainsHeader);

        return trustDomainsHeader;
    }

    private void addTrustDomainTable(VerticalPanel detailPanel) {
        detailPanel.add(getTrustDomainTable().asWidget());
    }

    private void addTrustDomainActions(VerticalPanel trustDomainsHeader) {
        ToolStrip trustDomainTools = new ToolStrip();
        final TrustedDomainTabEditor editor = this;

        addTrustedDomainBtn = new ToolButton(Console.CONSTANTS.common_label_add());

        addTrustedDomainBtn.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                new NewTrustDomainWizard(editor, presenter, uiConstants).launchWizard();
            }
        });

        trustDomainTools.addToolButtonRight(addTrustedDomainBtn);

        removeTrustedDomainBtn = new ToolButton(Console.CONSTANTS.common_label_delete());

        removeTrustedDomainBtn.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                final TrustDomain removedTrustedDomain = getTrustDomainTable().getSelectedTrustedDomain();
                
                Feedback.confirm(
                        Console.MESSAGES.deleteTitle(uiConstants.common_label_trustDomain()),
                        Console.MESSAGES.deleteConfirm(removedTrustedDomain.getName()),
                        new Feedback.ConfirmationHandler() {
                            @Override
                            public void onConfirmation(boolean isConfirmed) {
                                if (isConfirmed) {
                                    presenter.getFederationManager().onRemoveTrustDomain(identityProvider, removedTrustedDomain);
                                    getTrustDomainTable().getDataProvider().getList().remove(removedTrustedDomain);
                                }
                            }
                        });
            }
        });

        trustDomainTools.addToolButtonRight(removeTrustedDomainBtn);

        trustDomainTools.setStyleName("fill-layout-width");

        trustDomainsHeader.add(trustDomainTools);

        trustDomainsHeader.add(new ContentDescription(""));
    }

    public TrustDomainTable getTrustDomainTable() {
        if (this.trustDomainTable == null) {
            this.trustDomainTable = new TrustDomainTable();
        }

        return this.trustDomainTable;
    }

    /**
     * @param identityProvider
     */
    public void setIdentityProvider(IdentityProvider identityProvider) {
        if (identityProvider == null || identityProvider.isExternal()) {
            this.addTrustedDomainBtn.setEnabled(false);
            this.removeTrustedDomainBtn.setEnabled(false);
        } else {
            this.addTrustedDomainBtn.setEnabled(true);
            this.removeTrustedDomainBtn.setEnabled(true);
        }
        
        this.identityProvider = identityProvider;
    }

    public IdentityProvider getIdentityProvider() {
        return identityProvider;
    }
}
