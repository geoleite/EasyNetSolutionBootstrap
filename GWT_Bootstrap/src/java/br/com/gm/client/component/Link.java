/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.client.component;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.LIElement;
import com.google.gwt.dom.client.Node;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.dom.client.UListElement;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Hyperlink;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author geoleite
 */
public class Link extends Anchor {

    private String url = "";
    private String hint, badge;
    private String id;
    private List<Link> subLinks = new ArrayList<Link>();
    private LIElement li;
    private UListElement ul;

    public Link() {
        super();
//        NodeList nl =  getElement().getChildNodes();
//        Node anchor = nl.getItem(0);
//        anchor.removeFromParent();
//        setElement((Element)anchor);
        //setAttribute(getElement(), "class", "");
        setUrl("#");
        setBadge(badge);
        setId("link" + Random.nextInt(1000));
    }

    public Link(String value) {
        this();
        setText(value);
    }

    public Link(String value, String url) {
        this();
        setText(value);
        setUrl(url);
    }

    public Link(String value, String hint, String url) {
        this();
        setText(value);
        setUrl(url);
        setHint(hint);
    }

    public void setAttribute(String name, String value) {
        getElement().setAttribute(name, value);
    }

    public void appendAttribute(Element element, String name, String value) {
        String valueAttr = element.getAttribute(name);
        valueAttr += " " + value;
        element.setAttribute(name, valueAttr);
    }

    public void setAttribute(Element element, String name, String value) {
        element.setAttribute(name, value);
    }

    public void addDropdown(Link link) {
        if (link != null) {
            addSubLink(link);
        }
    }

    private void addSubLink(Link link) {
        if (subLinks.size() == 0) {
            defineFirstSubLink();            
        }
        setAttribute(ul, "class", "dropdown-menu for animate");
        setAttribute(ul, "role", "menu");
        LIElement li = Document.get().createLIElement();
        ul.appendChild(li);
        
    }

    public void defineFirstSubLink() {
        //li = Document.get().createLIElement();
        //ul = Document.get().createULElement();
        //li.appendChild(ul);        
        setAttribute("href", "#");
        setAttribute("class", "dropdown-toggle");
        setAttribute("data-toggle", "dropdown");
        setAttribute("aria-expanded", "false");

        SpanElement span = Document.get().createSpanElement();
        setAttribute(span, "class", "caret");
        getElement().appendChild(span);
        span = Document.get().createSpanElement();
        setAttribute(span, "style", "font-size:16px;");
        //glyphicon-user
        setAttribute(span, "class", "pull-right hidden-xs showopacity glyphicon ");
        getElement().appendChild(span);
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
        setAttribute(getElement(), "href", url);
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
}
