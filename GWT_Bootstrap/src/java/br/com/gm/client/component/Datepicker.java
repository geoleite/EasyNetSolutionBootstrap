/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.client.component;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.ScriptElement;

/**
 *
 * @author geoleite
 */
public class Datepicker extends InputText {
    private ScriptElement script;
    public Datepicker() {
        //super(new InputText(), null, Icon.IconType.CALENDAR);
        super("00/00/0000");
        //getInputText().setAttribute("type", "date");
        //getInputText().setMask("00/00/0000");
        createScript();
    }
    
    private void createScript() {
        String sourceJS = "$('#" + getId() + "').datepicker({\n" +
"            uiLibrary: 'bootstrap'\n" +
"        });";
        script = Document.get().createScriptElement(sourceJS);
        getElement().appendChild(script);
    }
}
