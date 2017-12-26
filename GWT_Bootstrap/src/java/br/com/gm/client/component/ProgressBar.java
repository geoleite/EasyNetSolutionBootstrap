/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.client.component;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.dom.client.Text;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import jdk.nashorn.internal.objects.NativeDate;

/**
 *
 * @author geoleite
 */
public class ProgressBar extends Widget {
    /*
 <div class="progress">
  <div class="progress-bar" role="progressbar" aria-valuenow="70"
  aria-valuemin="0" aria-valuemax="100" style="width:70%">
    <span class="sr-only">70% Complete</span>
  </div>
</div>     */
    private DivElement divProgress;
    private DivElement divProgressBar;
    private SpanElement spanElement;
    private int value=0, minValue=0, maxValue=100;
    private String text="";
            
    public static enum ProgressType {
        SUCCESS("progress-bar progress-bar-success"), INFO("progress-bar progress-bar-info"), 
        DANGER("progress-bar progress-bar-danger"), WARNING("progress-bar progress-bar-warning");
        
        private String value;

        ProgressType(String type) {
            this.value = type;
        }

        public String getValue() {
            return value;
        }
    };
    
    public ProgressBar() {
        super();
        createProgress();
    }
    
    public ProgressBar(int min, int max) {
        this();
        setMinValue(min);
        setMaxValue(max);
    }
    
    public ProgressBar(int min, int max, String text) {
        this(min, max);
        setText(text);
    }
    
    public ProgressBar(int min, int max, String text, ProgressType progressType) {
        this(min, max, text);
        setProgressType(progressType);
    }
    
    public void setProgressType(ProgressType progressType) {
        setAttribute(divProgressBar, "class", progressType.getValue());
    }
    
    private void createProgress() {
        divProgress = Document.get().createDivElement();
        setElement(divProgress);
        //getElement().appendChild(divProgress);
        setAttribute(divProgress, "class", "progress");
        createProgressBar();
    }
    
    private void createProgressBar() {
        divProgressBar = Document.get().createDivElement();
        divProgress.appendChild(divProgressBar);
        setAttribute(divProgressBar, "class", "progress-bar");
        setAttribute(divProgressBar, "role", "progressbar");
        setAttribute(divProgressBar, "aria-valuenow", "0");
        setAttribute(divProgressBar, "aria-valuemin", "0");
        setAttribute(divProgressBar, "aria-valuemax", "100");
        setAttribute(divProgressBar, "style", "width:0%");
        createSpan();
    }
    
    private void createSpan() {
        spanElement = Document.get().createSpanElement();
        divProgressBar.appendChild(spanElement);
        setAttribute(spanElement, "class", "sr-only");
    }

    public void appendAttribute(Element element, String name, String value) {
        String valueAttr = element.getAttribute(name);
        valueAttr += " " + value;
        element.setAttribute(name, valueAttr);
    }
    
    public void setAttribute(Element element, String name, String value) {
        element.setAttribute(name, value);
    }
    
    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
        if (value >= minValue && value <= maxValue) {
            divProgressBar.removeAllChildren();
            //spanElement.removeAllChildren();
            setAttribute(divProgressBar, "style", "width:" + value + "%");
            Text textNode = Document.get().createTextNode(value + "% " + text);
            divProgressBar.appendChild(textNode);
            //spanElement.appendChild(Document.get().createTextNode(value + text));
        }
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text==null?"":text;
        
    }

    /**
     * @return the minValue
     */
    public int getMinValue() {
        return minValue;
    }

    /**
     * @param minValue the minValue to set
     */
    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    /**
     * @return the maxValue
     */
    public int getMaxValue() {
        return maxValue;
    }

    /**
     * @param maxValue the maxValue to set
     */
    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }
}
