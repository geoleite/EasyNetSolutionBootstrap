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
public class PanelGridCustom extends PanelGridSimple {
    private List<ColumnPanelGridConfig> listConfig;    

    public PanelGridCustom() {
        super(1);
    }    
    public PanelGridCustom( String heading) {
        this();
        setHeading(heading);
    }
    public PanelGridCustom( List<ColumnPanelGridConfig> listConfig) {
        this();
        setListConfig(listConfig);       
    }
    
    public PanelGridCustom(String heading, List<ColumnPanelGridConfig> listConfig) {
        this(listConfig);
        setHeading(heading);
    }   

    @Override
    public void add(Widget w) {
        if (cont > columnNumberMax) {
            createRow();
            cont = 1;
        }
        ColumnPanelGridConfig cpgc = getListConfig().get(cont-1);
        DivElement divCol = Document.get().createDivElement();
        setAttribute(divCol, "class", cpgc.getColumnSizeModel());
        super.add(w, divCol);
        listComponents.add(w);
        if (cpgc.getAlign() == ColumnPanelGridConfig.AlignType.CENTER) {
            appendAttribute(divCol, "class", cpgc.getAlign().getValue());
        } else {
            appendAttribute(w.getElement(), "class", cpgc.getAlign().getValue());
        }
//        for (int i = 0; i < listComponents.size(); i++) {
//            Widget widget = listComponents.get(i);
//            appendAttribute(widget.getElement(), "class", cpgc.getAlign().getValue());
//        }
        divRow.appendChild(divCol);
        cont++;
        
//        if (cont > columnNumberMax ) {
//            createRow();
//            cont = 1;
//        }
//        ColumnPanelGridConfig cpgc = getListConfig().get(cont-1);
//        DivElement divCol = Document.get().createDivElement();
//        setAttribute(divCol, "class", cpgc.getColumnSizeModel());
//        super.add(w, divCol);
//        listComponents.add(w);
//        divRow.appendChild(divCol); 
//        cont++;
    }    

    /**
     * @return the listConfig
     */
    public List<ColumnPanelGridConfig> getListConfig() {
        return listConfig;
    }

    /**
     * @param listConfig the listConfig to set
     */
    public void setListConfig(List<ColumnPanelGridConfig> listConfig) {
        if (listConfig == null) {
            listConfig = new ArrayList<ColumnPanelGridConfig>();
            ColumnPanelGridConfig cpg = new ColumnPanelGridConfig(12);
            listConfig.add(cpg);
        }        
        this.listConfig = listConfig;
        columnNumberMax = listConfig.size();
    }
}