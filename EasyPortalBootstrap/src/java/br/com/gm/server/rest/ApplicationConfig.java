/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.server.rest;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author geoleite
 */
@javax.ws.rs.ApplicationPath("easyportal")
public class ApplicationConfig extends br.com.easynet.rest.ApplicationConfig {

    @Override
    public Set<Class<?>> getClasses() {
        super.getClasses();
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);        
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(br.com.gm.server.rest.UsuarioRest.class);
    }
    
}
