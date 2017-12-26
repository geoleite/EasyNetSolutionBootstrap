/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.client.component.event;
import br.com.gm.client.component.ComboBox;
import br.com.gm.client.model.ModelBase;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
/**
 *
 * @author geoleite
 */
public abstract class OnChangeEvent <T extends ModelBase> implements ChangeHandler {

    @Override
    public void onChange(ChangeEvent event) {
        ComboBox<T> cb = (ComboBox<T>) event.getSource();
        Event e = new Event();
        e.setSource(cb);
        e.setValue(cb.getValue());
        onChange(e);
        
    }
    
    public abstract void onChange(Event<T> event);
    
}
