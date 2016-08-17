/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import com.alee.laf.WebLookAndFeel;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.UnsupportedLookAndFeelException;
import ui.image.FileTransfer;
import ui.swing.utils.ColorController;
import ui.swing.imageLink.ImageLink;
import ui.swing.imageLink.ImageLinkRenderer;
import ui.swing.webLaf.WeblafUtils;

/**
 *
 * @author 5663296
 */
public class MainWindow extends javax.swing.JFrame {
    int pX, pY;
    ListBuilder builder;
    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(30);
        this.setLocationRelativeTo(null);
        configureTheme();
        builder = new ListBuilder(imagePane, this);
        textURL.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    webButton1.doClick();
                }
            }
        });
        
        jPanel3.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                // Get x,y and store them
                pX = me.getX();
                pY = me.getY();

            }

             public void mouseDragged(MouseEvent me) {

                MainWindow.this.setLocation(MainWindow.this.getLocation().x + me.getX() - pX, MainWindow.this.getLocation().y + me.getY() - pY);
            }
        });

        jPanel3.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent me) {

                MainWindow.this.setLocation(MainWindow.this.getLocation().x + me.getX() - pX, MainWindow.this.getLocation().y + me.getY() - pY);
            }
        });
        
    }
    
    
    
    private void configureTheme(){
        WeblafUtils.instalaWeblaf();
        WeblafUtils.configuraWeblaf(jPanel2);
        WeblafUtils.configuraWebLaf(textURL);
        WeblafUtils.configuraWebLaf(jScrollPane1);
        WeblafUtils.configurarBotao(webButton1, ColorController.COR_DESTAQUE, ColorController.COR_LETRA);
        WeblafUtils.configurarBotao(webButton4, ColorController.COR_DESTAQUE, ColorController.COR_LETRA);
        WeblafUtils.configurarBotao(webButton2, ColorController.COR_PRINCIPAL, ColorController.COR_LETRA,ColorController.PROGRESS_BAR, Color.orange, 5);
        WeblafUtils.configurarBotao(webButton3, ColorController.COR_PRINCIPAL, ColorController.COR_LETRA,ColorController.FUNDO_CLARO, Color.orange, 5);
        jPanel2.setBackground(ColorController.COR_PRINCIPAL);
        jPanel3.setBackground(ColorController.COR_PRINCIPAL);
        imagePane.setBackground(ColorController.COR_DESTAQUE);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        labelURl = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        webButton3 = new com.alee.laf.button.WebButton();
        webButton2 = new com.alee.laf.button.WebButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        textURL = new javax.swing.JTextField();
        webButton1 = new com.alee.laf.button.WebButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        imagePane = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        webButton4 = new com.alee.laf.button.WebButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Image Searcher");
        setUndecorated(true);
        setResizable(false);

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 5));
        jPanel3.setPreferredSize(new java.awt.Dimension(45, 45));
        jPanel3.setLayout(new java.awt.BorderLayout());

        labelURl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelURl.setForeground(new java.awt.Color(250, 250, 250));
        labelURl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelURl.setText("Image Automator");
        jPanel3.add(labelURl, java.awt.BorderLayout.CENTER);

        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 5, 0));

        webButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/resources/window_min.png"))); // NOI18N
        webButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                webButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(webButton3);

        webButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/resources/window_close.png"))); // NOI18N
        webButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                webButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(webButton2);

        jPanel3.add(jPanel4, java.awt.BorderLayout.EAST);

        getContentPane().add(jPanel3, java.awt.BorderLayout.NORTH);

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel2.setMinimumSize(new java.awt.Dimension(640, 480));
        jPanel2.setPreferredSize(new java.awt.Dimension(640, 480));
        jPanel2.setLayout(new java.awt.BorderLayout(20, 20));

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.BorderLayout(20, 10));

        textURL.setText("http://lite.acad.univali.br/temideianarede/");
        textURL.setBorder(null);
        jPanel1.add(textURL, java.awt.BorderLayout.CENTER);

        webButton1.setText("Find Images");
        webButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                webButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(webButton1, java.awt.BorderLayout.EAST);

        jPanel2.add(jPanel1, java.awt.BorderLayout.NORTH);

        imagePane.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane1.setViewportView(imagePane);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel5.setOpaque(false);
        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        webButton4.setText("Dowanload Selecteds");
        webButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                webButton4ActionPerformed(evt);
            }
        });
        jPanel5.add(webButton4);

        jPanel2.add(jPanel5, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void webButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_webButton1ActionPerformed
        imagePane.removeAll();
        String siteURL = textURL.getText();
        builder.fillList(siteURL);
        
    }//GEN-LAST:event_webButton1ActionPerformed

    private void webButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_webButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_webButton2ActionPerformed

    private void webButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_webButton3ActionPerformed
        setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_webButton3ActionPerformed

    private void webButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_webButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_webButton4ActionPerformed

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
    private javax.swing.JPanel imagePane;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelURl;
    private javax.swing.JTextField textURL;
    private com.alee.laf.button.WebButton webButton1;
    private com.alee.laf.button.WebButton webButton2;
    private com.alee.laf.button.WebButton webButton3;
    private com.alee.laf.button.WebButton webButton4;
    // End of variables declaration//GEN-END:variables
}
