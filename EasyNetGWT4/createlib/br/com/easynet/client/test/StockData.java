/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.client.test;

import br.com.easynet.client.json.DynamicJson;
import com.google.gwt.core.client.JavaScriptObject;

public class StockData extends DynamicJson {
    // Overlay types always have protected, zero argument constructors.
    protected StockData() {
    }

    //public final native String getSymbol() /*-{ return this.symbol; }-*/; 
    public final String getSymbol() {
        return getString("symbol");
    }
    
    public final void setSymbol(String symbol) {
        set("symbol", symbol);
    }

    //public final native double getPrice() /*-{ return this.price; }-*/;
    public final double getPrice() {
        return getDouble("price");
    }
    
    public final void setPrice(double price) {
        set("symbol", price);
    }

    //public final native double getChange() /*-{ return this.change; }-*/;
    
    public final double getChange() {
        return getDouble("change");
    }
    
    public final void setChange(double change) {
        set("change", change);
    }

    // Non-JSNI method to return change percentage.
    public final double getChangePercent() {
        return 100.0 * getChange() / getPrice();
    }

}
