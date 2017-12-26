/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.client.component;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.dom.client.LabelElement;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.Window;


/**
 * <div class="checkbox">
     <label><input type="checkbox" value="">Option 1</label>
   </div>
 * @author geoleite
 */
public class CheckBox extends com.google.gwt.user.client.ui.CheckBox{
    private DivElement div;
    private LabelElement lab;
    private InputElement input;
    private String hint, value="", label="", name;
    private String id;
    
    public CheckBox() {
        createDiv();
        setId("check"+Random.nextInt(1000));
    }
    
    public CheckBox(String label) {
        this();
        setLabel(label);
    }
    public void setAttribute(Element element, String name, String value) {
        element.setAttribute(name, value);
    }
    
    private void createDiv() {        
        div = Document.get().createDivElement();
        setElement(div);
        setAttribute(div, "class", "checkbox");
        createLabel();
    }
    
    private void createLabel() {
        div.removeAllChildren();
        lab = Document.get().createLabelElement();
        div.appendChild(lab);
        createCheck();
        lab.appendChild(Document.get().createTextNode(label));
    }
    
    private void createCheck() {
        input = Document.get().createCheckInputElement();     
        lab.appendChild(input);
        setAttribute(input, "value", value);
    }

    @Override
    public void setEnabled(boolean enabled) {        
        if (enabled) {
            setAttribute(div, "class", "checkbox");
            input.removeAttribute("disabled");
        } else {
            setAttribute(div, "class", "checkbox disabled");
            setAttribute(input, "disabled", "");
        }
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
    }

    @Override
    public Boolean getValue() {
        return input.isChecked();
    }
  
    public String getValueCheck() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValueCheck(String value) {
        this.value = value;
    }

    @Override
    public void setValue(Boolean value) {
        input.setChecked(value);
    }
    
    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
        createLabel();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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
        setAttribute(div, "id", id);
    }
}