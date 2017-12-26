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
import com.google.gwt.user.client.ui.ButtonBase;
import com.google.gwt.user.client.ui.RadioButton;

/**
 *
 * @author geoleite
 */
public class Radio extends ButtonBase {
    private LabelElement lab;
    private InputElement input;
    private boolean enabled, inLine;
    private String hint, value="", label="", name;
    private String id;

    public Radio(String name) {
        super(Document.get().createDivElement());
        createDiv();
        this.name = name;
        setId("radio" + Random.nextInt(1000));
    }
    
    public Radio(String name, String label) {
        this(name);
        setLabel(label);
    }
    public void setAttribute(Element element, String name, String value) {
        element.setAttribute(name, value);
    }
    
    private void createDiv() {        
        setAttribute(getElement(), "class", "radio");
        createLabel();
    }
    
    private void createLabel() {
        getElement().removeAllChildren();
        lab = Document.get().createLabelElement();
        getElement().appendChild(lab);
        createRadio();
        lab.appendChild(Document.get().createTextNode(getLabel()));
    }
    
    private void createRadio() {        
        input = Document.get().createCheckInputElement();
        lab.appendChild(input);
        setAttribute(input, "type", "radio");
        setAttribute(input, "name", name);
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
    protected void setName(String name) {
        this.name = name;
        if (name != null) {
            createLabel();
        }
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
     * @return the enable
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * @param enable the enable to set
     */
    public void setEnable(boolean enabled) {
        this.enabled = enabled;
        if (enabled) {
            setAttribute(getElement(), "class", "radio");
            input.removeAttribute("disabled");
        } else {
            setAttribute(getElement(), "class", "radio disabled");
            setAttribute(input, "disabled", "");
        }        
    }

    /**
     * @return the inLine
     */
    public boolean isInLine() {
        return inLine;
    }

    /**
     * @param inLine the inLine to set
     */
    public void setInLine(boolean inLine) {
        this.inLine = inLine;
        if (inLine) {
            setAttribute(lab, "class", "radio-inline");
        } else {
            lab.removeAttribute("class");
        }
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
