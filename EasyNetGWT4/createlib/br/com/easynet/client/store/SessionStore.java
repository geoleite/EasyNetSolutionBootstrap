/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.client.store;

import com.google.gwt.user.client.Window;

/**
 *
 * @author geoleite
 */
public class SessionStore {
    private static SessionStore sessionStore;
    private Object sessionStorage;
    private SessionStore() {
        Window.alert("Ponto1");
        create(this);
    }
    
    public static SessionStore getInstance() {
        if (sessionStore == null) {
            sessionStore = new SessionStore();
        }
        return sessionStore;
    }
    
    public void setStore(Object store) {
        sessionStorage = store;
        Window.alert("Ponto4 " + sessionStorage);
    }
    private static native void create(SessionStore sessionStore) /*-{
        alert("Ponto2");
        sessionStore.@br.com.easynet.client.store.SessionStore::setStore(Ljava/lang/Object;)(sessionStore);
        alert("Ponto3");
    }-*/;
}
