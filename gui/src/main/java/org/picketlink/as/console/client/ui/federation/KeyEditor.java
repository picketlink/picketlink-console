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

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import org.jboss.as.console.client.Console;
import org.jboss.as.console.client.layout.FormLayout;
import org.jboss.as.console.client.widgets.ContentDescription;
import org.jboss.ballroom.client.widgets.forms.Form;
import org.jboss.ballroom.client.widgets.forms.TextBoxItem;
import org.jboss.ballroom.client.widgets.tools.ToolButton;
import org.jboss.ballroom.client.widgets.tools.ToolStrip;
import org.jboss.ballroom.client.widgets.window.Feedback;
import org.picketlink.as.console.client.i18n.PicketLinkUIConstants;
import org.picketlink.as.console.client.shared.subsys.model.Key;

/**
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 31, 2012
 */
public class KeyEditor {

    private Form<Key> keyForm;
    private KeyTable keyTable;
    private FederationPresenter presenter;
    private ToolButton removeBtn;
    private ToolButton addBtn;
    private PicketLinkUIConstants uiConstants;
    private VerticalPanel keyLayout;

    public KeyEditor(FederationPresenter presenter, PicketLinkUIConstants uiConstants) {
        this.presenter = presenter;
        this.uiConstants = uiConstants;
    }

    public Widget asWidget() {
        // adds the trust domain section
        this.keyLayout = new VerticalPanel();

        this.keyLayout.setStyleName("fill-layout-width");

        addForm(this.keyLayout);
        addActions(this.keyLayout);
        addTable(this.keyLayout);

        return keyLayout;
    }

    private void addTable(VerticalPanel detailPanel) {
        detailPanel.add(getKeyTable().asWidget());
    }

    private void addActions(VerticalPanel header) {
        ToolStrip tools = new ToolStrip();

        addBtn = new ToolButton(Console.CONSTANTS.common_label_add());

        addBtn.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                Key newKey = keyForm.getUpdatedEntity();

                if (newKey != null && !newKey.getName().trim().isEmpty()) {
                    presenter.getFederationManager().onCreateKey(presenter.getCurrentFederation(), newKey);
                    getKeyTable().getDataProvider().getList().add(newKey);
                }

                keyForm.clearValues();
            }
        });

        tools.addToolButtonRight(addBtn);

        removeBtn = new ToolButton(Console.CONSTANTS.common_label_delete());

        removeBtn.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                final Key removedKey = getKeyTable().getSelectedTrustedDomain();

                Feedback.confirm(
                    Console.MESSAGES.deleteTitle(uiConstants.common_label_trustDomain()),
                    Console.MESSAGES.deleteConfirm(removedKey.getName()),
                    new Feedback.ConfirmationHandler() {
                        @Override
                        public void onConfirmation(boolean isConfirmed) {
                            if (isConfirmed) {
                                presenter.getFederationManager().onRemoveKey(presenter.getCurrentFederation(), removedKey);
                                getKeyTable().getDataProvider().getList().remove(removedKey);
                            }
                        }
                    });

                keyForm.clearValues();
            }
        });

        tools.addToolButtonRight(removeBtn);

        tools.setStyleName("fill-layout-width");

        header.add(tools);

        header.add(new ContentDescription(""));
    }

    /**
     * @param trustDomainsHeader
     */
    private void addForm(VerticalPanel trustDomainsHeader) {
        this.keyForm = new Form<Key>(Key.class);

        TextBoxItem name = new TextBoxItem("name", uiConstants.common_label_key_alias());
        name.setRequired(true);

        TextBoxItem host = new TextBoxItem("host", uiConstants.common_label_key_host());
        host.setRequired(false);

        this.keyForm.setFields(name, host);

        trustDomainsHeader.add(this.keyForm.asWidget());
    }

    public KeyTable getKeyTable() {
        if (this.keyTable == null) {
            this.keyTable = new KeyTable();
        }

        return this.keyTable;
    }

    public void setEnabled(boolean enabled) {
        this.keyLayout.setVisible(enabled);
    }
}
