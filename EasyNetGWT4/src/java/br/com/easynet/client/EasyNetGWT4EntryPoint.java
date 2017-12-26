/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.client;

import br.com.easynet.client.json.DynamicJson;
import br.com.easynet.client.sqlite.Database;
import br.com.easynet.client.store.LocalStore;
import br.com.easynet.client.store.SessionStore;
import br.com.easynet.client.test.StockData;
import br.com.easynet.client.util.Console;
import br.com.gm.client.component.Button;
import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.ScriptElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.geolocation.client.Geolocation;
import com.google.gwt.geolocation.client.Position;
import com.google.gwt.geolocation.client.PositionError;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Main entry point.
 *
 * @author geoleite
 */
public class EasyNetGWT4EntryPoint extends EasyNetGWT4Base {

    @Override
    public void pageLoad() {
        Button btn = new Button("Sql");
        btn.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {

                String url = GWT.getHostPageBaseURL() + "easynet/easylog";
                RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
                try {
                    Request request = builder.sendRequest(null, new RequestCallback() {
                        @Override
                        public void onResponseReceived(Request request, Response response) {
                            Window.alert("Msg " + response.getText());
                            String json = response.getText();
                            JsArray<StockData> obj = JsonUtils.<JsArray<StockData>>safeEval(json);
                            Window.alert("Dados " + DynamicJson.toJson(obj));
                        }

                        @Override
                        public void onError(Request request, Throwable exception) {
                            Window.alert("ERROR Req " + exception.getMessage());
                        }
                    });
                } catch (RequestException ex) {
                    Window.alert("ERROR " + ex.getMessage());
                }
//                Window.alert("Ok");
//                Database db = Database.createDatabase();
//                Window.alert("DB ");

                //DynamicJson obj = JsonUtils.safeEval("{\"a\":\"b\"}");
            }
        });

        Canvas canvas = Canvas.createIfSupported();
        Context2d ctx = canvas.getContext2d();
        ctx.arc(95, 50, 40, 0, 2 * Math.PI);
        ctx.stroke();
        RootPanel.get().add(canvas);
        RootPanel.get().add(btn);
        LocalStore.getInstance();
        Geolocation.getIfSupported().getCurrentPosition(new Callback<Position, PositionError>() {
            @Override
            public void onFailure(PositionError reason) {
                Window.alert("Erro GPS: " + reason.getMessage());
            }

            @Override
            public void onSuccess(Position result) {
                Window.alert("GPS:" + result.getCoordinates().getLatitude());
            }
        });

    }
}
