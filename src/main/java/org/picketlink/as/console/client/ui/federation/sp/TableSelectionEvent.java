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

package org.picketlink.as.console.client.ui.federation.sp;

import com.google.gwt.event.shared.GwtEvent;

/**
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 *
 */
public class TableSelectionEvent extends GwtEvent<TableSelectionEventHandler>{

    public static Type<TableSelectionEventHandler> TYPE = new Type<TableSelectionEventHandler>();
    
    private Object selection;
    
    public TableSelectionEvent(Object selection) {
        this.selection = selection;
    }
    
    @Override
    protected void dispatch(TableSelectionEventHandler handler) {
        handler.onSelect(this);
    }

    @Override
    public com.google.gwt.event.shared.GwtEvent.Type<TableSelectionEventHandler> getAssociatedType() {
        return TYPE;
    }

    /**
     * @return the selection
     */
    public Object getSelection() {
        return selection;
    }

    /**
     * @param selection the selection to set
     */
    public void setSelection(Object selection) {
        this.selection = selection;
    }
    
}
