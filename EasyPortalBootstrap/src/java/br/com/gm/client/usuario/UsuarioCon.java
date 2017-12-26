/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.client.usuario;

import br.com.gm.client.AlunoTO;
import br.com.gm.client.UsuarioTO;
import br.com.gm.client.component.Button;
import br.com.gm.client.component.Column;
import br.com.gm.client.component.ColumnRenderer;
import br.com.gm.client.component.DataTable;
import br.com.gm.client.component.Icon;
import br.com.gm.client.container.Panel;
import br.com.gm.client.container.PanelGridSimple;
import br.com.gm.client.container.WindowConfirm;
import br.com.gm.client.container.WindowConfirmHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author geoleite
 */
public class UsuarioCon extends PanelGridSimple {

    private DataTable<UsuarioTO> dataTable = new DataTable<UsuarioTO>();
    private Button btnNovo = new Button("", Button.ButtonType.SUCCESS, Icon.IconType.FILE);
    private List<Column> colunas = new ArrayList();
    private List<UsuarioTO> list = new ArrayList<UsuarioTO>();

    public UsuarioCon() {
        super(1);
        setHeading("Usuários");
        btnNovo.setHint("Criar novo Usuário");
        btnNovo.setCircle(true);
        btnNovo.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                UsuarioCad usuCad = new UsuarioCad();
                usuCad.setUsuCon(UsuarioCon.this);
                usuCad.show();
            }
        });
        add(btnNovo);
        Column col = new Column("nome", "Nome", Column.AlignType.LEFT);
        colunas.add(col);
        col = new Column("email", "Email", Column.AlignType.LEFT);
        colunas.add(col);
        col = new Column("visualizar", null);
        col.setColumnRenderer(new ColumnRenderer<UsuarioTO>() {
            @Override
            public Widget onRenderer(UsuarioTO field, DataTable dataTable) {
                Button btn = new Button("", Button.ButtonType.SUCCESS, Icon.IconType.EYE_OPEN);
                btn.setHint("Visualizar dados do usuário");
                btn.setCircle(true);
                //btn.setCircleType(Button.ButtonCircleType.DANGER);
                btn.setObject(field);
                btn.addClickHandler(new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent event) {
                        Button btn = (Button) event.getSource();
                        UsuarioTO usuTO = (UsuarioTO) btn.getObject();
                        UsuarioView usuView = new UsuarioView();
                        usuView.load(usuTO);
                        usuView.show();
                    }
                });
                return btn;
            }
        });
        colunas.add(col);

        col = new Column("editar", null);
        colunas.add(col);
        col.setColumnRenderer(new ColumnRenderer<UsuarioTO>() {
            @Override
            public Widget onRenderer(UsuarioTO field, DataTable dataTable) {
                Button btn = new Button("", Button.ButtonType.WARNING, Icon.IconType.EDIT);
                btn.setHint("Alterar dados do Usuário");
                btn.setCircle(true);
                //btn.setCircleType(Button.ButtonCircleType.DANGER);
                btn.setObject(field);
                btn.addClickHandler(new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent event) {
                        Button btn = (Button) event.getSource();
                        UsuarioTO usuTO = (UsuarioTO) btn.getObject();
                        UsuarioAltDel usuAltDel = new UsuarioAltDel();
                        usuAltDel.setUsuCon(UsuarioCon.this);
                        usuAltDel.load(usuTO);
                        usuAltDel.show();
                    }
                });
                return btn;
            }
        });

        col = new Column("excluir", null);
        colunas.add(col);
        col.setColumnRenderer(new ColumnRenderer<UsuarioTO>() {
            @Override
            public Widget onRenderer(UsuarioTO field, DataTable dataTable) {
                Button btn = new Button("", Button.ButtonType.DANGER, Icon.IconType.REMOVE);
                btn.setHint("Excluir usuário");
                btn.setCircle(true);
                //btn.setCircleType(Button.ButtonCircleType.DANGER);
                btn.setObject(field);
                btn.addClickHandler(new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent event) {
                        Button btn = (Button) event.getSource();
                        final UsuarioTO usuTO = (UsuarioTO) btn.getObject();
                        WindowConfirm.confirm("Excluir Usuário", "Tem certeza que deseja excluir usuário?", br.com.gm.client.container.Window.WindowType.WARNING, 
                                new WindowConfirmHandler() {
                            @Override
                            public void onClick(String option) {
                                if (WindowConfirm.OK.equalsIgnoreCase(option)) {
                                   list.remove(usuTO);
                                   load();
                                }
                            }
                        }).show();
                    }
                });
                return btn;
            }
        });

        dataTable.setHeading("Lista de Alunos");
        dataTable.setHeadVisible(true);
        dataTable.setListColumns(colunas);
//dt.setRowTypeHead(DataTable.RowType.DANGER);
        dataTable.addRowType(DataTable.RowType.SUCCESS);
        dataTable.addRowType(DataTable.RowType.DEFAULT);
        add(dataTable);
    }

    public void load() {
        dataTable.setListStore(list);
    }

    /**
     * @return the list
     */
    public List<UsuarioTO> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<UsuarioTO> list) {
        this.list = list;
    }
}
