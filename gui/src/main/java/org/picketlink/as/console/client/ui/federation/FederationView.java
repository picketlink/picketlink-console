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

import java.util.List;

import org.jboss.as.console.client.core.SuspendableViewImpl;
import org.jboss.as.console.client.widgets.tabs.DefaultTabLayoutPanel;
import org.picketlink.as.console.client.shared.subsys.model.Federation;
import org.picketlink.as.console.client.shared.subsys.model.IdentityProvider;
import org.picketlink.as.console.client.shared.subsys.model.ServiceProvider;
import org.picketlink.as.console.client.shared.subsys.model.TrustDomain;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.Widget;

/**
 * <p>
 * The view for the PicketLink -> Federation menu item.
 * </p>
 * 
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 14, 2012
 */
public class FederationView extends SuspendableViewImpl implements FederationPresenter.MyView {

    private FederationPresenter presenter;
    private FederationEditor federationEditor;
    
    /* (non-Javadoc)
     * @see org.jboss.as.console.client.core.SuspendableView#createWidget()
     */
    @Override
    public Widget createWidget() {
        DefaultTabLayoutPanel tabLayoutpanel = new DefaultTabLayoutPanel(40, Style.Unit.PX);
        
        tabLayoutpanel.addStyleName("default-tabpanel");
        tabLayoutpanel.add(getFederationEditor().asWidget(), "PicketLink Federation", true);
        tabLayoutpanel.selectTab(0);

        return tabLayoutpanel;
    }
    
    /* (non-Javadoc)
     * @see org.picketlink.as.console.client.ui.federation.FederationPresenter.MyView#getCurrentFederation()
     */
    @Override
    public Federation getCurrentFederation() {
        return this.getFederationEditor().getCurrentFederation();
    }

    /* (non-Javadoc)
     * @see org.picketlink.as.console.client.ui.federation.FederationPresenter.MyView#getIdentityProvider()
     */
    @Override
    public IdentityProvider getIdentityProvider() {
        return this.getFederationEditor().getIdentityProvider();
    }
    
    /* (non-Javadoc)
     * @see org.picketlink.as.console.client.ui.federation.FederationPresenter.MyView#updateFederations(java.util.List)
     */
    @Override
    public void updateFederations(List<Federation> federations) {
        getFederationEditor().updateFederations(federations);
    }

    /* (non-Javadoc)
     * @see org.picketlink.as.console.client.ui.federation.FederationPresenter.MyView#updateFederations(java.util.List)
     */
    @Override
    public void updateIdentityProviders(List<IdentityProvider> federations) {
        getFederationEditor().updateIdentityProviders(federations);
    }
    
    /* (non-Javadoc)
     * @see org.picketlink.as.console.client.ui.federation.FederationPresenter.MyView#updateServiceProviders(java.util.List)
     */
    @Override
    public void updateServiceProviders(List<ServiceProvider> result) {
        getFederationEditor().updateServiceProviders(result);
    }
    
    /* (non-Javadoc)
     * @see org.picketlink.as.console.client.ui.federation.FederationPresenter.MyView#updateTrustDomains(java.util.List)
     */
    @Override
    public void updateTrustDomains(List<TrustDomain> result) {
        getFederationEditor().updateTrustDomains(result);
    }
    
    /* (non-Javadoc)
     * @see org.picketlink.as.console.client.ui.federation.FederationPresenter.MyView#setPresenter(org.picketlink.as.console.client.ui.federation.FederationPresenter)
     */
    @Override
    public void setPresenter(FederationPresenter presenter) {
        this.presenter = presenter;
    }

    /**
     * @return
     */
    private FederationEditor getFederationEditor() {
        if (this.federationEditor == null) {
            this.federationEditor = new FederationEditor(presenter);
        }

        return this.federationEditor;
    }

}
