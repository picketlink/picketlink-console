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

import static org.jboss.dmr.client.ModelDescriptionConstants.ADDRESS;
import static org.jboss.dmr.client.ModelDescriptionConstants.OP;

import javax.inject.Inject;

import com.google.gwt.user.client.rpc.AsyncCallback;
import org.jboss.as.console.client.core.ApplicationProperties;
import org.jboss.as.console.client.shared.BeanFactory;
import org.jboss.as.console.client.shared.deployment.model.DeploymentRecord;
import org.jboss.as.console.client.shared.dispatch.DispatchAsync;
import org.jboss.as.console.client.shared.dispatch.impl.DMRAction;
import org.jboss.as.console.client.shared.dispatch.impl.DMRResponse;
import org.jboss.dmr.client.ModelNode;

/**
 * <p>
 * Implementation of {@link FederationStore}.
 * </p>
 * 
 * @author<a href="mailto:psilva@redhat.com">Pedro Silva</a>
 * @since Mar 14, 2012
 */
public class DeploymentFederationStoreImpl implements DeploymentFederationStore {

    private DispatchAsync dispatcher;

    @Inject
    public DeploymentFederationStoreImpl(DispatchAsync dispatcher, BeanFactory factory, ApplicationProperties bootstrap) {
        this.dispatcher = dispatcher;
    }

    @Override
    public void redeploy(DeploymentRecord deploymentRecord, AsyncCallback<DMRResponse> callback) {
        doDeploymentCommand(deploymentRecord, makeOperation("redeploy", deploymentRecord.getServerGroup(), deploymentRecord), callback);
    }
    
    private ModelNode makeOperation(String command, String serverGroup, DeploymentRecord deployment) {
        ModelNode operation = new ModelNode();
        if ((serverGroup != null) && (!serverGroup.equals(""))) {
            operation.get(ADDRESS).add("server-group", serverGroup);
        }

        operation.get(ADDRESS).add("deployment", deployment.getName());
        operation.get(OP).set(command);
        return operation;
    }

    private void doDeploymentCommand(final DeploymentRecord deploymentRecord, ModelNode operation,
                                     final AsyncCallback<DMRResponse> callback) {
        dispatcher.execute(new DMRAction(operation), new AsyncCallback<DMRResponse>() {

            @Override
            public void onFailure(Throwable caught) {
                callback.onFailure(caught);
            }

            @Override
            public void onSuccess(DMRResponse response) {
                ModelNode result = response.get();
                
                if (result.isFailure()) {
                    deploymentRecord.setEnabled(false);
                } else {
                    deploymentRecord.setEnabled(true);
                }
                
                callback.onSuccess(response);
            }
        });
    }

}
