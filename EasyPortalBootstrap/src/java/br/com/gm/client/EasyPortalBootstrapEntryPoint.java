/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.client;

import br.com.easynet.client.EasyNetGWT4Base;
import br.com.easynet.client.rest.GMRequestBuilder;
import br.com.easynet.client.test.StockData;
import br.com.easynet.client.util.Console;
import br.com.gm.client.component.Button;
import br.com.gm.client.container.Panel;
import br.com.gm.client.component.InputText;
import br.com.gm.client.component.Label;
import br.com.gm.client.container.Window;
import br.com.gm.client.dao.UsuarioDAO;
import br.com.gm.client.to.SistemaTOGWT;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Main entry point.
 *
 * @author geoleite
 */
public class EasyPortalBootstrapEntryPoint extends EasyNetGWT4Base {

    private Window window = new Window(false);
    private InputText itLogin = new InputText();
    private InputText itPassword = new InputText(true);
    private Button btnEnter = new Button("Entrar", Button.ButtonType.SUCCESS);

    @Override
    public void pageLoad() {
        Console.write("Iniciando o Portal");
        window.setHeading("Autenticação");
        window.add(new Label("Usuário"));
        window.add(itLogin);
        window.add(new Label("Senha"));
        window.add(itPassword);
        window.add(btnEnter);
        btnEnter.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                String url = "";

                //GMRequestBuilder builder = new GMRequestBuilder(RequestBuilder.GET, url);
                UsuarioDAO usuDao = new UsuarioDAO();
                try {
                    SistemaTOGWT sisTO = (SistemaTOGWT)SistemaTOGWT.createObject();
                    com.google.gwt.user.client.Window.alert("Obj " + sisTO);
                    sisTO.setSisNrId(10);
                    sisTO.setSisTxDescricao("Descricao");
                    sisTO.setSisTxNome("Nome");
                    sisTO.setSisTxStatus("A");
                    com.google.gwt.user.client.Window.alert("Obj JSON " + sisTO.toJson());
                    Request request = usuDao.autenticate().sendRequestObject(sisTO, new RequestCallback() {
                        @Override
                        public void onResponseReceived(Request request, Response response) {
                            com.google.gwt.user.client.Window.alert("Msg " + response.getText());
                            //String json = response.getText();
                            //JsArray<StockData> obj = JsonUtils.<JsArray<StockData>>safeEval(json);
                            //com.google.gwt.user.client.Window.alert("Dados " + json);
                        }

                        @Override
                        public void onError(Request request, Throwable ex) {
                            com.google.gwt.user.client.Window.alert("ERROR " + ex.getMessage());
                        }
                    });
                    /*(sisTO, new RequestCallback() {
                        @Override
                        public void onResponseReceived(Request request, Response response) {
                            com.google.gwt.user.client.Window.alert("Msg " + response.getText());
                            String json = response.getText();
                            JsArray<StockData> obj = JsonUtils.<JsArray<StockData>>safeEval(json);
                            com.google.gwt.user.client.Window.alert("Dados " + obj.get(0).getSymbol());
                        }

                        @Override
                        public void onError(Request request, Throwable exception) {
                            com.google.gwt.user.client.Window.alert("ERROR Req " + exception.getMessage());
                        }
                    });
                     */
                } catch (RequestException ex) {
                    com.google.gwt.user.client.Window.alert("ERROR " + ex.getMessage());
                }
                window.close();
                EasyPortalPanel epp = new EasyPortalPanel();
                RootPanel.get().add(epp);
            }
        });
        window.show();
        //RootPanel.get().add(window);
    }

}
