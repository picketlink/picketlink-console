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

package org.picketlink.as.console.client.ui.federation.keystore;

import com.google.gwt.user.client.ui.TabPanel;
import org.jboss.as.console.client.domain.model.SimpleCallback;
import org.jboss.ballroom.client.widgets.forms.TextBoxItem;
import org.picketlink.as.console.client.i18n.PicketLinkUIConstants;
import org.picketlink.as.console.client.i18n.PicketLinkUIMessages;
import org.picketlink.as.console.client.shared.subsys.model.FederationWrapper;
import org.picketlink.as.console.client.shared.subsys.model.Key;
import org.picketlink.as.console.client.shared.subsys.model.KeyStore;
import org.picketlink.as.console.client.shared.subsys.model.KeyStoreWrapper;
import org.picketlink.as.console.client.shared.subsys.model.ServiceProviderWrapper;
import org.picketlink.as.console.client.ui.federation.AbstractFederationDetailEditor;
import org.picketlink.as.console.client.ui.federation.FederationPresenter;
import org.picketlink.as.console.client.ui.federation.Wizard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 30, 2012
 */
public class KeyStoreEditor extends AbstractFederationDetailEditor<KeyStore> {

    private PicketLinkUIConstants uiConstants;
    private PicketLinkUIMessages uiMessages;
    private KeyEditor keyEditor;

    public KeyStoreEditor(FederationPresenter presenter,
        final PicketLinkUIConstants uiConstants, final PicketLinkUIMessages uiMessages) {
        super(presenter, new KeyStoreTable(presenter), KeyStore.class);
        this.uiConstants = uiConstants;
        this.uiMessages = uiMessages;
    }

    @Override
    public String doGetEntityName() {
        return uiConstants.common_label_key_store();
    }
    
    @Override
    protected String doGetDescription() {
        return uiConstants.subsys_picketlink_key_store_desc();
    }
    
    /* (non-Javadoc)
     * @see org.picketlink.as.console.client.ui.federation.AbstractFederationDetailEditor#getStackName()
     */
    @Override
    public String doGetTableSectionName() {
        return "Key Stores";
    }

    @Override
    protected boolean doInsert(KeyStore keyStore) {
        if (keyStore.getRelativeTo().trim().length() == 0) {
            keyStore.setRelativeTo(null);
        }

        getPresenter().getFederationManager().onCreateKeyStore(keyStore, new SimpleCallback<Boolean>() {
            @Override
            public void onSuccess(Boolean aBoolean) {
            }
        });

        return true;
    }

    @Override
    protected String doGetName(KeyStore currentSelection) {
        return "Key Store";
    }

    @Override
    protected void addDetailsSectionTabs(TabPanel bottomTabs) {
    }

    @Override
    protected void doUpdateSelection(KeyStore keyStore) {
    }
    
    @Override
    protected void doDelete(KeyStore keyStore) {
        FederationPresenter presenter = getPresenter();
        FederationWrapper currentFederation = presenter.getCurrentFederation();

        presenter.getFederationManager().onRemoveKeyStore(keyStore);

        if (currentFederation.getIdentityProvider() != null) {
            currentFederation.getIdentityProvider().getIdentityProvider().setSupportsSignatures(true);

            HashMap<String, Object> changedValues = new HashMap<String, Object>();

            changedValues.put("supportsSignatures", "false");

            presenter.getFederationManager().onUpdateIdentityProvider(currentFederation.getIdentityProvider().getIdentityProvider(), changedValues);

            List<ServiceProviderWrapper> serviceProviders = currentFederation.getServiceProviders();

            for (ServiceProviderWrapper serviceProvider : serviceProviders) {
                presenter.getFederationManager().onUpdateServiceProvider(serviceProvider.getServiceProvider(), changedValues);

            }
        }
    }

    @Override
    public void doUpdate(KeyStore keyStore, Map<String, Object> changedValues) {
        NewKeyStoreWizard wizard = (NewKeyStoreWizard) getWizard();
        TextBoxItem relativeToItem = wizard.getRelativeTo();

        if (relativeToItem.getValue() != null && relativeToItem.getValue().isEmpty()) {
            keyStore.setRelativeTo(null);
        }

        getPresenter().getFederationManager().onUpdateKeyStore(keyStore, changedValues);

    }

    @Override
    public Wizard<KeyStore> doCreateWizard() {
        return new NewKeyStoreWizard(this, getEntityClass(), getPresenter(), "key-store", uiConstants);
    }

    @Override
    protected void doCreateAttributesTab(TabPanel bottomTabs) {
        bottomTabs.add(getKeyEditor().asWidget(), "Host Keys");
    }

    private KeyEditor getKeyEditor() {
        if (this.keyEditor == null) {
            this.keyEditor = new KeyEditor(getPresenter(), this.uiConstants);
        }

        return this.keyEditor;
    }

    public void updateKeyStore(FederationWrapper federation) {
        if (federation != null) {
            ArrayList<KeyStore> keyStores = new ArrayList<KeyStore>();

            if (!federation.getKeyStores().isEmpty()) {
                KeyStoreWrapper keyStoreWrapper = federation.getKeyStores().get(0);

                keyStores.add(keyStoreWrapper.getKeyStore());

                getKeyEditor().setEnabled(true);
                getKeyEditor().getKeyTable().setList(keyStoreWrapper.getKeys());
            } else {
                getKeyEditor().setEnabled(false);
                getKeyEditor().getKeyTable().setList(new ArrayList<Key>());
            }

            setData(federation, keyStores);
        }
    }
}