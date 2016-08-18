/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import com.alee.laf.WebLookAndFeel;
import java.awt.Image;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author lite
 */
public class Application {
    
    private static final ExecutorService service = Executors.newCachedThreadPool();
    
    private ImagePreviewer imagePreviewer=null;
    private MainWindow mainWindow;
    private final static Application application = new Application();
    
    private Application() {
    }
    
        /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Application.getInstance().start();
    }

    private void start() {
        try {
            javax.swing.UIManager.setLookAndFeel(new WebLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                mainWindow = new MainWindow();
                mainWindow.setVisible(true);
            }
        });
    }

    public MainWindow getMainWindow() {
        return mainWindow;
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
    
    public void performAsynchronousTask(Runnable task)
    {
        service.submit(task);
    }
}
