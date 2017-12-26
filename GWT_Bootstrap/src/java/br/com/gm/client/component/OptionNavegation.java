/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.client.component;

import br.com.gm.client.container.Panel;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.LIElement;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.dom.client.UListElement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author geoleite
 */
public class OptionNavegation extends Panel {

    private Link link;
    private String actionID;
    private Icon.IconType icon = Icon.IconType.HOME;
    private boolean root = true, separator=false;
    private OptionNavegation parent = null;
    private List<OptionNavegation> subOption = new ArrayList<OptionNavegation>();

    public OptionNavegation() {
        this(new Link("ROOT", "#"), Icon.IconType.NULL, "", true);
    }
    
    public OptionNavegation(boolean separator) {
        //this(new Link("ROOT", "#"), "", "", true);
        this(null, Icon.IconType.NULL);
        setSeparator(separator);
    }

    public OptionNavegation(Link link, Icon.IconType icon) {
        setLink(link);
        setIcon(icon);
        setRoot(false);
    }

    public OptionNavegation(Link link, Icon.IconType icon, String actionID) {
        setLink(link);
        setIcon(icon);
        setActionID(actionID);
        setRoot(false);
    }
    
    

    public OptionNavegation(Link link, Icon.IconType icon, String actionID, boolean isRoot) {
        setLink(link);
        setRoot(isRoot);
        setIcon(icon);
        setActionID(actionID);
    }

    public void setAttribute(Element element, String name, String value) {
        element.setAttribute(name, value);
    }

    public void addItem(OptionNavegation item) {
        if (item != null) {
            if (!"ROOT".equals(link.getText())) {
                setRoot(false);
            }
            //defineFirstSubLink();
            item.setParent(this);
            subOption.add(item);
        }
    }

    public boolean hasChild() {
        return subOption.size() > 0;
    }

    public Element createStructure() {
        return null;
    }

    private void defineFirstSubLink() {
        //li = Document.get().createLIElement();
        //ul = Document.get().createULElement();
        //li.appendChild(ul);        
        link.setAttribute("href", "#");
        link.setAttribute("class", "dropdown-toggle");
        link.setAttribute("data-toggle", "dropdown");
        link.setAttribute("aria-expanded", "false");

        SpanElement span = Document.get().createSpanElement();
        setAttribute(span, "class", "caret");
        getElement().appendChild(span);
        span = Document.get().createSpanElement();
        setAttribute(span, "style", "font-size:16px;");
        //glyphicon-user
        setAttribute(span, "class", "pull-right hidden-xs showopacity glyphicon ");
        link.getElement().appendChild(span);
    }

    /**
     * @return the link
     */
    public Link getLink() {
        return link;
    }

    /**
     * @param link the link to set
     */
    public void setLink(Link link) {
        if (link == null) {
            this.link = new Link("ROOT");
        } else {
            this.link = link;
        }
    }

    /**
     * @return the root
     */
    public boolean isRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    public void setRoot(boolean root) {
        this.root = root;
    }

    /**
     * @return the parent
     */
    public OptionNavegation getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(OptionNavegation parent) {
        this.parent = parent;
    }

    /**
     * @return the subOption
     */
    public List<OptionNavegation> getSubOption() {
        return subOption;
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
    }

    /**
     * @return the actionID
     */
    public String getActionID() {
        return actionID;
    }

    /**
     * @param actionID the actionID to set
     */
    public void setActionID(String actionID) {
        this.actionID = actionID;
    }

    /**
     * @return the separator
     */
    public boolean isSeparator() {
        return separator;
    }

    /**
     * @param separator the separator to set
     */
    public void setSeparator(boolean separator) {
        this.separator = separator;
    }
}
