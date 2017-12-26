/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.client.to;

import br.com.easynet.client.json.DynamicJson;

/**
 *
 * @author geoleite
 */
public class SistemaTOGWT extends DynamicJson {
    protected SistemaTOGWT() {
        
    }
    public final int getSisNrId() {
        return getInteger("sis_nr_id");
    }
    
    public final void setSisNrId(int sisNrid) {
        set("sis_nr_id", sisNrid);
    }

    public final String getSisTxNome() {
        return getString("sis_tx_nome");
    }
    
    public final void setSisTxNome(String sisTxNome) {
        set("sis_tx_nome", sisTxNome);
    }
    
    public final String getSisTxDescricao() {
        return getString("sis_tx_descricao");
    }
    
    public final void setSisTxDescricao(String sisTxDescricao) {
        set("sis_tx_descricao", sisTxDescricao);
    }

    public final String getSisTxStatus() {
        return getString("sis_tx_status");
    }
    
    public final void setSisTxStatus(String sisTxStatus) {
        set("sis_tx_status", sisTxStatus);
    }
}
