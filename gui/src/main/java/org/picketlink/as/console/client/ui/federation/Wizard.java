package org.picketlink.as.console.client.ui.federation;

import com.google.gwt.user.client.ui.Widget;

public interface Wizard<T> {
 
    void edit(T object);
    Widget asWidget();
    Wizard setIsDialogue(boolean b);
    void clearValues();
}