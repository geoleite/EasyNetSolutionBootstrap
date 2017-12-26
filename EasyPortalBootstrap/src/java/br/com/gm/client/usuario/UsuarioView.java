/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.client.usuario;

import br.com.gm.client.UsuarioTO;
import br.com.gm.client.component.Label;

/**
 *
 * @author geoleite
 */
public class UsuarioView extends UsuarioAltDel {
    private Label lbNome = new Label();
    private Label lbEmail = new Label();
    public UsuarioView() {
        btnAlterar.setVisible(false);
        btnExcluir.setVisible(false);
    }

    @Override
    public void load(UsuarioTO usuTO) {
        super.load(usuTO);
        if (usuTO != null) {
//            lbNome.setText(usuTO.getNome());
//            lbEmail.setText(usuTO.getEmail());
            itNome.setReadOnly(true);
            itEmail.setReadOnly(true);
        }        
    }       
}
