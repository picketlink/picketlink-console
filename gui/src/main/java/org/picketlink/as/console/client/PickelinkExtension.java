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

package org.picketlink.as.console.client;

import org.jboss.as.console.spi.GinExtension;
import org.picketlink.as.console.client.ui.federation.FederationPresenter;

import com.google.gwt.inject.client.AsyncProvider;


/**
 * <p>Console Extension for PicketLink.</p>
 * <p>This interface provides the configuration for the AS7 extension mechanism. The annotations declared in the type
 * uses the extension mechanism to add PicketLink features to the AS7 Console.</p>
 * 
 * @see PickelinkExtensionBinding
 * 
 * @author Pedro Silva
 * @author Rob Cernich
 */
@GinExtension("org.picketlink.as.console.PicketLinkExtension")
public interface PickelinkExtension
{
    AsyncProvider<FederationPresenter> getFederationPresenter();
}
