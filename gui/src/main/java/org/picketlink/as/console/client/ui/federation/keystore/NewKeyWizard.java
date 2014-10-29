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
package org.picketlink.as.console.client.ui.federation.keystore;

import org.jboss.ballroom.client.widgets.forms.FormItem;
import org.jboss.ballroom.client.widgets.forms.TextBoxItem;
import org.picketlink.as.console.client.i18n.PicketLinkUIConstants;
import org.picketlink.as.console.client.shared.subsys.model.Key;
import org.picketlink.as.console.client.ui.federation.AbstractWizard;
import org.picketlink.as.console.client.ui.federation.FederationPresenter;

/**
 * @author Pedro Igor
 */
public class NewKeyWizard extends AbstractWizard<Key> {

    private final KeyEditor editor;
    private final PicketLinkUIConstants uiConstants;

    public NewKeyWizard(KeyEditor editor, FederationPresenter presenter, PicketLinkUIConstants uiConstants) {
        super(Key.class, presenter, new String[] {"key-store","key"}, "host");
        this.editor = editor;
        this.uiConstants = uiConstants;
    }

    @Override
    protected void doSaveWizard(Key newKey) {
        if (newKey != null
            && !newKey.getName().trim().isEmpty()
            && !newKey.getHost().trim().isEmpty()) {
            getPresenter().getFederationManager().onCreateKey(getPresenter().getCurrentFederation(), newKey);
            this.editor.getKeyTable().getDataProvider().getList().add(newKey);
        }
    }

    @Override
    protected FormItem<?>[] doGetCustomFields() {
        TextBoxItem name = new TextBoxItem("name", uiConstants.common_label_key());

        name.setRequired(true);

        TextBoxItem host = new TextBoxItem("host", uiConstants.common_label_key_host());

        host.setRequired(true);

        return new FormItem<?>[] {name, host};
    }

    @Override
    protected String doGetTitle() {
        return "Add Key";
    }

    @Override
    public void edit(Key object) {

    }
}
