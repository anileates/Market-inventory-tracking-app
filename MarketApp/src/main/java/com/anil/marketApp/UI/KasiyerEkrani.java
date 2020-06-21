/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anil.marketApp.UI;

import com.anil.marketApp.Business.IslemlerBusiness;
import com.anil.marketApp.Business.UrunBusiness;
import com.anil.marketApp.Entities.Personel;
import com.anil.marketApp.Entities.Urun;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author anila
 * 
 * Bu pencere kasiyer ekranı olarak tasarlanmıştır.
 */
public class KasiyerEkrani extends javax.swing.JFrame {

    private static Personel personel;

    DefaultTableModel modelUrunler;
    DefaultTableModel modelSepettekiler;

    UrunBusiness urunB = new UrunBusiness();
    IslemlerBusiness islemB = new IslemlerBusiness();

    public KasiyerEkrani(Personel personel) {
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.personel = personel;
        this.setTitle("Kasa Ekranı, Kasiyer " + personel.getAdSoyad());
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        modelUrunler = (DefaultTableModel) tableUrunler.getModel();
        modelSepettekiler = (DefaultTableModel) tableSepettekiler.getModel();

        List<Urun> urunler = urunB.getAll();
        for (Urun urun : urunler) //Ekran ilk açıldığında tüm ürünler listelenir.
            modelUrunler.addRow(new Object[]{urun.getKod(), urun.getAd(), urun.getFiyat()});

        tableUrunler.addMouseListener(new TableListener(tableSepettekiler, lbl_tutar));  //Bu tablonun mouse işlemleri uzun olduğu için bir class'ta oluşturuldu.
        tableSepettekiler.addMouseListener(new MouseAdapter() {//Sepettekiler tablosundan tıklanan satırı kaldırır.
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    modelSepettekiler.removeRow(tableSepettekiler.getSelectedRow());
                    tutarGuncelle();
                }
            }
        });

        modelSepettekiler.addTableModelListener(new TableModelListener() {
            //Urun adeti tablo üzerinde güncellenebildiği için onu algılamak ve tutarı güncelleyebilmek adına...
            @Override
            public void tableChanged(TableModelEvent e) {
                tutarGuncelle();
            }
        });  
    }

    public void tutarGuncelle() { //Çok fazla kullandığımız için
        double tutar = 0.0;
        for (int j = 0; j < modelSepettekiler.getRowCount(); j++) {
            double fiyat = Double.parseDouble(modelSepettekiler.getValueAt(j, 2).toString());
            int adet = Integer.parseInt(modelSepettekiler.getValueAt(j, 3).toString());
            tutar += fiyat * adet;
        }
        lbl_tutar.setText(tutar + "");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableUrunler = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableSepettekiler = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_tutar = new javax.swing.JLabel();
        btn_bitir = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuHesap = new javax.swing.JMenu();
        itemSifre = new javax.swing.JMenuItem();
        itemCikis = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kasa Ekranı");
        setResizable(false);

        tableUrunler.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Urun Kodu", "Urun", "Fiyat"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableUrunler);
        if (tableUrunler.getColumnModel().getColumnCount() > 0) {
            tableUrunler.getColumnModel().getColumn(0).setResizable(false);
            tableUrunler.getColumnModel().getColumn(1).setResizable(false);
            tableUrunler.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Tüm Ürünler");

        tableSepettekiler.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Urun Kodu", "Urun", "Fiyat", "Adet"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableSepettekiler);
        if (tableSepettekiler.getColumnModel().getColumnCount() > 0) {
            tableSepettekiler.getColumnModel().getColumn(0).setResizable(false);
            tableSepettekiler.getColumnModel().getColumn(1).setResizable(false);
            tableSepettekiler.getColumnModel().getColumn(2).setResizable(false);
            tableSepettekiler.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Sepettekiler");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Toplam: ");

        lbl_tutar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl_tutar.setText("Tutar");

        btn_bitir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_bitir.setText("Alışverişi Bitir");
        btn_bitir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bitirActionPerformed(evt);
            }
        });

        menuHesap.setText("Hesap");

        itemSifre.setText("Şifre Değiş");
        itemSifre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSifreActionPerformed(evt);
            }
        });
        menuHesap.add(itemSifre);

        itemCikis.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        itemCikis.setText("Çıkış");
        itemCikis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCikisActionPerformed(evt);
            }
        });
        menuHesap.add(itemCikis);

        jMenuBar1.add(menuHesap);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 323, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(62, 62, 62))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_tutar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(btn_bitir))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_tutar, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_bitir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_bitirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bitirActionPerformed
        HashMap<Integer, Integer> urunKodlari = new HashMap<>();
        for (int i = 0; i < modelSepettekiler.getRowCount(); i++)
            urunKodlari.put(Integer.parseInt(modelSepettekiler.getValueAt(i, 0).toString()), Integer.parseInt(modelSepettekiler.getValueAt(i, 3).toString()));
        
        islemB.satisYap(personel.getKullaniciAdi(), Double.parseDouble(lbl_tutar.getText()), urunKodlari);

        modelSepettekiler.setRowCount(0);
        lbl_tutar.setText("0");
    }//GEN-LAST:event_btn_bitirActionPerformed

    private void itemCikisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCikisActionPerformed
        //Çıkış yapıldığında giriş yap ekranına yönlendirilir.
        new GirisEkrani().setVisible(true);
        this.dispose(); //dispose, kullanılan donanım kaynaklarını ve bilgileri kalıcı olarak sildiği için tercih edilir.
    }//GEN-LAST:event_itemCikisActionPerformed

    private void itemSifreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSifreActionPerformed
        new SifreDegis(this, true, personel).setVisible(true);
    }//GEN-LAST:event_itemSifreActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KasiyerEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KasiyerEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KasiyerEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KasiyerEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KasiyerEkrani(personel).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_bitir;
    private javax.swing.JMenuItem itemCikis;
    private javax.swing.JMenuItem itemSifre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_tutar;
    private javax.swing.JMenu menuHesap;
    private javax.swing.JTable tableSepettekiler;
    private javax.swing.JTable tableUrunler;
    // End of variables declaration//GEN-END:variables
}
