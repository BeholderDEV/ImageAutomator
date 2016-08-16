/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.swing;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author lite
 */
public class ImageLinkRenderer extends DefaultListCellRenderer{

    public ImageLinkRenderer() {
    }

    
    
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel component = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); //To change body of generated methods, choose Tools | Templates.
        ImageLink imageLink = (ImageLink) value;
        component.setIcon(new ImageIcon(imageLink.imageLoader.getImage()));
        return component;
    }
    
    
    
}
