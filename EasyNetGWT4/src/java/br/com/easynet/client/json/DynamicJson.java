/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.client.json;
import com.google.gwt.core.client.JavaScriptObject; 
import com.google.gwt.core.client.JsArrayString; 


 
 
/**
 * A generic mutable JavaScript Overlay Type that exposes methods to get and set 
 * fields on a JavaScript object. 
 * 
 * <p> 
 * See {@link 
 * "http://code.google.com/webtoolkit/doc/latest/DevGuideCodingBasicsOverlay.html"} 
 * for more information about JavaScript overlay types. 
 * </p> 
 * 
 * @author jasonhall@google.com (Jason Hall) 
 */ 
public class DynamicJson extends JavaScriptObject { 
 
  protected DynamicJson() {} 
           
  public final native String toJson()/*-{
    return JSON.stringify(this);
  }-*/;

  public static final native String toJson(Object obj)/*-{
    return JSON.stringify(obj);
  }-*/;
  
  /** Returns the boolean field found at the given key. */ 
  public final native boolean getBoolean(String key) /*-{
    return !!this[key]; 
  }-*/; 
 
  /** Returns the integer field found at the given key. */ 
  public final native int getInteger(String key) /*-{
    return this[key]; 
  }-*/; 
 
  /** Returns the double field found at the given key. */ 
  public final native double getDouble(String key) /*-{
    return this[key]; 
  }-*/; 
 
  /** Returns the String field found at the given key. */ 
  public final native String getString(String key) /*-{
    return this[key]; 
  }-*/; 
 
  /** Returns the nested JavaScript object found at the given key. */ 
  public final native <T extends JavaScriptObject> T get(String key) /*-{
    return this[key]; 
  }-*/; 
 
  /** Returns a {@link JsArrayString} of the keys in this object. */ 
  public final native JsArrayString keys() /*-{
    var keys = []; 
    for (key in this) { 
      if (this.hasOwnProperty(key)) { 
        keys.push(key); 
      } 
    } 
    return keys; 
  }-*/; 
 
  /**
   * Returns a {@link JsType} corresponding to the type of the field identified 
   * by the given key. 
   */ 
  public final native JsType typeofKey(String key) /*-{
    var value = this[key]; 
    if (value == null) { 
      return null; 
    } else if (typeof value == "string") { 
      // Because the value will be wrapped in an Object(), JsType can't tell 
      // whether the object is a String or an Object, so we must explicitly 
      // check this case beforehand here. 
      return @br.com.easynet.client.json.JsType::STRING; 
    } else { 
      return @br.com.easynet.client.json.JsType::typeof(Ljava/lang/Object;) 
      (Object(value)); 
    } 
  }-*/; 
 
  /** Sets the given boolean value on the given key and returns this object. */ 
  public final native DynamicJson set(String key, boolean value) /*-{
    this[key] = value; 
    return this; 
  }-*/; 
 
  /** Sets the given integer value on the given key and returns this object. */ 
  public final native DynamicJson set(String key, int value) /*-{
    this[key] = value; 
    return this; 
  }-*/; 
 
  /** Sets the given double value on the given key and returns this object. */ 
  public final native DynamicJson set(String key, double value) /*-{
    this[key] = value; 
    return this; 
  }-*/; 
 
  /** Sets the given String value on the given key and returns this object. */ 
  public final native DynamicJson set(String key, String value) /*-{
    this[key] = value; 
    return this; 
  }-*/; 
 
  /**
   * Sets the given JavaScript overlay type value on the given key and returns 
   * this object. 
   */ 
  public final native <T extends JavaScriptObject> DynamicJson set(String key, T value) /*-{
    this[key] = value; 
    return this; 
  }-*/; 
 
  /**
   * Clears the data found at the given key. 
   * 
   * @return True if the value was successfully removed, or if it didn't exist. 
   */ 
  public final native boolean clear(String key) /*-{
    return delete this[key]; 
  }-*/;     
}
