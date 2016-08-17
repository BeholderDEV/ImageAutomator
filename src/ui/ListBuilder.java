/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import ui.swing.imageLink.ImageLink;
import core.sintatico.verificador.ImageVerifier;
import core.web.ResourcesGetter;
import core.web.URLGenerator;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 *
 * @author lite
 */
public class ListBuilder {
    String siteUrl;
    JPanel jPanel;
    static MainWindow  mainWindow;
    
    public ListBuilder(JPanel jPanel, MainWindow mainWindow) {
        this.jPanel = jPanel;
        this.mainWindow = mainWindow;
    }
    
    public static void updateWindow(){
        mainWindow.repaint();
    }
    
    public void fillList(String siteURL){
        ResourcesGetter crw = new ResourcesGetter();
        crw.getListaRecursos().add(siteURL);
        
        Thread t = new Thread(() -> {
            ArrayList<String> listaCodigos = crw.carregarRecursos();
            String codigoHTML = listaCodigos.get(0);
            ImageVerifier verifier = new ImageVerifier();
            
            List<String> resources = verifier.getSources(codigoHTML);
            URLGenerator generator = new URLGenerator(siteURL);
            
            resources.stream().forEach((resource) -> {
                String url = generator.generate(resource);
                ImageLink imageLink = new ImageLink(url);
                ImageLinkPanel imageLinkPanel = new ImageLinkPanel(imageLink);
                jPanel.add(imageLinkPanel);
            });
        });
        t.start();
        
        
    }
}
