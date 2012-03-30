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

package org.picketlink.as.console.client;

import org.jboss.as.console.client.Console;
import org.jboss.ballroom.client.spi.Framework;
import org.picketlink.as.console.client.i18n.PicketLinkUIConstants;
import org.picketlink.as.console.client.i18n.PicketLinkUIMessages;

import com.google.gwt.autobean.shared.AutoBeanFactory;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.gwtplatform.mvp.client.proxy.PlaceManager;

/**
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 20, 2012
 */
public class PicketLinkConsoleFramework implements Framework {

    private final static BeanFactory factory = GWT.create(BeanFactory.class);
    
    public final static PicketLinkUIConstants CONSTANTS = GWT.create(PicketLinkUIConstants.class);
    public final static PicketLinkUIMessages MESSAGES = GWT.create(PicketLinkUIMessages.class);

    @Override
    public EventBus getEventBus() {
        return Console.MODULES.getEventBus();
    }

    @Override
    public PlaceManager getPlaceManager() {
        return Console.MODULES.getPlaceManager();
    }

    @Override
    public AutoBeanFactory getBeanFactory() {
        return factory;
    }
    
    public static PicketLinkUIConstants getConstants() {
        return CONSTANTS;
    }
    
}
