/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.client.component;

import com.google.gwt.user.client.ui.Widget;

/**
 *
 * @author geoleite
 */
public interface ColumnRenderer <T> {
    public Widget onRenderer(T field, DataTable dataTable);
}
