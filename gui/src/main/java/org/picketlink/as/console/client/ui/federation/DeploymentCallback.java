package org.picketlink.as.console.client.ui.federation;

import java.util.List;

import org.jboss.as.console.client.shared.deployment.model.DeploymentRecord;

public interface DeploymentCallback {

    void onLoadDeployments(List<DeploymentRecord> deployments);
    
}
