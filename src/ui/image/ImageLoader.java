/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.image;

import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author lite
 */
public class ImageLoader{
    volatile Image image;
    Image proxyImage;
    String path;
    int size;

    public ImageLoader(String path, int size) {
        this.path = path;
        this.size = size;
        proxyImage = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Thread t = new Thread(() -> {
            BufferedImage bi1 = FileTransfer.downloadImage(path);
            assert(bi1 != null);
            setImage(ImageEditor.resizeImage(bi1, 64));
        });
        t.start();
    }

    private synchronized void setImage(Image image) {
        this.image = image;
    }
    
    public synchronized Image getImage(){
        if(imageAvailable()){
            return image;
        }
        return proxyImage;
    }
    
    
    private synchronized boolean imageAvailable()
    {
        return image != null;
    }    
}
