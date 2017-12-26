/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.client.sqlite;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.ScriptElement;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;

/**
 *
 * @author geoleite
 */
public class Database {

    private static Database database;
    private static Object db;
    
    
    private Database(int size) {
        Window.alert("Ponto2");
        db = createDB(size);
        Window.alert("Ponto5");
    }

    public void teste(String teste) {
        Window.alert("testando " + teste);
    }

    public static Database createDatabase(int size) {
        Window.alert("Ponto1 " + database);
        if (database == null) {
            database = new Database(size);
        }
        return database;
        //int size = 5 * 1024 * 1024;
    }
    public static Database createDatabase() {
        Window.alert("Ponto1 " + database);
        if (database == null) {
            int size = 5 * 1024 * 1024;
            database = new Database(size);
        }
        return database;
    }

    public void executeUpdate(String sql) {
        executeModify(db, sql);
    }

    public void executeUpdateParam(String sql, String[] param) {
        String parameters = "[";
        for (int i = 0; i < param.length; i++) {
            String p = param[i];
            parameters += p + ",";
        }
        parameters += "]";
        parameters = parameters.replace(",]", "]");
        executeModifyWithParam(db, sql, parameters);
    }

    private static native void executeModify(Object db, String sql) /*-{
        db.run(sql);
    }-*/;

    private static native void executeModifyWithParam(Object db, String sql, String param) /*-{
        db.run(sql, param);
    }-*/;

    private static native Object createDB(int dbSize) /*-{
        alert("Ponto3.0");
        //var html5rocks = {};
        alert("Ponto3.1 ");
        //html5rocks.webdb = {};            
        alert("Ponto3.2 ");
        //html5rocks.webdb.db = null;    
        //html5rocks.webdb.open = function() {
            //var dbSize = 5 * 1024 * 1024; // 5MB
        var db = openDatabase("Todo", "1", "Todo manager", dbSize);
        alert("Ponto3.3" + db);
        //}
        //html5rocks.webdb.onError = function(tx, e) {
        //    alert("There has been an error: " + e.message);
        //}
        alert("Ponto4 " + html5rocks.webdb.db);    
        return html5rocks.webdb.db;
    }-*/;
    /*
    private static native Object connect(WebSocketGWT wsGWT, String url) /*-{
     //var wsUri = "ws://localhost:8080/I9TaxiGwt/wst?session=" + id;
     var wsUri = url;
     var websocket = new WebSocket(wsUri);
     websocket.onerror = function (evt) {
       wsGWT.@br.com.easynet.gwt.client.websocket.WebSocketGWT::onClosed()();
     };
                
     websocket.onopen = function (evt) {
        wsGWT.@br.com.easynet.gwt.client.websocket.WebSocketGWT::onOpen()();
     };
     websocket.onmessage = function (evt) {
        wsGWT.@br.com.easynet.gwt.client.websocket.WebSocketGWT::onMessage(Ljava/lang/String;)(evt.data);
     };
     
     websocket.onclose = function(ev) {
        wsGWT.@br.com.easynet.gwt.client.websocket.WebSocketGWT::onClosed()();
     }; 
        
     return websocket;
     }-*/
;

}
