/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.client.container;

import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.LinkElement;
import com.google.gwt.dom.client.Text;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.Window;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author geoleite
 */
public class PanelAccordion extends Panel {

    private DivElement divAccordion;
    private List<Panel> listPanel = new ArrayList<Panel>();
    private String id;

    public PanelAccordion() {
        divAccordion = Document.get().createDivElement();
        id = "accordion" + Random.nextInt();
        setAttribute(divAccordion, "id", id);
        setAttribute(divAccordion, "class", "panel-group");
        //getDivBody().appendChild(divAccordion);
        setPanelType(getPanelType());
        getDivBody().appendChild(divAccordion);
    }

    private Panel getPanel(Panel panel) {
        for (int i = 0; i < listPanel.size(); i++) {
            Panel pn = listPanel.get(i);
            if (pn.getId().equals(panel.getId())) {
                return pn;
            }
        }
        return null;
    }
    
    public boolean existPanel(Panel panel) {
        return getPanel(panel) != null;
    }    
    
    public void removePanel(Panel panel) {
        Panel pn = getPanel(panel);
        pn.removeFromParent();
        listPanel.remove(pn);
    }
    
    public void addPanel(Panel panel) {
        if (panel != null) {
            try {
                panel.removeFromParent();
            } catch (Exception e) {
            }

            panel.setFooter(null);
            panel.setPanelType(getPanelType());

            Element h4 = Document.get().createElement("h4");
            String titlePanel = panel.getHeading();
            panel.getDivHeading().removeAllChildren();
            panel.getDivHeading().appendChild(h4);
            setAttribute(h4, "class", "panel-title");

            String idCollapse = "collapse" + Random.nextInt(100);
            AnchorElement link = Document.get().createAnchorElement();
            setAttribute(link, "class", "");
            setAttribute(link, "data-toggle", "collapse");
            setAttribute(link, "data-parent", "#" + id);
            setAttribute(link, "href", "#" + idCollapse);
            setAttribute(link, "aria-expanded", "false");
            //data-toggle="collapse" data-parent="#accordion" href="#collapseOne"
            Text txtH = Document.get().createTextNode(titlePanel);
            link.appendChild(txtH);
            h4.appendChild(link);

            DivElement divCollapse = Document.get().createDivElement();
            setAttribute(divCollapse, "id", idCollapse);
            setAttribute(divCollapse, "class", "panel-collapse collapse in");
            setAttribute(divCollapse, "aria-expanded", "true");
            setAttribute(divCollapse, "style", "");
            panel.getDivBody().removeFromParent();
            panel.getDivFooter().removeFromParent();
            divCollapse.appendChild(panel.getDivBody());
            panel.getDiv().appendChild(divCollapse);
            listPanel.add(panel);
            add(panel, divAccordion);
            //divAccordion.appendChild(panel.getElement());
        }
    }

    @Override
    public void setPanelType(PanelType panelType) {
        super.setPanelType(panelType);
        //Window.alert("Panels: " + listPanel);
        if (listPanel != null) {
            for (int i = 0; i < listPanel.size(); i++) {
                Panel pn = listPanel.get(i);
                pn.setPanelType(panelType);
            }
        }
        //setAttribute(divAccordion, "class", "panel " + panelType.getValue());
    }

}
