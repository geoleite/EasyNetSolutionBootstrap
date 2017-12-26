/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.client.container;

import br.com.gm.client.component.Button;
import br.com.gm.client.component.ButtonGroup;
import br.com.gm.client.component.Link;
import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.LIElement;
import com.google.gwt.dom.client.UListElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.user.client.Timer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author geoleite
 */
public class TabPanel extends Panel {

    private UListElement navElement;
    private DivElement divContent;
    private List<Panel> tabs = new ArrayList<Panel>();
    private ClickTabItemHandler clickTabItemHandler;
    private ChangeTabItemHandler changeTabItemHandler;
    private CloseTabItemHandler closeTabItemHandler;
    private Panel currentTabItem;

    public TabPanel() {
        createNav();
        createContent();
    }

    public TabPanel(ClickTabItemHandler clickTabItemHandler) {
        this();
        setClickTabItemHandler(clickTabItemHandler);
    }

    public TabPanel(ChangeTabItemHandler changeTabItemHandler) {
        this();
        setChangeTabItemHandler(changeTabItemHandler);
    }

    private void createNav() {
        getElement().removeAllChildren();
        navElement = Document.get().createULElement();
        getElement().appendChild(navElement);
        //setElement(navElement);
        setAttribute(navElement, "class", "nav nav-tabs inline");
    }

    private void createContent() {
        divContent = Document.get().createDivElement();
        setAttribute(divContent, "class", "tab-content");
        getElement().appendChild(divContent);
    }

    private Panel getPanel(Panel panel) {
        for (int i = 0; i < tabs.size(); i++) {
            Panel pn = tabs.get(i);
            if (pn.getId().equals(panel.getId())) {
                return pn;
            }
        }
        return null;
    }

    public boolean existPanel(Panel panel) {
        return getPanel(panel) != null;
    }

    public void addPanel(Panel panel, boolean closable) {
        if (panel != null) {
            if (existTabItem(panel)) {
                activeTabItem(panel);
            } else {
                createTabItem(panel, closable);
                createContentItem(panel);
                activeTabItem(panel);
                tabs.add(panel);
            }
        }

    }

    public void addPanel(Panel panel) {
        this.addPanel(panel, true);
    }

    public void activeTabItem(Panel panel) {
        if (panel != null) {
            //if (!panel.getId().equals(currentTabItem.getId())) {
            LIElement li = (LIElement) Document.get().getElementById("aba-" + currentTabItem.getId());
            DivElement divContentItem = (DivElement) Document.get().getElementById("tabitem-" + currentTabItem.getId());
            if (li != null && divContentItem != null) {
                setAttribute(li, "class", "");
                setAttribute(divContentItem, "class", "tab-pane fade");

                currentTabItem = panel;
                li = (LIElement) Document.get().getElementById("aba-" + currentTabItem.getId());
                divContentItem = (DivElement) Document.get().getElementById("tabitem-" + currentTabItem.getId());
                setAttribute(li, "class", "active");
                setAttribute(divContentItem, "class", "tab-pane fade in active");
            }
            //}
        }
    }

    public boolean existTabItem(Panel panel) {
        for (int i = 0; i < tabs.size(); i++) {
            Panel tabItem = tabs.get(i);
            if (tabItem.getId().equals(panel.getId())) {
                return true;
            }
        }
        return false;
    }

    private void createTabItem(final Panel panel, boolean closable) {
        LIElement li = Document.get().createLIElement();
        setAttribute(li, "id", "aba-" + panel.getId());
        navElement.appendChild(li);
        if (tabs.size() == 0) {
            currentTabItem = panel;
            setAttribute(li, "class", "active");
        }
        //AnchorElement link = Document.get().createAnchorElement();
        Link link = new Link(panel.getHeading());
        //criando evento onclick Aba
        link.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                //definindo o currentTabItem
                if (currentTabItem.getId() != panel.getId()) {
                    currentTabItem = panel;
                    if (changeTabItemHandler != null) {
                        changeTabItemHandler.onChangeTabItem(currentTabItem, TabPanel.this);
                    }
                }

                if (clickTabItemHandler != null) {
                    clickTabItemHandler.onClickTabItem(panel, TabPanel.this);
                }
            }
        });

        //Permite fechar a aba
        if (closable) {
            link.addDoubleClickHandler(new DoubleClickHandler() {
                @Override
                public void onDoubleClick(DoubleClickEvent event) {
                    new Timer() {
                        @Override
                        public void run() {
                            if (currentTabItem.getId().equals(panel.getId())) {
                                removeTabItem(panel);
                            }
                        }
                    }.schedule(500);
                }
            });
        }
        add(link, li);
        //add(linkClose, li);
        //add(bg, li);
        link.setHref("#tabitem-" + panel.getId());
        setAttribute(link.getElement(), "data-toggle", "tab");
        //link.appendChild(Document.get().createTextNode(panel.getHeading()));
    }

    public void removeTabItem(Panel panel) {
        if (closeTabItemHandler != null) {
            closeTabItemHandler.onClose(panel, this);
        }
        tabs.remove(panel);
        if (tabs.size() == 0) {
            currentTabItem = null;
        } else {
            Panel panelAux = tabs.get(0);
            if (panelAux != null) {
                activeTabItem(panelAux);
            }
        }
        LIElement li = (LIElement) Document.get().getElementById("aba-" + panel.getId());
        DivElement divContentItem = (DivElement) Document.get().getElementById("tabitem-" + panel.getId());
        li.removeFromParent();
        divContentItem.removeFromParent();
    }

    private void createContentItem(Panel panel) {
        DivElement divContentItem = Document.get().createDivElement();
        setAttribute(divContentItem, "id", "tabitem-" + panel.getId());
        divContent.appendChild(divContentItem);
        if (tabs.size() == 0) {
            setAttribute(divContentItem, "class", "tab-pane fade in active");
        } else {
            setAttribute(divContentItem, "class", "tab-pane fade");
        }
        panel.setHeadVisible(false);
        add(panel, divContentItem);
    }

    /**
     * @return the clickTabItemHandler
     */
    public ClickTabItemHandler getClickTabItemHandler() {
        return clickTabItemHandler;
    }

    /**
     * @param clickTabItemHandler the clickTabItemHandler to set
     */
    public void setClickTabItemHandler(ClickTabItemHandler clickTabItemHandler) {
        this.clickTabItemHandler = clickTabItemHandler;
    }

    /**
     * @return the changeTabItemHandler
     */
    public ChangeTabItemHandler getChangeTabItemHandler() {
        return changeTabItemHandler;
    }

    /**
     * @param changeTabItemHandler the changeTabItemHandler to set
     */
    public void setChangeTabItemHandler(ChangeTabItemHandler changeTabItemHandler) {
        this.changeTabItemHandler = changeTabItemHandler;
    }

    /**
     * @return the currentTabItem
     */
    public Panel getCurrentTabItem() {
        return currentTabItem;
    }

    /**
     * @param currentTabItem the currentTabItem to set
     */
    public void setCurrentTabItem(Panel currentTabItem) {
        this.currentTabItem = currentTabItem;
    }

    /**
     * @return the closeTabItemHandler
     */
    public CloseTabItemHandler getCloseTabItemHandler() {
        return closeTabItemHandler;
    }

    /**
     * @param closeTabItemHandler the closeTabItemHandler to set
     */
    public void setCloseTabItemHandler(CloseTabItemHandler closeTabItemHandler) {
        this.closeTabItemHandler = closeTabItemHandler;
    }

}
