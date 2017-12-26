/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.client;

import br.com.gm.client.component.Button;
import br.com.gm.client.component.ButtonGroup;
import br.com.gm.client.component.CheckBox;
import br.com.gm.client.component.CloseWindowHandler;
import br.com.gm.client.component.Column;
import br.com.gm.client.component.ColumnRenderer;
import br.com.gm.client.component.ComboBox;
import br.com.gm.client.component.DataTable;
import br.com.gm.client.component.Datepicker;
import br.com.gm.client.component.Datetimepicker;
import br.com.gm.client.component.Icon;
import br.com.gm.client.component.Image;
import br.com.gm.client.component.InputNumber;
import br.com.gm.client.component.InputText;
import br.com.gm.client.component.InputTextGroup;
import br.com.gm.client.component.Label;
import br.com.gm.client.component.Link;
import br.com.gm.client.component.MenuAccordion;
import br.com.gm.client.component.Navegation;
import br.com.gm.client.component.OptionNavegation;
import br.com.gm.client.component.ProgressBar;
import br.com.gm.client.component.Radio;
import br.com.gm.client.component.RadioGroup;
import br.com.gm.client.component.SelectionNavegationHandler;
import br.com.gm.client.component.WindowMessage;
import br.com.gm.client.component.data.Field;
import br.com.gm.client.component.event.Event;
import br.com.gm.client.component.event.OnChangeEvent;
import br.com.gm.client.container.ChangeTabItemHandler;
import br.com.gm.client.container.ClickTabItemHandler;
import br.com.gm.client.container.ColumnPanelGridConfig;
import br.com.gm.client.container.ConfigBorderLayout;
import br.com.gm.client.container.MenuResponsive;
import br.com.gm.client.container.Panel;
import br.com.gm.client.container.PanelAccordion;
import br.com.gm.client.container.PanelBorderLayout;
import br.com.gm.client.container.PanelGridCustom;
import br.com.gm.client.container.PanelGridSimple;
import br.com.gm.client.container.TabPanel;
import br.com.gm.client.container.WindowConfirm;
import br.com.gm.client.container.WindowConfirmHandler;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.ScriptElement;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;

import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.event.dom.client.MouseWheelHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TabPane;

/**
 * Main entry point.
 *
 * @author geoleite
 */
//public class MainEntryPoint implements EntryPoint {
public class MainEntryPoint_backup extends GMBootstrap3Base {

    private Label label = new Label("Hello, GWT!!!");
    private Button button = new Button("Click me!");
    private Button button2 = new Button("Btn 2!");
    private InputText textBox = new InputText();
    private InputText itCodigo = new InputText();
    private InputText itNome = new InputText();
    private InputText itFone = new InputText();
    private InputNumber numberBox = new InputNumber();
    private InputText textBoxTeste = new InputText();
    private Panel panel = new Panel();
    private PanelAccordion pnAccordion = new PanelAccordion();
    private Panel pn1 = new Panel();
    private DataTable<AlunoTO> dt = new DataTable<AlunoTO>();
    private Navegation nav;
    private PanelBorderLayout panelBorderLayout;
    private Image img = new Image("https://www.w3schools.com/w3images/lights.jpg", Image.ImageType.CIRCLE, "Testando Imagem");
    private ProgressBar progressBar = new ProgressBar(0, 100, " Complete.", ProgressBar.ProgressType.SUCCESS);

    private InputTextGroup textBoxGroup = new InputTextGroup(textBoxTeste);
    private ComboBox<AlunoTO> cbAlunos = new ComboBox<AlunoTO>();
    private CheckBox check = new CheckBox("Ativo");
    private RadioGroup radios = new RadioGroup();
    private ButtonGroup bg = new ButtonGroup();
    private PanelGridSimple panelGridDefault = new PanelGridSimple("Panel Grid Exemplo", 10);
    private PanelGridCustom panelGridCustom = new PanelGridCustom("Panel Grid Customizado Exemplo");
    private TabPanel tab = new TabPanel();

    /**
     * The entry point method, called automatically by loading a module that
     * declares an implementing class as an entry-point
     */
//    @Override
//    public void onModuleLoad() {
//        super.onModuleLoad();
//
//    }
    @Override
    public void pageLoad() {
        //super.pageLoad(); //To change body of generated methods, choose Tools | Templates.
        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {

            }
        });
        button2.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                WindowMessage win = new WindowMessage("Teste", WindowMessage.WindowType.DANGER);
                win.setCloseWindowHandler(new CloseWindowHandler() {
                    @Override
                    public void onCloseWindow() {
                        progressBar.setValue(74);
                    }
                });
                win.add(button);
                win.show();
                progressBar.setValue(44);
            }
        });
        textBox.setEmailModel(true);
        textBox.setUpperCase(true);
