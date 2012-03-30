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

import org.jboss.as.console.client.Console;
import org.jboss.as.console.client.shared.subsys.Baseadress;
import org.jboss.ballroom.client.widgets.forms.Form;
import org.jboss.ballroom.client.widgets.forms.TextBoxItem;
import org.jboss.dmr.client.ModelNode;
import org.picketlink.as.console.client.PicketLinkConsoleFramework;
import org.picketlink.as.console.client.shared.subsys.model.Federation;
import org.picketlink.as.console.client.ui.core.AbstractWizardStep;

/**
 * <p>
 * The first step during the wizard to create a new federation instance.
 * </p>
 * 
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 19, 2012
 */
public class NewFederationWizardStep1 extends AbstractWizardStep<Federation> {

    public NewFederationWizardStep1(NewFederationWizard wizard) {
        super(Console.MESSAGES.createTitle(PicketLinkConsoleFramework.CONSTANTS.common_label_federation()), wizard, Federation.class);
    }

    /* (non-Javadoc)
     * @see org.picketlink.as.console.client.ui.federation.AbstractWizardStep#doAddFormItems(org.jboss.ballroom.client.widgets.forms.Form)
     */
    @Override
    protected void doAddFormItems(Form<Federation> form) {
        addFormItem(new TextBoxItem("alias", PicketLinkConsoleFramework.CONSTANTS.common_label_alias()));
    }
    
    /* (non-Javadoc)
     * @see org.picketlink.as.console.client.ui.federation.AbstractWizardStep#doGetHelpAddress()
     */
    protected ModelNode doGetHelpAddress() {
        ModelNode address = Baseadress.get();
        address.add("subsystem", "picketlink");
        address.add("federation", "*");
        return address;
    }


}