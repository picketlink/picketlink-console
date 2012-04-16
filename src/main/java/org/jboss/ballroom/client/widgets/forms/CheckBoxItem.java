package org.jboss.ballroom.client.widgets.forms;

import com.google.gwt.dom.client.Element;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Widget;

public class CheckBoxItem extends FormItem<Boolean> {

    private CheckBox checkBox;

    public CheckBoxItem(String name, String title) {
        super(name, title);
        checkBox = new CheckBox();
        checkBox.setTabIndex(0);
        checkBox.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
            @Override
            public void onValueChange(ValueChangeEvent<Boolean> booleanValueChangeEvent) {
                setModified(true);
                doValueChange();
            }
        });
        setUndefined(false);
    }

    protected void doValueChange() {
        
    }

    @Override
    public Element getInputElement() {
        return checkBox.getElement().getFirstChildElement();
    }

    @Override
    public void resetMetaData() {
        super.resetMetaData();
        setUndefined(false); // implicitly defined
        checkBox.setValue(false);
    }

    @Override
    public Boolean getValue() {
        return checkBox.getValue();
    }

    @Override
    public void setValue(Boolean value) {
        checkBox.setValue(value);
    }

    @Override
    public Widget asWidget() {
        return checkBox;
    }

    @Override
    public void setEnabled(boolean b) {
        checkBox.setEnabled(b);
    }

    @Override
    public boolean validate(Boolean value) {
        return true;
    }

    @Override
    public void clearValue() {
        setValue(false);
    }
}
