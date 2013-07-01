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

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.inject.Inject;
import org.jboss.as.console.client.Console;
import org.jboss.as.console.client.domain.model.SimpleCallback;
import org.jboss.as.console.client.shared.deployment.DeploymentStore;
import org.jboss.as.console.client.shared.deployment.model.DeploymentRecord;
import org.jboss.as.console.client.shared.dispatch.impl.DMRResponse;
import org.jboss.ballroom.client.widgets.window.Feedback;
import org.jboss.dmr.client.ModelNode;
import org.picketlink.as.console.client.shared.subsys.model.DeploymentFederationStore;
import org.picketlink.as.console.client.shared.subsys.model.IdentityProvider;
import org.picketlink.as.console.client.shared.subsys.model.SecurityTokenService;
import org.picketlink.as.console.client.shared.subsys.model.ServiceProvider;

/**
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 *
 */
public class DeploymentManager {
    
    private DeploymentStore deploymentStore;
    private DeploymentFederationStore deploymentFederationStore;

    @Inject
    public DeploymentManager(DeploymentFederationStore deploymentFederationStore, DeploymentStore deploymentStore) {
        this.deploymentFederationStore = deploymentFederationStore;
        this.deploymentStore = deploymentStore;
    }
    
    public void restartIdentityProvider(IdentityProvider identityProvider) {
        identityProvider.setName(identityProvider.getName());
        identityProvider.setRuntimeName(identityProvider.getName());
        redeployDeployment(identityProvider);
    }

    public void restartServiceProvider(ServiceProvider serviceProvider) {
        serviceProvider.setName(serviceProvider.getName());
        serviceProvider.setRuntimeName(serviceProvider.getName());
        redeployDeployment(serviceProvider);
    }
    
    /**
     * <p>
     * Load all available deployments. This deployments will me used during the configuration of Identity Providers and Service
     * Providers.
     * </p>
     */
    public void loadDeployments(final DeploymentCallback callback) {
        this.deploymentStore.loadDeployments(new SimpleCallback<List<DeploymentRecord>>() {

            @Override
            public void onSuccess(List<DeploymentRecord> result) {
                callback.onLoadDeployments(result);
            }
        });
    }
    
    public void redeployDeployment(final DeploymentRecord record) {
        final PopupPanel loading = Feedback.loading(Console.CONSTANTS.common_label_plaseWait(),
                Console.CONSTANTS.common_label_requestProcessed(), new Feedback.LoadingCallback() {
                    @Override
                    public void onCancel() {

                    }
                });

        deploymentFederationStore.redeploy(record, new SimpleCallback<DMRResponse>() {

            @Override
            public void onSuccess(DMRResponse response) {
                loading.hide();

                ModelNode result = response.get();

                if (result.isFailure()) {
                    Window.alert("Could not undeploy the deployment " + record.getName() + ". Make sure it is deployed and check the logs.");
                    Console.error(Console.MESSAGES.modificationFailed("Deployment " + record.getRuntimeName()),
                            result.getFailureDescription());
                } else {
                    Console.info(Console.MESSAGES.modified("Deployment " + record.getRuntimeName()));
                }
            }
        });
    }

    public void restartSecurityTokenService(SecurityTokenService serviceProvider) {
        
    }
    
}
