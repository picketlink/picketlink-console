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

package org.picketlink.as.console.client.ui.federation.idp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jboss.as.console.client.shared.model.DeploymentRecord;
import org.jboss.as.console.client.shared.subsys.Baseadress;
import org.jboss.ballroom.client.widgets.forms.CheckBoxItem;
import org.jboss.ballroom.client.widgets.forms.ComboBoxItem;
import org.jboss.ballroom.client.widgets.forms.FormItem;
import org.jboss.ballroom.client.widgets.forms.TextBoxItem;
import org.jboss.dmr.client.ModelNode;
import org.picketlink.as.console.client.PicketLinkConsoleFramework;
import org.picketlink.as.console.client.shared.subsys.model.IdentityProvider;
import org.picketlink.as.console.client.shared.subsys.model.ServiceProvider;
import org.picketlink.as.console.client.ui.core.AbstractFormLayout;
import org.picketlink.as.console.client.ui.federation.FederationPresenter;

import com.google.gwt.core.client.GWT;

/**
 * <p>
 * This class defines the widget to that renders a read-only form for the informations about a Identity Provider.
 * </p>
 * 
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 14, 2012
 */
public class IdentityProviderDetails extends AbstractFormLayout<IdentityProvider> {

    private FederationPresenter presenter;
    private IdentityProvider identityProvider;
    List<FormItem<?>> items;
    private ComboBoxItem aliasesItem;
    private List<ServiceProvider> serviceProviders;

    public IdentityProviderDetails(FederationPresenter presenter) {
        super();
        this.presenter = presenter;
    }

    protected List<FormItem<?>> getFormItems() {
        items = new ArrayList<FormItem<?>>();

        aliasesItem = new ComboBoxItem("alias", "Alias");

        aliasesItem.setRequired(true);

        items.add(aliasesItem);
        items.add(new TextBoxItem("url", PicketLinkConsoleFramework.CONSTANTS.common_label_identityURL(), true));
        items.add(new CheckBoxItem("signOutgoingMessages", PicketLinkConsoleFramework.CONSTANTS.common_label_signOutgoingMessages()));
        items.add(new CheckBoxItem("ignoreIncomingSignatures", PicketLinkConsoleFramework.CONSTANTS.common_label_ignoreIncomingSignatures()));

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

    /*
     * (non-Javadoc)
     * 
     * @see org.picketlink.as.console.client.ui.federation.AbstractFederationDetails#getEntityClass()
     */
    @Override
    protected Class<?> getEntityClass() {
        return IdentityProvider.class;
    }

    /**
     * @param identityProviders
     */
    public void updateIdentityProvider(IdentityProvider identityProvider) {
        updateAliasItems();
        if (identityProvider != null) {
            this.identityProvider = identityProvider;
            setEntityInstance(this.identityProvider);
            getForm().setEnabled(false);
            getForm().edit(this.identityProvider);
        } else {
            this.identityProvider = null;
            getForm().clearValues();
            getForm().setEnabled(false);
            if (this.presenter.getView().getCurrentFederation() != null) {
                IdentityProvider as = this.presenter.getBeanFactory().identityProvider().as();

                as.setUrl(getBaseUrl() + "/");
                as.setIgnoreIncomingSignatures(false);
                as.setSignOutgoingMessages(false);

                getForm().edit(as);
            } 
        }
    }

    /**
     * 
     */
    private void updateAliasItems() {
        List<DeploymentRecord> availableIdentityProviders = new ArrayList<DeploymentRecord>();
        
        if (this.serviceProviders != null && !this.serviceProviders.isEmpty()) {
            for (DeploymentRecord serviceProvider : serviceProviders) {
                for (DeploymentRecord deploymentRecord : this.presenter.getAvailableDeployments()) {
                    if (!serviceProvider.getName().equals(deploymentRecord.getName())) {
                        availableIdentityProviders.add(deploymentRecord);
                    }
                }
            }
        } else {
            availableIdentityProviders.addAll(this.presenter.getAvailableDeployments());
        }
        
        String[] aliases = new String[availableIdentityProviders.size()];
        
        for (int i = 0; i < availableIdentityProviders.size(); i++) {
            aliases[i] = availableIdentityProviders.get(i).getName();
        }

        aliasesItem.setValueMap(aliases);
        if (this.identityProvider != null) {
            aliasesItem.setValue(this.identityProvider.getAlias());            
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.picketlink.as.console.client.ui.federation.AbstractFederationDetails#doOnSave(java.util.Map)
     */
    @Override
    protected void doOnSave(Map<String, Object> changeset) {
        if (this.identityProvider == null) {
            this.presenter.onCreateIdentityProvider(this.getForm().getUpdatedEntity());
        } else {
            this.presenter.onUpdateIdentityProvider(this.identityProvider, changeset);
        }
    }

    private String getBaseUrl() {
        // extract host
        String base = GWT.getHostPageBaseURL();
        return extractHttpEndpointUrl(base);

    }

    public static String extractHttpEndpointUrl(String base) {
        String protocol = base.substring(0, base.indexOf("//") + 2);
        String remainder = base.substring(base.indexOf(protocol) + protocol.length(), base.length());

        String host = null;
        String port = null;

        int portDelim = remainder.indexOf(":");
        if (portDelim != -1) {
            host = remainder.substring(0, portDelim);
            String portRemainder = remainder.substring(portDelim + 1, remainder.length());
            if (portRemainder.indexOf("/") != -1) {
                port = portRemainder.substring(0, portRemainder.indexOf("/"));
            } else {
                port = portRemainder;
            }
        } else {
            host = remainder.substring(0, remainder.indexOf("/"));
            port = "80";
        }

        // default url
        return protocol + host + ":" + port + "/";
    }

    /**
     * @return the identityProvider
     */
    public IdentityProvider getIdentityProvider() {
        return identityProvider;
    }

    /**
     * @param result
     */
    public void setServiceProviders(List<ServiceProvider> result) {
        updateAliasItems();
        this.serviceProviders = result;
    }
}
