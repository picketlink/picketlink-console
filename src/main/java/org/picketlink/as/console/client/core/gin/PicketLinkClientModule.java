/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This copyrighted material is made available to anyone wishing to use,
 * modify, copy, or redistribute it subject to the terms and conditions
 * of the GNU Lesser General Public License, v. 2.1.
 * This program is distributed in the hope that it will be useful, but WITHOUT A
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License,
 * v.2.1 along with this distribution; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA  02110-1301, USA.
 */

package org.picketlink.as.console.client.core.gin;

import org.jboss.as.console.spi.GinExtensionBinding;
import org.picketlink.as.console.client.shared.subsys.model.FederationStore;
import org.picketlink.as.console.client.shared.subsys.model.FederationStoreImpl;
import org.picketlink.as.console.client.ui.federation.DeploymentManager;
import org.picketlink.as.console.client.ui.federation.FederationManager;
import org.picketlink.as.console.client.ui.federation.FederationPresenter;
import org.picketlink.as.console.client.ui.federation.NewFederationView;

import com.google.inject.Singleton;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;


/**
 * PicketLink configuration bindings.
 * 
 * @author Pedro Silva
 */
@GinExtensionBinding
public class PicketLinkClientModule extends AbstractPresenterModule {

    /* (non-Javadoc)
     * @see com.google.gwt.inject.client.AbstractGinModule#configure()
     */
    protected void configure() {
        bindFederation();
    }

    /**
     * Binds the components related with the federation configuration path
     */
    private void bindFederation() {
        bindPresenter(FederationPresenter.class, FederationPresenter.MyView.class, NewFederationView.class,
                FederationPresenter.MyProxy.class);
        bind(FederationStore.class).to(FederationStoreImpl.class).in(Singleton.class);
        bind(DeploymentManager.class).in(Singleton.class);
        bind(FederationManager.class);
    }

}
