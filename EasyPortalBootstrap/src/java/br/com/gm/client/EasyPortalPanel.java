/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.client;

import br.com.gm.client.component.Button;
import br.com.gm.client.component.Icon;
import br.com.gm.client.component.Label;
import br.com.gm.client.component.Link;
import br.com.gm.client.component.MenuAccordion;
import br.com.gm.client.component.Navegation;
import br.com.gm.client.component.OptionNavegation;
import br.com.gm.client.component.SelectionNavegationHandler;
import br.com.gm.client.container.Panel;
import br.com.gm.client.container.PanelAccordion;
import br.com.gm.client.container.PanelGridCustom;
import br.com.gm.client.container.PanelGridSimple;
import br.com.gm.client.container.TabPanel;
import br.com.gm.client.usuario.UsuarioCon;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.OptionElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;

/**
 *
 * @author geoleite
 */
public class EasyPortalPanel extends PanelGridSimple implements SelectionNavegationHandler {

    private Panel panelTop = new Panel();
    //private Panel panelMenu = new Panel();
    private Panel panelContent = new Panel();
    private TabPanel tabPanel = new TabPanel();
    private Navegation navMenu;
    private OptionNavegation root;

    public EasyPortalPanel() {
        super(1);
        //panelMenu.setHeading("Menu");
        //panelMenu.setHeadVisible(false);
        //panelContent.setHeadVisible(false);
        //add(panelMenu, divLeft);
        setHeadVisible(false);
        //panelTop.setHeadVisible(false);
        //panelTop.setFooter(id);
        //add(panelTop);

        //add(navMenu, divTop);
        //add(panelContent, divCenter);
        createMenu();
        createTabItemDefault();
    }

    protected void createTabItemDefault() {
        Panel pnWelcome = new Panel("Welcome");
        pnWelcome.add(new Label("Lorem ipsum dolor sit amet consectetur adipisicing elit. Sequi iste ratione repellat architecto, dolore dicta aliquid, error quasi optio quisquam a excepturi, exercitationem libero consequatur maiores rerum corporis nobis asperiores! Lorem ipsum dolor sit amet consectetur adipisicing elit. A obcaecati error dolore eos accusamus magnam, voluptates vero eligendi, nemo architecto consequatur quod quo harum alias rerum molestiae laboriosam velit dolorum. "));
        panelContent.add(getTabPanel());
        getTabPanel().addPanel(pnWelcome, false);
        add(panelContent);
    }

    protected void createMenu() {
        root = new OptionNavegation();
        Link lnHome = new Link("Início", "");
        OptionNavegation home = new OptionNavegation(lnHome, Icon.IconType.HOME);
        root.addItem(home);
        Link lnAlterarDados = new Link("Alterar Dados", "");
        OptionNavegation alterarDados = new OptionNavegation(lnAlterarDados, Icon.IconType.NULL);
        Link lnAlterarSenha = new Link("Alterar Senha", "");
        OptionNavegation alterarSenha = new OptionNavegation(lnAlterarSenha, Icon.IconType.NULL);
        Link lnSair = new Link("Sair", "");
        OptionNavegation sair = new OptionNavegation(lnSair, Icon.IconType.OFF, "sair");
        home.addItem(alterarDados);
        home.addItem(alterarSenha);
        home.addItem(new OptionNavegation(true));
        home.addItem(sair);

        Link lnAdm = new Link("Administração", "");
        OptionNavegation adm = new OptionNavegation(lnAdm, Icon.IconType.COG);
        Link lnSistemas = new Link("Sistemas", "");
        OptionNavegation sistemas = new OptionNavegation(lnSistemas, Icon.IconType.NULL, "sistema");
        adm.addItem(sistemas);
        Link lnUsuarios = new Link("Usuários", "");
        OptionNavegation usuarios = new OptionNavegation(lnUsuarios, Icon.IconType.NULL, "usuario");
        adm.addItem(usuarios);
        Link lnPerfis = new Link("Perfis", "");
        OptionNavegation perfis = new OptionNavegation(lnPerfis, Icon.IconType.NULL, "perfil");
        adm.addItem(perfis);
        root.addItem(adm);
        navMenu = new Navegation(root, Navegation.HORIZONTAL);
        navMenu.setSelectionMenuHandler(this);
        add(navMenu);
    }

    /**
     * @return the tabPanel
     */
    public TabPanel getTabPanel() {
        return tabPanel;
    }

    @Override
    public void onSelection(OptionNavegation optionNavegation) {
        if ("sair".equalsIgnoreCase(optionNavegation.getActionID())) {
            Window.Location.reload();
        } else if ("sistema".equalsIgnoreCase(optionNavegation.getActionID())) {
            SistemaCad tabItem = new SistemaCad();
            tabItem.setId("tabItem-" + optionNavegation.getActionID());
            getTabPanel().addPanel(tabItem, true);
        } else if ("usuario".equalsIgnoreCase(optionNavegation.getActionID())) {
            UsuarioCon tabItem = new UsuarioCon();
            tabItem.setId("tabItem-" + optionNavegation.getActionID());
            getTabPanel().addPanel(tabItem, true);
        } else {
            createTabItem(optionNavegation);
        }
    }

    private void createTabItem(OptionNavegation opNav) {
        Panel tabItem = new Panel(opNav.getLink().getText());
        tabItem.setId("tabItem-" + opNav.getLink().getId());
        tabItem.add(new Label(opNav.getElement().toString()));
        getTabPanel().addPanel(tabItem, true);

    }
}
