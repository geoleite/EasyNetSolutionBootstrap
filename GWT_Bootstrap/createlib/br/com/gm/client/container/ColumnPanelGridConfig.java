/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.client.container;

/**
 *
 * @author geoleite
 */
public class ColumnPanelGridConfig {
    private int columnSize;
    private String columnSizeModel;
    
    private AlignType align=AlignType.LEFT;

    /**
     * @return the align
     */
    public AlignType getAlign() {
        return align;
    }

    /**
     * @param align the align to set
     */
    public void setAlign(AlignType align) {
        this.align = align;        
    }

    public static enum AlignType {
        LEFT("pull-left"), RIGHT("pull-right"), CENTER("text-center");
        private String value;

        AlignType(String type) {
            this.value = type;
        }

        public String getValue() {
            return value;
        }
    };            

    public ColumnPanelGridConfig(int columnSize) {
        setColumnSize(columnSize);        
    }
    public ColumnPanelGridConfig(int columnSize, AlignType alignType) {
        this(columnSize);
        setAlign(alignType);
    }
    /**
     * @return the columnSize
     */
    public int getColumnSize() {
        return columnSize;
    }

    /**
     * @param columnSize the columnSize to set
     */
    public void setColumnSize(int columnSize) {        
        this.columnSize = columnSize<1?1:columnSize;
        this.columnSize = columnSize>12?12:columnSize;
        columnSizeModel = "col-md-" + columnSize;
    }

    /**
     * @return the columnSizeModel
     */
    public String getColumnSizeModel() {
        return columnSizeModel;
    }

    /**
     * @param columnSizeModel the columnSizeModel to set
     */
    public void setColumnSizeModel(String columnSizeModel) {
        this.columnSizeModel = columnSizeModel;
    }
}
