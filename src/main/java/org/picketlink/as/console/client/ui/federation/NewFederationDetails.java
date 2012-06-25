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
import java.util.Map;

import org.jboss.as.console.client.shared.viewframework.builder.FormLayout;
import org.jboss.ballroom.client.widgets.forms.EditListener;
import org.jboss.ballroom.client.widgets.forms.Form;
import org.jboss.ballroom.client.widgets.forms.FormAdapter;
import org.jboss.ballroom.client.widgets.forms.FormValidation;
import org.jboss.ballroom.client.widgets.forms.TextItem;
import org.picketlink.as.console.client.PicketLinkConsoleFramework;
import org.picketlink.as.console.client.shared.subsys.model.Federation;
import org.picketlink.as.console.client.shared.subsys.model.FederationWrapper;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 30, 2012
 */
public class NewFederationDetails implements FormAdapter<Federation> {

    private final Form<Federation> form;
    private final FederationPresenter presenter;
    private DigitalCertificateDetails digitalCertificateDetails;
    private SAMLConfigurationDetails samlConfigurationDetails;

    /**
     * @param table
     */
    public NewFederationDetails(FederationPresenter presenter) {
        form = new Form<Federation>(Federation.class);
        this.presenter = presenter;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.google.gwt.user.client.ui.IsWidget#asWidget()
     */
    @Override
    public Widget asWidget() {
        TabPanel tabPanel = new TabPanel();

        tabPanel.setStyleName("default-tabpanel");

        VerticalPanel layout = new VerticalPanel();

        layout.setStyleName("fill-layout-width");

        final TextItem aliasItem = new TextItem("name", PicketLinkConsoleFramework.CONSTANTS.common_label_federationAlias());

        form.setFields(aliasItem);
        form.setEnabled(false);

        layout.add(new FormLayout().setSetTools(null).setHelp(null).setForm(form).build());

        tabPanel.add(layout, "Attributes");
        
        this.digitalCertificateDetails = new DigitalCertificateDetails(this.presenter);
        
        tabPanel.add(this.digitalCertificateDetails.asWidget(), "Digital Certificates");

        this.samlConfigurationDetails = new SAMLConfigurationDetails(this.presenter);
        
        tabPanel.add(this.samlConfigurationDetails.asWidget(), "SAML Configuration");

        tabPanel.selectTab(0);

        return tabPanel;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.jboss.ballroom.client.widgets.forms.FormAdapter#bind(com.google.gwt.user.cellview.client.CellTable)
     */
    @Override
    public void bind(CellTable<Federation> instanceTable) {
        form.bind(instanceTable);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.jboss.ballroom.client.widgets.forms.FormAdapter#cancel()
     */
    @Override
    public void cancel() {
        form.cancel();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.jboss.ballroom.client.widgets.forms.FormAdapter#edit(java.lang.Object)
     */
    @Override
    public void edit(Federation bean) {
        this.form.edit(bean);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.jboss.ballroom.client.widgets.forms.FormAdapter#addEditListener(org.jboss.ballroom.client.widgets.forms.EditListener)
     */
    @Override
    public void addEditListener(EditListener listener) {
        form.addEditListener(listener);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.jboss.ballroom.client.widgets.forms.FormAdapter#removeEditListener(org.jboss.ballroom.client.widgets.forms.EditListener
     * )
     */
    @Override
    public void removeEditListener(EditListener listener) {
        form.removeEditListener(listener);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.jboss.ballroom.client.widgets.forms.FormAdapter#getChangedValues()
     */
    @Override
    public Map<String, Object> getChangedValues() {
        return form.getChangedValues();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.jboss.ballroom.client.widgets.forms.FormAdapter#getConversionType()
     */
    @Override
    public Class<?> getConversionType() {
        return Federation.class;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.jboss.ballroom.client.widgets.forms.FormAdapter#getEditedEntity()
     */
    @Override
    public Federation getEditedEntity() {
        return form.getEditedEntity();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.jboss.ballroom.client.widgets.forms.FormAdapter#getUpdatedEntity()
     */
    @Override
    public Federation getUpdatedEntity() {
        return form.getUpdatedEntity();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.jboss.ballroom.client.widgets.forms.FormAdapter#getFormItemNames()
     */
    @Override
    public List<String> getFormItemNames() {
        return form.getFormItemNames();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.jboss.ballroom.client.widgets.forms.FormAdapter#setEnabled(boolean)
     */
    @Override
    public void setEnabled(boolean b) {
        form.setEnabled(b);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.jboss.ballroom.client.widgets.forms.FormAdapter#validate()
     */
    @Override
    public FormValidation validate() {
        return form.validate();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.jboss.ballroom.client.widgets.forms.FormAdapter#clearValues()
     */
    @Override
    public void clearValues() {
        form.clearValues();
        this.digitalCertificateDetails.setKeyStore(null);
        this.samlConfigurationDetails.setSAMLConfiguration(null);
    }

    public void updateKeyStore(FederationWrapper federation) {
        if (federation != null && !federation.getKeyStores().isEmpty()) {
            this.digitalCertificateDetails.setKeyStore(federation.getKeyStores().get(0));            
        } else {
            this.digitalCertificateDetails.setKeyStore(null);
        }
        
        if (federation != null) {
            this.samlConfigurationDetails.setSAMLConfiguration(federation.getSAMLConfiguration());
        } else {
            this.samlConfigurationDetails.setSAMLConfiguration(null);
        }
    }

}
