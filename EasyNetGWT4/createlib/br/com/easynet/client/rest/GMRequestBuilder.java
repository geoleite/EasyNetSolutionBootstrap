/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.client.rest;

import br.com.easynet.client.json.DynamicJson;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;

/**
 *
 * @author geoleite
 */
public class GMRequestBuilder extends RequestBuilder {
    
    public GMRequestBuilder(Method httpMethod, String url) {
        super(httpMethod, url);
    }
    
    public Request sendRequestObject(DynamicJson objData, 
            RequestCallback callback) throws RequestException {
        if (objData != null) {
            return super.sendRequest(objData.toJson(), callback);
        } else {
            return super.sendRequest(null, callback);
        }
    }
}
