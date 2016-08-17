/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.swing.imageLink;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.border.EmptyBorder;
import ui.swing.utils.ColorController;

/**
 *
 * @author lite
 */
public class ImageLinkRenderer extends DefaultListCellRenderer{

    public ImageLinkRenderer() {
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setForeground(ColorController.COR_LETRA);
    }

    
    
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel component = (JLabel) this;
        ImageLink imageLink = (ImageLink) value;
        component.setIcon(new ImageIcon(imageLink.imageLoader.getImage()));
        component.setText(imageLink.nome);
        if(isSelected){
            setOpaque(true);
            setBackground(ColorController.FUNDO_ESCURO);
        }
        else{
            setOpaque(false);
        }
        return component;
    }
    
    
    
}
