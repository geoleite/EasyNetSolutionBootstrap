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
public class ConfigBorderLayout {

    private BorderSize bsTop = BorderSize.COL_12;
    private BorderSize bsLeft = BorderSize.COL_3;
    private BorderSize bsRight = BorderSize.COL_2;
    private BorderSize bsContent = BorderSize.COL_7;
    private BorderSize bsBottom = BorderSize.COL_12;

    public static enum BorderSize {
        NULL(null),
        COL_1("col-xs-1"), COL_2("col-xs-2"), COL_3("col-xs-3"),
        COL_4("col-xs-4"), COL_5("col-xs-5"), COL_6("col-xs-6"),
        COL_7("col-xs-7"), COL_8("col-xs-8"), COL_9("col-xs-9"),
        COL_10("col-xs-10"), COL_11("col-xs-11"), COL_12("col-xs-12");
        private String value;

        BorderSize(String type) {
            this.value = type;
        }

        public String getValue() {
            return value;
        }
    };

    public ConfigBorderLayout() {
    }

    public ConfigBorderLayout(BorderSize bsTop, BorderSize bsLeft,
            BorderSize bsRight, BorderSize bsContent, BorderSize bsBottom) {
        
        setBsTop(bsTop);
        setBsLeft(bsLeft);
        setBsRight(bsRight);
        setBsContent(bsContent);
        setBsBottom(bsBottom);
    }

    /**
     * @return the bsTop
     */
    public BorderSize getBsTop() {
        return bsTop;
    }

    /**
     * @param bsTop the bsTop to set
     */
    public void setBsTop(BorderSize bsTop) {
        this.bsTop = bsTop;
    }

    /**
     * @return the bsLeft
     */
    public BorderSize getBsLeft() {
        return bsLeft;
    }

    /**
     * @param bsLeft the bsLeft to set
     */
    public void setBsLeft(BorderSize bsLeft) {
        this.bsLeft = bsLeft;
    }

    /**
     * @return the bsRight
     */
    public BorderSize getBsRight() {
        return bsRight;
    }

    /**
     * @param bsRight the bsRight to set
     */
    public void setBsRight(BorderSize bsRight) {
        this.bsRight = bsRight;
    }

    /**
     * @return the bsContent
     */
    public BorderSize getBsContent() {
        return bsContent;
    }

    /**
     * @param bsContent the bsContent to set
     */
    public void setBsContent(BorderSize bsContent) {
        this.bsContent = bsContent;
    }

    /**
     * @return the bsBottom
     */
    public BorderSize getBsBottom() {
        return bsBottom;
    }

    /**
     * @param bsBottom the bsBottom to set
     */
    public void setBsBottom(BorderSize bsBottom) {
        this.bsBottom = bsBottom;
    }

}
