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

import org.jboss.as.console.client.shared.help.FormHelpPanel;
import org.jboss.as.console.client.shared.subsys.Baseadress;
import org.jboss.as.console.client.shared.viewframework.builder.FormLayout;
import org.jboss.as.console.client.widgets.forms.FormToolStrip;
import org.jboss.ballroom.client.widgets.forms.Form;
import org.jboss.ballroom.client.widgets.forms.TextItem;
import org.jboss.ballroom.client.widgets.tools.ToolButton;
import org.jboss.dmr.client.ModelNode;
import org.picketlink.as.console.client.shared.subsys.model.Federation;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * This class defines the widget to be displayed when a federation instance is selected.
 * 
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 14, 2012
 */
public class EditableFederationDetails {

    private Form<Federation> form;
    private FederationPresenter presenter;
    private ToolButton disableBtn;

    public EditableFederationDetails(FederationPresenter presenter) {
        this.presenter = presenter;
        form = new Form(Federation.class);
        form.setNumColumns(2);
    }

    public Widget asWidget() {
        VerticalPanel detailPanel = new VerticalPanel();
        detailPanel.setStyleName("fill-layout-width");

        final TextItem aliasItem = new TextItem("alias", "Alias");

        form.setFields(aliasItem);
        
        form.setEnabled(false);
        
        Widget formWidget = form.asWidget();
        
        FormToolStrip<Federation> toolStrip = new FormToolStrip<Federation>(
                form,
                new FormToolStrip.FormCallback<Federation>() {
                    @Override
                    public void onSave(Map<String, Object> changeset) {
                    }

                    @Override
                    public void onDelete(Federation entity) {

                    }
                });
        
        

        toolStrip.providesDeleteOp(false);
        
        detailPanel.add(toolStrip.asWidget());
        
        final FormHelpPanel helpPanel = new FormHelpPanel(new FormHelpPanel.AddressCallback() {
            @Override
            public ModelNode getAddress() {
                ModelNode address = Baseadress.get();
                address.add("subsystem", "picketlink");
                address.add("federation", "*");
                return address;
            }
        }, form);

        detailPanel.add(formWidget);

        FormLayout layout = new FormLayout().setHelp(helpPanel).setForm(form).setSetTools(toolStrip);

        return layout.build();
    }

    public void bind(CellTable<Federation> dataSourceTable) {
        form.bind(dataSourceTable);
    }

    public void setEnabled(boolean b) {
        form.setEnabled(b);
    }

    public Federation getCurrentSelection() {
        return form.getEditedEntity();
    }

}
