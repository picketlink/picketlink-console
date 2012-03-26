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

import org.picketlink.as.console.client.shared.subsys.model.Federation;

import com.google.gwt.user.client.ui.DeckPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 19, 2012
 */
public class NewFederationWizard {

    private FederationPresenter presenter;

    private DeckPanel deck;


    private Federation baseAttributes = null;

    private FederationEditor editor;

    public NewFederationWizard(
            FederationPresenter presenter, FederationEditor editor) {
        this.presenter = presenter;
        this.editor = editor;
    }

    public Widget asWidget() {
        deck = new DeckPanel();

        deck.add(new NewFederationWizardStep1(this, this.editor.getBeanFactory()).asWidget());
        
        deck.showWidget(0);
        
        return deck;
    }

    public FederationPresenter getPresenter() {
        return presenter;
    }

    public void onFinish(Federation updatedEntity) {

        // merge previous attributes into single entity
        updatedEntity.setAlias(baseAttributes.getAlias());

        presenter.onCreateFederation(updatedEntity);
    }

    /**
     * @param updatedEntity
     */
    public void onConfigureBaseAttributes(Federation updatedEntity) {
        this.presenter.onCreateFederation(updatedEntity);
    }
    
    /**
     * @return the editor
     */
    public FederationEditor getEditor() {
        return this.editor;
    }
}
