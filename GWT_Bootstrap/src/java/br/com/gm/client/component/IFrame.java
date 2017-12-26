/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.client.component;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.IFrameElement;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;

/**
 *
 * @author geoleite
 */
public class IFrame extends Widget {

    //<iframe src="URL"></iframe> 
    private DivElement div;
    private IFrameElement iframe;
    private String src, width = "100%", height = "100%";

    public IFrame() {
        createDiv();
    }
    
    private void createDiv() {
        div = Document.get().createDivElement();
        setElement(div);
        div.setAttribute("class", "embed-responsive embed-responsive-16by9");
        createIFrame();
    }
    private void createIFrame() {
        iframe = Document.get().createIFrameElement();
        div.appendChild(iframe);
        iframe.setFrameBorder(0);
        iframe.setNoResize(false);
        iframe.setAttribute("class", "embed-responsive-item");
        //iframe.setAttribute("width", "100%");
        //iframe.setAttribute("height", "100%");
        //resize(Window.getClientWidth(), Window.getClientHeight());
        
    }

    public IFrame(String src) {
        this();
        Window.addResizeHandler(new ResizeHandler() {
            @Override
            public void onResize(ResizeEvent event) {
                
                resize(event.getWidth(), event.getHeight());
            }
        });
        setSrc(src);
    }

    private void resize(int w, int h) {
//        int w = event.getWidth();
//        int h = event.getHeight();
        String widthFinal = width;
        String heightFinal = height;
        if (width != null && width.indexOf("%") > 0) {
            int wPercent = Integer.parseInt(width.replace("%", "").trim());
            w = (w * wPercent) / 100;
            widthFinal = w + "px";
        }
        if (height != null && height.indexOf("%") > 0) {
            int hPercent = Integer.parseInt(height.replace("%", "").trim());
            h = (h * hPercent) / 100;
            heightFinal = h + "px";
        }
        iframe.setAttribute("style", "width: " + widthFinal + "; height: " + heightFinal + ";");

    }

    /**
     * @return the src
     */
    public String getSrc() {
        return src;
    }

    /**
     * @param src the src to set
     */
    public void setSrc(String src) {
        this.src = src;
        //iframe.setAttribute("src", src);
        iframe.setSrc(src);
    }

    /**
     * @return the width
     */
    public String getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(String width) {
        this.width = width;
        //iframe.setAttribute("style", "width: " + width + "; height: " + height + ";");
        //iframe.setAttribute("width", width);
        //resize(Window.getClientWidth(), Window.getClientHeight());
    }

    /**
     * @return the height
     */
    public String getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(String height) {
        this.height = height;
        //iframe.setAttribute("style", "width: " + width + "; height: " + height + ";");
        //iframe.setAttribute("height", height);
        //resize(Window.getClientWidth(), Window.getClientHeight());
    }
}
