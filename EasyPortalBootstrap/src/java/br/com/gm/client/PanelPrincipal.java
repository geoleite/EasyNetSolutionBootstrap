/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.client;

import br.com.gm.client.container.Panel;
import br.com.gm.client.container.PanelGridCustom;
import br.com.gm.client.container.PanelGridSimple;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.sun.faces.taglib.html_basic.PanelGridTag;

/**
 *
 * @author geoleite
 */
public class PanelPrincipal extends PanelGridSimple{
    protected DivElement divLeft, divCenter, divTop;
    public PanelPrincipal() {
        super(1);
        setAttribute(getDiv(), "class", "container-general");
        getDiv().removeAllChildren();
        createTop();
        //createLeft();
        createCenter();
    }
    
    private void createTop() {
        divTop = Document.get().createDivElement();        
        getDiv().appendChild(divTop);
        setAttribute(divTop, "class", "top-panel");
        
    }
    private void createLeft() {
        divLeft = Document.get().createDivElement();
        getDiv().appendChild(divLeft);
        setAttribute(divLeft, "class", "left-panel");
    }
    private void createCenter() {
        divCenter = Document.get().createDivElement();
        getDiv().appendChild(divCenter);
        setAttribute(divCenter, "class", "center-panel");
    }
}
