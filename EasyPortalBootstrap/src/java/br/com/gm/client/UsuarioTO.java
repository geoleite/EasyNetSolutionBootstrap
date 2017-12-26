/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.client;

import br.com.gm.client.model.ModelBase;

/**
 *
 * @author geoleite
 */
public class UsuarioTO extends ModelBase {
   /**
     * @return the nome
     */
    public String getNome() {
        return (String)get("nome");
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        put("nome", nome);
    }

    public String getEmail() {
        return (String)get("email");
    }
    
    public void setEmail(String email) {
        put("email", email);
    }
    
    @Override
    public String getValueDisplay() {
        return getNome();
    }

    @Override
    public String getValue() {
        return getNome();
    }
    
}
