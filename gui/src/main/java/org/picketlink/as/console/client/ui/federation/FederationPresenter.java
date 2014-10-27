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

import com.google.gwt.core.client.Scheduler;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.Place;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import org.jboss.as.console.client.shared.BeanFactory;
import org.jboss.as.console.client.shared.deployment.model.DeploymentRecord;
import org.jboss.as.console.client.shared.subsys.RevealStrategy;
import org.jboss.as.console.client.shared.subsys.security.model.SecurityDomain;
import org.jboss.as.console.spi.AccessControl;
import org.jboss.as.console.spi.SubsystemExtension;
import org.jboss.ballroom.client.layout.LHSHighlightEvent;
import org.jboss.dmr.client.dispatch.DispatchAsync;
import org.picketlink.as.console.client.NameTokens;
import org.picketlink.as.console.client.PicketlinkBeanFactory;
import org.picketlink.as.console.client.shared.subsys.model.Federation;
import org.picketlink.as.console.client.shared.subsys.model.FederationWrapper;
import org.picketlink.as.console.client.shared.subsys.model.IdentityProviderWrapper;
import org.picketlink.as.console.client.ui.federation.event.UpdateSecurityDomainEvent;

import java.util.List;

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

        void initialLoad();

        void selectFederation(FederationWrapper federation);

        void updateSelectedFederation(FederationWrapper selectedFederationConfig);
    }

    @ProxyCodeSplit
    @NameToken(NameTokens.FEDERATION)
    @SubsystemExtension(name = "Federation", group = "PicketLink", key = "picketlink-federation")
    @AccessControl(resources = "/{selected.profile}/subsystem=picketlink-federation/federation=*")
    public interface MyProxy extends Proxy<FederationPresenter>, Place {
    }

    private final RevealStrategy revealStrategy;
    private final DeploymentManager deploymentManager;
    private final PlaceManager placeManager;
    private final DispatchAsync dispatcher;
    private final PicketlinkBeanFactory beanFactory;
    private final FederationManager federationManager;

    private List<DeploymentRecord> availableDeployments;
    private List<DeploymentRecord> allDeployments;
    
    private String selectedFederation;
    private List<SecurityDomain> securityDomains;

    @Inject
    public FederationPresenter(final EventBus eventBus, BeanFactory beanFactory, final MyView view, final MyProxy proxy,
            final PlaceManager placeManager, RevealStrategy revealStrategy, DeploymentManager deploymentManager, DispatchAsync dispatcher, FederationManager federationManager) {
        super(eventBus, view, proxy);
        this.revealStrategy = revealStrategy;
        this.deploymentManager = deploymentManager;
        this.placeManager = placeManager;
        this.dispatcher = dispatcher;
        this.beanFactory = (PicketlinkBeanFactory) beanFactory;
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
        loadDeployments();
        loadSecurityDomains();
    }

    private void loadSecurityDomains() {
        this.federationManager.loadAllSecurityDomains(this);
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
        getView().selectFederation(this.getFederationManager().getFederations().get(this.selectedFederation));
        loadSecurityDomains();
    }

    /**
     * Load all deployed applications in the AS.
     */
    public void loadDeployments() {
        this.deploymentManager.loadDeployments(this);
    }

    /**
     * <p>
     * This methos is called when a federation is selected, added or removed from the table. Loads the configuration for all configure federations.
     * </p>
     * 
     * @param currentSelection
     */
    public void updateFederationSelection(final Federation currentSelection) {
        if (currentSelection != null) {
            this.selectedFederation = currentSelection.getName();
        } else {
            this.selectedFederation = null;
        }

        getFederationManager().loadAllFederations();
        getView().updateSelectedFederation(getCurrentFederation());
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.picketlink.as.console.client.ui.federation.DeploymentCallback#onLoadDeployments(java.util.List)
     */
    @Override
    public void onLoadDeployments(List<DeploymentRecord> deployments) {
        FederationWrapper selectedFederationConfig = getCurrentFederation();
        
        if (selectedFederationConfig != null) {
            List<IdentityProviderWrapper> identityProviders = selectedFederationConfig.getIdentityProviders();
            
            for (DeploymentRecord deployment : deployments) {
                for (IdentityProviderWrapper identityProviderWrapper : identityProviders) {
                    if (deployment.getName().equals(identityProviderWrapper.getIdentityProvider().getName())) {
                        identityProviderWrapper.getIdentityProvider().setEnabled(deployment.isEnabled());
                    }
                }
            }

            getView().updateSelectedFederation(selectedFederationConfig);
        }
        
        // updates the deployments list
        this.allDeployments = deployments;
    }

    /**
     * <p>
     * Returns the idp configured for the selected federation.
     * </p>
     * 
     * @return
     */
    public IdentityProviderWrapper getIdentityProvider(){
        IdentityProviderWrapper identityProvider = null;
        
        if (getCurrentFederation() != null) {
            identityProvider = getCurrentFederation().getIdentityProvider();
        }
        
        return identityProvider;
    }

    public DispatchAsync getDispatchAsync() {
        return this.dispatcher;
    }

    public PicketlinkBeanFactory getBeanFactory() {
        return this.beanFactory;
    }
    
    public FederationManager getFederationManager() {
        return this.federationManager;
    }
    
    public DeploymentManager getDeploymentManager() {
        return this.deploymentManager;
    }

    public PlaceManager getPlaceManager() {
        return this.placeManager;
    }
    
    public List<DeploymentRecord> getAvailableDeployments() {
        return this.availableDeployments;
    }
    
    public List<DeploymentRecord> getAllDeployments() {
        return this.allDeployments;
    }

    public FederationWrapper getCurrentFederation() {
        FederationWrapper federation = null;
        
        if (this.selectedFederation != null) {
            federation = getFederationManager().getFederations().get(this.selectedFederation);
        }
        
        return federation;
    }

    public void onLoadSecurityDomains(List<SecurityDomain> result) {
        this.securityDomains = result;
        getEventBus().fireEvent(new UpdateSecurityDomainEvent(result));
    }

    public List<SecurityDomain> getSecurityDomains() {
        return this.securityDomains;
    }
}
