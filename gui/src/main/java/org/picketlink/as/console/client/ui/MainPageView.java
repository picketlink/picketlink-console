/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This copyrighted material is made available to anyone wishing to use,
 * modify, copy, or redistribute it subject to the terms and conditions
 * of the GNU Lesser General Public License, v. 2.1.
 * This program is distributed in the hope that it will be useful, but WITHOUT A
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License,
 * v.2.1 along with this distribution; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA  02110-1301, USA.
 */

package org.picketlink.as.console.client.ui;

import org.jboss.as.console.client.core.DisposableViewImpl;
import org.jboss.as.console.client.shared.viewframework.builder.SimpleLayout;

import com.google.gwt.user.client.ui.Widget;

/**
 * @author Pedro Silva
 */
public class MainPageView extends DisposableViewImpl implements MainPagePresenter.MyView {

    private MainPageEditor mainPageEditor;

    @Override
    public Widget createWidget() {
        mainPageEditor = new MainPageEditor();
        SimpleLayout layout = new SimpleLayout().setTitle("PicketLink Subsystem Details")
                .setHeadline("Federation Configuration").setDescription("Displays all federation configurations.")
                .addContent("Runtime Details", mainPageEditor.asWidget());
        return layout.build();
    }
    
    @Override
    public void setInSlot(Object slot, Widget content) {
        this.mainPageEditor.setComponentContent(content);
    }

}
