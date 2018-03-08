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
//public class MainEntryPointBootstrap4 implements EntryPoint {
public class MainEntryPointBootstrap4 extends GMBootstrap4Base {



    @Override
    public void pageLoad() {

        Panel panel = new Panel("Teste Iframe");
        panel.add(new Label("Ok"));
        panel.add(new InputText("Ok"));
        panel.add(new Button("Ok"));
        //panel.setUrl("http://www.infonet.com.br");
        RootPanel.get().add(panel);
    }
}
