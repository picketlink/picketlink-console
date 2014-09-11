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

import org.jboss.as.console.client.Console;
import org.jboss.ballroom.client.widgets.forms.FormItem;
import org.jboss.ballroom.client.widgets.forms.TextBoxItem;
import org.picketlink.as.console.client.shared.subsys.model.ServiceProviderHandler;
import org.picketlink.as.console.client.shared.subsys.model.ServiceProviderHandlerParameter;
import org.picketlink.as.console.client.ui.federation.AbstractWizard;
import org.picketlink.as.console.client.ui.federation.FederationPresenter;

/**
 * @author Pedro Igor
 */
public class NewServiceProviderHandlerParameterWizard extends AbstractWizard<ServiceProviderHandlerParameter> {

    private final ServiceProviderHandlersTabEditor editor;

    public NewServiceProviderHandlerParameterWizard(ServiceProviderHandlersTabEditor editor, FederationPresenter presenter) {
        super(ServiceProviderHandlerParameter.class, presenter, new String[] {"service-provider", "handler", "handler-parameter"}, "value");
        this.editor = editor;
    }

    @Override
    protected void doSaveWizard(ServiceProviderHandlerParameter newHandlerParameter) {
        ServiceProviderHandlerParameterTable handlerTable = this.editor.getHandlerParameterTable();
        ServiceProviderHandler selectedHandler = this.editor.getHandlerTable().getSelectedHandler();

        if (selectedHandler == null) {
            Console.error("Please, choose a handler first.");
        } else {
            if (newHandlerParameter != null && !newHandlerParameter.getName().trim().isEmpty()) {
                getPresenter().getFederationManager().onCreateServiceProviderHandlerParameter(this.editor.getServiceProvider()
                    .getServiceProvider(), selectedHandler, newHandlerParameter);
                handlerTable.getDataProvider().getList().add(newHandlerParameter);
            }
        }
    }

    @Override
    protected FormItem<?>[] doGetCustomFields() {
        TextBoxItem parameterName = new TextBoxItem("name", "Name");
        parameterName.setRequired(true);

        TextBoxItem parameterValue = new TextBoxItem("value", "Value");
        parameterValue.setRequired(true);

        return new FormItem<?>[] {parameterName, parameterValue};
    }

    @Override
    protected String doGetTitle() {
        return "Add SAML Handler Parameter";
    }

    @Override
    public void edit(ServiceProviderHandlerParameter object) {

    }
}
