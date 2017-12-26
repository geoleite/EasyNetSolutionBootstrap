/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.client.component;

import com.google.gwt.user.client.ui.ListBox;
import java.util.ArrayList;
import java.util.List;
import br.com.gm.client.model.ModelBase;
import com.google.gwt.user.client.Random;

/**
 *
 * @author geoleite
 */
public class ComboBox<T extends ModelBase> extends ListBox {
    private List<T> list = new ArrayList<T>();
    private boolean multiple=false;
    private String hint;
    private String id;
    
    public ComboBox() {
        getElement().setAttribute("class", "form-control");
        setId("combo" + Random.nextInt(1000));
    }
    
    public void addItem(T item) {
        getList().add(item);
        super.addItem(item.getValueDisplay(), item.getValue());
    }
    
    public T getValue() {
        int idx = super.getSelectedIndex();
        return getList().get(idx);
    }

    /**
     * @return the hint
     */
    public String getHint() {
        return hint;
    }

    /**
     * @param hint the hint to set
     */
    public void setHint(String hint) {
        this.hint = hint;
        setAttribute("aria-describedby", hint);
        setAttribute("data-placement", "top");
        setAttribute("data-toggle", "tooltip");
        setAttribute("title", hint);
        
    }
    
    public void setAttribute(String name, String value) {
        getElement().setAttribute(name, value);
    }

    /**
     * @return the multiple
     */
    public boolean isMutiple() {
        return multiple;
    }

    /**
     * @param mutiple the mutiple to set
     */
    public void setMultiple(boolean multiple) {
        this.multiple = multiple;
        if (multiple) {            
            setAttribute("multiple", "true");
        } else {
            getElement().removeAttribute("multiple");
        }
    }

    /**
     * @return the list
     */
    public List<T> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<T> list) {
        this.list = list;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
        getElement().setAttribute("id", id);
    }
}
