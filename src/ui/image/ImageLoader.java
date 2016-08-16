/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.image;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import ui.ListFiller;

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
        URL url = getClass().getResource("/XIcon.png");
        BufferedImage backupImageGet = null;
        
        try {
            backupImageGet = ImageIO.read(url);
        } catch (IOException ex) {
            Logger.getLogger(ImageLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedImage backupImage = backupImageGet; // Finja que não viu
        
        this.path = path;
        this.size = size;
        proxyImage = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Thread t = new Thread(() -> {
            BufferedImage bi1 = FileTransfer.downloadImage(path);
            assert(bi1 != null);
            try {
                setImage(ImageEditor.resizeImage(bi1, 64));
            } catch (Exception e) {
                setImage(ImageEditor.resizeImage(backupImage, 64));
            }
            ListFiller.updateWindow();
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
