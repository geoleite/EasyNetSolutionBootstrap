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
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author geoleite
 */
public class MenuAccordion extends Panel {

    /*
<button class="accordion">Section 1</button>
<div class="panel">
  <p>Lorem ipsum...</p>
</div>    
     */
    private DivElement divAccordion;
    private List<Panel> listPanel = new ArrayList<Panel>();
    private String id;

    public MenuAccordion() {
        createAccordion();
    }

    public void createAccordion() {
        divAccordion = Document.get().createDivElement();
        setElement(divAccordion);
    }

    public void addPanel(Panel panel) {
        if (panel != null) {
            panel.setHeadVisible(false);
            setAttribute(panel.getElement(), "class", "panelaccordion");
            Button btn = new Button(panel.getHeading());
            btn.setId("btnaccordion-" + panel.getId());
            //setAttribute(btn.getElement(), "id", "btnaccordion-" + panel.getId());
            setAttribute(btn.getElement(), "class", "accordion");
            //setAttribute(panel.getElement(), "class", "panel");
            btn.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    accordionAction((Button) event.getSource());
                }
            });
            add(btn, divAccordion);
            add(panel, divAccordion);
            listPanel.add(panel);
        }
    }

    private void accordionAction(Button btn) {
        
        String idPanel = btn.getId().substring("btnaccordion-".length(), btn.getId().length());
        Element panel = Document.get().getElementById(idPanel);
        for (int i = 0; i < listPanel.size(); i++) {
            Panel pn = listPanel.get(i);
            if (pn.getId() == idPanel) {
                if (panel.getAttribute("style") == "display: block") {
                    setAttribute(panel, "style", "display: none");
                    setAttribute(btn.getElement(), "class", "accordion");
                } else {
                    setAttribute(panel, "style", "display: block");
                    setAttribute(btn.getElement(), "class", "accordion active");
                }
            } else {
                pn.setVisible(false);
                String idBtn = "btnaccordion-" + pn.getId();
                Element btnElement = Document.get().getElementById(idBtn);
                setAttribute(btnElement, "class", "accordion");
            }
        }
    }
}
