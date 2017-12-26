/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.client.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 *
 * @author geoleite
 */
public class GMJson {
    public static Gson getGsonDateFormat() {
        return getGsonDateFormat("dd/MM/yyyy");
    }
    public static Gson getGsonDateFormat(String dateFormat) {
        return new GsonBuilder().setDateFormat(dateFormat).create();        
    }
    public static Gson getGsonDateTimeFormat() {
        return getGsonDateTimeFormat("dd/MM/yyyy");
    }
    public static Gson getGsonDateTimeFormat(String dateTimeFormat) {
        return new GsonBuilder().setDateFormat(dateTimeFormat).create();        
    }
}
