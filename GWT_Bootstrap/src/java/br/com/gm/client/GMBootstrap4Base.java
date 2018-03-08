/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.client;

import br.com.gm.client.component.CloseWindowHandler;
import br.com.gm.client.component.ProgressBar;
import br.com.gm.client.component.WindowMessage;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.ScriptElement;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;

/**
 *
 * @author GMSolution
 */
public abstract class GMBootstrap4Base implements EntryPoint {

    private ProgressBar progressBarAutoLoad = new ProgressBar(0, 100, " Loaded.", ProgressBar.ProgressType.SUCCESS);
    private int time = 5000, contTime = 0, frequency = 100, incProgress = 0;
    private WindowMessage win = new WindowMessage("Load Page", WindowMessage.WindowType.INFO, false, false, false);
    private Element head;
    private String moduleName;

    @Override
    public void onModuleLoad() {
        moduleName = GWT.getModuleName();
        setHead(Document.get().getElementsByTagName("head").getItem(0));
        
        ScriptElement jsJQuery = Document.get().createScriptElement();
        jsJQuery.setType("text/javascript");
        jsJQuery.setSrc(moduleName + "/bootstrap4/bower_components/jquery/dist/jquery.min.js");
        getHead().appendChild(jsJQuery);

        new Timer() {
            @Override
            public void run() {
                ScriptElement jsBootstrap = Document.get().createScriptElement();
                jsBootstrap.setType("text/javascript");
                jsBootstrap.setSrc(moduleName + "/bootstrap4/bower_components/bootstrap/dist/js/bootstrap.min.js");

                ScriptElement jsMetisMenu = Document.get().createScriptElement();
                jsMetisMenu.setType("text/javascript");
                jsMetisMenu.setSrc(moduleName + "/bootstrap4/bower_components/fastclick/lib/fastclick.js");

                ScriptElement jsDataTable = Document.get().createScriptElement();
                jsDataTable.setType("text/javascript");
                jsDataTable.setSrc(moduleName + "/bootstrap4/dist/js/adminlte.min.js");

                ScriptElement jsDataTablePlugin = Document.get().createScriptElement();
                jsDataTablePlugin.setType("text/javascript");
                jsDataTablePlugin.setSrc(moduleName + "/bootstrap4/bower_components/jquery-sparkline/dist/jquery.sparkline.min.js");

                ScriptElement jsDataTableResponsive = Document.get().createScriptElement();
                jsDataTableResponsive.setType("text/javascript");
                jsDataTableResponsive.setSrc(moduleName + "/bootstrap4/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js");

                ScriptElement jsMask = Document.get().createScriptElement();
                jsMask.setType("text/javascript");
                jsMask.setSrc(moduleName + "/bootstrap4/plugins/jvectormap/jquery-jvectormap-world-mill-en.js");

                ScriptElement jsMomentLocales = Document.get().createScriptElement();
                jsMomentLocales.setType("text/javascript");
                jsMomentLocales.setSrc(moduleName + "/bootstrap4/bower_components/jquery-slimscroll/jquery.slimscroll.min.js");

                ScriptElement jsDatetimePicker = Document.get().createScriptElement();
                jsDatetimePicker.setType("text/javascript");
                jsDatetimePicker.setSrc(moduleName + "/bootstrap4/bower_components/Chart.js/Chart.js");

//                ScriptElement jsDatetimePickerGijgo = Document.get().createScriptElement();
//                jsDatetimePickerGijgo.setType("text/javascript");
//                jsDatetimePickerGijgo.setSrc(moduleName + "/bootstrap4/dist/js/pages/dashboard2.js");
                
                final ScriptElement onLoad = Document.get().createScriptElement();
                onLoad.setType("text/javascript");
                onLoad.setSrc(moduleName + "/gm/onload.js");
                
                if (getHead() != null) {
                    getHead().appendChild(jsBootstrap);
                    getHead().appendChild(jsMetisMenu);
                    getHead().appendChild(jsDataTable);
                    getHead().appendChild(jsMask);
                    getHead().appendChild(jsDataTablePlugin);
                    getHead().appendChild(jsDataTableResponsive);
                    getHead().appendChild(jsMomentLocales);
//                    getHead().appendChild(jsDatetimePickerGijgo);
                    getHead().appendChild(onLoad);
                    postLoad();
                }
            }
        }.schedule(1000);

        progressBarAutoLoad.setValue(0);
        incProgress = time / frequency;

        win.add(progressBarAutoLoad);
        win.show();
        try {
            new Timer() {
                @Override
                public void run() {

                    contTime += frequency;
                    int value = (contTime * 100) / time;
                    progressBarAutoLoad.setValue(value);
                    Element isLoad = Document.get().getElementById("loaded");
                    if (value > 100 || (isLoad != null)) {
                        progressBarAutoLoad.setValue(100);
                        if (isLoad == null) {
                            RootPanel.getBodyElement().removeAllChildren();
                            onModuleLoad();
                        }
                        new Timer() {
                            @Override
                            public void run() {
                                win.close();
                                pageLoad();
                            }
                        }.schedule(500);
                    } else {
                        this.schedule(frequency);
                    }
                }
            }.schedule(frequency);
        } catch (Exception e) {
        }
        
    }

    protected void postLoad() {
        
    }
    public abstract void pageLoad();

    /**
     * @return the head
     */
    public Element getHead() {
        return head;
    }

    /**
     * @param head the head to set
     */
    public void setHead(Element head) {
        this.head = head;
    }

    /**
     * @return the moduleName
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * @param moduleName the moduleName to set
     */
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
}
