/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.client.component;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.user.client.Random;

/**
 *
 * @author geoleite
 */
public class Label extends com.google.gwt.user.client.ui.Label {
    private String hint, badge;
    private String id;

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
        setAttribute("data-original-title", hint);
        setAttribute("data-placement", "top");
        setAttribute("data-toggle", "tooltip");
        setAttribute("title", hint);
    }

    /**
     * @return the badge
     */
    public String getBadge() {
        return badge;
    }

    /**
     * @param badge the badge to set
     */
    public void setBadge(String badge) {
        this.badge = badge;
        if (badge != null) {
            SpanElement span = Document.get().createSpanElement();
            span.setAttribute("class", "badge");
            span.appendChild(Document.get().createTextNode(badge));
            getElement().appendChild(span);
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
        setAttribute("id", id);
    }
    public static enum BGTextType {
        SUCCESS("bg-success"), INFO("bg-info"), 
        PRIMARY("bg-primary"), DANGER("bg-danger"), WARNING("bg-warning"),
        SECUNDARY("bg-secondary"), DARK("bg-dark"), LIGHT("bg-light");
        private String value;

        BGTextType(String type) {
            this.value = type;
        }

        public String getValue() {
            return value;
        }
    };
        
    public static enum TextType {
        SUCCESS("text-success"), DEFAULT("btn-default"), INFO("text-info"), 
        PRIMARY("text-primary"), DANGER("text-danger"), WARNING("text-warning"),
        MUTED("text-muted"), SECUNDARY("text-secondary"), WHITE("text-white"), 
        DARK("text-dark"), LIGHT("text-light");
        private String value;

        TextType(String type) {
            this.value = type;
        }

        public String getValue() {
            return value;
        }
    };
    
    public Label() {
        this("");
    }
    
    public Label(String value) {
        super(value);
        setBadge(null);
        setId("label" + Random.nextInt(1000) );
    }
    public void setAttribute(String name, String value) {
        getElement().setAttribute(name, value);
    }

    public void setTextType(TextType textType) {
        setAttribute("class", textType.getValue());
    }

    public void setBGTextType(BGTextType bgtextType) {
        setAttribute("class", bgtextType.getValue());
    }

    public Label getClone() {
        Label label = new Label(getText());
        return label;
    }
    
}