//        numberBox.addKeyDownHandler(new KeyDownHandler() {
//            @Override
//            public void onKeyDown(KeyDownEvent event) {
//                event.getNativeEvent().stopPropagation();
//            }
//        });
//        numberBox.addKeyUpHandler(new KeyUpHandler() {
//            @Override
//            public void onKeyUp(KeyUpEvent event) {
//                
//                textBox.setValue(event.getNativeEvent());
//            }
//        });
        textBox.setPlaceHolder("Placa do Carro");
        textBox.setMask("SSS-0000");
        textBoxGroup.setPlaceHolder("Twitter");
        textBoxGroup.setInputAddon("@", ",00");
        textBoxGroup.setValue("192");
//button.setEnabled(true);
        button.setHint("Teste Botão");
//button.setCircleType(Button.ButtonCircleType.LIST);
//button.setButtonType(Button.ButtonType.SUCCESS);
        cbAlunos.setHint("Teste Combo");
        cbAlunos.addChangeHandler(new OnChangeEvent<AlunoTO>() {
            @Override
            public void onChange(Event<AlunoTO> event) {
                textBox.setValue(event.getValue().getFone());
            }
        });
        List<AlunoTO> list = new ArrayList<AlunoTO>();
        for (int i = 0; i < 10; i++) {
            AlunoTO aluTO = new AlunoTO();
            aluTO.setCodigo(i);
            aluTO.setNome("George " + i);
            aluTO.setFone("fone " + i);
            list.add(aluTO);
            cbAlunos.addItem(aluTO);
        }

        panel.setHeading("Teste Panel Titulo");
//panel.setFooter("Teste Panel Rodapé");
        pn1.setHeading("Sub Panel");
        pn1.add(new Label("Código"));
        pn1.add(itCodigo);
        pn1.add(new Label("Nome"));
        pn1.add(itNome);
        pn1.add(new Label("Fone"));
        pn1.add(itFone);
        pn1.add(button);
        pnAccordion.setHeading("Titulo Accordion");
        pnAccordion.addPanel(pn1);
//pn1.setFooter("Teste Panel Rodapé");

        List<Column> colunas = new ArrayList();
        Column col = new Column("nome", "Nome", Column.AlignType.RIGHT);
//col.setWidget(new Label());
//col.setColumnType(Column.ColumnType.DANGER);
        colunas.add(col);
        col = new Column("fone", "Telefone");
        colunas.add(col);
        col = new Column("codigo", null);
        col.setColumnRenderer(new ColumnRenderer<AlunoTO>() {
            @Override
            public Widget onRenderer(AlunoTO field, DataTable dataTable) {
                Button btn = new Button("X");
                btn.setCircle(true);
                //btn.setCircleType(Button.ButtonCircleType.DANGER);
                btn.setObject(field);
                btn.addClickHandler(new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent event) {
                        Button btn = (Button) event.getSource();
                        AlunoTO aluTO = (AlunoTO) btn.getObject();
                        //textBox.setValue(aluTO.getNome());
                        itCodigo.setValue(aluTO.getCodigo() + "");
                        itNome.setValue(aluTO.getNome());
                        itFone.setValue(aluTO.getFone());
                    }
                });
                return btn;
            }
        });
        colunas.add(col);
        col = new Column("visualizar", null);
        col.setColumnRenderer(new ColumnRenderer<AlunoTO>() {
            @Override
            public Widget onRenderer(AlunoTO field, DataTable dataTable) {
                Button btn = new Button("X");
                btn.setCircle(true);
                //btn.setCircleType(Button.ButtonCircleType.DANGER);
                btn.setObject(field);
                btn.addClickHandler(new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent event) {
                        Button btn = (Button) event.getSource();
                        AlunoTO aluTO = (AlunoTO) btn.getObject();
                        //textBox.setValue(aluTO.getNome());
                        itCodigo.setValue(aluTO.getCodigo() + "");
                        itNome.setValue(aluTO.getNome());
                        itFone.setValue(aluTO.getFone());
                    }
                });
                return btn;
            }
        });
        colunas.add(col);

        col = new Column("confirme", null);
        colunas.add(col);
        col.setColumnRenderer(new ColumnRenderer<AlunoTO>() {
            @Override
            public Widget onRenderer(AlunoTO field, DataTable dataTable) {
                Button btn = new Button("C");
                btn.setCircle(true);
                //btn.setCircleType(Button.ButtonCircleType.DANGER);
                btn.setObject(field);
                btn.addClickHandler(new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent event) {
                        Button btn = (Button) event.getSource();
                        AlunoTO aluTO = (AlunoTO) btn.getObject();
                        WindowConfirm.confirm("titulo", "Mensagems", new Button("Confirmar"), new Button("Cancelar")).show();
                    }
                });
                return btn;
            }
        });

        dt.setHeading("DataTable exemplo");
        dt.setHeadVisible(true);
        dt.setListColumns(colunas);
