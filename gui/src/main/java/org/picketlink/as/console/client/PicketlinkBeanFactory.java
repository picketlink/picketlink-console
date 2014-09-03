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

import com.google.web.bindery.autobean.shared.AutoBean;
import org.jboss.as.console.spi.BeanFactoryExtension;
import org.picketlink.as.console.client.shared.subsys.model.*;

/**
 * <p><code>com.google.gwt.autobean.shared.AutoBeanFactory</code> for the PicketLink module.</p>
 * <p>This class extends the AS7 Console AutoBeanFactory as an extension to allow the PicketLink module reuse all
 * bean definitions from the AS7 Console.</p>
 * 
 * @author Pedro Silva
 * @since Mar 13, 2012
 */
@BeanFactoryExtension
public interface PicketlinkBeanFactory {

    AutoBean<Federation> federation();
    
    AutoBean<IdentityProvider> identityProvider();
    
    AutoBean<ServiceProvider> serviceProvider();
    
    AutoBean<TrustDomain> trustDomain();
    
    AutoBean<IdentityProviderHandler> identityProviderHandler();
    
    AutoBean<IdentityProviderHandlerParameter> identityProviderHandlerParameter();

    AutoBean<ServiceProviderHandler> serviceProviderHandler();
    
    AutoBean<ServiceProviderHandlerParameter> serviceProviderHandlerParameter();

    AutoBean<KeyStore> keyStore();
    
    AutoBean<SAMLConfiguration> samlConfiguration();
}
