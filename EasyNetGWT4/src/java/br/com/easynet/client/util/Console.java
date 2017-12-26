/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.client.util;

/**
 *
 * @author geoleite
 */
public class Console {
    public static final native void write(String msg)/*-{
        console.log(msg);
  }-*/;
}
