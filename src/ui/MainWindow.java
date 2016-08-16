/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import com.alee.laf.WebLookAndFeel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.UnsupportedLookAndFeelException;
import ui.swing.ColorController;
import ui.swing.ImageLink;
import ui.swing.ImageLinkRenderer;
import ui.swing.webLaf.WeblafUtils;

/**
 *
 * @author 5663296
 */
public class MainWindow extends javax.swing.JFrame {
    ListFiller filler;
    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        this.setLocationRelativeTo(null);
        imageList.setCellRenderer(new ImageLinkRenderer());
        filler = new ListFiller(imageList, this);
        WeblafUtils.instalaWeblaf();
        WeblafUtils.configuraWebLaf(jScrollPane2);
        WeblafUtils.configuraWeblaf(jPanel2);
        WeblafUtils.configurarBotao(webButton1, ColorController.COR_DESTAQUE, ColorController.COR_LETRA);
        jPanel2.setBackground(ColorController.COR_PRINCIPAL);
        textURL.setBackground(ColorController.COR_DESTAQUE);
        textURL.setForeground(ColorController.COR_LETRA);
        jScrollPane2.setBackground(ColorController.COR_DESTAQUE);
        imageList.setBackground(ColorController.COR_DESTAQUE);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        labelURl = new javax.swing.JLabel();
        textURL = new javax.swing.JTextField();
        webButton1 = new com.alee.laf.button.WebButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        imageList = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Image Searcher");

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        jPanel2.setMinimumSize(new java.awt.Dimension(640, 480));
        jPanel2.setPreferredSize(new java.awt.Dimension(640, 480));
        jPanel2.setLayout(new java.awt.BorderLayout(20, 20));

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.BorderLayout(20, 10));

        labelURl.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labelURl.setForeground(new java.awt.Color(250, 250, 250));
        labelURl.setText("Image Automator");
        jPanel1.add(labelURl, java.awt.BorderLayout.NORTH);

        textURL.setText("http://lite.acad.univali.br/temideianarede/");
        jPanel1.add(textURL, java.awt.BorderLayout.CENTER);

        webButton1.setText("webButton1");
        webButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                webButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(webButton1, java.awt.BorderLayout.EAST);

        jPanel2.add(jPanel1, java.awt.BorderLayout.NORTH);

        jScrollPane2.setViewportView(imageList);

        jPanel2.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void webButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_webButton1ActionPerformed
        String siteURL = textURL.getText();
        DefaultListModel<ImageLink> model = new DefaultListModel<>();
        imageList.setModel(model);
        filler.fillList(siteURL);
    }//GEN-LAST:event_webButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel(new WebLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<ImageLink> imageList;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelURl;
    private javax.swing.JTextField textURL;
    private com.alee.laf.button.WebButton webButton1;
    // End of variables declaration//GEN-END:variables
}
