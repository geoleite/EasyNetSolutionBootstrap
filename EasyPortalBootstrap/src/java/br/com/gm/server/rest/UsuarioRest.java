/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.server.rest;

import br.com.easynet.client.util.GMJson;
import br.com.gm.server.to.UsuarioTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Date;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author geoleite
 */
@Path("usuariorest")
@RolesAllowed({"ADMIN", "ORG1"})
public class UsuarioRest {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UsuarioRest
     */
    public UsuarioRest() {
    }

    /**
     * Retrieves representation of an instance of
     * br.com.gm.server.rest.UsuarioRest
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/authenticate")
    public String authenticate() {
        //TODO return proper representation object
        UsuarioTO usuTO = new UsuarioTO();
        usuTO.setUsuNrId(1);
        usuTO.setUsuTxNome("George Leite");
        usuTO.setUsuTxLogin("geoleite");
        usuTO.setUsuTxEmail("georgeleitejunior@gmail.com");
        usuTO.setUsuTxTrocarSenha("N");
        usuTO.setUsuDtCadastro(new Date());

        return GMJson.getGsonDateFormat().toJson(usuTO);
    }

    /**
     * PUT method for updating or creating an instance of UsuarioRest
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
