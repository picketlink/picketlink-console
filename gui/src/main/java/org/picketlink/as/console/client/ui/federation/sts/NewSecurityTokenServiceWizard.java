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

package org.picketlink.as.console.client.ui.federation.sts;

import org.jboss.ballroom.client.widgets.forms.ComboBoxItem;
import org.jboss.ballroom.client.widgets.forms.FormItem;
import org.jboss.ballroom.client.widgets.forms.TextBoxItem;
import org.picketlink.as.console.client.PicketLinkConsoleFramework;
import org.picketlink.as.console.client.shared.subsys.model.GenericFederationEntity;
import org.picketlink.as.console.client.ui.federation.AbstractFederationDetailEditor;
import org.picketlink.as.console.client.ui.federation.AbstractFederationWizard;
import org.picketlink.as.console.client.ui.federation.FederationPresenter;
import org.picketlink.as.console.client.ui.federation.Wizard;

/**
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 30, 2012
 */
public class NewSecurityTokenServiceWizard<T extends GenericFederationEntity> extends AbstractFederationWizard<T> implements Wizard<T> {

    public NewSecurityTokenServiceWizard(AbstractFederationDetailEditor<T> editor, Class<T> cls, FederationPresenter presenter, String type) {
        super(editor, cls, presenter, type, "alias", "endpoint", "security-domain");
    }

    @Override
    protected FormItem<?>[] doGetCustomFields() {
        TextBoxItem aliasItem = new TextBoxItem("name", "Alias");
        
        if (!isDialogue()) {
            aliasItem.setEnabled(false);
            aliasItem.setRequired(false);
        } else {
            aliasItem.setEnabled(true);
            aliasItem.setRequired(true);
        }
        
        ComboBoxItem securityDomainsItem =  new ComboBoxItem("securityDomain", "Security Domain");
        
        if (this.getPresenter().getSecurityDomains() != null) {
            String[] securityDomains = new String[this.getPresenter().getSecurityDomains().size()];

            for (int i = 0; i < this.getPresenter().getSecurityDomains().size(); i++) {
                securityDomains[i] = this.getPresenter().getSecurityDomains().get(i).getName();
            }
            
            securityDomainsItem.setValueMap(securityDomains);
        }
        
        FormItem<?>[] formItems = new FormItem<?>[] { aliasItem, securityDomainsItem,
                new TextBoxItem("endpoint", PicketLinkConsoleFramework.CONSTANTS.common_label_endpoint(), true)};

        return formItems;
    }

    public SecurityTokenServiceEditor getSecurityTokenServiceEditor() {
        return (SecurityTokenServiceEditor) this.getEditor();
    }

}
