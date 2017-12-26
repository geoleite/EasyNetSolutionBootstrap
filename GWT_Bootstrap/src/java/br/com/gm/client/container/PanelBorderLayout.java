/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.client.container;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;

/**
 *
 * @author geoleite
 */
public class PanelBorderLayout extends Panel {

    private DivElement divContainer, divColContent, divColLeft, divColRight, divColBottom, divColTop;
    private DivElement divLeft, divRight, divTop, divBottom, divContent;
    private Panel panelTop, panelLeft, panelRight, panelContent, panelBottom;
    private ConfigBorderLayout configBorderLayout = new ConfigBorderLayout();

    public PanelBorderLayout() {
        super();
        createContainer();
    }

    public PanelBorderLayout(Panel panelTop, Panel panelLeft, Panel panelRight,
            Panel panelContent, Panel panelBottom, ConfigBorderLayout configBorderLayout) {
        super();
        this.configBorderLayout = configBorderLayout;
        createContainer();
        setPanelTop(panelTop);
        setPanelLeft(panelLeft);
        setPanelRight(panelRight);
        setPanelContent(panelContent);
        setPanelBottom(panelBottom);
    }

    public void createContainer() {
        if (divContainer == null) {
            divContainer = Document.get().createDivElement();
            setElement(divContainer);
        } else {
            divContainer.removeAllChildren();
        }
        //setAttribute(divContainer, "class", "container");
        setAttribute(divContainer, "class", "panel");

        DivElement divRow = null;
        if (configBorderLayout.getBsTop().getValue() != null) {
            divRow = Document.get().createDivElement();
            divContainer.appendChild(divRow);
            setAttribute(divRow, "class", "row");

            divColTop = Document.get().createDivElement();
            divRow.appendChild(divColTop);
            setAttribute(divColTop, "class", configBorderLayout.getBsTop().getValue());
            createTop(divColTop);
        }

        if (configBorderLayout.getBsLeft().getValue() != null
                || configBorderLayout.getBsRight().getValue() != null
                || configBorderLayout.getBsContent().getValue() != null) {
            divRow = Document.get().createDivElement();
            divContainer.appendChild(divRow);
            setAttribute(divRow, "class", "row");

            if (configBorderLayout.getBsLeft().getValue() != null) {
                divColLeft = Document.get().createDivElement();
                divRow.appendChild(divColLeft);
                setAttribute(divColLeft, "class", configBorderLayout.getBsLeft().getValue());
                createLeft(divColLeft);
            }

            if (configBorderLayout.getBsContent().getValue() != null) {
                divColContent = Document.get().createDivElement();
                divRow.appendChild(divColContent);
                setAttribute(divColContent, "class", configBorderLayout.getBsContent().getValue());
                createContent(divColContent);
            }

            if (configBorderLayout.getBsRight().getValue() != null) {
                divColRight = Document.get().createDivElement();
                divRow.appendChild(divColRight);
                setAttribute(divColRight, "class", configBorderLayout.getBsRight().getValue());
                createRight(divColRight);
            }
        }

        if (configBorderLayout.getBsBottom().getValue() != null) {
            divRow = Document.get().createDivElement();
            divContainer.appendChild(divRow);
            setAttribute(divRow, "class", "row");
            divColBottom = Document.get().createDivElement();
            divRow.appendChild(divColBottom);
            setAttribute(divColBottom, "class", configBorderLayout.getBsBottom().getValue());
            createBottom(divColBottom);
        }

    }

    private void createLeft(DivElement element) {
        divLeft = Document.get().createDivElement();
        setAttribute(divLeft, "class", "left-box");
        element.appendChild(divLeft);
        //divLeft.appendChild(Document.get().createTextNode("Left"));
    }

    private void createRight(DivElement element) {
        divRight = Document.get().createDivElement();
        setAttribute(divRight, "class", "right-box");
        element.appendChild(divRight);
        //divRight.appendChild(Document.get().createTextNode("Right"));
    }

    private void createTop(DivElement element) {
//        DivElement divCol = Document.get().createDivElement();
//        element.appendChild(divCol);
//        setAttribute(divCol, "class", "col-xs-12");
        divTop = Document.get().createDivElement();
        element.appendChild(divTop);
        setAttribute(divTop, "class", "top-box");
        //divTop.appendChild(Document.get().createTextNode("Top"));
    }

