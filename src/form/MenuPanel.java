/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package form;

import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import org.json.simple.JSONObject;

/**
 *
 * @author aka
 */
public class MenuPanel extends javax.swing.JPanel {

    /**
     * Creates new form MenuPanel
     */
    
    private int id_menu;
    private String nama;
    private int harga;
    private String kategori;
    private String gambar;
    private PemesananForm parentForm;
    
    
    public MenuPanel() {
        initComponents();
    }
    
    public MenuPanel(int id_menu, String nama, int harga, String kategori, String gambar, PemesananForm parentForm) {
        
        this.id_menu = id_menu;
        this.nama = nama;
        this.harga = harga;
        this.kategori = kategori;
        this.gambar = gambar;
        this.parentForm = parentForm;
        
        initComponents();
        
        
        
        try {
            // dapatkan gambar        
            ImageIcon icon;
            icon = new ImageIcon(new URL("http://localhost:8000/storage/" + this.gambar));
            Image image = icon.getImage();
            image = image.getScaledInstance(200, 150, Image.SCALE_SMOOTH);
            icon = new ImageIcon(image);
            label_image.setIcon(icon);
        } catch (MalformedURLException ex) {
            Logger.getLogger(MenuPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_nama = new javax.swing.JLabel();
        label_harga = new javax.swing.JLabel();
        label_kategori = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        label_image = new javax.swing.JLabel();
        btn_tambah = new javax.swing.JButton();

        setBackground(new java.awt.Color(250, 250, 250));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_nama.setFont(new java.awt.Font("Hack", 0, 18)); // NOI18N
        label_nama.setForeground(new java.awt.Color(102, 102, 102));
        label_nama.setText(this.nama);
        add(label_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, -1));

        label_harga.setFont(new java.awt.Font("Hack", 1, 24)); // NOI18N
        label_harga.setForeground(new java.awt.Color(102, 102, 102));
        label_harga.setText(Long.toString(this.harga));
        add(label_harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, -1, -1));

        label_kategori.setFont(new java.awt.Font("Hack", 1, 12)); // NOI18N
        label_kategori.setForeground(new java.awt.Color(102, 102, 102));
        label_kategori.setText(this.kategori);
        add(label_kategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 390, 20));
        add(label_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 200, 150));

        btn_tambah.setBackground(new java.awt.Color(3, 124, 182));
        btn_tambah.setFont(new java.awt.Font("Hack", 1, 14)); // NOI18N
        btn_tambah.setForeground(new java.awt.Color(255, 255, 255));
        btn_tambah.setText("Tambahkan");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });
        add(btn_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 120, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        
        // TODO add your handling code here:
        
        JSONObject json = new JSONObject();
        json.put("id_menu", this.id_menu);
        json.put("jumlah", 1);
        json.put("subtotal", this.harga * 1);
        
        this.parentForm.addPesanan(json);
    }//GEN-LAST:event_btn_tambahActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_tambah;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel label_harga;
    private javax.swing.JLabel label_image;
    private javax.swing.JLabel label_kategori;
    private javax.swing.JLabel label_nama;
    // End of variables declaration//GEN-END:variables
}
