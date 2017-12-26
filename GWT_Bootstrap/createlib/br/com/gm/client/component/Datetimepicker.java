/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.client.component;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.dom.client.ScriptElement;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlowPanel;
import java.util.Date;

/**
 * <div class="container">
 * <div class="row">
 * <div class='col-sm-6'>
 * <div class="form-group">
 * <div class='input-group date' id='datetimepicker1'>
 * <input type='text' class="form-control" />
 * <span class="input-group-addon">
 * <span class="glyphicon glyphicon-calendar"></span>
 * </span>
 * </div>
 * </div>
 * </div>
 * <script type="text/javascript">
 * $(function () { $('#datetimepicker1').datetimepicker(); });
 * </script>
 * </div>
 * </div> * @author geoleite
 */
public class Datetimepicker extends FlowPanel {

    private DivElement divContainer, divRow, divCol, divForm, divInputGroup;
    private SpanElement spanAddon, spanIcon;
    private InputElement input;
    private ScriptElement script;
    private String id;
    //private InputText input = new InputText();
    private static String formatDate = "dd/mm/yyyy";
    private Date value = new Date(System.currentTimeMillis());
    private String locale = "pt_BR";
    private static DateTimeFormat dtf = DateTimeFormat.getFormat(formatDate);
    private String valueStr = dtf.format(value);

    public Datetimepicker() {
        id = "datepicker" + Random.nextInt(1000);
        createContainer();
    }

    public void setAttribute(Element element, String name, String value) {
        element.setAttribute(name, value);
    }

    private void createContainer() {
        if (divContainer != null) {
            divContainer.removeAllChildren();
        } else {
            divContainer = Document.get().createDivElement();
            setElement(divContainer);
            setAttribute(divContainer, "class", "container");
        }
        createRow();
    }

    private void createRow() {
        divRow = Document.get().createDivElement();
        divContainer.appendChild(divRow);
        setAttribute(divRow, "class", "row");
        createCol();
        createScript();
    }

    private void createCol() {
        divCol = Document.get().createDivElement();
        divRow.appendChild(divCol);
        setAttribute(divCol, "class", "col-sm-6");
        createForm();
    }

    private void createForm() {
        divForm = Document.get().createDivElement();
        divCol.appendChild(divForm);
        setAttribute(divForm, "class", "form-group");
        createInputGroup();
    }

    private void createInputGroup() {
        divInputGroup = Document.get().createDivElement();
        divForm.appendChild(divInputGroup);
        setAttribute(divInputGroup, "class", "input-group date");
        setAttribute(divInputGroup, "id", id);
        createInput();
        createSpanAddon();
    }

    private void createInput() {
        input = Document.get().createTextInputElement();
        setAttribute(input, "type", "text");
        setAttribute(input, "class", "form-control");
        divInputGroup.appendChild(input);
        //add(input, divInputGroup);
    }

    private void createSpanAddon() {
        spanAddon = Document.get().createSpanElement();
        divInputGroup.appendChild(spanAddon);
        setAttribute(spanAddon, "class", "input-group-addon");
        createIcon();
    }

    private void createIcon() {
        //<span class="glyphicon glyphicon-calendar"></span>
        spanIcon = Document.get().createSpanElement();
        spanAddon.appendChild(spanIcon);
        setAttribute(spanIcon, "class", "glyphicon glyphicon-calendar");
    }

    private void createScript() {
        String sourceJS = "$(function () {\n" +
"                $('#" + id + "').datetimepicker({"
                + "format: '" + formatDate + "',"
                + "autoclose: true,"
                + "locale: '" + locale + "'"                
                + "});\n" +
"            });";
        script = Document.get().createScriptElement(sourceJS);
        script.setType("text/javascript");
        divRow.appendChild(script);
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
        //Refazendo a estrutura pra definir o novo id
        createContainer();
    }

    /**
     * @return the value
     */
    public Date getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(Date value) {
        this.value = value;
        if (value != null) {
            valueStr = dtf.format(value);
            createContainer();
        }
    }

    /**
     * @return the valueStr
     */
    public String getValueStr() {
        return valueStr;
    }

    /**
     * @param valueStr the valueStr to set
     */
    public void setValueStr(String valueStr) {
        this.valueStr = valueStr;
        if (valueStr != null && valueStr.trim().length() > 0) {
            value = dtf.parse(valueStr);
            createContainer();
        }
    }

    /**
     * @return the formatDate
     */
    public String getFormatDate() {
        return formatDate;
    }

    /**
     * @param aFormatDate the formatDate to set
     */
    public void setFormatDate(String aFormatDate) {
        formatDate = aFormatDate;
    }

    /**
     * @return the locale
     */
    public String getLocale() {
        return locale;
    }

    /**
     * @param locale the locale to set
     */
    public void setLocale(String locale) {
        this.locale = locale;
        createContainer();
    }
}
