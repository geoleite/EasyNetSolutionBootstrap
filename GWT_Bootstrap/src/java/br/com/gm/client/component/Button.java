/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.client.component;

import br.com.gm.client.component.data.Field;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.user.client.Random;

/**
 *
 * @author geoleite
 */
public class Button extends com.google.gwt.user.client.ui.Button {

    private boolean block = false;
    private boolean outline = false;
    private boolean circle = false;
    private String hint;
    private String id;
    private Field object;
    private String badge = null;
    private Icon.IconType icon;

    public Button() {
        this("");
    }

    public Button(Field object, String value) {
        this(value);
        this.setObject(object);
    }

    public Button(String value) {
        super(value);
        //getElement().setAttribute("class", "btn");
        setAttribute("class", "btn");
        id = "btn" + Random.nextInt();
        setAttribute("id", id);
        setBlock(block);
        setOutline(outline);
        setEnabled(true);
        setModelSize(ModelSize.DEFAULT);
        setButtonType(ButtonType.DEFAULT);
    }

    public Button(String value, ButtonType buttonType) {
        this(value);
        setButtonType(buttonType);
    }

    public Button(String value, ButtonType buttonType, Icon.IconType icon) {
        this(value);
        setButtonType(buttonType);
        setIcon(icon);
    }
    
    public Button(String value, ButtonType buttonType, ModelSize modelSize) {
        this(value, buttonType);
        setModelSize(modelSize);
    }

    public Button(String value, ButtonType buttonType, ModelSize modelSize,
            Icon.IconType icon) {
        this(value, buttonType, icon);
        setModelSize(modelSize);
    }
    
    public void setAttribute(String name, String value) {
        getElement().setAttribute(name, value);
    }

    /**
     * @return the block
     */
    public boolean isBlock() {
        return block;
    }

    /**
     * @param block the block to set
     */
    public void setBlock(boolean block) {
        this.block = block;
        if (block) {
            appendAttribute("class", "btn-block");
        }
    }

    /**
     * @return the outline
     */
    public boolean isOutline() {
        return outline;
    }

    /**
     * @param outline the outline to set
     */
    public void setOutline(boolean outline) {
        this.outline = outline;
        if (this.outline) {
            appendAttribute("class", "btn-outline");
        }
    }

    public void appendAttribute(String name, String value) {
        String valueAttr = getElement().getAttribute(name);
        valueAttr += " " + value;
        getElement().setAttribute(name, valueAttr);

    }

    /**
     * @param enabled the enabled to set
     */
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if (!isEnabled()) {
            appendAttribute("class", "disabled");
        }

    }

    /**
     * @return the circle
     */
    public boolean isCircle() {
        return circle;
    }

    /**
     * @param circle the circle to set
     */
    public void setCircle(boolean circle) {
        this.circle = circle;
        if (circle) {
            appendAttribute("class", "btn-circle");
            //super.setHTML("<i class=\"fa fa-list\"> </i>");
        }
    }

    public void setCircleType(ButtonCircleType circleType) {
        setCircle(true);
        //appendAttribute("class", "btn-circle");
        String value = "<i class=\"VALUE\"> </i>";
        value = value.replace("VALUE", circleType.getValue());
        super.setHTML(value);
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
        setAttribute("data-original-title", hint);
        setAttribute("data-placement", "top");
        setAttribute("data-toggle", "tooltip");
        setAttribute("title", hint);
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
     * @return the object
     */
    public Field getObject() {
        return object;
    }

    /**
     * @param object the object to set
     */
    public void setObject(Field object) {
        this.object = object;
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
     * @return the icon
     */
    public Icon.IconType getIcon() {
        return icon;
    }

    /**
     * @param icon the icon to set
     */
    public void setIcon(Icon.IconType icon) {
        this.icon = icon;
        if (icon != null) {
            SpanElement span = Document.get().createSpanElement();
            span.setAttribute("class", icon.getValue());
            getElement().appendChild(span);
        }
    }

    public static enum ModelSize {
        MINI("btn-xs"), SMALL("btn-sm"), DEFAULT(""), LARGER("btn-lg"),
        EXTRA_LARGER("btn-xl");
        private String value;

        ModelSize(String model) {
            this.value = model;
        }

        public String getValue() {
            return value;
        }
    };

    public static enum ButtonType {
        SUCCESS("btn-success"), DEFAULT("btn-default"), INFO("btn-info"),
        PRIMARY("btn-primary"), DANGER("btn-danger"), WARNING("btn-warning"),
        LINK("btn-link");
        private String value;

        ButtonType(String type) {
            this.value = type;
        }

        public String getValue() {
            return value;
        }
    };

    public static enum ButtonCircleType {
        CHECK("fa fa-check"), LIST("fa fa-list"), LINK("fa fa-link"),
        WARNING("fa fa-times"), DANGER("fa fa-heart");
        private String value;

        ButtonCircleType(String type) {
            this.value = type;
        }

        public String getValue() {
            return value;
        }
    };



    public void setModelSize(ModelSize modelSize) {
        appendAttribute("class", modelSize.getValue());
    }

    public void setButtonType(ButtonType buttonType) {
        setAttribute("class", "btn " + buttonType.getValue());
    }
}
