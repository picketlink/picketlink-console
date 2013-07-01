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
import org.jboss.ballroom.client.widgets.ContentHeaderLabel;
import org.jboss.ballroom.client.widgets.forms.Form;
import org.jboss.ballroom.client.widgets.forms.TextBoxItem;
import org.jboss.ballroom.client.widgets.tools.ToolButton;
import org.jboss.ballroom.client.widgets.tools.ToolStrip;
import org.jboss.ballroom.client.widgets.window.Feedback;
import org.picketlink.as.console.client.i18n.PicketLinkUIConstants;
import org.picketlink.as.console.client.i18n.PicketLinkUIMessages;
import org.picketlink.as.console.client.shared.subsys.model.IdentityProvider;
import org.picketlink.as.console.client.shared.subsys.model.IdentityProviderHandler;
import org.picketlink.as.console.client.shared.subsys.model.IdentityProviderHandlerParameter;
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
public class IdentityProviderHandlersTabEditor {

    private Form<IdentityProviderHandler> handlerForm;
    private IdentityProviderHandlerTable handlerTable;
    private Form<IdentityProviderHandlerParameter> handlerParameterForm;
    private IdentityProviderHandlerParameterTable handlerParameterTable;
    private FederationPresenter presenter;
    private IdentityProvider identityProvider;
    private ToolButton removeHandlerBtn;
    private ToolButton addHandlerBtn;
    private ToolButton removeHandlerParameterBtn;
    private ToolButton addHandlerParameterBtn;
    private PicketLinkUIConstants uiConstants;
    private PicketLinkUIMessages uiMessages;

    public IdentityProviderHandlersTabEditor(FederationPresenter presenter,
            final PicketLinkUIConstants uiConstants, final PicketLinkUIMessages uiMessages) {
        this.presenter = presenter;
        this.uiConstants = uiConstants;
        this.uiMessages = uiMessages;
    }
    
    public Widget asWidget() {
        // adds the trust domain section
        VerticalPanel trustDomainsHeader = new VerticalPanel();

        trustDomainsHeader.setStyleName("fill-layout-width");

        addHandlerForm(trustDomainsHeader);
        addHandlerActions(trustDomainsHeader);
        addHandlerTable(trustDomainsHeader);
        
        trustDomainsHeader.add(new ContentHeaderLabel("Handler Parameters"));
        
        addHandlerParameterForm(trustDomainsHeader);
        addHandlerParameterActions(trustDomainsHeader);
        trustDomainsHeader.add(getHandlerParameterTable().asWidget());

        return trustDomainsHeader;
    }

    /**
     * @param detailPanel
     */
    private void addHandlerTable(VerticalPanel detailPanel) {
        detailPanel.add(getHandlerTable().asWidget());
    }

