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
import org.jboss.ballroom.client.widgets.tables.DefaultCellTable;
import org.picketlink.as.console.client.PicketLinkConsoleFramework;
import org.picketlink.as.console.client.shared.subsys.model.Federation;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 30, 2012
 */
public class NewFederationDetails implements FormAdapter<Federation> {

    private Form<Federation> form;

    /**
     * @param table
     */
    public NewFederationDetails(DefaultCellTable<Federation> table) {
        form = new Form<Federation>(Federation.class);
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
        // TODO Auto-generated method stub

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
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.jboss.ballroom.client.widgets.forms.FormAdapter#getChangedValues()
     */
    @Override
    public Map<String, Object> getChangedValues() {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.jboss.ballroom.client.widgets.forms.FormAdapter#getConversionType()
     */
    @Override
    public Class<?> getConversionType() {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.jboss.ballroom.client.widgets.forms.FormAdapter#getEditedEntity()
     */
    @Override
    public Federation getEditedEntity() {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.jboss.ballroom.client.widgets.forms.FormAdapter#getUpdatedEntity()
     */
    @Override
    public Federation getUpdatedEntity() {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.jboss.ballroom.client.widgets.forms.FormAdapter#getFormItemNames()
     */
    @Override
    public List<String> getFormItemNames() {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.jboss.ballroom.client.widgets.forms.FormAdapter#setEnabled(boolean)
     */
    @Override
    public void setEnabled(boolean b) {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.jboss.ballroom.client.widgets.forms.FormAdapter#validate()
     */
    @Override
    public FormValidation validate() {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.jboss.ballroom.client.widgets.forms.FormAdapter#clearValues()
     */
    @Override
    public void clearValues() {
        // TODO Auto-generated method stub

    }

}
