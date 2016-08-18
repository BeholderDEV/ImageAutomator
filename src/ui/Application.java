/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Image;

/**
 *
 * @author lite
 */
public class Application {
    private ImagePreviewer imagePreviewer=null;
    private MainWindow mainWindow=null;
    private final static Application application = new Application();
    
    private Application() {
    }
    
    public static Application getInstance(){
        return application;
    }
    
    public void previewImage(Image image){
        if(imagePreviewer==null){
            imagePreviewer= new ImagePreviewer();
        }
        imagePreviewer.previewImage(image);
    }
    
}
