/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.client.component.data;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author geoleite
 */
public class Field {
    private Map<String, Object> map = new HashMap();
    public void put(String id, Object obj) {
        map.put(id, obj);
    }
    
    public Object remove(String id) {
        return map.remove(id);
    }
    
    public Object get(String id) {
        return map.get(id);
    }
}
