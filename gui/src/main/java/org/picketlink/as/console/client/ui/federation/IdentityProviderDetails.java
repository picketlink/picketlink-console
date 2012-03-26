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

import org.jboss.as.console.client.shared.subsys.Baseadress;
import org.jboss.ballroom.client.widgets.forms.FormItem;
import org.jboss.ballroom.client.widgets.forms.TextItem;
import org.jboss.dmr.client.ModelNode;
import org.picketlink.as.console.client.shared.subsys.model.IdentityProvider;

/**
 * <p>
 * This class defines the widget to that renders a read-only form for the informations about a Identity Provider.
 * </p>
 * 
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 14, 2012
 */
public class IdentityProviderDetails extends AbstractFederationDetails<IdentityProvider> {

    public IdentityProviderDetails(FederationPresenter presenter) {
        super();
    }

    protected List<FormItem<?>> getFormItems() {
        List<FormItem<?>> items = new ArrayList<FormItem<?>>();

        items.add(new TextItem("alias", "Alias"));
        items.add(new TextItem("url", "Identity URL"));
        items.add(new TextItem("signOutgoingMessages", "Sign Outgoing Messages"));
        items.add(new TextItem("ignoreIncomingSignatures", "Ignore Incoming Signatures"));

        return items;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.picketlink.as.console.client.ui.federation.AbstractFederationDetails#getHelpModelAddress()
     */
    @Override
    protected ModelNode getHelpModelAddress() {
        ModelNode address = Baseadress.get();
        
        address.add("subsystem", "picketlink");
        address.add("federation", "*");
        address.add("identity-provider", "*");
        
        return address;
    }
    
    /* (non-Javadoc)
     * @see org.picketlink.as.console.client.ui.federation.AbstractFederationDetails#getEntityClass()
     */
    @Override
    protected Class<?> getEntityClass() {
        return IdentityProvider.class;
    }
    
    /**
     * @param identityProviders
     */
    public void updateIdentityProvider(List<IdentityProvider> identityProviders) {
        setEntityInstance(identityProviders.get(0));
        getForm().edit(identityProviders.get(0));
    }

}
