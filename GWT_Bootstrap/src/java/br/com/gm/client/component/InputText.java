/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.client.component;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.ScriptElement;
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
public class InputText extends TextBox {

    private boolean emailModel = false, upperCase = false, password = false;
    private String hint, placeHolder;
    private String id;
    private String mask;
    private ScriptElement script;

    public InputText() {
        setId("inputtext" + Random.nextInt(1000));
        setAttribute("class", "form-control");
        addKeyUpHandler(new KeyUpHandler() {
            @Override
            public void onKeyUp(KeyUpEvent event) {
                if (upperCase) {
                    int positionCursor = InputText.this.getCursorPos();
                    String text = (String) InputText.this.getValue();
                    text = text.toUpperCase();
                    InputText.this.setValue(text);
                    InputText.this.setCursorPos(positionCursor);
                }
            }
        });
//        addKeyPressHandler(new KeyPressHandler() {
//            @Override
//            public void onKeyPress(KeyPressEvent event) {
//                //event.stopPropagation();
//                if (upperCase) {
//                    int positionCursor = InputText.this.getCursorPos();
//                    String text = (String) InputText.this.getValue();
//                    text = text.toUpperCase();
//                    InputText.this.setValue(text);
//                    InputText.this.setCursorPos(positionCursor);
//                }
//            }
//        });
    }

    public InputText(boolean password) {
        this();
        setPassword(password);
    }

    public InputText(String mask) {
        this();
        setMask(mask);
    }

    public void setAttribute(String name, String value) {
        getElement().setAttribute(name, value);
    }

    /**
     * @return the emailModel
     */
    public boolean isEmailModel() {
        return emailModel;
    }

    /**
     * @param emailModel the emailModel to set
     */
    public void setEmailModel(boolean emailModel) {
        this.emailModel = emailModel;
        setAttribute("type", "email");
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
     * @return the upperCase
     */
    public boolean isUpperCase() {
        return upperCase;
    }

    /**
     * @param upperCase the upperCase to set
     */
    public void setUpperCase(boolean upperCase) {
        this.upperCase = upperCase;
    }

    @Override
    public void setValue(String value) {
        if (!password) {
            if (upperCase && value != null) {
                value = value.toUpperCase();
            }
            super.setValue(value);
        }
    }

    /**
     * @return the password
     */
    public boolean isPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(boolean password) {
        this.password = password;
        setAttribute("type", password ? "password" : "text");
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

    /**
     * @return the mask
     */
    public String getMask() {
        return mask;
    }

    /**
     * @param mask the mask to set
     */
    public void setMask(String mask) {
        this.mask = mask;
        if (mask != null && mask.trim().length() > 0) {
            if (script == null) {
                String sourceJS = "$('#" + getId() + "').mask('" + mask + "', {reverse: false});";
                script = Document.get().createScriptElement(sourceJS);
                getElement().appendChild(script);
            }
        }
    }
}
