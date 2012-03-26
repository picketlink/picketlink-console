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

import org.jboss.as.console.client.widgets.ContentDescription;
import org.picketlink.as.console.client.shared.subsys.model.ServiceProvider;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * <p>
 * This class defines the widget to be displayed to show the general informations about a selected federation instance.
 * </p>
 * 
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 14, 2012
 */
public class ServiceProviderDetails {

    private ServiceProviderTable serviceProviderTable;

    public Widget asWidget() {
        VerticalPanel layout = new VerticalPanel();
        
        layout.setStyleName("rhs-content-panel");
        
        HorizontalPanel horizontalPanel = new HorizontalPanel();
        
        horizontalPanel.setHeight("10px");
        
        layout.add(horizontalPanel);
        layout.add(new ContentDescription("Avaiable Service Providers"));
        layout.add(getFederationTable().asWidget());
        
        return layout;
    }
    
    /**
     * Returns a instance of the table to be used to show the service provider instances.
     * 
     * @return
     */
    private ServiceProviderTable getFederationTable() {
        if (this.serviceProviderTable == null) {
            this.serviceProviderTable = new ServiceProviderTable();
        }

        return this.serviceProviderTable;
    }

    /**
     * @param result
     */
    public void updateServiceProviders(List<ServiceProvider> result) {
        this.getFederationTable().getDataProvider().setList(result);
    }

}
