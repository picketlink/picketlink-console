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
public class NewIdentityProviderWizard<T extends GenericFederationEntity> extends AbstractFederationWizard<T> implements
        Wizard<T> {

    private final EventBus eventBus;
    private TextBoxItem editNameItem;
    private CheckBoxItem externalIDP;
    private CheckBoxItem strictPostBinding;
    private ComboBoxItem securityDomainsItem;
    private PicketLinkUIConstants uiConstants;
    private TextBoxItem url;

    public NewIdentityProviderWizard(AbstractFederationDetailEditor<T> editor, Class<T> cls, FederationPresenter presenter,
            String type, PicketLinkUIConstants uiConstants, EventBus eventBus) {
        super(editor, cls, presenter, type, "external", "security-domain", "url", "strict-post-binding");
        this.uiConstants = uiConstants;
        this.eventBus = eventBus;
    }

    @Override
    protected FormItem<?>[] doGetCustomFields() {
        FormItem<?>[] formItems = null;

        securityDomainsItem =  new ComboBoxItem("securityDomain", "Security Domain");

        eventBus.addHandler(UpdateSecurityDomainEvent.TYPE, new UpdateSecurityDomainHandler() {
            @Override
            public void onUpdateSecurityDomain(List<SecurityDomain> securityDomains) {
                updateSecurityDomains(securityDomains);
            }
        });

        updateSecurityDomains(getPresenter().getSecurityDomains());

        strictPostBinding = new CheckBoxItem("strictPostBinding", "Strict Post Binding");
        strictPostBinding.setEnabled(true);

        this.url = new TextBoxItem("url", uiConstants.common_label_URL(), false);

        if (isDialogue()) {
            final TextBoxItem nameItem = new TextBoxItem("name", this.uiConstants.common_label_name());

            nameItem.setRequired(true);

            externalIDP = new CheckBoxItem("external", "Is external?") {
                @Override
                protected void doValueChange() {
                    if (getValue() != null && getValue()) {
                        nameItem.setEnabled(false);
                        nameItem.setRequired(false);
                        securityDomainsItem.setEnabled(false);
                        securityDomainsItem.setRequired(false);
                        strictPostBinding.setEnabled(false);
                        strictPostBinding.setRequired(false);
                        url.setRequired(true);
                    } else {
                        nameItem.setEnabled(true);
                        nameItem.setRequired(true);
                        securityDomainsItem.setEnabled(true);
                        securityDomainsItem.setRequired(true);
                        strictPostBinding.setEnabled(true);
                        strictPostBinding.setRequired(true);
                        url.setRequired(false);
                    }
                }
            };

            formItems = new FormItem<?>[] { externalIDP, nameItem, securityDomainsItem, url};
        } else {
            this.editNameItem = new TextBoxItem("name", this.uiConstants.common_label_name());
            this.editNameItem.setEnabled(false);
            formItems = new FormItem<?>[] {this.editNameItem, this.securityDomainsItem, this.url, this.strictPostBinding};
        }

        return formItems;
    }

    private void updateSecurityDomains(List<SecurityDomain> securityDomains) {
        if (securityDomains != null) {
            String[] names = new String[securityDomains.size()];

            for (int i = 0; i < securityDomains.size(); i++) {
                names[i] = securityDomains.get(i).getName();
            }

            securityDomainsItem.setValueMap(names);

            if (!isDialogue()) {
                if (getEditor().getCurrentSelection() != null) {
                    securityDomainsItem.setValue(this.getEditor().getCurrentSelection().getSecurityDomain());
                }
            }
        }
    }
}
