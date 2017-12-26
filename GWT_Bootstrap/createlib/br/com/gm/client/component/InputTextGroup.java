/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.client.component;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.TextBoxBase;

/**
 *
 * @author geoleite
 */
public class InputTextGroup extends TextBox {

    private String id;
    private String hint, placeHolder;
    private String inputAddonBefore = "@";
    private String inputAddonAfter = ",00";
    private Icon.IconType iconAddonBefore, iconAddonAfter;
    private DivElement div;
    private InputText inputText;
    
    public InputTextGroup(InputText inputText) {
        this(Document.get().createDivElement());
        setInputText(inputText);
        //setAttribute("class", "form-control");
    }
    public InputTextGroup(InputText inputText, String inputAddonBefore, 
            String inputAddonAfter) {
        this(Document.get().createDivElement());
        setInputText(inputText);
        setInputAddon(inputAddonBefore, inputAddonAfter);
        //setAttribute("class", "form-control");
    }

    public InputTextGroup(InputText inputText, Icon.IconType iconAddonBefore, 
            Icon.IconType iconAddonAfter) {
        this(Document.get().createDivElement());
        setInputText(inputText);
        setIconAddon(iconAddonBefore, iconAddonAfter);
        //setAttribute("class", "form-control");
    }
    
    protected InputTextGroup(DivElement div) {
        super(div);
        this.div = div;
        setId("inputextgroup" + Random.nextInt(1000));
        div.setAttribute("class", "form-group input-group");
        setInputAddon(inputAddonBefore, inputAddonAfter);
    }

    public void setAttribute(String name, String value) {
        getElement().setAttribute(name, value);
    }

    /*
        textBox.getElement().setAttribute("class", "form-control");
        textBox.getElement().setAttribute("type", "email");
        textBox.getElement().setAttribute("aria-describedby", "emailHelp");
        textBox.getElement().setAttribute("placeholder", "Enter email");
        button.getElement().setAttribute("class", "btn btn-primary btn-block");
    
     */

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

    /**
     * @return the placeHolder
     */
    public String getPlaceHolder() {
        return placeHolder;
    }

    /**
     * @param placeHolder the placeHolder to set
     */
    public void setPlaceHolder(String placeHolder) {
        this.placeHolder = placeHolder;
        setAttribute("placeholder", placeHolder);
    }

    /**
     * @return the inputAddon
     */
    public String getInputAddonBefore() {
        return inputAddonBefore;
    }

    public String getInputAddonAfter() {
        return inputAddonAfter;
    }
    /**
     * @param inputAddon the inputAddon to set
     */
    public void setInputAddon(String inputAddonBefore, String inputAddonAfter) {
        this.inputAddonBefore = inputAddonBefore;
        this.inputAddonAfter = inputAddonAfter;
        div.removeAllChildren();
        if (inputAddonBefore != null) {
            SpanElement spanBefore = Document.get().createSpanElement();
            spanBefore.setAttribute("class", "input-group-addon");
            spanBefore.setInnerHTML(inputAddonBefore);
            div.appendChild(spanBefore);
        }
        //Inserindo o componente de texto
        if (inputText != null) {
            div.appendChild(inputText.getElement());
        }
        if (inputAddonAfter != null) {
            SpanElement spanAfter = Document.get().createSpanElement();
            spanAfter.setAttribute("class", "input-group-addon");
            spanAfter.setInnerHTML(inputAddonAfter);
            div.appendChild(spanAfter);
        }
        //getElement().getParentElement().setInnerHTML("<span class=\"input-group-addon\">" + inputAddon + "</span>");
        //setAttribute("class", "");
    }

    public void setIconAddon(Icon.IconType iconAddonBefore, Icon.IconType iconAddonAfter) {
        this.iconAddonBefore = iconAddonBefore;
        this.iconAddonAfter = iconAddonAfter;
        div.removeAllChildren();
        if (iconAddonBefore != null) {
            SpanElement spanBefore = Document.get().createSpanElement();
            spanBefore.setAttribute("class", "input-group-addon " + iconAddonBefore.getValue());
            //spanBefore.setInnerHTML(inputAddonBefore);
            div.appendChild(spanBefore);
        }
        //Inserindo o componente de texto
        if (inputText != null) {
            div.appendChild(inputText.getElement());
        }
        if (iconAddonAfter != null) {
            SpanElement spanAfter = Document.get().createSpanElement();
            spanAfter.setAttribute("class", "input-group-addon " + iconAddonAfter.getValue());
            //spanAfter.setInnerHTML(inputAddonAfter);
            div.appendChild(spanAfter);
        }
        //getElement().getParentElement().setInnerHTML("<span class=\"input-group-addon\">" + inputAddon + "</span>");
        //setAttribute("class", "");
    }
    
    /**
     * @return the inputText
     */
    public InputText getInputText() {
        return inputText;
    }

    /**
     * @param inputText the inputText to set
     */
    public void setInputText(InputText inputText) {
        this.inputText = inputText;
    }

    public String getValue() {
        if (inputText != null) {
            return inputText.getValue();
        }
        return null;
    }
    
    public void setValue(String value) {
        if (inputText != null) {
            inputText.setValue(value);
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
        div.setAttribute("id", id);
    }
}
