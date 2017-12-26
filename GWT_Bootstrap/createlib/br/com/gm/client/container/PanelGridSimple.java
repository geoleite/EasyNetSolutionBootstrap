/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.client.container;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.Widget;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author geoleite
 */
public class PanelGridSimple extends Panel {
    protected DivElement divRow;
    protected int columnNumberMax;
    protected int cont=1;
    protected String columnNumberModel="col-md-1";
    protected List<Widget> listComponents = new ArrayList<Widget>();
    
    public PanelGridSimple( int columnNumber) {
        super();
        this.columnNumberMax = columnNumber;
        if (columnNumberMax > 12 || columnNumberMax < 1) {
            columnNumberMax = 12;
        } else {
            int divColumn = 12 / columnNumberMax;
            this.columnNumberModel = "col-md-" + divColumn;
        }
        createRow();
    }
    public PanelGridSimple(String heading, int columnNumber) {
        this(columnNumber);
        setHeading(heading);
    }
    
    protected void createRow() {
        divRow = Document.get().createDivElement();
        setAttribute(divRow, "class", "row");
        getDivBody().appendChild(divRow);
    }

    @Override
    public void add(Widget w) {
        if (cont > columnNumberMax) {
            createRow();
            cont = 1;
        }
        DivElement divCol = Document.get().createDivElement();
        setAttribute(divCol, "class", columnNumberModel);
        super.add(w, divCol);
        listComponents.add(w);
        divRow.appendChild(divCol);
        cont++;
    }
}
