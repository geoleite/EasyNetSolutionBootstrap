/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.client.container;

import br.com.gm.client.component.Button;
import br.com.gm.client.component.CloseWindowHandler;
import com.google.gwt.dom.client.ButtonElement;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.dom.client.Text;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import java.util.List;

/**
 *
 * @author geoleite
 */
public class Window extends FlowPanel {

    private String heading;
    private boolean headVisible=true, footerVisible=true;
    private boolean closeable=true;
    protected DivElement divModalGeneral;
    protected DivElement divModalDialog;
    protected DivElement divModalContent;
    protected DivElement divModalHeader;
    protected DivElement divModalBody;
    protected DivElement divModalFooter;
    protected Element h4;
    protected Button btnCloseX = new Button("X");

    protected CloseWindowHandler closeWindowHandler;

    public static enum WindowType {
        SUCCESS("alert alert-success"), INFO("alert alert-info"), 
        DANGER("alert alert-danger"), WARNING("alert alert-warning");
        
        private String value;

        WindowType(String type) {
            this.value = type;
        }

        public String getValue() {
            return value;
        }
    };    
    public Window() {
        divModalGeneral = Document.get().createDivElement();
        divModalDialog = Document.get().createDivElement();
        divModalContent = Document.get().createDivElement();
        divModalHeader = Document.get().createDivElement();
        divModalBody = Document.get().createDivElement();
        divModalFooter = Document.get().createDivElement();
        createModalGeneral();
        getElement().appendChild(divModalGeneral);
    }
    
    public Window(boolean closable) {
        this();
        setCloseable(false);
    }

    public void setWindowType(WindowType windowType) {
        //divModalBody.removeAllChildren();
        if (windowType != null) {
            setAttribute(divModalBody, "class", windowType.getValue());        
        }
    }        
    public void setAttribute(Element element, String name, String value) {
        element.setAttribute(name, value);
    }

    protected void createModalGeneral() {
        setAttribute(divModalGeneral, "id", "myModal");
        setAttribute(divModalGeneral, "class", "modal");
        setAttribute(divModalGeneral, "role", "dialog");
        setAttribute(divModalGeneral, "aria-labeldby", "myModalLabel");
        setAttribute(divModalGeneral, "aria-hidden", "true");
        setAttribute(divModalGeneral, "style", "display: none;");
        createModalDialog();
        divModalGeneral.appendChild(divModalDialog);
    }

    protected void createModalDialog() {
        setAttribute(divModalDialog, "class", "modal-dialog");
        createModalContent();
        divModalDialog.appendChild(divModalContent);
    }

    protected void createModalContent() {
        setAttribute(divModalContent, "class", "modal-content");
        createModalHeader();
        createModalBody();
        createModalFooter();
        divModalContent.appendChild(divModalHeader);
        divModalContent.appendChild(divModalBody);
        divModalContent.appendChild(divModalFooter);

    }

    protected void createModalHeader() {
        //InputElement btnClose = Document.get().createButtonInputElement();
        
        btnCloseX.setAttribute("class", "close");
        btnCloseX.setAttribute("type", "button");
        btnCloseX.setAttribute("data_dismiss", "modal");
        btnCloseX.setAttribute("aria-hidden", "true");
        btnCloseX.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                close();
            }
        });
        h4 = Document.get().createElement("h4");
        Text txtH = Document.get().createTextNode(getHeading());
        h4.appendChild(txtH);
        setAttribute(h4, "id", "myModalLabel");
        setAttribute(h4, "class", "modal-title");
        super.add(btnCloseX, divModalHeader);
        //divModalHeader.appendChild(btnClose);
        divModalHeader.appendChild(h4);
        setAttribute(divModalHeader, "class", "modal-header");
    }

    public void close() {
        setAttribute(divModalGeneral, "style", "display: none;");
        if (closeWindowHandler != null) {
            closeWindowHandler.onCloseWindow();
        }
    }

    protected void createModalBody() {
        setAttribute(divModalBody, "class", "modal-body");
    }

    protected void createModalFooter() {
        setAttribute(divModalFooter, "class", "modal-footer");
    }

    @Override
    public void add(Widget w) {
        if (w != null) {
            super.add(w, divModalBody);
        }
    }

    public void show() {
        setAttribute(divModalGeneral, "style", "display: block;");
        RootPanel.get().add(this);
    }

    public void addFooter(Widget w) {
        if (divModalFooter != null) {
            super.add(w, divModalFooter);
        }
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
        if (heading != null) {
            h4.removeAllChildren();
            Text txtH = Document.get().createTextNode(getHeading());
            h4.appendChild(txtH);
        }
    }

    /**
     * @return the closeWindowHandler
     */
    public CloseWindowHandler getCloseWindowHandler() {
        return closeWindowHandler;
    }

    /**
     * @param closeWindowHandler the closeWindowHandler to set
     */
    public void setCloseWindowHandler(CloseWindowHandler closeWindowHandler) {
        this.closeWindowHandler = closeWindowHandler;
    }

    /**
     * @return the closeable
     */
    public boolean isCloseable() {
        return closeable;
    }

    /**
     * @param closeable the closeable to set
     */
    public void setCloseable(boolean closeable) {
        this.closeable = closeable;
        btnCloseX.setAttribute("style", closeable?"display: block":"display: none");
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
        if (divModalHeader != null) {
            //setAttribute(divModalHeader, "style", "display: none");
            if (!headVisible) {
                divModalHeader.removeFromParent();
            }
        }
    }

    /**
     * @return the footerVisible
     */
    public boolean isFooterVisible() {
        return footerVisible;
    }

    /**
     * @param footerVisible the footerVisible to set
     */
    public void setFooterVisible(boolean footerVisible) {
        this.footerVisible = footerVisible;
        if (divModalFooter != null) {
            if (!footerVisible) {
                divModalFooter.removeFromParent();
            }
        }
    }
}
