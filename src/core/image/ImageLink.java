/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.image;

import java.awt.Image;

/**
 *
 * @author lite
 */
public class ImageLink {
    String url;
    Image image;
    String nome;

    public ImageLink(String url, Image image) {
        this.url = url;
        this.image = image;
        
        String[] parts = url.split("/");
        String nome = parts[parts.length-1];
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
    
    
}
