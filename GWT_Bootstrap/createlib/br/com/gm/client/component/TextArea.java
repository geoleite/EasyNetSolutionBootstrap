/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.client.component;

import com.google.gwt.user.client.Random;

/**
 *
 * @author geoleite
 */
public class TextArea extends com.google.gwt.user.client.ui.TextArea {
    private int rows=3;
    private String id;
    public TextArea() {
        setId("textarea" + Random.nextInt(1000));
        getElement().setAttribute("class", "form-control");
        setRows(rows);
    }
    
    private void appendAttribute(String name, String value) {
        String valueAttr = getElement().getAttribute(name);
        valueAttr += " " + value;
        getElement().setAttribute(name, valueAttr);

    }    

    /**
     * @return the rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * @param rows the rows to set
     */
    public void setRows(int rows) {
        this.rows = rows;
        appendAttribute("rows", "" + rows);
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
        getElement().setAttribute("id", id);
    }
}
