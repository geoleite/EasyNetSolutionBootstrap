/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.client.container;

import br.com.gm.client.component.Button;
import br.com.gm.client.component.Label;
import br.com.gm.client.component.WindowMessage;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

/**
 *
 * @author geoleite
 */
public class WindowConfirm extends Window{
    public final static String OK="OK";
    public final static String CANCEL="Cancel";
    private WindowConfirm() {
        super(false);
    }
    
    public static WindowConfirm confirm(String title, String message, Button... buttons) {
//        WindowConfirm window = new WindowConfirm();
//        window.setHeading(title);
//        window.add(new Label(message));
//        for (int i = 0; i < buttons.length; i++) {
//            Button btn = buttons[i];
//            btn.addClickHandler(new ClickHandler() {
//                @Override
//                public void onClick(ClickEvent event) {
//                    window.close();
//                }
//            });            
//            window.addFooter(btn);
//        }
//        return window;
        return confirm(title, message, null, buttons);
    }        
    
    public static WindowConfirm confirm(String title, String message, 
            WindowType windowType, Button... buttons) {
        final WindowConfirm window = new WindowConfirm();
        window.setHeading(title);
        window.add(new Label(message));
        for (int i = 0; i < buttons.length; i++) {
            Button btn = buttons[i];
            btn.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    window.close();
                }
            });
            window.addFooter(btn);
        }
        window.setWindowType(windowType);
        return window;
    }        

    public static WindowConfirm confirm(String title, String message, 
            WindowType windowType, String... options) {
        Button[] btns = new Button[options.length];
        for (int i = 0; i < options.length; i++) {
            String str = options[i];
            Button btn = new Button(str);
            btns[i] = btn;
        }
        return confirm(title, message,windowType, btns);
    }        

    public static WindowConfirm confirm(String title, String message, 
            WindowType windowType, final WindowConfirmHandler windowConfirmHandler) {
        Button btnOk = new Button("Ok", Button.ButtonType.SUCCESS);
        Button btnCancel = new Button("Cancel", Button.ButtonType.DANGER);
        btnOk.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {                
                if (windowConfirmHandler!= null) {
                    windowConfirmHandler.onClick(OK);
                }
            }
        });
        btnCancel.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (windowConfirmHandler!= null) {
                    windowConfirmHandler.onClick(CANCEL);
                }
            }
        });
        return confirm(title, message, windowType, btnOk, btnCancel);
    }        

}
