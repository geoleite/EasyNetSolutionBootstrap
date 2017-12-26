/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.client.component.event;

import br.com.gm.client.model.ModelBase;
import com.google.gwt.user.client.ui.Widget;

/**
 *
 * @author geoleite
 */
public class Event<T extends ModelBase> {
    private Widget source;
    private T value;

    /**
     * @return the source
     */
    public Widget getSource() {
        return source;
    }

    /**
     * @param source the source to set
     */
    public void setSource(Widget source) {
        this.source = source;
    }

    /**
     * @return the value
     */
    public T getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(T value) {
        this.value = value;
    }
    
    
}
