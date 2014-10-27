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

package org.picketlink.as.console.client.ui.federation.sp;

import com.google.web.bindery.event.shared.EventBus;
import org.jboss.as.console.client.shared.subsys.security.model.SecurityDomain;
import org.jboss.ballroom.client.widgets.forms.CheckBoxItem;
import org.jboss.ballroom.client.widgets.forms.ComboBoxItem;
import org.jboss.ballroom.client.widgets.forms.FormItem;
import org.jboss.ballroom.client.widgets.forms.TextBoxItem;
import org.picketlink.as.console.client.i18n.PicketLinkUIConstants;
import org.picketlink.as.console.client.shared.subsys.model.GenericFederationEntity;
import org.picketlink.as.console.client.ui.federation.AbstractFederationDetailEditor;
import org.picketlink.as.console.client.ui.federation.AbstractFederationWizard;
import org.picketlink.as.console.client.ui.federation.FederationPresenter;
import org.picketlink.as.console.client.ui.federation.Wizard;
import org.picketlink.as.console.client.ui.federation.event.UpdateSecurityDomainEvent;
import org.picketlink.as.console.client.ui.federation.event.UpdateSecurityDomainHandler;

import java.util.List;

/**
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 30, 2012
 */
public class NewServiceProviderWizard<T extends GenericFederationEntity> extends AbstractFederationWizard<T> implements Wizard<T> {

    private final EventBus eventBus;
    private TextBoxItem nameItem;
    private TextBoxItem deploymentsItem;
    private ComboBoxItem securityDomainsItem;
    private CheckBoxItem strictPostBinding;
    private PicketLinkUIConstants uiConstants;

    public NewServiceProviderWizard(AbstractFederationDetailEditor<T> editor, Class<T> cls, FederationPresenter presenter, String type,
            PicketLinkUIConstants uiConstants, EventBus eventBus) {
        super(editor, cls, presenter, type, "security-domain", "url", "post-binding", "strict-post-binding", "error-page", "logout-page");
        this.uiConstants = uiConstants;
        this.eventBus = eventBus;
    }

    @Override
    protected FormItem<?>[] doGetCustomFields() {
        TextBoxItem nameItem = null;
        
        if (!isDialogue()) {
            this.deploymentsItem = new TextBoxItem("name", "Name");
            nameItem = this.deploymentsItem;
            nameItem.setEnabled(false);
            nameItem.setRequired(false);
        } else {
            nameItem = getAliasItem();
            nameItem.setRequired(true);
        }
        
        this.securityDomainsItem =  new ComboBoxItem("securityDomain", "Security Domain");

        eventBus.addHandler(UpdateSecurityDomainEvent.TYPE, new UpdateSecurityDomainHandler() {
            @Override
            public void onUpdateSecurityDomain(List<SecurityDomain> securityDomains) {
                updateSecurityDomains(securityDomains);
            }
        });

        updateSecurityDomains(getPresenter().getSecurityDomains());
        
        strictPostBinding = new CheckBoxItem("strictPostBinding", "Strict Post Binding");
        strictPostBinding.setEnabled(true);
        strictPostBinding.setRequired(false);
        
        TextBoxItem errorPageItem = new TextBoxItem("errorPage", "Error Page");
        errorPageItem.setEnabled(true);
        errorPageItem.setRequired(false);

        TextBoxItem logoutPageItem = new TextBoxItem("logoutPage", "LogOut Page");
        logoutPageItem.setEnabled(true);
        logoutPageItem.setRequired(false);

        FormItem<?>[] formItems = null;

        if (!isDialogue()) {
            formItems = new FormItem<?>[] { nameItem, securityDomainsItem,
                    new TextBoxItem("url", uiConstants.common_label_URL(), true),
                    new CheckBoxItem("postBinding", uiConstants.common_label_postBinding()), strictPostBinding, errorPageItem, logoutPageItem};           
        } else {
            formItems = new FormItem<?>[] { nameItem, securityDomainsItem,
                    new TextBoxItem("url", uiConstants.common_label_URL(), false)}; 
        }

        return formItems;
    }

    private TextBoxItem getAliasItem() {
        if (this.nameItem == null) {
            this.nameItem = new TextBoxItem("name", "Name");
        }

        return this.nameItem;
    }

    public ServiceProviderEditor getServiceProviderEditor() {
        return (ServiceProviderEditor) this.getEditor();
    }
    
    private void updateSecurityDomains(List<SecurityDomain> securityDomains) {
        if (securityDomains != null) {
            String[] securityDomainsNames = new String[securityDomains.size()];

            for (int i = 0; i < securityDomains.size(); i++) {
                securityDomainsNames[i] = securityDomains.get(i).getName();
            }

            securityDomainsItem.setValueMap(securityDomainsNames);

            if (!isDialogue()) {
                if (this.getServiceProviderEditor().getCurrentSelection() != null) {
                    securityDomainsItem.setValue(this.getServiceProviderEditor().getCurrentSelection().getSecurityDomain());
                }
            }
        }
    }

}
