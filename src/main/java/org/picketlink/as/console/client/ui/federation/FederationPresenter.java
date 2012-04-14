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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
import org.picketlink.as.console.client.ui.federation.idp.AddIdentityProviderEvent;
import org.picketlink.as.console.client.ui.federation.idp.ChangedIdentityProviderHandler;
import org.picketlink.as.console.client.ui.federation.idp.RemoveIdentityProviderEvent;
import org.picketlink.as.console.client.ui.federation.sp.AddServiceProviderEvent;
import org.picketlink.as.console.client.ui.federation.sp.ChangedServiceProviderHandler;
import org.picketlink.as.console.client.ui.federation.sp.RemoveServiceProviderEvent;

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
        DeploymentCallback, ChangedIdentityProviderHandler, ChangedServiceProviderHandler {

    public interface MyView extends View {
        void setPresenter(FederationPresenter presenter);

        Federation getCurrentFederation();

        void initialLoad();

        void setSelectedFederation(String selectedFederation);

        void setIdentityProviders(String name, List<IdentityProvider> modules);

        void setServiceProviders(String string, List<ServiceProvider> result);

        void setTrustedDomains(List<TrustDomain> result);

        void setKeyStore(String name, KeyStore keyStore);

        void updateDeployments(List<DeploymentRecord> deployments);
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
    private Map<String, IdentityProvider> identityProviders = new HashMap<String, IdentityProvider>();
    private Map<String, List<ServiceProvider>> serviceProviders = new HashMap<String, List<ServiceProvider>>();
    
//    private IdentityProvider identityProvider;
    private List<DeploymentRecord> allDeployments;
//    private List<ServiceProvider> serviceProviders = new ArrayList<ServiceProvider>();

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
        eventBus.addHandler(AddIdentityProviderEvent.TYPE, this);
        eventBus.addHandler(RemoveIdentityProviderEvent.TYPE, this);
        eventBus.addHandler(AddServiceProviderEvent.TYPE, this);
        eventBus.addHandler(RemoveServiceProviderEvent.TYPE, this);
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
        this.selectedFederation = request.getParameter("name", null);
        super.prepareFromRequest(request);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.gwtplatform.mvp.client.HandlerContainerImpl#onBind()
     */
    @Override
    protected void onBind() {
        super.onBind();
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
    
    public List<DeploymentRecord> getAllDeployments() {
        return this.allDeployments;
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
        this.availableDeployments = new ArrayList<DeploymentRecord>(deployments);
        this.allDeployments = new ArrayList<DeploymentRecord>(deployments);
        
        for (DeploymentRecord deployment : new ArrayList<DeploymentRecord>(this.availableDeployments)) {
            boolean isAvailable = true;
            
            for (Map.Entry<String, IdentityProvider> identityProviders : this.identityProviders.entrySet()) {
                if (deployment.getName().equals(identityProviders.getValue().getName())) {
                    this.availableDeployments.remove(deployment);
                    isAvailable = false;
                }
            }

            for (Entry<String, List<ServiceProvider>> serviceProviders : this.serviceProviders.entrySet()) {
                for (ServiceProvider serviceProvider : serviceProviders.getValue()) {
                    if (deployment.getName().equals(serviceProvider.getName())) {
                        this.availableDeployments.remove(deployment);
                        isAvailable = false;
                    }
                    
                }
            }
            
            if (isAvailable && !this.availableDeployments.contains(deployment)) {
                this.availableDeployments.add(deployment);
            }
        }
        
        getView().updateDeployments(this.availableDeployments);
//        getView().setSelectedFederation(this.selectedFederation);
    }

    public IdentityProvider getIdentityProvider(){
        if (this.selectedFederation == null) {
            return null;
        }
        
        return this.identityProviders.get(this.selectedFederation);
    }

    private List<ServiceProvider> getServiceProviders() {
        if (this.selectedFederation == null) {
            return null;
        }

        if (this.serviceProviders.get(this.selectedFederation) == null) {
            this.serviceProviders.put(this.selectedFederation, new ArrayList<ServiceProvider>());
        }
        
        return this.serviceProviders.get(this.selectedFederation);
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

    @Override
    public void onAddIdentityProvider(IdentityProvider identityProvider) {
        if (this.selectedFederation != null) {
            this.identityProviders.put(this.selectedFederation, identityProvider);
        }
    }

    @Override
    public void onRemoveIdentityProvider(IdentityProvider identityProvider) {
        this.identityProviders.remove(this.selectedFederation);
    }

    @Override
    public void onAddServiceProvider(ServiceProvider serviceProvider) {
        if (getServiceProviders() != null) {
            for (ServiceProvider configureServiceProviders : getServiceProviders()) {
                if (configureServiceProviders.getName().equals(serviceProvider.getName())) {
                    return;
                }
            }
            
            getServiceProviders().add(serviceProvider);
        }
    }

    @Override
    public void onRemoveServiceProvider(ServiceProvider serviceProvider) {
        for (ServiceProvider configureServiceProviders : new ArrayList<ServiceProvider>(getServiceProviders())) {
            if (configureServiceProviders.getName().equals(serviceProvider.getName())) {
                getServiceProviders().remove(configureServiceProviders);
            }
        }
    }

//    public void clearFederation() {
//        if (this.selectedFederation != null) {
//            this.identityProviders.remove(this.selectedFederation);
//            this.serviceProviders.remove(this.selectedFederation);
//        }
//    }

    public void clearFederation(Federation federation) {
        if (federation != null) {
            for (Map.Entry<String, IdentityProvider> identityProviders : new HashMap<String, IdentityProvider>(this.identityProviders).entrySet()) {
                if (identityProviders.getKey().equals(federation.getName())) {
                    continue;
                }
                
                this.identityProviders.remove(federation.getName());
            }
            
            for (Entry<String, List<ServiceProvider>> serviceProviders : new HashMap<String, List<ServiceProvider>>(this.serviceProviders).entrySet()) {
                if (serviceProviders.getKey().equals(federation.getName())) {
                    continue;
                }
                
                this.serviceProviders.remove(federation.getName());
            }
        }
    }

}
