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
public class LocalStore {
    private static LocalStore localStore;
    private Object localStorage;
    
    private LocalStore() {
        create(this);
    }
    
    public static LocalStore getInstance() {
        if (localStore == null) {
            localStore = new LocalStore();
        }
        return localStore;
    }
    
    public void setStore(Object store) {
        localStorage = store;
    }
    private static native void create(LocalStore localStore) /*-{
        localStore.@br.com.easynet.client.store.LocalStore::setStore(Ljava/lang/Object;)(localStore);
    }-*/;
}
