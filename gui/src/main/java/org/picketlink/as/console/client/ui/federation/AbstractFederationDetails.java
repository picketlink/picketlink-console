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

import org.jboss.as.console.client.shared.help.FormHelpPanel;
import org.jboss.as.console.client.shared.viewframework.builder.FormLayout;
import org.jboss.ballroom.client.widgets.forms.Form;
import org.jboss.ballroom.client.widgets.forms.FormItem;
import org.jboss.dmr.client.ModelNode;
import org.picketlink.as.console.client.shared.subsys.model.IdentityProvider;

import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 19, 2012
 */
public abstract class AbstractFederationDetails<T> {

    private Form<T> form;
    private IdentityProvider entityInstance;

    public AbstractFederationDetails() {
        this.form = new Form(getEntityClass());
        this.form.setNumColumns(2);
    }
    
    /**
     * @return
     */
    protected abstract Class<?> getEntityClass();

    public Widget asWidget() {
        VerticalPanel detailPanel = new VerticalPanel();
        detailPanel.setStyleName("fill-layout-width");

        List<FormItem<?>> formItems = getFormItems();
        
        form.setFields(formItems.toArray(new FormItem<?>[formItems.size()]));
        
        form.setEnabled(false);
        
        Widget formWidget = form.asWidget();
        
        final FormHelpPanel helpPanel = new FormHelpPanel(new FormHelpPanel.AddressCallback() {
            @Override
            public ModelNode getAddress() {
                return getHelpModelAddress();
            }

        }, form);

        detailPanel.add(formWidget);

        return new FormLayout().setHelp(helpPanel).setForm(form).build();
    }

    protected abstract ModelNode getHelpModelAddress();
    
    /**
     * @return
     */
    protected abstract List<FormItem<?>> getFormItems();
    
    /**
     * @param entityInstance the entityInstance to set
     */
    public void setEntityInstance(IdentityProvider entityInstance) {
        this.entityInstance = entityInstance;
    }
    
    /**
     * @return the form
     */
    public Form<T> getForm() {
        return this.form;
    }
}
