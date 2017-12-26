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
public class AlunoTO extends ModelBase {

   
    
    @Override
    public String getValueDisplay() {
        return getNome();
    }

    @Override
    public String getValue() {
        return String.valueOf(getCodigo());
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return (Integer)get("codigo");
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        
        put("codigo", codigo);
    }

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

    /**
     * @return the fone
     */
    public String getFone() {
        return (String)get("fone");
    }

    /**
     * @param fone the fone to set
     */
    public void setFone(String fone) {
        put("fone", fone );
    }
    
}
