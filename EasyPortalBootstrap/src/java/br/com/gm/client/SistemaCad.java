/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.client;

import br.com.gm.client.component.InputText;
import br.com.gm.client.component.Label;
import br.com.gm.client.container.Panel;
import br.com.gm.client.container.PanelGridSimple;

/**
 *
 * @author geoleite
 */
public class SistemaCad extends PanelGridSimple {
    
    private InputText itNome = new InputText();
    private InputText itCpf = new InputText("000.000.000-00");
    private InputText itPlaca = new InputText("SSS-0000");
    public SistemaCad() {
        super(1);
        setHeading("Cadstrar Sistema");
        
        add(new Label("Nome:"));
        add(itNome);
        add(new Label("CPF:"));
        add(itCpf);
        add(new Label("Placa:"));
        add(itPlaca);
    }
}
