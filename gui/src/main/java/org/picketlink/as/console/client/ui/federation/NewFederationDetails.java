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

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import org.jboss.as.console.client.layout.FormLayout;
import org.jboss.ballroom.client.widgets.forms.EditListener;
import org.jboss.ballroom.client.widgets.forms.Form;
import org.jboss.ballroom.client.widgets.forms.FormAdapter;
import org.jboss.ballroom.client.widgets.forms.FormCallback;
import org.jboss.ballroom.client.widgets.forms.FormValidation;
import org.jboss.ballroom.client.widgets.forms.FormValidator;
import org.jboss.ballroom.client.widgets.forms.TextItem;
import org.picketlink.as.console.client.i18n.PicketLinkUIConstants;
import org.picketlink.as.console.client.shared.subsys.model.Federation;
import org.picketlink.as.console.client.shared.subsys.model.FederationWrapper;

/**
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 30, 2012
 */
public class NewFederationDetails implements FormAdapter<Federation> {

    private final Form<Federation> form;
    private final FederationPresenter presenter;
    private final PicketLinkUIConstants uiConstants;
    private SAMLConfigurationDetails samlConfigurationDetails;
    private TabPanel tabPanel;

    public NewFederationDetails(FederationPresenter presenter, final PicketLinkUIConstants uiConstants) {
        form = new Form<>(Federation.class);
        this.presenter = presenter;
        this.uiConstants = uiConstants;
    }

    @Override
    public Widget asWidget() {
        this.tabPanel = new TabPanel();
        tabPanel.setStyleName("default-tabpanel");
        tabPanel.addStyleName("master_detail-detail");

        VerticalPanel layout = new VerticalPanel();


        final TextItem aliasItem = new TextItem("name", uiConstants.common_label_federationName());

        form.setFields(aliasItem);
        form.setEnabled(false);

        layout.add(new FormLayout().setTools(null).setForm(form).build());

        tabPanel.add(layout, "Attributes");
        
        this.samlConfigurationDetails = new SAMLConfigurationDetails(this.presenter);
        
        tabPanel.add(this.samlConfigurationDetails.asWidget(), "SAML Configuration");

        tabPanel.selectTab(0);

        return tabPanel;
    }

    @Override
    public void bind(CellTable<Federation> instanceTable) {
        form.bind(instanceTable);
    }

    @Override
    public void cancel() {
        form.cancel();
    }

    @Override
    public void edit(Federation bean) {
        this.form.edit(bean);
    }

    @Override
    public void editTransient(Federation federation) {
        form.editTransient(federation);
    }

    @Override
    public void addEditListener(EditListener listener) {
        form.addEditListener(listener);
    }

    @Override
    public void removeEditListener(EditListener listener) {
        form.removeEditListener(listener);
    }

    @Override
    public void setToolsCallback(FormCallback formCallback) {
        form.setToolsCallback(formCallback);
    }

    @Override
    public Map<String, Object> getChangedValues() {
        return form.getChangedValues();
    }

    @Override
    public Class<?> getConversionType() {
        return Federation.class;
    }

    @Override
    public Federation getEditedEntity() {
        return form.getEditedEntity();
    }

    @Override
    public Federation getUpdatedEntity() {
        return form.getUpdatedEntity();
    }

    @Override
    public List<String> getFormItemNames() {
        return form.getFormItemNames();
    }

    @Override
    public String getFormItemTitle(final String ref) {
        return form.getFormItemTitle(ref);
    }

    @Override
    public void setEnabled(boolean b) {
        form.setEnabled(b);
    }

    @Override
    public FormValidation validate() {
        return form.validate();
    }

    @Override
    public void addFormValidator(final FormValidator formValidator) {
        form.addFormValidator(formValidator);
    }

    @Override
    public void clearValues() {
        form.clearValues();
        this.samlConfigurationDetails.setSAMLConfiguration(null);
    }

    public void updateTabs(FederationWrapper federation) {
        this.tabPanel.setVisible(federation != null);

        if (federation != null) {
            this.samlConfigurationDetails.setSAMLConfiguration(federation.getSAMLConfiguration());
        } else {
            this.samlConfigurationDetails.setSAMLConfiguration(null);
        }
    }
}
