/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.client.component;

import br.com.gm.client.container.Panel;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.ui.Widget;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author geoleite
 */
public class RadioGroup extends Panel {

    private DivElement divGroup;
    private String name;
    private boolean inLine = false;
    private List<Radio> listRadio = new ArrayList<Radio>();

    public RadioGroup() {
        name = "rg" + Random.nextInt(100);
        createGroup();
    }

    public RadioGroup(boolean inline) {
        this();
        setInLine(inline);
    }

    public void setAttribute(Element element, String name, String value) {
        element.setAttribute(name, value);
    }

    private void createGroup() {
        divGroup = Document.get().createDivElement();
        setElement(divGroup);
        divGroup.setId(getId());
        setAttribute(divGroup, "class", "form-group");
    }

    public void addRadio(Radio radio) {
        if (radio != null) {
            listRadio.add(radio);
            radio.setName(name);
            radio.setInLine(inLine);
            add(radio, divGroup );
        }
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
     * @return the inLine
     */
    public boolean isInLine() {
        return inLine;
    }

    /**
     * @param inLine the inLine to set
     */
    public void setInLine(boolean inLine) {
        this.inLine = inLine;
        for (int i = 0; i < listRadio.size(); i++) {
            Radio radio = listRadio.get(i);
            radio.setInLine(inLine);
        }
    }

    @Override
    public void setId(String id) {
        super.setId(id); //To change body of generated methods, choose Tools | Templates.
        divGroup.setId(getId());
    }        
}
