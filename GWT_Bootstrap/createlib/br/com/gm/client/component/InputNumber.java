/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.client.component;

import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.ui.TextBox;

/**
 *
 * @author geoleite
 */
public class InputNumber extends TextBox {

    private String hint, placeHolder;
    private static final String CONST_DIGITO = "0123456789";
    private String id;

    public InputNumber() {
        setId("inputnumber" + Random.nextInt(1000));
        setAttribute("class", "form-control");
        //setAttribute("type", "number");
        setAttribute("onkeypress", "return isNumberKey(event)");//onkeypress="return isNumberKey(event);
        addKeyPressHandler(new KeyPressHandler() {
            @Override
            public void onKeyPress(KeyPressEvent event) {
                
                if (!CONST_DIGITO.contains("" + event.getCharCode())) {
                    event.stopPropagation();
                } else {
                    
                    int positionCursor = InputNumber.this.getCursorPos();
                    String text = (String) InputNumber.this.getValue();
                    text = text.toUpperCase();
                    InputNumber.this.setValue(text);
                    InputNumber.this.setCursorPos(positionCursor);
                }
            }
        });
    }
    
    private static native void isNumberKey(Object evt)/*-{
        var charCode = (evt.which) ? evt.which : evt.keyCode
        return !(charCode > 31 && (charCode < 48 || charCode > 57));            
      }-*/;
    

    public void setAttribute(String name, String value) {
        getElement().setAttribute(name, value);
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
        setAttribute("id", id);
    }
}
