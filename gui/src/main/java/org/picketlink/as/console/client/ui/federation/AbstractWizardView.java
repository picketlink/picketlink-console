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

import org.jboss.as.console.client.Console;
import org.jboss.ballroom.client.widgets.window.DefaultWindow;

import com.google.gwt.user.client.ui.DeckPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.Presenter;

/**
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 23, 2012
 */
public abstract class AbstractWizardView<P extends Presenter, T> implements WizardView<P, T> {

    private P presenter;
    private DeckPanel deck;
    private DefaultWindow window;
    private String title;
    
    public AbstractWizardView(String title, P presenter) {
        this.presenter = presenter;
        this.title = title;
    }
    
    public Widget asWidget() {
        deck = new DeckPanel();

        doAddSteps(deck);
        
        deck.showWidget(0);
        
        return deck;
    }
    
    /**
     * @param deck2
     */
    protected abstract void doAddSteps(DeckPanel deck);

    /**
     * Lunch this wizard.
     */
    public void lunch() {
        window = new DefaultWindow(Console.MESSAGES.createTitle(this.title));
        window.setWidth(480);
        window.setHeight(450);

        window.setWidget(this.asWidget());

        window.setGlassEnabled(true);
        window.center();
    }
    
    /**
     * <p>
     * Callback method called when the user wants to close/cancel the wizard.
     * </p>
     */
    public void onClose() {
        window.hide();
    }

    public P getPresenter() {
        return this.presenter;
    }
    
}
