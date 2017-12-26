/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.client.container;

import br.com.gm.client.component.Link;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.ScriptElement;
import com.google.gwt.dom.client.Text;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author geoleite
 */
public class MenuResponsive extends FlowPanel {  
    /*
 <div class="topnav" id="myTopnav">
  <a href="#home" class="active">Home</a>
  <a href="#news">News</a>
  <a href="#contact">Contact</a>
  <a href="#about">About</a>
  <a href="javascript:void(0);" class="icon" onclick="myFunction()">&#9776;</a>
</div>     */
    
    private DivElement divMenu;
    private ScriptElement script;
    private String id;
    private List<Widget> list = new ArrayList<Widget>();
    public MenuResponsive() {        
        setId("menu-" + Random.nextInt(100));
        createMenu();
    }
    private void createMenu() {
        divMenu = Document.get().createDivElement();
        setAttribute(divMenu, "class", "topnav");
        setAttribute(divMenu, "id", id);
        setElement(divMenu);
        //createScript();
        
        Link linkOpen = new Link("&#9776;", "javascript:void(0);");
        setAttribute(linkOpen.getElement(), "class", "icon");
        //setAttribute(linkClose.getElement(), "onclick", "menuFunction()");
        linkOpen.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (divMenu.getAttribute("class").equals("topnav")) {
                    appendAttribute(divMenu, "class", "responsive");
                } else {
                    setAttribute(divMenu, "class", "topnav");
                }
            }
        });
        Link linkTeste1 = new Link("Home", "#");
        setAttribute(linkTeste1.getElement(), "class", "active");
        Link linkTeste2 = new Link("Casa", "#");
        add(linkTeste1, divMenu);
        add(linkTeste2, divMenu);
        add(linkOpen, divMenu);        
    }
    
    
    public void addOption(Link widget) {
        add(widget, divMenu);
    }
    
    public void appendAttribute(Element element, String name, String value) {
        String valueAttr = element.getAttribute(name);
        valueAttr += " " + value;
        element.setAttribute(name, valueAttr);
    }
    
    public void setAttribute(Element element, String name, String value) {
        element.setAttribute(name, value);
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
    }
}
