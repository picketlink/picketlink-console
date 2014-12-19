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

import org.jboss.ballroom.client.widgets.forms.ComboBoxItem;
import org.jboss.ballroom.client.widgets.forms.FormItem;
import org.jboss.ballroom.client.widgets.forms.TextBoxItem;
import org.picketlink.as.console.client.shared.subsys.model.HandlerTypeEnum;
import org.picketlink.as.console.client.shared.subsys.model.ServiceProviderHandler;
import org.picketlink.as.console.client.ui.federation.AbstractWizard;
import org.picketlink.as.console.client.ui.federation.FederationPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pedro Igor
 */
public class NewServiceProviderHandlerWizard extends AbstractWizard<ServiceProviderHandler> {

    private final ServiceProviderHandlersTabEditor editor;
    private TextBoxItem className;
    private ComboBoxItem code;

    public NewServiceProviderHandlerWizard(ServiceProviderHandlersTabEditor editor, FederationPresenter presenter) {
        super(ServiceProviderHandler.class, presenter, new String[] {"service-provider", "handler"}, "class-name");
        this.editor = editor;
    }

    @Override
    protected void doSaveWizard(ServiceProviderHandler newHandler) {
        String code = newHandler.getCode();
        String className = newHandler.getClassName();

        if (!code.trim().isEmpty() || !className.trim().isEmpty()) {
            if (HandlerTypeEnum.find(code) == null) {
                newHandler.setCode(null);
            } else {
                newHandler.setClassName(null);
            }

            getPresenter().getFederationManager().onCreateServiceProviderHandler(this.editor.getServiceProvider()
                    .getServiceProvider(), newHandler);

            this.editor.getHandlerTable().getDataProvider().getList().add(newHandler);
        }
    }

    @Override
    protected FormItem<?>[] doGetCustomFields() {
        TextBoxItem name = new TextBoxItem("name", "Name");

        name.setRequired(true);

        this.className = new TextBoxItem("className", "Class Name") {
            @Override
            public void setUndefined(boolean undefined) {
                code.setEnabled(undefined);
                code.setRequired(undefined);

                if (!undefined) {
                    code.setValue("");
                }
            }
        };

        className.setRequired(true);

        this.code = new ComboBoxItem("code", "Code") {
            @Override
            public void setUndefined(boolean undefined) {
                className.setEnabled(undefined);
                className.setRequired(undefined);

                if (!undefined) {
                    className.setValue("");
                }
            }
        };

        List<String> handlerTypes = new ArrayList<>();

        for (HandlerTypeEnum handlerType : HandlerTypeEnum.values()) {
            handlerTypes.add(handlerType.getAlias());
        }

        code.setValueMap(handlerTypes);

        return new FormItem<?>[] {name, code, className};
    }

    @Override
    protected String doGetTitle() {
        return "Add SAML Handler";
    }

    @Override
    public void edit(ServiceProviderHandler object) {

    }
}
