/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import core.image.FileTransfer;
import core.image.ImageEditor;
import core.image.swing.ImageLink;
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

    public ListFiller(JList<ImageLink> jList) {
        this.jList = jList;
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
                BufferedImage image = FileTransfer.downloadImage(url);
                image = ImageEditor.resizeImage(image, 64);
                ImageLink imageLink = new ImageLink(url, image);
                model.addElement(imageLink);
        });
        jList.setModel(model);
        
    }
}
