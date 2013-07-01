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

package org.picketlink.as.console.client.ui.federation.sts;

import java.util.Map;

import org.picketlink.as.console.client.i18n.PicketLinkUIConstants;
import org.picketlink.as.console.client.shared.subsys.model.FederationWrapper;
import org.picketlink.as.console.client.shared.subsys.model.SecurityTokenService;
import org.picketlink.as.console.client.ui.federation.AbstractFederationDetailEditor;
import org.picketlink.as.console.client.ui.federation.FederationPresenter;
import org.picketlink.as.console.client.ui.federation.Wizard;

/**
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 30, 2012
 */
public class SecurityTokenServiceEditor extends AbstractFederationDetailEditor<SecurityTokenService> {

    private PicketLinkUIConstants uiConstants;

    public SecurityTokenServiceEditor(FederationPresenter presenter, PicketLinkUIConstants uiConstants) {
        super(presenter, new SecurityTokenServiceTable(presenter), SecurityTokenService.class);
        this.uiConstants = uiConstants;
    }

    /* (non-Javadoc)
     * @see org.picketlink.as.console.client.ui.federation.AbstractFederationDetailEditor#getEntityName()
     */
    @Override
    public String doGetEntityName() {
        return uiConstants.common_label_securityTokenService();
    }
    
    /* (non-Javadoc)
     * @see org.picketlink.as.console.client.ui.federation.AbstractFederationDetailEditor#doGetDescription()
     */
    @Override
    protected String doGetDescription() {
        return uiConstants.subsys_picketlink_security_token_service_desc();
    }
    
    /* (non-Javadoc)
     * @see org.picketlink.as.console.client.ui.federation.AbstractFederationDetailEditor#getStackName()
     */
    @Override
    public String doGetTableSectionName() {
        return "Security Token Services";
    }

    @Override
    protected boolean doInsert(SecurityTokenService serviceProvider) {
        getPresenter().getFederationManager().onCreateSecurityTokenService(serviceProvider);
        getPresenter().getDeploymentManager().restartSecurityTokenService(serviceProvider);
        return true;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see
     * org.picketlink.as.console.client.ui.federation.idp.AbstractFederationDetailEditor#onDelete(org.picketlink.as.console.
     * client.shared.subsys.model.GenericFederationEntity)
     */
    @Override
    protected void doDelete(SecurityTokenService securityTokenService) {
        this.getPresenter().getFederationManager().onRemoveSecurityTokenService(securityTokenService);
    }

    /* (non-Javadoc)
     * @see org.picketlink.as.console.client.ui.federation.AbstractFederationDetailEditor#doUpdate(org.picketlink.as.console.client.shared.subsys.model.GenericFederationEntity, java.util.Map)
     */
    public void doUpdate(SecurityTokenService securityTokenService, Map<String, Object> changedValues) {
        this.getPresenter().getFederationManager().onUpdateSecurityTokenService(securityTokenService, changedValues);
        this.getPresenter().getDeploymentManager().restartSecurityTokenService(securityTokenService);
    }

    /* (non-Javadoc)
     * @see org.picketlink.as.console.client.ui.federation.AbstractFederationDetailEditor#getWizard()
     */
    @Override
    public Wizard<SecurityTokenService> doCreateWizard() {
        return new NewSecurityTokenServiceWizard(this, getEntityClass(), getPresenter(), "security-token-service", uiConstants);
    }

    public void updateSecurityTokenServices(FederationWrapper federation) {
        setData(federation, federation.getSecurityTokenServices());
    }

}