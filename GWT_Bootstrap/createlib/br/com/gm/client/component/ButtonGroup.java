/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.client.component;

import br.com.gm.client.container.Panel;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author geoleite
 */
public class ButtonGroup extends Panel {

    private DivElement divGroup;
    private List<Button> list = new ArrayList<Button>();

    public ButtonGroup() {
        createGroup();
    }

    public void setAttribute(Element element, String name, String value) {
        element.setAttribute(name, value);
    }

    private void createGroup() {
        divGroup = Document.get().createDivElement();
        setElement(divGroup);
        setAttribute(divGroup, "class", "btn-group");
    }

    public void addButton(Button btn) {
        if (btn != null) {
            add(btn, divGroup);
        }
    }

    public void addLink(Link link) {
        if (link != null) {
            add(link, divGroup);
        }
    }
    
}
