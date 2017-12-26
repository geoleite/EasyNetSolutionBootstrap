/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.client.component;

import br.com.gm.client.container.Panel;
import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.LIElement;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.dom.client.UListElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import java.util.List;

/**
 *
 * @author geoleite
 */
public class Navegation extends Panel {

    private DivElement divNav;
    private DivElement divContainer;
    private DivElement divNavBarHeader;
    private DivElement divCollapse;
    private OptionNavegation root;
    public final static String VERTICAL = "sidebar";
    public final static String HORIZONTAL = "";
    private String sideBar = HORIZONTAL;

    private SelectionNavegationHandler selectionMenuHandler;
    private Button btnHeader = new Button();

    public Navegation() {
        getElement().removeAllChildren();
        divNav = Document.get().createDivElement();
        divContainer = Document.get().createDivElement();;
        divNavBarHeader = Document.get().createDivElement();;
        divCollapse = Document.get().createDivElement();;
        setId("sidebar" + Random.nextInt(1000));
    }

    public Navegation(String direction) {
        this();
        sideBar = direction;
        setAttribute(divNav, "class", "navbar navbar-default navbar-fixed-top " + sideBar);
    }

    public Navegation(OptionNavegation root) {
        this(HORIZONTAL);
        setRoot(root);
        //createNav();
    }

    public Navegation(OptionNavegation root, String direction) {
        this(direction);
        setRoot(root);
    }

    protected void createNav() {
        getElement().removeAllChildren();
        setElement(divNav);
        setAttribute(divNav, "class", "navbar navbar-default navbar-fixed-top " + sideBar);
        setAttribute(divNav, "role", "navigation");
        setAttribute(divNav, "style", "z-index: 100");
        createContainer();
        divNav.appendChild(divContainer);
    }

    protected void createContainer() {
        setAttribute(divContainer, "class", "container-fluid");
        createNavBarHeader();
        createCollapse();
        divContainer.appendChild(divNavBarHeader);
        divContainer.appendChild(divCollapse);
    }

    protected void createNavBarHeader() {
        setAttribute(divNavBarHeader, "class", "navbar-header");
        //setAttribute(btnHeader.getElement(), "type", "button");
        setAttribute(btnHeader.getElement(), "class", "navbar-toggle");
        setAttribute(btnHeader.getElement(), "data-toggle", "collapse");
        setAttribute(btnHeader.getElement(), "data-target", "#" + id);
        SpanElement span1 = Document.get().createSpanElement();
        setAttribute(span1, "class", "sr-only");
        span1.appendChild(Document.get().createTextNode("Toggle Navegation"));
        SpanElement span2 = Document.get().createSpanElement();
        setAttribute(span2, "class", "icon-bar");
        SpanElement span3 = Document.get().createSpanElement();
        setAttribute(span3, "class", "icon-bar");
        SpanElement span4 = Document.get().createSpanElement();
        setAttribute(span4, "class", "icon-bar");
        btnHeader.getElement().appendChild(span1);
        btnHeader.getElement().appendChild(span2);
        btnHeader.getElement().appendChild(span3);
        btnHeader.getElement().appendChild(span4);
        btnHeader.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                onOpenNavegation(event);
            }
        });
        add(btnHeader, divNavBarHeader);
    }

    protected void createCollapse() {
        setAttribute(divCollapse, "class", "collapse navbar-collapse");
        setAttribute(divCollapse, "id", id);

        UListElement ulNavBar = Document.get().createULElement();
        setAttribute(ulNavBar, "class", "nav navbar-nav");
        divCollapse.appendChild(ulNavBar);
        //inicio repetir
        if (getRoot() != null) {
            List<OptionNavegation> list = getRoot().getSubOption();
            for (int i = 0; i < list.size(); i++) {
                OptionNavegation optionNav = list.get(i);
                //Link link = optionNav.getLink();
                LIElement li = Document.get().createLIElement();
                ulNavBar.appendChild(li);
                if (i == 0) {
                    setAttribute(li, "class", "active");
                }
                createSubItem(li, optionNav);
            }
        }
    }

    protected void createSubItem(LIElement li, OptionNavegation optionNav) {
        Link link = optionNav.getLink();
        if (!optionNav.hasChild()) {
            if (optionNav.isSeparator()) {
                setAttribute(li, "class", "divider");
                setAttribute(li, "role", "separator");
            } else {
                link.setAttribute("href", "#");
                if (optionNav.getIcon() != null) {
                    SpanElement span = Document.get().createSpanElement();
                    setAttribute(span, "style", "font-size:16px;");
                    setAttribute(span, "class", "pull-right hidden-xs showopacity " + optionNav.getIcon().getValue());
                    link.getElement().appendChild(span);
                }
                link.addClickHandler(new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent event) {
                        if (selectionMenuHandler != null) {
                            selectionMenuHandler.onSelection(optionNav);
                        }
                    }
                });
                add(link, li);
            }
        } else {
            setAttribute(li, "class", "dropdown");
            link.setAttribute("href", "#");
            link.setAttribute("class", "dropdown-toggle");
            link.setAttribute("data-toggle", "dropdown");
            link.setAttribute("role", "button");
            link.setAttribute("aria-haspopup", "true");
            link.setAttribute("aria-expanded", "false");
            SpanElement span = Document.get().createSpanElement();
            setAttribute(span, "class", "caret");
            link.getElement().appendChild(span);
            if (optionNav.getIcon() != null) {
                span = Document.get().createSpanElement();
                setAttribute(span, "style", "font-size:16px;");
                setAttribute(span, "class", "pull-right hidden-xs showopacity " + optionNav.getIcon().getValue());
                link.getElement().appendChild(span);
            }
            add(link, li);
            UListElement ulNavBar = Document.get().createULElement();
            li.appendChild(ulNavBar);
//            setAttribute(ulNavBar, "class", "dropdown-menu forAnimate");
            setAttribute(ulNavBar, "class", "dropdown-menu");
            //setAttribute(ulNavBar, "role", "menu");
            List<OptionNavegation> subList = optionNav.getSubOption();
            for (int i = 0; i < subList.size(); i++) {
                OptionNavegation subOptionNav = subList.get(i);
                LIElement liSub = Document.get().createLIElement();
                ulNavBar.appendChild(liSub);
                createSubItem(liSub, subOptionNav);
            }

        }
    }

    protected void createCollapse1() {
        setAttribute(divCollapse, "class", "collapse navbar-collapse");
        setAttribute(divCollapse, "id", id);

        UListElement ulNavBar = Document.get().createULElement();
        setAttribute(ulNavBar, "class", "nav navbar-nav");
        divCollapse.appendChild(ulNavBar);
        //inicio repetir
        LIElement li = Document.get().createLIElement();
        ulNavBar.appendChild(li);
        setAttribute(li, "class", "active");
        //AnchorElement link = Document.get().createAnchorElement();

        Link link1 = new Link("Home");
        add(link1, li);//li.appendChild(link);
        link1.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Window.alert("Teste Link");
            }
        });
        //setAttribute(link, "href", "#");
        //link.appendChild(Document.get().createTextNode("Home"));
        SpanElement span = Document.get().createSpanElement();
        setAttribute(span, "style", "font-size:16px;");
        setAttribute(span, "class", "ull-right hidden-xs showopacity glyphicon glyphicon-home");
        link1.getElement().appendChild(span);
        //fim repetir
        li = Document.get().createLIElement();
        ulNavBar.appendChild(li);
        setAttribute(li, "class", "dropdown");
        AnchorElement link = Document.get().createAnchorElement();
        li.appendChild(link);
        setAttribute(link, "href", "#");
        setAttribute(link, "class", "dropdown-toggle");
        setAttribute(link, "data-toggle", "dropdown");
        link.appendChild(Document.get().createTextNode("Usuários"));
        span = Document.get().createSpanElement();
        link.appendChild(span);
        setAttribute(span, "class", "caret");
        span = Document.get().createSpanElement();
        setAttribute(span, "style", "font-size:16px;");
        setAttribute(span, "class", "pull-right hidden-xs showopacity glyphicon glyphicon-user");
        link.appendChild(span);

        ulNavBar = Document.get().createULElement();
        li.appendChild(ulNavBar);
        setAttribute(ulNavBar, "class", "dropdown-menu forAnimate");
        setAttribute(ulNavBar, "role", "menu");
        li = Document.get().createLIElement();
        ulNavBar.appendChild(li);
        link = Document.get().createAnchorElement();
        li.appendChild(link);
        setAttribute(link, "href", "{{URL::to('createusuario')}}");
        link.appendChild(Document.get().createTextNode("Novo Usuário"));

        li = Document.get().createLIElement();
        ulNavBar.appendChild(li);
        setAttribute(li, "class", "divider");

        li = Document.get().createLIElement();
        ulNavBar.appendChild(li);
        link = Document.get().createAnchorElement();
        li.appendChild(link);
        setAttribute(link, "href", "#");
