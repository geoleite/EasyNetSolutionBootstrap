/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.client.usuario;

import br.com.gm.client.UsuarioTO;
import br.com.gm.client.component.Button;
import br.com.gm.client.component.Icon;
import br.com.gm.client.component.InputText;
import br.com.gm.client.component.Label;
import br.com.gm.client.container.PanelGridSimple;
import br.com.gm.client.container.Window;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

/**
 *
 * @author geoleite
 */
public class UsuarioCad extends Window {
    
    protected InputText itNome = new InputText(), itEmail = new InputText();
    protected Button btnCadastrar = new Button("", Button.ButtonType.SUCCESS, Icon.IconType.OK);
    protected Button btnFechar = new Button("", Button.ButtonType.DEFAULT, Icon.IconType.OFF);
    protected UsuarioCon usuCon;
    
    public UsuarioCad() {
        setHeading("Cadastrar Usuário");
        add(new Label("Nome"));
        add(itNome);
        add(new Label("Email"));
        add(itEmail);
        btnCadastrar.setHint("Cadastrar Usuário");
        btnCadastrar.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (usuCon != null) {
                    UsuarioTO usuTO = new UsuarioTO();
                    usuTO.setNome(itNome.getText());
                    usuTO.setEmail(itEmail.getText());
                    usuCon.getList().add(usuTO);
                    UsuarioCad.this.close();
                    usuCon.load();
                }
            }
        });
        
        btnFechar.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                UsuarioCad.this.close();
            }
        });
        btnFechar.setCircle(true);
        btnFechar.setHint("Fechar Janela");
        addFooter(btnFechar);
        addFooter(btnCadastrar);
    }

    /**
     * @return the usuCon
     */
    public UsuarioCon getUsuCon() {
        return usuCon;
    }

    /**
     * @param usuCon the usuCon to set
     */
    public void setUsuCon(UsuarioCon usuCon) {
        this.usuCon = usuCon;
    }
}
