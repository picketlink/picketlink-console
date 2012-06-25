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

import java.util.Map;

import org.jboss.as.console.client.widgets.forms.FormToolStrip;
import org.jboss.ballroom.client.widgets.forms.EditListener;
import org.jboss.ballroom.client.widgets.forms.Form;
import org.jboss.ballroom.client.widgets.forms.FormItem;
import org.jboss.ballroom.client.widgets.forms.FormValidation;
import org.jboss.ballroom.client.widgets.window.DialogueOptions;
import org.jboss.ballroom.client.widgets.window.WindowContentBuilder;
import org.picketlink.as.console.client.shared.subsys.model.GenericFederationEntity;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 30, 2012
 */
public abstract class AbstractFederationWizard<T extends GenericFederationEntity> implements Wizard<T> {

    private final AbstractFederationDetailEditor<T> editor;
    private final Class<T> entityClass;
    private Form<T> form;
    private final FederationPresenter presenter;

    private final String type;
    private final String[] attributesNames;

    private boolean isDialogue = false;

    public AbstractFederationWizard(AbstractFederationDetailEditor<T> editor, Class<T> cls, FederationPresenter presenter,
            String type, String... attributeNames) {
        this.editor = editor;
        this.entityClass = cls;
        this.presenter = presenter;
        this.type = type;
        this.attributesNames = attributeNames;
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

        form.setFields(doGetCustomFields());
        
        final Command saveCmd = new Command() {
            @Override
            public void execute() {
                FormValidation validation = form.validate();
                if (!validation.hasErrors()) {
                    if (!isDialogue) {
                        T original = form.getEditedEntity();
                        T edited = form.getUpdatedEntity();
                        
                        original.setName(edited.getName());

                        editor.doUpdate(edited, form.getChangedValues());
                        form.edit(edited);
                    } else {
                        T data = form.getUpdatedEntity();
                        editor.doSaveWizard(data);
                    }
                    presenter.loadDeployments();
                    editor.closeWizard();
                }
            }
        };

        // ----
        if (!isDialogue) {
            FormToolStrip<T> toolStrip = new FormToolStrip<T>(form, new FormToolStrip.FormCallback<T>() {
                @Override
                public void onSave(Map<String, Object> changeset) {
                    saveCmd.execute();
                }

                @Override
                public void onDelete(T entity) {
                    editor.closeWizard();
                    presenter.loadDeployments();
                }
            });

            toolStrip.providesDeleteOp(false);
            layout.add(toolStrip.asWidget());

            form.setEnabled(false);
            form.setNumColumns(2);
        }

        // ----

        new AsyncHelpText(this.type, this.attributesNames, this.presenter, layout, isDialogue);

        // ----

        layout.add(form.asWidget());

        DialogueOptions options = new DialogueOptions(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                saveCmd.execute();
            }
        }, new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                form.clearValues();
                editor.closeWizard();
            }
        });
        
        return isDialogue ? new WindowContentBuilder(layout, options).build() : layout;
    }

    protected FormItem<?>[] doGetCustomFields() {
        return new FormItem[] {};
    }

    /* (non-Javadoc)
     * @see org.picketlink.as.console.client.ui.federation.Wizard#edit(java.lang.Object)
     */
    public void edit(T object) {
        form.edit(object);
    }

    /**
     * @return the editor
     */
    public AbstractFederationDetailEditor<T> getEditor() {
        return this.editor;
    }

    /**
     * @return the isDialogue
     */
    public boolean isDialogue() {
        return isDialogue;
    }
    
    protected FederationPresenter getPresenter() {
        return presenter;
    }
}
