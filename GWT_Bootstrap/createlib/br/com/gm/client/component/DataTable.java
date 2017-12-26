/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.client.component;

import br.com.gm.client.component.data.Field;
import br.com.gm.client.container.Panel;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.ScriptElement;
import com.google.gwt.dom.client.TableCellElement;
import com.google.gwt.dom.client.TableElement;
import com.google.gwt.dom.client.TableRowElement;
import com.google.gwt.dom.client.TableSectionElement;
import com.google.gwt.dom.client.Text;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.Window;

import com.google.gwt.user.client.ui.Widget;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author geoleite
 */
public class DataTable<T extends Field> extends Panel {

    private DivElement divTableResponsive;
    private TableElement tableElement;
    private TableSectionElement tHeadElement;
    private TableSectionElement tBodyElement;
    private TableSectionElement tFootElement;
    private ScriptElement script;
    private List<Column> listColumns = new ArrayList<Column>();
    private List<T> listStore = new ArrayList<T>();
    private boolean numberSequence = true;
    private List<RowType> listRowType = new ArrayList<RowType>();
    private RowType rowTypeHead;
    //private String id;

    public DataTable() {
        divTableResponsive = Document.get().createDivElement();
        tableElement = Document.get().createTableElement();
        tHeadElement = Document.get().createTHeadElement();
        tBodyElement = Document.get().createTBodyElement();
        tFootElement = Document.get().createTFootElement();
        script = Document.get().createScriptElement();
        createDivTableResponsive();
        getDivBody().appendChild(divTableResponsive);
        setHeadVisible(false);
        //getDivHeading().removeFromParent();
        repaint();
    }

    /**
     * @return the listRowType
     */
    public List<RowType> getListRowType() {
        return listRowType;
    }

    /**
     * @param listRowType the listRowType to set
     */
    public void setListRowType(List<RowType> listRowType) {
        this.listRowType = listRowType;
    }

    /**
     * @return the rowTypeHead
     */
    public RowType getRowTypeHead() {
        return rowTypeHead;
    }

    /**
     * @param rowTypeHead the rowTypeHead to set
     */
    public void setRowTypeHead(RowType rowTypeHead) {
        this.rowTypeHead = rowTypeHead;
    }

    public static enum RowType {
        SUCCESS("success"), DEFAULT("default"), INFO("info"),
        DANGER("danger"), WARNING("warning");
        private String value;

        RowType(String type) {
            this.value = type;
        }

        public String getValue() {
            return value;
        }
    };

    public void addRowType(RowType rowType) {
        getListRowType().add(rowType);
    }

    public void clearRowType() {
        getListRowType().clear();
    }

    public void setAttribute(Element element, String name, String value) {
        element.setAttribute(name, value);
    }

    protected void createDivTableResponsive() {
        setAttribute(divTableResponsive, "class", "table-responsive");
        createTable();
        createScript();
        divTableResponsive.appendChild(script);
        divTableResponsive.appendChild(tableElement);
    }

    protected void createScript() {
        String contentJS = "$(document).ready(function() {"
                + "	$('#" + id + "').DataTable();"
                + "} );";
        Text js = Document.get().createTextNode(contentJS);
        setAttribute(script, "class", "init");
        script.appendChild(js);
    }

    private void createTable() {
        //id = "dataTable" + Random.nextInt(1000);
        setId("dataTable" + Random.nextInt(1000));
        setAttribute(tableElement, "id", getId());
        setAttribute(tableElement, "role", getId() + "_info");
        setAttribute(tableElement, "role", "grid");
        //setAttribute(tableElement, "class", "table");
        //setAttribute(tableElement, "class", "table table-striped table-bordered table-hover dataTable dtr-inline");
        setAttribute(tableElement, "class", "table table-striped table-bordered");
        tableElement.appendChild(tHeadElement);
        tableElement.appendChild(tBodyElement);
    }

