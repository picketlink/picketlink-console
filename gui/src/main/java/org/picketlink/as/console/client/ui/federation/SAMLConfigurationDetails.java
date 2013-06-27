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

import java.util.Map;

import org.jboss.as.console.client.widgets.forms.FormToolStrip;
import org.jboss.ballroom.client.widgets.forms.Form;
import org.jboss.ballroom.client.widgets.forms.NumberBoxItem;
import org.picketlink.as.console.client.shared.subsys.model.KeyStore;
import org.picketlink.as.console.client.shared.subsys.model.SAMLConfiguration;
import org.picketlink.as.console.client.shared.subsys.model.ServiceProviderWrapper;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 30, 2012
 */
public class SAMLConfigurationDetails {

    private final Form<SAMLConfiguration> form;
    private final FederationPresenter presenter;
    private boolean hasSAMLConfiguration;
    
    /**
     * @param table
     */
    public SAMLConfigurationDetails(FederationPresenter presenter) {
        form = new Form<SAMLConfiguration>(SAMLConfiguration.class);
        this.presenter = presenter;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.google.gwt.user.client.ui.IsWidget#asWidget()
     */
    public Widget asWidget() {
        VerticalPanel layout = new VerticalPanel();

        layout.setStyleName("fill-layout");

        NumberBoxItem tokenTimeoutItem = new NumberBoxItem("tokenTimeout", "Token Timeout");
        
        tokenTimeoutItem.getInputElement().getStyle().setWidth(300, Unit.PX);
        
        NumberBoxItem clockSkewItem = new NumberBoxItem("clockSkew", "Clock Skew");
        
        clockSkewItem.getInputElement().getStyle().setWidth(150, Unit.PX);
        
        form.setFields(tokenTimeoutItem, clockSkewItem);
        
        form.setEnabled(false);
        
        FormToolStrip<SAMLConfiguration> toolStrip = new FormToolStrip<SAMLConfiguration>(form, new FormToolStrip.FormCallback<SAMLConfiguration>() {
            @Override
            public void onSave(Map<String, Object> changeset) {
                if (!hasSAMLConfiguration) {
                    presenter.getFederationManager().onCreateSAMLConfiguration(form.getUpdatedEntity());
                    hasSAMLConfiguration = true;
                } else {
                    presenter.getFederationManager().onUpdateSAMLConfiguration(form.getUpdatedEntity(), changeset);
                }
                
                form.edit(form.getUpdatedEntity());
            }

            @Override
            public void onDelete(SAMLConfiguration keyStore) {
                if (hasSAMLConfiguration) {
                    presenter.getFederationManager().onRemoveKeyStore(keyStore);
                    form.clearValues();
                    hasSAMLConfiguration = false;
                    form.edit(presenter.getBeanFactory().samlConfiguration().as());
                } else {
                    Window.alert("You must save before removing.");
                }
            }
        });
        
        toolStrip.providesDeleteOp(true);
        form.edit(this.presenter.getBeanFactory().samlConfiguration().as());

        layout.add(toolStrip.asWidget());
        layout.add(form.asWidget());

        return layout;
    }

    public void setSAMLConfiguration(SAMLConfiguration samlConfig) {
        this.hasSAMLConfiguration = samlConfig != null;
        
        if (samlConfig != null) {
            form.edit(samlConfig);
        } else {
            form.clearValues();
            SAMLConfiguration as = this.presenter.getBeanFactory().samlConfiguration().as();
            
            as.setTokenTimeout(0);
            
            form.edit(as);
        }
    }

}
