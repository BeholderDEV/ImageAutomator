/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import ui.image.FileTransfer;
import ui.swing.imageLink.ImageLink;
import ui.swing.utils.ColorController;
import ui.swing.webLaf.WeblafUtils;

/**
 *
 * @author lite
 */
public class ImageLinkPanel extends javax.swing.JPanel {
    
    ImageLink imageLink;
    
    private boolean selected = false;
    
    /**
     * Creates new form ImageLinkPanel
     * @param imageLink
     */
    public ImageLinkPanel(ImageLink imageLink) {
        initComponents();
        this.imageLink = imageLink;
        this.imageLink.getImageLoader().setIlp(this);
        imagePanel.setIcon(new ImageIcon(this.imageLink.getImageLoader().getImage()));
        imagePanel.setText("");
        size.setText("");
        nameLabel.setText(this.imageLink.getNome());
        jPanel1.setBackground(ColorController.COR_DESTAQUE);
        nameLabel.setForeground(ColorController.COR_LETRA);
        size.setForeground(ColorController.COR_LETRA);
        WeblafUtils.configurarBotao(downloadButton, ColorController.COR_PRINCIPAL, ColorController.COR_LETRA, 10);
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        if(selected){
            setBackground(ColorController.FUNDO_ESCURO);
        }else{
            setBackground(ColorController.COR_DESTAQUE);
        }
        this.selected = selected;
    }
    
    public void update(){
        imagePanel.setIcon(new ImageIcon(this.imageLink.getImageLoader().getImage()));
        nameLabel.setText(this.imageLink.getNome());
        size.setText("("+imageLink.getImageLoader().getImageWidth()+"x"+imageLink.getImageLoader().getImageHeight()+")");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        downloadButton = new com.alee.laf.button.WebButton();
        jPanel2 = new javax.swing.JPanel();
        size = new javax.swing.JLabel();
        imagePanel = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel1.setLayout(new java.awt.BorderLayout());

        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel.setText("name");
        jPanel1.add(nameLabel, java.awt.BorderLayout.CENTER);

        downloadButton.setText("Download");
        downloadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadButtonActionPerformed(evt);
            }
        });
        jPanel1.add(downloadButton, java.awt.BorderLayout.EAST);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.BorderLayout());

        size.setText("size");
        jPanel2.add(size, java.awt.BorderLayout.SOUTH);

        imagePanel.setText("image");
        jPanel2.add(imagePanel, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2, java.awt.BorderLayout.WEST);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void downloadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadButtonActionPerformed
        String url = imageLink.getUrl();
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("/home/me/Documents"));
        chooser.setSelectedFile(new File(imageLink.getNome()));
        int retrival = chooser.showSaveDialog(null);
        if (retrival == JFileChooser.APPROVE_OPTION) {
            try {
                FileTransfer.saveFile(chooser.getSelectedFile().toString(), url.substring(url.length()-3), FileTransfer.downloadImage(url));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_downloadButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.alee.laf.button.WebButton downloadButton;
    private javax.swing.JLabel imagePanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel size;
    // End of variables declaration//GEN-END:variables
}
