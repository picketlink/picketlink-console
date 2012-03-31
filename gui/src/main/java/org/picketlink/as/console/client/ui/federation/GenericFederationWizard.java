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
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.jboss.as.console.client.Console;
import org.jboss.as.console.client.shared.BeanFactory;
import org.jboss.as.console.client.shared.help.StaticHelpPanel;
import org.jboss.as.console.client.shared.properties.PropertyManagement;
import org.jboss.as.console.client.shared.properties.PropertyRecord;
import org.jboss.as.console.client.shared.subsys.security.SecurityDomainsPresenter;
import org.jboss.as.console.client.widgets.forms.FormToolStrip;
import org.jboss.ballroom.client.widgets.forms.Form;
import org.jboss.ballroom.client.widgets.forms.FormItem;
import org.jboss.ballroom.client.widgets.forms.FormValidation;
import org.jboss.ballroom.client.widgets.window.DialogueOptions;
import org.jboss.ballroom.client.widgets.window.WindowContentBuilder;
import org.jboss.dmr.client.ModelDescriptionConstants;
import org.jboss.dmr.client.ModelNode;
import org.picketlink.as.console.client.shared.subsys.model.GenericFederationEntity;
import org.picketlink.as.console.client.ui.federation.AbstractFederationDetailEditor.Wizard;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 30, 2012
 */
public class GenericFederationWizard <T extends GenericFederationEntity> implements PropertyManagement, Wizard<T> {

    private final AbstractFederationDetailEditor<T> editor;
    private final Class<T> entityClass;
    private final BeanFactory factory = GWT.create(BeanFactory.class);
    private Form<T> form;
    private final FederationPresenter presenter;
    private final List<PropertyRecord> properties = new ArrayList<PropertyRecord>();

    private final String type;
    private final String moduleAttrName;
    private final String [] customAttributeNames;

    private boolean isDialogue = false;

    public GenericFederationWizard(AbstractFederationEditor<T> editor, Class<T> cls, FederationPresenter presenter, String type,
                                       String moduleAttrName, String ... customAttributeNames) {
        this.editor = editor;
        this.entityClass = cls;
        this.presenter = presenter;
        this.type = type;
        this.moduleAttrName = moduleAttrName;
        this.customAttributeNames = customAttributeNames;
    }

    public Wizard<T> setIsDialogue(boolean b) {
        this.isDialogue = b;
        return this;
    }

    @Override
    public void clearValues() {
        form.clearValues();
    }

    public Widget asWidget() {

        VerticalPanel layout = new VerticalPanel();
        layout.setStyleName(isDialogue ? "window-content" : "fill-layout");

        // ----

        form = new Form<T>(entityClass);

        FormItem<?>[] customFields = getCustomFields();
        form.setFields(customFields);

        final Command saveCmd = new Command() {
            @Override
            public void execute() {
                FormValidation validation = form.validate();
                if (!validation.hasErrors()) {
                    if (!isDialogue) {
                        T original = form.getEditedEntity();
                        T edited = form.getUpdatedEntity();
                        original.setName(edited.getName());

//                        copyCustomFields(original, edited);

                        editor.onUpdate(form.getChangedValues());
                    } else {
                        // it's a new policy
                        T data = form.getUpdatedEntity();
                        editor.addAttribute(data);
                    }

                    editor.closeWizard();
                }
            }
        };

        // ----
        if(!isDialogue)
        {
            FormToolStrip<T> toolStrip = new FormToolStrip<T>(
                    form,
                    new FormToolStrip.FormCallback<T>() {
                        @Override
                        public void onSave(Map<String, Object> changeset) {
                            saveCmd.execute();
                        }

                        @Override
                        public void onDelete(T entity) {
                            editor.closeWizard();
                        }
                    }
            );

            toolStrip.providesDeleteOp(false);
            layout.add(toolStrip.asWidget());

            form.setEnabled(false);
        }

        // ----

        new AsyncHelpText(layout, isDialogue);

        // ----

        layout.add(form.asWidget());

        DialogueOptions options = new DialogueOptions(
                new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent event) {
                        saveCmd.execute();
                    }
                },
                new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent event) {
                        form.clearValues();
                        editor.closeWizard();
                    }
                });

        Widget container = isDialogue ? new WindowContentBuilder(layout, options).build() : layout;
        return container;
    }

    protected FormItem<?>[] getCustomFields() {
        return new FormItem[] {};
    }

    protected void copyCustomFields(T original, T edited) {
    }

    public void edit(T object) {
        form.edit(object);
    }

    // PropertyManagement methods
    @Override
    public void onCreateProperty(String reference, PropertyRecord prop) {
        // No need to implement
    }

    @Override
    public void onDeleteProperty(String reference, PropertyRecord prop) {
        properties.remove(prop);
    }

    @Override
    public void onChangeProperty(String reference, PropertyRecord prop) {
        // No need to implement
    }

    @Override
    public void launchNewPropertyDialoge(String reference) {
        PropertyRecord proto = factory.property().as();
        proto.setKey(Console.CONSTANTS.common_label_name().toLowerCase());
        proto.setValue(Console.CONSTANTS.common_label_value().toLowerCase());

        properties.add(proto);
    }

    @Override
    public void closePropertyDialoge() {
    }

    private class AsyncHelpText implements SecurityDomainsPresenter.DescriptionCallBack {
        private final VerticalPanel layout;
        private boolean isDialogue;

        private AsyncHelpText(VerticalPanel layout, boolean isDialogue) {
            this.layout = layout;
            presenter.getDescription(type, this);
            this.isDialogue = isDialogue;
        }

        @Override
        public void setDescription(ModelNode desc) {
            SafeHtmlBuilder builder = new SafeHtmlBuilder();
            if (desc.get(ModelDescriptionConstants.DESCRIPTION).isDefined()) {
                builder.appendEscaped(desc.get(ModelDescriptionConstants.DESCRIPTION).asString());
                builder.appendHtmlConstant("<p/>");
            }

            List<String> attrs = new ArrayList<String>(Arrays.asList(customAttributeNames));

            ModelNode values = desc.get(ModelDescriptionConstants.ATTRIBUTES);
            builder.appendHtmlConstant("<ul>");

            for (String s : attrs) {
                builder.appendHtmlConstant("<li><b>");
                builder.appendEscaped(s);
                builder.appendHtmlConstant("</b> - ");
                builder.appendEscaped(values.get(s, ModelDescriptionConstants.DESCRIPTION).asString());
            }

            builder.appendHtmlConstant("</ul>");
            SafeHtml safeHtml = builder.toSafeHtml();
            StaticHelpPanel helpPanel = new StaticHelpPanel(safeHtml);
            layout.insert(helpPanel.asWidget(), isDialogue ? 0:1);
        }
    }
    
    /**
     * @return the editor
     */
    public AbstractFederationDetailEditor<T> getEditor() {
        return this.editor;
    }
    
}
