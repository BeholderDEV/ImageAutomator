/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.image;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author lite
 */
public class FileTransfer {
    public static BufferedImage downloadImage(String urlPath){
        BufferedImage image = null;
        try {
            URL url = new URL(urlPath);
            image = ImageIO.read(url);
        } catch (IOException e) {
        }
        return image;
    }
    
    public static void saveFile(String urlPath, Image image){
               
    }
}
