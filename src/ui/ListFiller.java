/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import ui.image.FileTransfer;
import ui.image.ImageEditor;
import ui.swing.ImageLink;
import core.sintatico.verificador.ImageVerifier;
import core.web.ResourcesGetter;
import core.web.URLGenerator;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author lite
 */
public class ListFiller {
    String siteUrl;
    JList<ImageLink> jList;
    static MainWindow  mainWindow;
    
    public ListFiller(JList<ImageLink> jList, MainWindow mainWindow) {
        this.jList = jList;
        this.mainWindow = mainWindow;
    }
    
    public static void updateWindow(){
        mainWindow.repaint();
    }
    
    public void fillList(String siteURL){
        ResourcesGetter crw = new ResourcesGetter();
        crw.getListaRecursos().add(siteURL);
        ArrayList<String> listaCodigos = crw.carregarRecursos();

        String codigoHTML = listaCodigos.get(0);
        ImageVerifier verifier = new ImageVerifier();
        List<String> resources = verifier.getSources(codigoHTML);
        
        URLGenerator generator = new URLGenerator(siteURL);
        
        DefaultListModel<ImageLink> model = new DefaultListModel<>();
        resources.stream().forEach((resource) -> {
                String url = generator.generate(resource);
                ImageLink imageLink = new ImageLink(url);
                model.addElement(imageLink);
        });
        jList.setModel(model);
        
    }
}
