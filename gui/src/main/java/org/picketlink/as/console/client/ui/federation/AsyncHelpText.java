package org.picketlink.as.console.client.ui.federation;

import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.ui.VerticalPanel;
import org.jboss.as.console.client.domain.model.SimpleCallback;
import org.jboss.as.console.client.shared.help.StaticHelpPanel;
import org.jboss.as.console.client.shared.subsys.Baseadress;
import org.jboss.as.console.client.shared.subsys.security.SecurityDomainsPresenter;
import org.jboss.as.console.client.shared.subsys.security.SecurityDomainsPresenter.DescriptionCallBack;
import org.jboss.dmr.client.ModelDescriptionConstants;
import org.jboss.dmr.client.ModelNode;
import org.jboss.dmr.client.dispatch.impl.DMRAction;
import org.jboss.dmr.client.dispatch.impl.DMRResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AsyncHelpText implements SecurityDomainsPresenter.DescriptionCallBack {

    private final VerticalPanel layout;
    private boolean isDialogue;
    private String type;
    private String[] attributesNames;
    private FederationPresenter presenter;

    public AsyncHelpText(String type, String[] attributesNames, FederationPresenter presenter, VerticalPanel layout, boolean isDialogue) {
        this.layout = layout;
        this.type = type;
        this.attributesNames = attributesNames;
        this.presenter = presenter;
        getDescription(this.type, this);
        this.isDialogue = isDialogue;
    }

    @Override
    public void setDescription(ModelNode desc) {
        SafeHtmlBuilder builder = new SafeHtmlBuilder();
        if (desc.get(ModelDescriptionConstants.DESCRIPTION).isDefined()) {
            builder.appendEscaped(desc.get(ModelDescriptionConstants.DESCRIPTION).asString());
            builder.appendHtmlConstant("<p/>");
        }

        List<String> attrs = new ArrayList<String>(Arrays.asList(attributesNames));

        ModelNode values = desc.get(ModelDescriptionConstants.ATTRIBUTES);
        builder.appendHtmlConstant("<ul>");

        for (String s : attrs) {
            builder.appendHtmlConstant("<li><b>");
            builder.appendEscaped(s);
            builder.appendHtmlConstant("</b> - ");
            builder.appendEscaped(values.get(s, ModelDescriptionConstants.DESCRIPTION).asString());
        }

        builder.appendHtmlConstant("</ul>");
        SafeHtml safeHtml = builder.toSafeHtml();
        StaticHelpPanel helpPanel = new StaticHelpPanel(safeHtml);
        layout.insert(helpPanel.asWidget(), isDialogue ? 0 : 1);
    }
    
    private void getDescription(String type, final DescriptionCallBack callback) {
        ModelNode operation = createOperation(ModelDescriptionConstants.READ_RESOURCE_DESCRIPTION_OPERATION);
        operation.get(ModelDescriptionConstants.ADDRESS).add("federation", "*");
        operation.get(ModelDescriptionConstants.ADDRESS).add(type, "*");

        this.presenter.getDispatchAsync().execute(new DMRAction(operation), new SimpleCallback<DMRResponse>() {
            @Override
            public void onSuccess(DMRResponse result) {
                ModelNode response = result.get();
                ModelNode responseResult = response.get(ModelDescriptionConstants.RESULT);
                
                if (!responseResult.isDefined()) {
                    return;
                }
                
                List<ModelNode> resList = responseResult.asList();
                if (resList.size() == 0)
                    return;

                callback.setDescription(resList.get(0).get(ModelDescriptionConstants.RESULT));
            }
        });
    }

    private ModelNode createOperation(String operator) {
        ModelNode operation = new ModelNode();
        operation.get(ModelDescriptionConstants.OP).set(operator);
        operation.get(ModelDescriptionConstants.ADDRESS).set(Baseadress.get());
        operation.get(ModelDescriptionConstants.ADDRESS).add(ModelDescriptionConstants.SUBSYSTEM, "picketlink")
                .add("federation");
        return operation;
    }
    
}
