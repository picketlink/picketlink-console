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

import org.jboss.as.console.client.domain.model.SimpleCallback;
import org.jboss.as.console.client.shared.subsys.RevealStrategy;
import org.jboss.ballroom.client.layout.LHSHighlightEvent;
import org.picketlink.as.console.client.BeanFactory;
import org.picketlink.as.console.client.NameTokens;
import org.picketlink.as.console.client.shared.subsys.model.Federation;
import org.picketlink.as.console.client.shared.subsys.model.FederationStore;
import org.picketlink.as.console.client.shared.subsys.model.IdentityProvider;
import org.picketlink.as.console.client.shared.subsys.model.ServiceProvider;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.Place;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.Proxy;

/**
 * <p>
 * The presenter for the PicketLink -> Federation menu item.
 * </p>
 * 
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since 03/01/2011
 */
public class FederationPresenter extends Presenter<FederationPresenter.MyView, FederationPresenter.MyProxy> {

    public interface MyView extends View {
        void setPresenter(FederationPresenter presenter);
        
        /**
         * <p>
         * Updates the view with federations instances configured in the subsystem.
         * </p>
         * @param federations
         */
        void updateFederations(List<Federation> federations);

        /**
         * Updates the view with the informations about a identity provider.
         * 
         * @param result
         */
        void updateIdentityProviders(List<IdentityProvider> result);

        /**
         * @param result
         */
        void updateServiceProviders(List<ServiceProvider> result);
    }

    @ProxyCodeSplit
    @NameToken(NameTokens.FEDERATION)
    public interface MyProxy extends Proxy<FederationPresenter>, Place {
    }

    private final RevealStrategy revealStrategy;
    private FederationStore federationStore;
    private BeanFactory beanFactory;

    @Inject
    public FederationPresenter(final EventBus eventBus, BeanFactory beanFactory, final MyView view, final MyProxy proxy,
            final PlaceManager placeManager, RevealStrategy revealStrategy, FederationStore federationStore) {
        super(eventBus, view, proxy);
        this.revealStrategy = revealStrategy;
        this.federationStore = federationStore;
        this.beanFactory = beanFactory;
    }

    /* (non-Javadoc)
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

    /* (non-Javadoc)
     * @see com.gwtplatform.mvp.client.Presenter#revealInParent()
     */
    @Override
    protected void revealInParent() {
        this.revealStrategy.revealInParent(this);
    }

    /* (non-Javadoc)
     * @see com.gwtplatform.mvp.client.HandlerContainerImpl#onBind()
     */
    @Override
    protected void onBind() {
        super.onBind();
        getView().setPresenter(this);
    }

    /* (non-Javadoc)
     * @see com.gwtplatform.mvp.client.PresenterWidget#onReset()
     */
    @Override
    protected void onReset() {
        super.onReset();
        loadFederations();
    }

    /**
     * <p>
     * Loads the federation instances from the subsystem.
     * </p>
     */
    private void loadFederations() {
        this.federationStore.loadFederations(new SimpleCallback<List<Federation>>() {
            @Override
            public void onSuccess(List<Federation> result) {
                getView().updateFederations(result);
            }
        });
    }
    
    /**
     * <p>
     * Loads the federation instances from the subsystem.
     * </p>
     */
    public void loadIdentityProvider(Federation federation) {
        this.federationStore.loadIdentityProviders(federation, new SimpleCallback<List<IdentityProvider>>() {
            @Override
            public void onSuccess(List<IdentityProvider> result) {
                getView().updateIdentityProviders(result);
            }
        });
    }
    
    /**
     * @param federation
     */
    public void loadServiceProviders(Federation federation) {
        this.federationStore.loadServiceProviders(federation, new SimpleCallback<List<ServiceProvider>>() {
            @Override
            public void onSuccess(List<ServiceProvider> result) {
                getView().updateServiceProviders(result);
            }
        });
    }


    /**
     * @param currentSelection
     */
    public void onDelete(Federation currentSelection) {
        // TODO: on delete federation
    }

    /**
     * @param updatedEntity
     */
    public void onCreateFederation(Federation updatedEntity) {
        
    }

    /**
     * @return
     */
    public BeanFactory getBeanFactory() {
        return this.beanFactory;
    }

}
