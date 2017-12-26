/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.client.usuario;

import br.com.gm.client.UsuarioTO;
import br.com.gm.client.component.Button;
import br.com.gm.client.component.Icon;
import br.com.gm.client.container.Window;
import br.com.gm.client.container.WindowConfirm;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

/**
 *
 * @author geoleite
 */
public class UsuarioAltDel extends UsuarioCad {

    protected Button btnAlterar = new Button("", Button.ButtonType.SUCCESS, Icon.IconType.OK);
    protected Button btnExcluir = new Button("", Button.ButtonType.DANGER, Icon.IconType.REMOVE);
    protected UsuarioTO usuTO;

    public UsuarioAltDel() {
        super();
        setHeading("Alterar Usuário");
        btnCadastrar.setVisible(false);
        btnAlterar.setCircle(true);
        btnAlterar.setHint("Salvar");
        btnExcluir.setCircle(true);
        btnExcluir.setHint("Excluir");
        btnAlterar.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (usuTO != null) {
                    usuTO.setNome(itNome.getText());
                    usuTO.setEmail(itEmail.getText());
                    if (usuCon != null) {
                        usuCon.load();
                        UsuarioAltDel.this.close();
                    }
                }
            }
        });
        btnExcluir.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (usuTO != null) {
                    if (usuCon != null) {
                        Button btnConfirme = new Button("Confirme", Button.ButtonType.SUCCESS);
                        Button btnCancela = new Button("Cancelar", Button.ButtonType.DANGER);
                        btnConfirme.addClickHandler(new ClickHandler() {
                            @Override
                            public void onClick(ClickEvent event) {
                                usuCon.getList().remove(usuTO);
                                usuCon.load();
                                UsuarioAltDel.this.close();
                            }
                        });
                        btnCancela.addClickHandler(new ClickHandler() {
                            @Override
                            public void onClick(ClickEvent event) {
                                UsuarioAltDel.this.close();
                            }
                        });
                        WindowConfirm.confirm("Excluir Usuário", "Tem certeza que deseja excluir usuário?", btnConfirme, btnCancela).show();
                    }
                }
            }
        });
        addFooter(btnAlterar);
        addFooter(btnExcluir);
    }

    public void load(UsuarioTO usuTO) {
        this.usuTO = usuTO;
        if (usuTO != null) {
            itNome.setText(usuTO.getNome());
            itEmail.setText(usuTO.getEmail());
        }
    }

    /**
     * @return the usuTO
     */
    public UsuarioTO getUsuTO() {
        return usuTO;
    }
}
