/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2006, Red Hat Middleware LLC, and individual contributors
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

import org.jboss.as.console.client.shared.BeanFactory;
import org.jboss.as.console.client.shared.dispatch.DispatchAsync;
import org.jboss.as.console.client.shared.model.DeploymentRecord;
import org.jboss.as.console.client.shared.subsys.RevealStrategy;
import org.jboss.as.console.spi.Subsystem;
import org.jboss.ballroom.client.layout.LHSHighlightEvent;
import org.picketlink.as.console.client.NameTokens;
import org.picketlink.as.console.client.shared.subsys.model.Federation;
import org.picketlink.as.console.client.shared.subsys.model.IdentityProvider;
import org.picketlink.as.console.client.shared.subsys.model.KeyStore;
import org.picketlink.as.console.client.shared.subsys.model.ServiceProvider;
import org.picketlink.as.console.client.shared.subsys.model.TrustDomain;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.Place;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.Proxy;

/**
 * <p>
 * The presenter for the PicketLink -> Federation menu item.
 * </p>
 * 
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since 03/01/2011
 */
public class FederationPresenter extends Presenter<FederationPresenter.MyView, FederationPresenter.MyProxy> implements
        DeploymentCallback {

    public interface MyView extends View {
        void setPresenter(FederationPresenter presenter);

        Federation getCurrentFederation();

        void initialLoad();

        void setSelectedFederation(String selectedFederation);

        void setIdentityProviders(String name, List<IdentityProvider> modules);

        void setServiceProviders(String string, List<ServiceProvider> result);

        void setTrustedDomains(List<TrustDomain> result);

        void setKeyStore(String name, KeyStore keyStore);
    }

    @ProxyCodeSplit
    @NameToken(NameTokens.FEDERATION)
    @Subsystem(name = "Federation", group = "PicketLink", key = "logging")
    public interface MyProxy extends Proxy<FederationPresenter>, Place {
    }

    private final RevealStrategy revealStrategy;
    private final DeploymentManager deploymentManager;
    private final PlaceManager placeManager;
    private final DispatchAsync dispatcher;
    private final BeanFactory beanFactory;
    private final FederationManager federationManager;

    private List<DeploymentRecord> availableDeployments;
    private String selectedFederation;

    @Inject
    public FederationPresenter(final EventBus eventBus, BeanFactory beanFactory, final MyView view, final MyProxy proxy,
            final PlaceManager placeManager, RevealStrategy revealStrategy, DeploymentManager deploymentManager, DispatchAsync dispatcher, FederationManager federationManager) {
        super(eventBus, view, proxy);
        this.revealStrategy = revealStrategy;
        this.deploymentManager = deploymentManager;
        this.placeManager = placeManager;
        this.dispatcher = dispatcher;
        this.beanFactory = beanFactory;
        this.federationManager = federationManager;
        this.federationManager.setPresenter(this);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.gwtplatform.mvp.client.PresenterWidget#onReveal()
     */
    @Override
    protected void onReveal() {
        super.onReveal();
        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
            @Override
            public void execute() {
                fireEvent(new LHSHighlightEvent("unused", "PicketLink", "profiles"));
            }
        });
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.gwtplatform.mvp.client.Presenter#revealInParent()
     */
    @Override
    protected void revealInParent() {
        this.revealStrategy.revealInParent(this);
    }

    @Override
    public void prepareFromRequest(PlaceRequest request) {
        super.prepareFromRequest(request);
        this.selectedFederation = request.getParameter("name", null);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.gwtplatform.mvp.client.HandlerContainerImpl#onBind()
     */
    @Override
    protected void onBind() {
        super.onBind();
        loadDeployments();
        getView().setPresenter(this);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.gwtplatform.mvp.client.PresenterWidget#onReset()
     */
    @Override
    protected void onReset() {
        super.onReset();
        getView().initialLoad();
        getView().setSelectedFederation(this.selectedFederation);
    }

    /**
     * Load all deployed applications in the AS.
     */
    public void loadDeployments() {
        this.deploymentManager.loadDeployments(this);
    }

    /**
     * @return the availableDeployments
     */
    public List<DeploymentRecord> getAvailableDeployments() {
        return this.availableDeployments;
    }

    /**
     * @return
     */
    public PlaceManager getPlaceManager() {
        return this.placeManager;
    }

    /**
     * @param currentSelection
     */
    public void updateFederationSelection(final Federation currentSelection) {
        loadDeployments();
        getFederationManager().loadKeyStore(currentSelection);
        getFederationManager().loadIdentityProvider(currentSelection);
        getFederationManager().loadServiceProviders(currentSelection);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.picketlink.as.console.client.ui.federation.DeploymentCallback#onLoadDeployments(java.util.List)
     */
    @Override
    public void onLoadDeployments(List<DeploymentRecord> deployments) {
        this.availableDeployments = deployments;
    }

    public DispatchAsync getDispatchAsync() {
        return this.dispatcher;
    }

    public BeanFactory getBeanFactory() {
        return this.beanFactory;
    }
    
    public FederationManager getFederationManager() {
        return this.federationManager;
    }
    
    public DeploymentManager getDeploymentManager() {
        return this.deploymentManager;
    }
}