    private void createBottom(DivElement element) {
//        DivElement divCol = Document.get().createDivElement();
//        element.appendChild(divCol);
//        setAttribute(divCol, "class", "col-xs-12");
        divBottom = Document.get().createDivElement();
        element.appendChild(divBottom);
        setAttribute(divBottom, "class", "bottom-box");
        //divBottom.appendChild(Document.get().createTextNode("Bottom"));
    }

    private void createContent(DivElement element) {
//        DivElement divCol = Document.get().createDivElement();
//        element.appendChild(divCol);
//        setAttribute(divCol, "class", "col-xs-12");
        divContent = Document.get().createDivElement();
        element.appendChild(divContent);
        setAttribute(divContent, "class", "right-box");
        //divContent.appendChild(Document.get().createTextNode("Content"));
    }

    /**
     * @return the panelTop
     */
    public Panel getPanelTop() {
        return panelTop;
    }

    /**
     * @param panelTop the panelTop to set
     */
    public void setPanelTop(Panel panelTop) {
        this.panelTop = panelTop;
        if (panelTop == null) {
            //divTop.getParentElement().removeFromParent();
            //divTop.removeFromParent();
            if (divTop != null) {
                divTop.removeFromParent();
            }

        } else {
            add(panelTop, divTop);
        }
        //createContainer();
    }

    /**
     * @return the panelLeft
     */
    public Panel getPanelLeft() {
        return panelLeft;
    }

    /**
     * @param panelLeft the panelLeft to set
     */
    public void setPanelLeft(Panel panelLeft) {
        if (configBorderLayout.getBsLeft() != ConfigBorderLayout.BorderSize.NULL) {
            this.panelLeft = panelLeft;
            if (panelLeft != null) {
                add(panelLeft, divLeft);
            } else //divLeft.getParentElement().removeFromParent();
            //divLeft.removeFromParent();
             if (divLeft != null) {
                    divLeft.removeFromParent();
                }
        }
    }

    /**
     * @return the panelRigth
     */
    public Panel getPanelRight() {
        return panelRight;
    }

    /**
     * @param panelRigth the panelRigth to set
     */
    public void setPanelRight(Panel panelRight) {
        if (configBorderLayout.getBsRight() != ConfigBorderLayout.BorderSize.NULL) {
            this.panelRight = panelRight;
            if (panelRight != null) {
                add(panelRight, divRight);
            } else //divLeft.getParentElement().removeFromParent();
            //divLeft.removeFromParent();
             if (divRight != null) {
                    divRight.removeFromParent();
                }
        }
    }

    /**
     * @return the panelContent
     */
    public Panel getPanelContent() {
        return panelContent;
    }

    /**
     * @param panelContent the panelContent to set
     */
    public void setPanelContent(Panel panelContent) {
        if (configBorderLayout.getBsContent() != ConfigBorderLayout.BorderSize.NULL) {
            this.panelContent = panelContent;
            if (panelContent != null) {
                add(panelContent, divContent);
            } else //divLeft.getParentElement().removeFromParent();
            //divLeft.removeFromParent();
             if (divContent != null) {
                    divContent.removeFromParent();
                }
        }

    }

    /**
     * @return the panelBotton
     */
    public Panel getPanelBottom() {
        return panelBottom;
    }

    /**
     * @param panelBotton the panelBotton to set
     */
    public void setPanelBottom(Panel panelBottom) {
        if (configBorderLayout.getBsBottom() != ConfigBorderLayout.BorderSize.NULL) {
            this.panelBottom = panelBottom;
            if (panelBottom != null) {
                add(panelBottom, divBottom);
            } else //divLeft.getParentElement().removeFromParent();
            //divLeft.removeFromParent();
             if (divBottom != null) {
                    divBottom.removeFromParent();
                }
        }
    }

    /**
     * @return the configBorderLayout
     */
    public ConfigBorderLayout getConfigBorderLayout() {
        return configBorderLayout;
    }

    /**
     * @param configBorderLayout the configBorderLayout to set
     */
    public void setConfigBorderLayout(ConfigBorderLayout configBorderLayout) {
        if (configBorderLayout != null) {
            this.configBorderLayout = configBorderLayout;
        }
    }
}
