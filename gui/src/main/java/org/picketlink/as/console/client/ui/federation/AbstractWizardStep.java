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

import org.jboss.as.console.client.Console;
import org.jboss.as.console.client.shared.help.FormHelpPanel;
import org.jboss.ballroom.client.widgets.forms.Form;
import org.jboss.ballroom.client.widgets.forms.FormItem;
import org.jboss.ballroom.client.widgets.forms.FormValidation;
import org.jboss.ballroom.client.widgets.window.DialogueOptions;
import org.jboss.ballroom.client.widgets.window.WindowContentBuilder;
import org.jboss.dmr.client.ModelNode;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 23, 2012
 */
public abstract class AbstractWizardStep<T> {

    private WizardView wizard;
    private Class entityClass;
    private String title;
    private Form<T> form;
    private List<FormItem> formItems;

    public AbstractWizardStep(String title, WizardView wizard, Class entityClass) {
        this.wizard = wizard;
        this.entityClass = entityClass;
        this.title = title;
    }

    public Widget asWidget() {
        VerticalPanel layout = new VerticalPanel();

        layout.setStyleName("window-content");
        layout.add(new HTML("<h3>" + this.title + "</h3>"));

        form = new Form<T>(this.entityClass);

        doAddFormItems(form);
        
        form.setFields(this.formItems.toArray(new FormItem[this.formItems.size()]));
        
        final FormHelpPanel helpPanel = new FormHelpPanel(
                new FormHelpPanel.AddressCallback() {
                    @Override
                    public ModelNode getAddress() {
                        return doGetHelpAddress();
                    }
                }, form
        );
        
        layout.add(helpPanel.asWidget());

        layout.add(form.asWidget());

        ClickHandler submitHandler = new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                FormValidation validation = form.validate();
                if(!validation.hasErrors())
                {
                    wizard.onSave(form.getUpdatedEntity());
                    wizard.onClose();
                }
            }
        };

        ClickHandler cancelHandler = new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                wizard.onClose();
            }
        };

        DialogueOptions options = new DialogueOptions(
                Console.CONSTANTS.common_label_save(),submitHandler,
                Console.CONSTANTS.common_label_cancel(),cancelHandler
        );

        return new WindowContentBuilder(layout, options).build();
    }

    /**
     * @return
     */
    protected abstract void doAddFormItems(Form<T> form);
    
    protected void addFormItem(FormItem formItem) {
        if (this.formItems == null) {
            this.formItems = new ArrayList<FormItem>();
        }
        
        this.formItems.add(formItem);
    }
    
    /**
     * @return
     */
    protected ModelNode doGetHelpAddress() {
        return null;
    }
    
    /**
     * @return the wizard
     */
    public WizardView getWizard() {
        return this.wizard;
    }

}
