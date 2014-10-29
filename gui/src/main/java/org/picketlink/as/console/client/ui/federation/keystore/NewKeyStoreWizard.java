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

import com.google.gwt.dom.client.Style;
import org.jboss.ballroom.client.widgets.forms.FormItem;
import org.jboss.ballroom.client.widgets.forms.PasswordBoxItem;
import org.jboss.ballroom.client.widgets.forms.TextBoxItem;
import org.picketlink.as.console.client.i18n.PicketLinkUIConstants;
import org.picketlink.as.console.client.shared.subsys.model.KeyStore;
import org.picketlink.as.console.client.ui.federation.AbstractFederationDetailEditor;
import org.picketlink.as.console.client.ui.federation.AbstractFederationWizard;
import org.picketlink.as.console.client.ui.federation.FederationPresenter;
import org.picketlink.as.console.client.ui.federation.Wizard;

/**
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 30, 2012
 */
public class NewKeyStoreWizard<T extends KeyStore> extends AbstractFederationWizard<T> implements
        Wizard<T> {

    private PicketLinkUIConstants uiConstants;
    private TextBoxItem relativeTo;

    public NewKeyStoreWizard(AbstractFederationDetailEditor<T> editor, Class<T> cls, FederationPresenter presenter,
        String type, PicketLinkUIConstants uiConstants) {
        super(editor, cls, presenter, type, "file", "relative-to", "password", "sign-key-alias", "sign-key-password");
        this.uiConstants = uiConstants;
    }

    @Override
    protected FormItem<?>[] doGetCustomFields() {
        TextBoxItem pathItem = new TextBoxItem("url", "KeyStore Path");

        pathItem.getInputElement().getStyle().setWidth(300, Style.Unit.PX);

        this.relativeTo  = new TextBoxItem("relativeTo", "Path Relative To");

        this.relativeTo.getInputElement().getStyle().setWidth(300, Style.Unit.PX);
        this.relativeTo.setRequired(false);

        PasswordBoxItem passwdItem = new PasswordBoxItem("passwd", "KeyStore Password");

        passwdItem.getInputElement().getStyle().setWidth(150, Style.Unit.PX);

        TextBoxItem signKeyAliasItem = new TextBoxItem("signKeyAlias", "Signing Key Alias");

        signKeyAliasItem.getInputElement().getStyle().setWidth(150, Style.Unit.PX);

        PasswordBoxItem signKeyPasswdItem = new PasswordBoxItem("signKeyPasswd", "Signing Key Password");

        signKeyPasswdItem.getInputElement().getStyle().setWidth(150, Style.Unit.PX);

        return new FormItem[] {pathItem, this.relativeTo, passwdItem, signKeyAliasItem, signKeyPasswdItem};
    }

    public TextBoxItem getRelativeTo() {
        return this.relativeTo;
    }
}