//        setAttribute(link, "href", "{{URL::to('sistema')}}");
        link.appendChild(Document.get().createTextNode("Consultar Sistemas"));

        li = Document.get().createLIElement();
        ulNavBar.appendChild(li);
        //setAttribute(li, "class", "active");
        link = Document.get().createAnchorElement();
        li.appendChild(link);
        setAttribute(link, "href", "#");
        link.appendChild(Document.get().createTextNode("Tags"));
        span = Document.get().createSpanElement();
        setAttribute(span, "style", "font-size:16px;");
        setAttribute(span, "class", "ull-right hidden-xs showopacity glyphicon glyphicon-home");
        link.appendChild(span);

        li = Document.get().createLIElement();
        ulNavBar.appendChild(li);
        //setAttribute(li, "class", "active");
        link = Document.get().createAnchorElement();
        li.appendChild(link);
        setAttribute(link, "href", "#");
        link.appendChild(Document.get().createTextNode("Livros"));
        span = Document.get().createSpanElement();
        setAttribute(span, "style", "font-size:16px;");
        setAttribute(span, "class", "ull-right hidden-xs showopacity glyphicon glyphicon-home");
        link.appendChild(span);
    }

    /**
     * Evento executado quando o menu é clicado pra abrir
     *
     * @param event
     */
    public void onOpenNavegation(ClickEvent event) {
        //Window.alert("Menu Aberto");
    }

    @Override
    public void setId(String id) {
        setAttribute(divNav, "id", id);
    }

    /**
     * @return the root
     */
    public OptionNavegation getRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    public void setRoot(OptionNavegation root) {
        this.root = root;
        createNav();
    }

    /**
     * @return the selectionMenuHandler
     */
    public SelectionNavegationHandler getSelectionMenuHandler() {
        return selectionMenuHandler;
    }

    /**
     * @param selectionMenuHandler the selectionMenuHandler to set
     */
    public void setSelectionMenuHandler(SelectionNavegationHandler selectionMenuHandler) {
        this.selectionMenuHandler = selectionMenuHandler;
    }
}