    private void addHandlerActions(VerticalPanel trustDomainsHeader) {
        ToolStrip trustDomainTools = new ToolStrip();

        addHandlerBtn = new ToolButton(Console.CONSTANTS.common_label_add());

        addHandlerBtn.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                if (identityProvider == null) {
                    Window.alert(uiMessages.identityProviderNotConfigured());
                } else {
                    IdentityProviderHandler newTrustedDomain = handlerForm.getUpdatedEntity();
                    
                    if (newTrustedDomain != null
                            && !newTrustedDomain.getClassName().trim().isEmpty()) {
                        presenter.getFederationManager().onCreateIdentityProviderHandler(identityProvider, newTrustedDomain);
                        getHandlerTable().getDataProvider().getList().add(newTrustedDomain);
                    } else {
                        Window.alert(uiMessages.invalidTrustedDomain());
                    }
                    
                    handlerForm.clearValues();
                }
            }
        });

        trustDomainTools.addToolButtonRight(addHandlerBtn);

        removeHandlerBtn = new ToolButton(Console.CONSTANTS.common_label_delete());

        removeHandlerBtn.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                final IdentityProviderHandler removedTrustedDomain = getHandlerTable().getSelectedHandler();
                
                Feedback.confirm(
                        Console.MESSAGES.deleteTitle(uiConstants.common_label_trustDomain()),
                        Console.MESSAGES.deleteConfirm(removedTrustedDomain.getClassName()),
                        new Feedback.ConfirmationHandler() {
                            @Override
                            public void onConfirmation(boolean isConfirmed) {
                                if (isConfirmed) {
                                    presenter.getFederationManager().onRemoveIdentityProviderHandler(identityProvider, removedTrustedDomain);
                                    getHandlerTable().getDataProvider().getList().remove(removedTrustedDomain);
                                    getHandlerParameterTable().getDataProvider().getList().clear();
                                }
                            }
                        });
                
                handlerForm.clearValues();
            }
        });

        trustDomainTools.addToolButtonRight(removeHandlerBtn);

        trustDomainTools.setStyleName("fill-layout-width");

        trustDomainsHeader.add(trustDomainTools);

        trustDomainsHeader.add(new ContentDescription(""));
    }

    private void addHandlerParameterActions(VerticalPanel trustDomainsHeader) {
        ToolStrip trustDomainTools = new ToolStrip();

        addHandlerParameterBtn = new ToolButton(Console.CONSTANTS.common_label_add());

        addHandlerParameterBtn.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                if (getHandlerTable().getSelectedHandler() == null) {
                    Window.alert("Please, selecte a handler first.");
                } else {
                    IdentityProviderHandlerParameter newHandlerParameter = handlerParameterForm.getUpdatedEntity();
                    
                    if (newHandlerParameter != null
                            && !newHandlerParameter.getName().trim().isEmpty()) {
                        presenter.getFederationManager().onCreateIdentityProviderHandlerParameter(identityProvider, getHandlerTable().getSelectedHandler(), newHandlerParameter);
                        getHandlerParameterTable().getDataProvider().getList().add(newHandlerParameter);
                    } else {
                        Window.alert("Invalid Handler Parameter");
                    }
                    
                    handlerParameterForm.clearValues();
                }
            }
        });

        trustDomainTools.addToolButtonRight(addHandlerParameterBtn);

        removeHandlerParameterBtn = new ToolButton(Console.CONSTANTS.common_label_delete());

        removeHandlerParameterBtn.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                final IdentityProviderHandlerParameter removedHandlerParameter = getHandlerParameterTable().getSelectedHandlerParameter();
                
                Feedback.confirm(
                        Console.MESSAGES.deleteTitle("Handler Parameter"),
                        Console.MESSAGES.deleteConfirm(removedHandlerParameter.getName()),
                        new Feedback.ConfirmationHandler() {
                            @Override
                            public void onConfirmation(boolean isConfirmed) {
                                if (isConfirmed) {
                                    presenter.getFederationManager().onRemoveIdentityProviderHandlerParameter(identityProvider, getHandlerTable().getSelectedHandler(), removedHandlerParameter);
                                    getHandlerParameterTable().getDataProvider().getList().remove(removedHandlerParameter);
                                }
                            }
                        });
                
                handlerParameterForm.clearValues();
            }
        });

        trustDomainTools.addToolButtonRight(removeHandlerParameterBtn);

        trustDomainTools.setStyleName("fill-layout-width");

        trustDomainsHeader.add(trustDomainTools);

        trustDomainsHeader.add(new ContentDescription(""));
    }

    private void addHandlerForm(VerticalPanel trustDomainsHeader) {
        this.handlerForm = new Form<IdentityProviderHandler>(IdentityProviderHandler.class);

        TextBoxItem domainName = new TextBoxItem("className", "Class Name");

        domainName.setRequired(true);

        this.handlerForm.setFields(domainName);

        trustDomainsHeader.add(this.handlerForm.asWidget());
    }

    private void addHandlerParameterForm(VerticalPanel trustDomainsHeader) {
        this.handlerParameterForm = new Form<IdentityProviderHandlerParameter>(IdentityProviderHandlerParameter.class);

        TextBoxItem handlerName = new TextBoxItem("name", "Name");
        handlerName.setRequired(true);

        TextBoxItem handlerValue = new TextBoxItem("value", "Value");
        handlerValue.setRequired(true);

        this.handlerParameterForm.setFields(handlerName, handlerValue);

        trustDomainsHeader.add(this.handlerParameterForm.asWidget());
    }

    public IdentityProviderHandlerTable getHandlerTable() {
        if (this.handlerTable == null) {
            this.handlerTable = new IdentityProviderHandlerTable();
            this.handlerTable.setParametersTable(this.getHandlerParameterTable());
            this.handlerTable.setPresenter(this.presenter);
        }

        return this.handlerTable;
    }

    public IdentityProviderHandlerParameterTable getHandlerParameterTable() {
        if (this.handlerParameterTable == null) {
            this.handlerParameterTable = new IdentityProviderHandlerParameterTable();
        }

        return this.handlerParameterTable;
    }

    private void showRestartDialog() {
        if (Window.confirm("Changes would be applied after a restart. Do you want to do it now ?")) {
            presenter.getDeploymentManager().restartIdentityProvider(identityProvider);
        }        
    }
    
    public void setIdentityProvider(IdentityProvider identityProvider) {
        if (identityProvider == null || identityProvider.isExternal()) {
            this.handlerForm.setEnabled(false);
            this.addHandlerBtn.setEnabled(false);
            this.removeHandlerBtn.setEnabled(false);
        } else {
            this.handlerForm.setEnabled(true);
            this.addHandlerBtn.setEnabled(true);
            this.removeHandlerBtn.setEnabled(true);
        }
        
        this.identityProvider = identityProvider;
    }

}
