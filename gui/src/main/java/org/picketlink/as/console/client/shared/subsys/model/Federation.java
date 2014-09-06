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

package org.picketlink.as.console.client.shared.subsys.model;

import org.jboss.as.console.client.shared.viewframework.NamedEntity;
import org.jboss.as.console.client.widgets.forms.Address;
import org.jboss.as.console.client.widgets.forms.Binding;
import org.jboss.as.console.client.widgets.forms.FormItem;

/**
 * <p>Federation bean definition.</p>
 * <p>This interface also defines the address to be used when using the AS7 management API.</p>
 * 
 * @author Pedro Silva
 * @since Mar 14, 2012
 */
@Address("/subsystem=picketlink-federation/federation={0}")
public interface Federation extends NamedEntity {

    @Override
    @FormItem(localLabel="common_label_name",
            required=true,
            formItemTypeForEdit="TEXT",
            formItemTypeForAdd="TEXT_BOX",
            tabName="common_label_attributes")
    @Binding(detypedName="name", key = true)
    String getName();
    
    @Override
    void setName(String alias);
    
}
