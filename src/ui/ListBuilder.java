/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import ui.swing.imageLink.ImageLinkPanel;
import ui.swing.imageLink.ImageLink;
import core.sintatico.verificador.ImageVerifier;
import core.web.ResourcesGetter;
import core.web.URLGenerator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lite
 */
public class ListBuilder {
    private List<ImageLinkPanel> imageLinkPanels;
    private String siteUrl;
    
    public ListBuilder() {
        imageLinkPanels = new ArrayList<>();
    }

    public List<ImageLinkPanel> getImageLinkPanels() {
        return imageLinkPanels;
    }
    
    public void fillList(String siteURL){
        ResourcesGetter crw = new ResourcesGetter();
        crw.getListaRecursos().add(siteURL);
        
        Application.getInstance().performAsynchronousTask(() -> {
            ArrayList<String> listaCodigos = crw.carregarRecursos();
            String codigoHTML = listaCodigos.get(0);
            ImageVerifier verifier = new ImageVerifier();
            
            List<String> resources = verifier.getSources(codigoHTML);
            URLGenerator generator = new URLGenerator(siteURL);
            
            resources.stream().forEach((resource) -> {
                String url = generator.generate(resource);
                ImageLink imageLink = new ImageLink(url);
                ImageLinkPanel imageLinkPanel = new ImageLinkPanel(imageLink);
                imageLinkPanels.add(imageLinkPanel);
                Application.getInstance().getMainWindow().addImageLinkPanel(imageLinkPanel);
            });
        });
    }
}
