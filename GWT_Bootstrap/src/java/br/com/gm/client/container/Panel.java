/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.client.container;

import br.com.gm.client.component.Button;
import br.com.gm.client.component.IFrame;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Text;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 *
 * @author geoleite
 */
public class Panel extends FlowPanel {

    private DivElement div, divHeading, divBody, divFooter;
    private String heading, footer;
    private PanelType panelType = PanelType.DEFAULT;
    private boolean headVisible=true;
    protected String id;
    private String url;


    public Panel() {
        super();
        id = "panel" + Random.nextInt(100);
        div = Document.get().createDivElement();
        divHeading = Document.get().createDivElement();
        divBody = Document.get().createDivElement();
        divFooter = Document.get().createDivElement();
        //Defindo os estilos
        divHeading.setAttribute("class", "panel-heading");
        divBody.setAttribute("class", "panel-body");
        divFooter.setAttribute("class", "panel-footer");
        //div.setAttribute("class", "panel");
        setPanelType(panelType);
        getElement().appendChild(div);
        div.setAttribute("id", id);
        div.appendChild(divHeading);
        div.appendChild(divBody);
        
        //repaint();
    }
    
    public Panel(String heading) {
        this();
        setHeading(heading);
    }

    public Panel(String heading, String url) {
        this();
        setHeading(heading);
        setUrl(url);
    }
    
    /**
     * @return the headVisible
     */
    public boolean isHeadVisible() {
        return headVisible;
    }

    /**
     * @param headVisible the headVisible to set
     */
    public void setHeadVisible(boolean headVisible) {
        this.headVisible = headVisible;
        repaint();
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
        if (id != null) {
            setAttribute(div, "id", id);
        }
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
        setUrl(url, false);
    }
    public void setUrl(String url, boolean clearPanel) {
        this.url = url;
        IFrame iframe = new IFrame(url);
        if (clearPanel) {
            divBody.removeAllChildren();
        }
        super.add(iframe, divBody);
    }

//    public void setUrl(String url, String width, String height) {
//        this.url = url;
//        IFrame iframe = new IFrame(url);
//        setWidth(width);
//        setHeight(height);
//        divBody.removeAllChildren();
//        super.add(iframe, divBody);
//    }
    
    public static enum PanelType {
        SUCCESS("panel-success"), DEFAULT("panel-default"), INFO("panel-info"),
        PRIMARY("panel-primary"), DANGER("panel-danger"), WARNING("panel-warning"),
        GREEN("panel-green"), YELLOW("panel-yellow"), RED("panel-red");
        private String value;

        PanelType(String type) {
            this.value = type;
        }

        public String getValue() {
            return value;
        }
    };

    @Override
    public void add(Widget w) {
        //super.add(w); //To change body of generated methods, choose Tools | Templates.
        if (w!= null) {
            //divBody.appendChild(w.getElement());
            super.add(w, divBody);
            //getChildren().add(child)
            //divBody.
        }
    }
    
    public void addFooter(Widget w) {
        if (divFooter != null) {
            super.add(w, divFooter);
        }
    }
    
    @Override
    public void clear() {
        //super.clear(); //To change body of generated methods, choose Tools | Templates.
        divBody.removeAllChildren();
        repaint();
    }

    public void repaint() {
        getElement().removeAllChildren();
        getDiv().removeAllChildren();
        if (headVisible) {
            getDiv().appendChild(getDivHeading());
        } else {
            getDivHeading().removeFromParent();
        }
        getDiv().appendChild(getDivBody());
        if (footer != null) {
            getDiv().appendChild(getDivFooter());
        }

        //getElement().appendChild(div);
        setElement(div);
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
     * @return the heading
     */
    public String getHeading() {
        return heading;
    }

    /**
     * @param heading the heading to set
     */
    public void setHeading(String heading) {
        this.heading = heading;
        Text txtHeading = Document.get().createTextNode(heading);
        divHeading.removeAllChildren();
        divHeading.appendChild(txtHeading);
        repaint();
    }

    /**
     * @return the footer
     */
    public String getFooter() {
        return footer;
    }

    /**
     * @param footer the footer to set
     */
    public void setFooter(String footer) {
        this.footer = footer;
        if (footer == null) {
            divFooter.removeFromParent();
            //div.removeChild(divFooter);
//            for (int i=0 ; i < div.getChildCount();i++) {
//                Element df = (Element)div.getChild(i);
//                div.remove
//                if () {
//                    
//                }
//            }
        } else {
            Text txtFooter = Document.get().createTextNode(footer);
            divFooter.removeAllChildren();
            divFooter.appendChild(txtFooter);
        }
        repaint();
    }

    /**
     * @return the div
     */
    protected DivElement getDiv() {
        return div;
    }

    /**
     * @param div the div to set
     */
    protected void setDiv(DivElement div) {
        this.div = div;
    }

    /**
     * @return the divHeading
     */
    protected DivElement getDivHeading() {
        return divHeading;
    }

    /**
     * @param divHeading the divHeading to set
     */
    protected void setDivHeading(DivElement divHeading) {
        this.divHeading = divHeading;
    }

    /**
     * @return the divBody
     */
    protected DivElement getDivBody() {
        return divBody;
    }

    /**
     * @param divBody the divBody to set
     */
    protected void setDivBody(DivElement divBody) {
        this.divBody = divBody;
    }

    /**
     * @return the divFooter
     */
    protected DivElement getDivFooter() {
        return divFooter;
    }

    /**
     * @param divFooter the divFooter to set
     */
    protected void setDivFooter(DivElement divFooter) {
        this.divFooter = divFooter;
    }

    public PanelType getPanelType() {
        return panelType;
    }

    public void setPanelType(Panel.PanelType panelType) {
        setAttribute(div, "class", "panel " + panelType.getValue());
        //appendAttribute(div, "class", panelType.getValue());
        //repaint();
    }

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        //setAttribute(div, "style", "display: " + (visible?"block":"none"));
    }

    
}
