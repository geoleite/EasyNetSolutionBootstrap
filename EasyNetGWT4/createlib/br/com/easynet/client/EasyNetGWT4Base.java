/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.client;

import br.com.gm.client.GMBootstrap3Base;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.ScriptElement;
import com.google.gwt.user.client.Window;

/**
 *
 * @author geoleite
 */
public abstract class EasyNetGWT4Base extends GMBootstrap3Base {

    
    @Override
    protected void postLoad() {
        super.postLoad(); //To change body of generated methods, choose Tools | Templates.
        ScriptElement jsSqlite = Document.get().createScriptElement();
        jsSqlite.setType("text/javascript");
        jsSqlite.setSrc(getModuleName() + "/js/sql.js");
        //Window.alert(jsSqlite.getSrc());
        //getHead().appendChild(jsSqlite);
    }

}