    private void createTHead() {
        tHeadElement.removeAllChildren();
        TableRowElement tr = Document.get().createTRElement();
        if (rowTypeHead != null) {
            setAttribute(tr, "class", rowTypeHead.getValue());
        }
        if (numberSequence) {
            TableCellElement th = Document.get().createTHElement();
            Text text = Document.get().createTextNode("#");
            th.appendChild(text);
            tr.appendChild(th);
        }
        tHeadElement.appendChild(tr);
        for (int i = 0; i < listColumns.size(); i++) {
            Column column = listColumns.get(i);
            if (column.isVisible()) {
                TableCellElement th = Document.get().createTHElement();
                tr.appendChild(th);
                appendAttribute(th, "class", "");
                if (column.getColumnType() != null) {
                    appendAttribute(th, "class", column.getColumnType().getValue());
                }
                if (column.getWidget() == null) {
                    //setAttribute(th, "aria-controls", id);
                    add(new Label(""), th);
                } else {
                    appendAttribute(th, "class", column.getAlignType().getValue());
                    add(column.getWidget(), th);
                }
            }
        }
    }

    private void createTBody() {
        tBodyElement.removeAllChildren();
        int contRowType = 0;
        for (int f = 0; f < listStore.size(); f++) {
            T field = listStore.get(f);
            //Percorre todos os campos do objeto
            int cont = f + 1;
            TableRowElement tr = Document.get().createTRElement();
            TableCellElement td = Document.get().createTDElement();
            tr.appendChild(td);
            if (contRowType < listRowType.size()) {
                RowType rowType = listRowType.get(contRowType);
                if (rowType != null && rowType.getValue() != null) {
                    setAttribute(tr, "class", rowType.getValue());
                }
                contRowType++;
                if (contRowType >= listRowType.size()) {
                    contRowType = 0;
                }
            }
            tBodyElement.appendChild(tr);
            Text text = Document.get().createTextNode("" + cont);
            td.appendChild(text);
            for (int i = 0; i < listColumns.size(); i++) {
                Column column = listColumns.get(i);
                if (column.isVisible()) {
                    td = Document.get().createTDElement();
                    setAttribute(td, "class", column.getAlignType().getValue());
                    tr.appendChild(td);
                    if (column.getColumnType() != null) {
                        appendAttribute(td, "class", column.getColumnType().getValue());
                    }
                    Object objValue = field.get(column.getName());
                    String value = "";
                    if (objValue != null) {
                        value = objValue.toString();
                    } else {
                        value = "";
                    }
                    if (column.getColumnRenderer() == null) {
                        Text data = Document.get().createTextNode(value);
                        td.appendChild(data);
                    } else {
                        ColumnRenderer cr = column.getColumnRenderer();
                        Widget w = cr.onRenderer(field, this);
                        add(w, td);
                    }
                }
            }
        }
    }

    public void addColumn(Column column) {
        if (column != null) {
            listColumns.add(column);
        }
    }

    public void repaint() {
        createTHead();
        createTBody();
    }

    /**
     * @return the listColumns
     */
    public List<Column> getListColumns() {
        return listColumns;
    }

    /**
     * @param listColumns the listColumns to set
     */
    public void setListColumns(List<Column> listColumns) {
        this.listColumns = listColumns;
    }

    /**
     * @return the numberSequence
     */
    public boolean isNumberSequence() {
        return numberSequence;
    }

    /**
     * @param numberSequence the numberSequence to set
     */
    public void setNumberSequence(boolean numberSequence) {
        this.numberSequence = numberSequence;
    }

    /**
     * @return the listStore
     */
    public List<T> getListStore() {
        return listStore;
    }

    /**
     * @param listStore the listStore to set
     */
    public void setListStore(List<T> listStore) {
        this.listStore = listStore;
        repaint();
    }

    @Override
    public void setId(String id) {
        super.id = id;
        setAttribute(tableElement, "id", getId());
        setAttribute(tableElement, "role", getId() + "_info");
        script.removeAllChildren();
        createScript();
    }
}
