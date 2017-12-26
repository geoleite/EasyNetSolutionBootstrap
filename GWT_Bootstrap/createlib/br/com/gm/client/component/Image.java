/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.client.component;

import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.Window;

/**
 *
 * @author geoleite
 */
public class Image extends com.google.gwt.user.client.ui.Image {
    private String hint;
    private String id;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
        getElement().setAttribute("id", id);        
    }

    public static enum ImageType {
        CIRCLE("img-circle"), THUMBNAIL("img-thumbnail"), 
        ROUNDED("img-rounded"), RESPONSIVE("img-responsive");
        
        private String value;

        ImageType(String type) {
            this.value = type;
        }

        public String getValue() {
            return value;
        }
    };
    
    
    public Image(String url, ImageType imageType) {
        super();
        getElement().removeAllChildren();
        setUrl(url);
        setImageType(imageType);
        setId("img" + Random.nextInt(1000));
    }
    
    public Image(String url, ImageType imageType, String hint) {
        this(url, imageType);
        setHint(hint);
    }

    public void setImageType(ImageType imageType) {
        getElement().setAttribute("class", imageType.getValue());
    }
    /**
     * @return the hint
     */
    public String getHint() {
        return hint;
    }

    /**
     * @param hint the hint to set
     */
    public void setHint(String hint) {
        this.hint = hint;
        getElement().setAttribute("alt", hint);
    }        
}
