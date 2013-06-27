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

import java.util.Map;

import org.jboss.as.console.client.widgets.forms.FormToolStrip;
import org.jboss.ballroom.client.widgets.forms.CheckBoxItem;
import org.jboss.ballroom.client.widgets.forms.Form;
import org.picketlink.as.console.client.i18n.PicketLinkUIConstants;
import org.picketlink.as.console.client.shared.subsys.model.GenericFederationEntity;
import org.picketlink.as.console.client.ui.federation.AsyncHelpText;
import org.picketlink.as.console.client.ui.federation.FederationPresenter;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * <p>Abstract class for creating a tab with signature support configurations.</p>
 * 
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 31, 2012
 */
public abstract class SignatureSupportTabEditor<P extends GenericFederationEntity> {

    private Form<P> form;
    private FederationPresenter presenter;
    private PicketLinkUIConstants uiConstants;
    
    private CheckBoxItem supportsSignatures;
    private P entity;
    private HTML errorMessage;

    public SignatureSupportTabEditor(FederationPresenter presenter, PicketLinkUIConstants uiConstants) {
        this.presenter = presenter;
        this.uiConstants = uiConstants;
    }
    
    public Widget asWidget() {
        VerticalPanel panel = new VerticalPanel();

        panel.setStyleName("fill-layout-width");
        
        new AsyncHelpText("identity-provider", new String[] {"supportsSignatures"}, this.presenter, panel, false);
        
        addForm(panel);

        return panel;
    }

    /**
     * @param panel
     */
    private void addForm(VerticalPanel panel) {
        this.form = new Form<P>(getEntityClass());
        
        errorMessage = new HTML();
        
        errorMessage.setStyleName("error-panel");
        
        panel.add(errorMessage);
        
        FormToolStrip<P> toolStrip = new FormToolStrip<P>(this.form, new FormToolStrip.FormCallback<P>() {
            @Override
            public void onSave(Map<String, Object> changeset) {
                P updatedIdentityProvider = form.getUpdatedEntity();
                
                entity.setSupportsSignatures(updatedIdentityProvider.isSupportsSignatures());
                
                doUpdateEntity(changeset);
            }

            @Override
            public void onDelete(P entity) {
            }
        });

        toolStrip.providesDeleteOp(false);
        
        panel.add(toolStrip.asWidget());

        this.form.setEnabled(false);

        this.supportsSignatures = new CheckBoxItem("supportsSignatures",
                doGetSupportsSignatureLabel());

        this.form.setFields(supportsSignatures);
        
        panel.add(this.form.asWidget());
    }

    protected String doGetSupportsSignatureLabel() {
        return uiConstants.common_label_supportsSignatures();
    }

    protected abstract Class<P> getEntityClass();

    protected abstract void doUpdateEntity(Map<String, Object> changeset);

    private void enableDisableSignatureSupportFields() {
        if (getPresenter().getCurrentFederation() != null) {
            if (getPresenter().getCurrentFederation().getKeyStores().isEmpty()) {
                errorMessage.setHTML("This configuration is disabled because the current federation does not support signatures.");
            } else {
                errorMessage.setHTML("");
            }
            
            if (getPresenter().getCurrentFederation().getKeyStores().isEmpty()) {
                this.supportsSignatures.setEnabled(false);
            } else {
                this.supportsSignatures.setEnabled(true);
            }
        }
    }

    public void setEntity(P entity) {
        this.entity = entity;
        this.form.edit(entity);
        supportsSignatures.setValue(entity.isSupportsSignatures());
        enableDisableSignatureSupportFields();
    }
    
    protected FederationPresenter getPresenter() {
        return presenter;
    }
    
    protected P getEntity() {
        return entity;
    }
}