//dt.setRowTypeHead(DataTable.RowType.DANGER);
        dt.addRowType(DataTable.RowType.SUCCESS);
        dt.addRowType(DataTable.RowType.DANGER);
        dt.addRowType(DataTable.RowType.DEFAULT);
        dt.addRowType(DataTable.RowType.WARNING);
        dt.setListStore(list);

//FlowPanel fp = new FlowPanel();
//fp.add(new InputText());
//fp.add(panel);
        label.setBGTextType(Label.BGTextType.PRIMARY);
        label.setTextType(Label.TextType.SECUNDARY);
        label.setBadge("ok");
        panel.add(label);
        panel.add(textBox);
        panel.add(new Label("Numero"));
        panel.add(textBoxGroup);
        panel.add(new Label("Combo"));
        panel.add(cbAlunos);
        panel.setPanelType(Panel.PanelType.SUCCESS);
//panel.add(pnAccordion);
//panel.add(dt);
        button2.setBadge("10");
        panel.add(progressBar);
        progressBar.setValue(24);
        panel.add(check);
        check.setTitle("Check exemplo");
        radios.addRadio(new Radio("r1", "Masculino"));
        radios.addRadio(new Radio("r2", "Feminino"));
        panel.add(radios);
        Button btn1 = new Button("Btn1");
        Button btn2 = new Button("Btn2");
        Button btn3 = new Button("Btn3");
        Button btn4 = new Button("Btn4");
        bg.addButton(btn1);
        bg.addButton(btn2);
        bg.addButton(btn3);
        bg.addButton(btn4);
        panel.add(bg);

        for (int i = 1; i <= 12; i++) {
            Button btn = new Button("Btn" + i);
            panelGridDefault.add(btn);
        }
        panel.add(panelGridDefault);
        List<ColumnPanelGridConfig> listConfig = new ArrayList<ColumnPanelGridConfig>();
        ColumnPanelGridConfig cpgc = new ColumnPanelGridConfig(3);
        listConfig.add(cpgc);
        cpgc = new ColumnPanelGridConfig(3, ColumnPanelGridConfig.AlignType.CENTER);
        listConfig.add(cpgc);
        cpgc = new ColumnPanelGridConfig(6, ColumnPanelGridConfig.AlignType.RIGHT);
        listConfig.add(cpgc);
        panelGridCustom.setListConfig(listConfig);
        for (int i = 1; i <= 12; i++) {
            Button btn = new Button("Btn" + i);
            panelGridCustom.add(btn);
        }
//panel.add(panelGridCustom);
        Panel aba1 = new Panel("Aba 1");
        Panel aba2 = new Panel("Aba 2");
        final Panel aba3 = new Panel("Aba 3");
        Panel aba4 = new Panel("Aba 4");
        aba1.add(new Button("Click"));
        aba2.add(new Label("Click"));
        aba3.add(pnAccordion);
        aba4.add(panelGridCustom);
        aba1.setId("aba1");
        aba2.setId("aba2");
        aba3.setId("aba3");
        aba4.setId("aba4");
//aba2.add(new Label("Click"));
        tab.addPanel(aba1);
        tab.addPanel(aba2);
        tab.addPanel(aba3);
        tab.addPanel(aba4);

