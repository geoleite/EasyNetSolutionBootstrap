/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.client.component;

import com.google.gwt.user.client.ui.HTMLTable;
//import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 *
 * @author geoleite
 */
public class Column extends Widget {

    private String name, title;
    private boolean visible = true;
    private String formatter;
    private Widget widget = new Label();
    private String width, height, vAlign, hAlign;
    private ColumnRenderer columnRenderer;
    private ColumnType columnType;
    private AlignType alignType = AlignType.LEFT;

    public static enum AlignType {
        LEFT("text-left"), RIGHT("text-right"), CENTER("text-center");
        private String value;

        AlignType(String type) {
            this.value = type;
        }

        public String getValue() {
            return value;
        }
    };

    public static enum ColumnType {
        SUCCESS("success"), DEFAULT("default"), INFO("info"),
        DANGER("danger"), WARNING("warning");
        private String value;

        ColumnType(String type) {
            this.value = type;
        }

        public String getValue() {
            return value;
        }
    };

    public Column() {
        this("", "");
    }

    public Column(String name, String title) {
        setName(name);
        setTitle(title);
    }
    
    public Column(String name, String title, AlignType alignType) {
        this(name, title);
        setAlignType(alignType);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the visible
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * @param visible the visible to set
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /**
     * @return the formatter
     */
    public String getFormatter() {
        return formatter;
    }

    /**
     * @param formatter the formatter to set
     */
    public void setFormatter(String formatter) {
        this.formatter = formatter;
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
    }

    /**
     * @return the vAlign
     */
    public String getvAlign() {
        return vAlign;
    }

    /**
     * @param vAlign the vAlign to set
     */
    public void setvAlign(String vAlign) {
        this.vAlign = vAlign;
    }

    /**
     * @return the hAlign
     */
    public String gethAlign() {
        return hAlign;
    }

    /**
     * @param hAlign the hAlign to set
     */
    public void sethAlign(String hAlign) {
        this.hAlign = hAlign;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
        if (title == null) {
            widget = null;
        } else if (widget instanceof Label) {
            ((Label) widget).setText(title);
        }
    }

    /**
     * @return the widget
     */
    public Widget getWidget() {
        return widget;
    }

    /**
     * @param widget the widget to set
     */
    public void setWidget(Widget widget) {
        this.widget = widget;
    }

    /**
     * @return the columnRenderer
     */
    public ColumnRenderer getColumnRenderer() {
        return columnRenderer;
    }

    /**
     * @param columnRenderer the columnRenderer to set
     */
    public void setColumnRenderer(ColumnRenderer columnRenderer) {
        this.columnRenderer = columnRenderer;
    }



    /**
     * @return the alignType
     */
    public AlignType getAlignType() {
        return alignType;
    }

    /**
     * @param alignType the alignType to set
     */
    public void setAlignType(AlignType alignType) {
        this.alignType = alignType;
    }

    /**
     * @return the columnType
     */
    public ColumnType getColumnType() {
        return columnType;
    }

    /**
     * @param columnType the columnType to set
     */
    public void setColumnType(ColumnType columnType) {
        this.columnType = columnType;
    }

}
