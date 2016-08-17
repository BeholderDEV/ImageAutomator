/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.swing.imageLink;

import ui.image.ImageLoader;

/**
 *
 * @author lite
 */
public class ImageLink {
    String url;
    ImageLoader imageLoader;
    String nome;

    public ImageLink(String url) {
        this.url = url;
        this.imageLoader = new ImageLoader(url, 64);
        String[] parts = url.split("/");
        String nome = parts[parts.length-1];
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }

    public String getUrl() {
        return url;
    }

    public ImageLoader getImageLoader() {
        return imageLoader;
    }

    public String getNome() {
        return nome;
    }
    
    
}
