/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.swing;

import ui.swing.imageLink.ImageLink;
import ui.swing.imageLink.ImageLinkRenderer;
import core.sintatico.verificador.ImageVerifier;
import core.web.ResourcesGetter;
import core.web.URLGenerator;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author lite
 */
public class ImageList extends JList<ImageLink>{
    
    public ImageList() {
        setCellRenderer(new ImageLinkRenderer());
    }
    
    public void fill(String siteURL){
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
        this.setModel(model);
        
    }
}