//tab.setClickTabItemHandler(new ClickTabItemHandler() {
//            @Override
//            public void onClickTabItem(Panel tabItem, TabPanel tabPanel) {
//                
//                if (tabItem.getId() == aba3.getId()) {                    
//                    pnAccordion.addPanel(dt);
//                }
//            }
//        });
        tab.setChangeTabItemHandler(new ChangeTabItemHandler() {
            @Override
            public void onChangeTabItem(Panel tabItem, TabPanel tabPanel) {
                if (tabItem.getId() == aba3.getId()) {
                    if (!pnAccordion.existPanel(dt)) {
                        pnAccordion.addPanel(dt);
                    }
                }
            }
        });
        panel.add(tab);
        Button btnAux = new Button("Definir aba", Button.ButtonType.SUCCESS, Icon.IconType.CHECK);
        btnAux.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Button btnConfirme = new Button("Confirme", Button.ButtonType.SUCCESS);
                Button btnCancela = new Button("Cancelar", Button.ButtonType.DANGER);
                btnConfirme.addClickHandler(new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent event) {
                        Window.alert("Confirmado");
                    }
                });
                btnCancela.addClickHandler(new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent event) {
                        Window.alert("Cancelado");
                    }
                });

                WindowConfirm.confirm("Confirme", "Mensagem", 
                        br.com.gm.client.container.Window.WindowType.INFO, 
                        new WindowConfirmHandler() {
                    @Override
                    public void onClick(String option) {
                        Window.alert(option);
                    }
                }).show();
                        //                Datepicker date = new Datepicker();
                        //                panel.add(date);                
                        //                for (int i = 10; i < 20; i++) {
                        //                    AlunoTO aluTO = new AlunoTO();
                        //                    int v = Random.nextInt(1000);
                        //                    aluTO.setCodigo(v);
                        //                    aluTO.setNome("George " + v);
                        //                    aluTO.setFone("fone " + v);
                        //                    list.add(aluTO);
                        //                }
                        //                dt.setListStore(list);
            }
        });
        panel.add(btnAux);
        panel.add(button2);
        panel.setUrl("http://www.infonet.com.br");

//panel.add(nav);
//RootPanel.get("btn").add(label);
        Panel pnTop = new Panel();
        //pnTop.add(img);
        //pnTop.setTitle("Top");
        pnTop.setUrl("http://www.infonet.com.br");
        //Panel pnLeft = new Panel();
        MenuAccordion menuAccordion = new MenuAccordion();
        PanelGridSimple opMenu1 = new PanelGridSimple("Home", 1);
        opMenu1.add(new Link("Opcao 1", "Click na opção 1", "#"));
        opMenu1.add(new Link("Opcao 2", "Click na opção 2", "#"));
        menuAccordion.addPanel(opMenu1);
        Panel opMenu2 = new Panel("Administração");
        opMenu2.add(new Link("Opcao 3", "Click na opção 3", "#"));
        menuAccordion.addPanel(opMenu2);
        Panel pnRight = new Panel();
        pnRight.setTitle("Right");
        Panel pnBottom = new Panel();
        pnBottom.setTitle("Bottom");

        nav = new Navegation(createMenu(), Navegation.HORIZONTAL);
        pnTop.add(nav);
        //RootPanel.get().add(nav);
        nav.setSelectionMenuHandler(new SelectionNavegationHandler() {
            @Override
            public void onSelection(OptionNavegation optionNavegation) {
                com.google.gwt.user.client.Window.alert(optionNavegation.getLink().getText());
            }
        });
        //MenuResponsive menu = new MenuResponsive();
        //RootPanel.get().add(menu);
        ConfigBorderLayout configBL = new ConfigBorderLayout(ConfigBorderLayout.BorderSize.COL_12,
                ConfigBorderLayout.BorderSize.NULL,
                ConfigBorderLayout.BorderSize.NULL,
                ConfigBorderLayout.BorderSize.COL_12,
                ConfigBorderLayout.BorderSize.NULL);
        panelBorderLayout = new PanelBorderLayout(pnTop, null, null, panel, null, configBL);
//panelBorderLayout = new PanelBorderLayout();
        RootPanel.get().add(panelBorderLayout);
//        DialogBox dialogBox = new DialogBox(true, true);
//        dialogBox.setText("Dialog Box");
//        dialogBox.setWidget(new Label("Ok"));
//        dialogBox.setGlassEnabled(true);
//        dialogBox.setAnimationEnabled(true);
//        dialogBox.center();        
//        dialogBox.show();        
    }

    private OptionNavegation createMenu() {
        OptionNavegation root = new OptionNavegation();
        Link lnHome = new Link("Home", "");
        lnHome.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                com.google.gwt.user.client.Window.alert("2 handler");
            }
        });
        root.addItem(new OptionNavegation(lnHome, Icon.IconType.HOME));
        OptionNavegation opAdm = new OptionNavegation(new Link("Administração", ""), Icon.IconType.USER);
        opAdm.addItem(new OptionNavegation(new Link("Sistemas", ""), Icon.IconType.TOWER));
        opAdm.addItem(new OptionNavegation(new Link("Perfis", ""), Icon.IconType.ALERT));
        opAdm.addItem(new OptionNavegation(true));
        opAdm.addItem(new OptionNavegation(new Link("Usuários", ""), Icon.IconType.ADJUST));
        root.addItem(opAdm);
        root.addItem(new OptionNavegation(new Link("Frota", ""), Icon.IconType.ASTERISK));

        return root;
    }
}
