/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.client.dao;

import br.com.easynet.client.rest.GMRequestBuilder;
import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.RequestBuilder;

/**
 *
 * @author geoleite
 */
public class UsuarioDAO {
    private static String url = "easyportal/";
    
    public GMRequestBuilder autenticate() {
        String urlMethod = GWT.getHostPageBaseURL() + url + "usuariorest/authenticate";
        return new GMRequestBuilder(RequestBuilder.GET, urlMethod);        
    }
}
