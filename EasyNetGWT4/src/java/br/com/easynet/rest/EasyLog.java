/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.rest;

import br.com.easynet.client.test.StockData;
import br.com.easynet.tansfer.StockT;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
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
@Path("easylog")
public class EasyLog {

    @Context
    private UriInfo context;

    /**
     * Retrieves representation of an instance of br.com.easynet.rest.EasyLog
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        List<StockT> list =new ArrayList<StockT>();
        for (int i = 0; i < 10; i++) {
            StockT stock = new StockT();
            stock.setSymbol("Stock " + i);
            stock.setPrice(i);
            stock.setChange(i);
            list.add(stock);
        }
        return new Gson().toJson(list);
                /*
        return "[\n"
                        + "  {\n"
                        + "    \"symbol\": \"ABC\",\n"
                        + "    \"price\": 47.65563005127077,\n"
                        + "    \"change\": -0.4426563818062567\n"
                        + "  }\n"
                        + "]";
        */
    }

    /**
     * PUT method for updating or creating an instance of EasyLog
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
