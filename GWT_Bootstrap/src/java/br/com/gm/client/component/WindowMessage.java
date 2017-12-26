/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.client.component;

import br.com.gm.client.container.Window;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.impl.DOMImpl;

/**
 *
 * @author geoleite
 */
public class WindowMessage extends Window {
    private String message;
    private Button btnClose;
    private boolean closeVisible=true;

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
        if (message != null) {
            divModalBody.removeAllChildren();
            divModalBody.appendChild(Document.get().createTextNode(getMessage()));        
        }
    }

    /**
     * @return the closeVisible
     */
    public boolean isCloseVisible() {
        return closeVisible;
    }

    /**
     * @param closeVisible the closeVisible to set
     */
    public void setCloseVisible(boolean closeVisible) {
        this.closeVisible = closeVisible;
        if (!closeVisible) {
            btnCloseX.removeFromParent();
            btnClose.removeFromParent();
        }
    }
            

    
    public WindowMessage() {
        btnClose = new Button("Close", Button.ButtonType.DEFAULT);
        btnClose.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                setAttribute(divModalGeneral, "style", "display: none;");
                if (closeWindowHandler != null) {
                    closeWindowHandler.onCloseWindow();
                }                
            }
        });
        add(btnClose, divModalFooter);
    }
        
    public WindowMessage(String message) {
        this();
        setMessage(message);
        setWindowType(WindowType.SUCCESS);
    }
    
    public WindowMessage(String message, WindowType messageType) {        
        this(message);
        setWindowType(messageType);
    }

    public WindowMessage(String message, WindowType messageType, boolean closeVisible) {        
        this(message);
        setWindowType(messageType);
        setCloseVisible(closeVisible);
    }

    public WindowMessage(String message, WindowType messageType, boolean closeVisible, boolean headVisible, boolean footerVisible) {
        this(message);
        setWindowType(messageType);
        setCloseVisible(closeVisible);
        setHeadVisible(headVisible);
        setFooterVisible(footerVisible);
    }
    
    @Override
    public void setHeading(String heading) {
        //super.setHeading(heading); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setWindowType(WindowType messageType) {
        divModalBody.removeAllChildren();
        super.setWindowType(messageType);
        //setAttribute(divModalBody, "class", messageType.getValue());        
        divModalBody.appendChild(Document.get().createTextNode(getMessage()));
        if (messageType == WindowType.SUCCESS) {
            super.setHeading("Sucesso");
        } else if (messageType == WindowType.INFO) {
            super.setHeading("Informação");
        } else if (messageType == WindowType.WARNING) {
            super.setHeading("Atenção");
        } else if (messageType == WindowType.DANGER) {
            super.setHeading("Erro");
        }
    }
}
