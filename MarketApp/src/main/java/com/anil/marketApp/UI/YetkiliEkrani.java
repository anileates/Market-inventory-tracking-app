/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anil.marketApp.UI;

import com.anil.marketApp.Business.IslemlerBusiness;
import com.anil.marketApp.Business.PersonelBusiness;
import com.anil.marketApp.Business.UrunBusiness;
import com.anil.marketApp.Entities.Islem;
import com.anil.marketApp.Entities.Personel;
import com.anil.marketApp.Entities.Urun;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import javax.swing.ImageIcon;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author anila
 */
public class YetkiliEkrani extends javax.swing.JFrame {

    private static Personel personel;

    Color colorSecili = new Color(13, 159, 184); //Yan panelde seçilen panelin rengi
    Color colorDefault = new Color(13, 103, 187);

    DefaultTableModel model;
    DefaultTableModel modelPersonelTable;
    DefaultTableModel table2model;

    UrunBusiness urunB = new UrunBusiness();
    List<Urun> urunler;

    PersonelBusiness personelB = new PersonelBusiness();
    List<Personel> personeller;

    IslemlerBusiness islemlerBusiness = new IslemlerBusiness();
    List<Islem> islemler;

    DefaultTableModel modelIslemler;

    JPanel seciliPanel;
    
    ImageIcon icon = new ImageIcon("src/resources/restart-resized.png");
    public YetkiliEkrani(Personel personel) {
        initComponents();
        this.personel = personel;
        
        btn_guncelle.setIcon(icon);
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();    //Pencere konumu işlemleri
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        lbl_hosgeldin.setText("Hoşgeldin " + personel.getAdSoyad());

        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy HH:mm:ss", new Locale("tr"));
        ActionListener updateClockAction = new ActionListener() { //Saat ve tarih bilgisinin görünmesi için
            public void actionPerformed(ActionEvent e) {
                lbl_tarih.setText(sdf.format(new Date()).toString());
            }
        };
        Timer t = new Timer(1000, updateClockAction);
        t.start();


        model = (DefaultTableModel) tableUrunler.getModel();
        modelIslemler = (DefaultTableModel) table_islemler.getModel();

        tableUrunler.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tableUrunler.getSelectedRow();
                String id = model.getValueAt(selectedRow, 0).toString();
                String ad = model.getValueAt(selectedRow, 1).toString();
                String fiyat = model.getValueAt(selectedRow, 2).toString();
                String stok = model.getValueAt(selectedRow, 3).toString();

                textField_id.setText(id);
                textField_ad.setText(ad);
                textField_fiyat2.setText(fiyat);
                textField_stok2.setText(stok);
            }
        });

        seciliPanel = ekranGelirGider;
        lbl_gelir.setText(String.valueOf(islemlerBusiness.getGelir()));
        lbl_giderler.setText(String.valueOf(islemlerBusiness.getGider()));
        Double toplam = islemlerBusiness.getGelir() + islemlerBusiness.getGider();
        lbl_toplam.setText("" + toplam);
 
        islemler = islemlerBusiness.getAll();
        for (Islem islem : islemler)
            modelIslemler.addRow(new Object[]{islem.getId(), islem.getTip(), islem.getKullanici_adi(), islem.getToplam(), islem.getDate()});

        table2model = (DefaultTableModel) tableUrunler2.getModel();
    }

    public void renkDegis(JPanel seciliPanel) { //Panel değiştiği renk değişimi yapar
        for (Component component : MenuPaneli.getComponents()) { //Ekranın soluna dayalı olan panelin adı MenuPaneli'dir.
            if (component instanceof JPanel) {  //MenuPaneli'nin içindeki component JPanel nesnesi ise...
                component.setBackground(colorDefault);
            }
        }
        seciliPanel.setBackground(colorSecili);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        UstPanel = new javax.swing.JPanel();
        lbl_hosgeldin = new javax.swing.JLabel();
        lbl_tarih = new javax.swing.JLabel();
        MenuPaneli = new javax.swing.JPanel();
        cardAlim = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cardGelirGider = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cardYeniEkle = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cardUrunDuzenle = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        panel_centre = new javax.swing.JPanel();
        ekranGelirGider = new javax.swing.JPanel();
        lbl_gelir = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_giderler = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_giderler1 = new javax.swing.JLabel();
        lbl_toplam = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_islemler = new javax.swing.JTable();
        comboBoxGun = new javax.swing.JComboBox<>();
        comboBoxYil = new javax.swing.JComboBox<>();
        comboBoxGunBitis = new javax.swing.JComboBox<>();
        comboBoxAyBitis = new javax.swing.JComboBox<>();
        comboBoxYilBitis = new javax.swing.JComboBox<>();
        btn_getir = new javax.swing.JButton();
        comboBoxAy = new javax.swing.JComboBox<>();
        lbl_dateMesaj = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        ekranYeniEkle = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        textField_urunAd = new javax.swing.JTextField();
        textField_fiyat = new javax.swing.JTextField();
        textField_stok = new javax.swing.JTextField();
        btn_urunKaydet = new javax.swing.JButton();
        lbl_mesaj = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtField_maliyet = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        ekranUrunDuzenle = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableUrunler = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        textField_id = new javax.swing.JTextField();
        textField_ad = new javax.swing.JTextField();
        textField_fiyat2 = new javax.swing.JTextField();
        textField_stok2 = new javax.swing.JTextField();
        btn_degisiklikUygula = new javax.swing.JButton();
        lbl_mesajDuzen = new javax.swing.JLabel();
        btn_guncelle = new javax.swing.JButton();
        btn_urunSil = new javax.swing.JButton();
        ekranAlim = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableUrunler2 = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        lbl_urunKodu = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbl_urunAd = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtField_adet = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtField_toplam = new javax.swing.JTextField();
        btn_onayla = new javax.swing.JButton();
        lbl_mesajYeni = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuHesap = new javax.swing.JMenu();
        itemCikis = new javax.swing.JMenuItem();
        itemSifre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Yetkili Paneli");
        setResizable(false);

        UstPanel.setBackground(new java.awt.Color(13, 103, 187));
        UstPanel.setPreferredSize(new java.awt.Dimension(761, 70));

        lbl_hosgeldin.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_hosgeldin.setForeground(new java.awt.Color(255, 255, 255));
        lbl_hosgeldin.setText("Hoşgeldiniz ");

        lbl_tarih.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lbl_tarih.setForeground(new java.awt.Color(255, 255, 255));
        lbl_tarih.setText("Tarih Saat");

        javax.swing.GroupLayout UstPanelLayout = new javax.swing.GroupLayout(UstPanel);
        UstPanel.setLayout(UstPanelLayout);
        UstPanelLayout.setHorizontalGroup(
            UstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UstPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_hosgeldin, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 199, Short.MAX_VALUE)
                .addComponent(lbl_tarih, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        UstPanelLayout.setVerticalGroup(
            UstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UstPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(UstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_tarih, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_hosgeldin, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(UstPanel, java.awt.BorderLayout.PAGE_START);

        MenuPaneli.setBackground(new java.awt.Color(13, 103, 187));
        MenuPaneli.setPreferredSize(new java.awt.Dimension(150, 90));

        cardAlim.setBackground(new java.awt.Color(13, 103, 187));
        cardAlim.setPreferredSize(new java.awt.Dimension(121, 75));
        cardAlim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cardAlimMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Satın Alım Kaydet");

        javax.swing.GroupLayout cardAlimLayout = new javax.swing.GroupLayout(cardAlim);
        cardAlim.setLayout(cardAlimLayout);
        cardAlimLayout.setHorizontalGroup(
            cardAlimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardAlimLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addContainerGap())
        );
        cardAlimLayout.setVerticalGroup(
            cardAlimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardAlimLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        cardGelirGider.setBackground(new java.awt.Color(13, 159, 184));
        cardGelirGider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cardGelirGiderMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gelir Gider");

        javax.swing.GroupLayout cardGelirGiderLayout = new javax.swing.GroupLayout(cardGelirGider);
        cardGelirGider.setLayout(cardGelirGiderLayout);
        cardGelirGiderLayout.setHorizontalGroup(
            cardGelirGiderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardGelirGiderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cardGelirGiderLayout.setVerticalGroup(
            cardGelirGiderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardGelirGiderLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        cardYeniEkle.setBackground(new java.awt.Color(13, 103, 180));
        cardYeniEkle.setPreferredSize(new java.awt.Dimension(121, 75));
        cardYeniEkle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cardYeniEkleMouseClicked(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(13, 103, 180));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Yeni Ürün Kaydet");

        javax.swing.GroupLayout cardYeniEkleLayout = new javax.swing.GroupLayout(cardYeniEkle);
        cardYeniEkle.setLayout(cardYeniEkleLayout);
        cardYeniEkleLayout.setHorizontalGroup(
            cardYeniEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardYeniEkleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cardYeniEkleLayout.setVerticalGroup(
            cardYeniEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardYeniEkleLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        cardUrunDuzenle.setBackground(new java.awt.Color(13, 103, 180));
        cardUrunDuzenle.setPreferredSize(new java.awt.Dimension(121, 75));
        cardUrunDuzenle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cardUrunDuzenleMouseClicked(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(13, 103, 180));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Ürün Düzenle");

        javax.swing.GroupLayout cardUrunDuzenleLayout = new javax.swing.GroupLayout(cardUrunDuzenle);
        cardUrunDuzenle.setLayout(cardUrunDuzenleLayout);
        cardUrunDuzenleLayout.setHorizontalGroup(
            cardUrunDuzenleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardUrunDuzenleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cardUrunDuzenleLayout.setVerticalGroup(
            cardUrunDuzenleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardUrunDuzenleLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout MenuPaneliLayout = new javax.swing.GroupLayout(MenuPaneli);
        MenuPaneli.setLayout(MenuPaneliLayout);
        MenuPaneliLayout.setHorizontalGroup(
            MenuPaneliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cardGelirGider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cardYeniEkle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
            .addComponent(cardUrunDuzenle, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
            .addComponent(cardAlim, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        MenuPaneliLayout.setVerticalGroup(
            MenuPaneliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPaneliLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cardGelirGider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cardYeniEkle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cardUrunDuzenle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardAlim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(149, 149, 149))
        );

        getContentPane().add(MenuPaneli, java.awt.BorderLayout.LINE_START);

        panel_centre.setLayout(new java.awt.CardLayout());

        lbl_gelir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_gelir.setForeground(new java.awt.Color(51, 204, 0));
        lbl_gelir.setText("gelir");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Gelirler:");

        lbl_giderler.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_giderler.setForeground(new java.awt.Color(255, 0, 51));
        lbl_giderler.setText("giderler");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Giderler:");

        lbl_giderler1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_giderler1.setText("Toplam: ");

        lbl_toplam.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_toplam.setForeground(new java.awt.Color(51, 204, 0));
        lbl_toplam.setText("Toplam");

        table_islemler.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "İslem Kodu", "İşlem tipi", "Yapan Kişi", "Toplam", "Tarih"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(table_islemler);
        if (table_islemler.getColumnModel().getColumnCount() > 0) {
            table_islemler.getColumnModel().getColumn(0).setResizable(false);
            table_islemler.getColumnModel().getColumn(1).setResizable(false);
            table_islemler.getColumnModel().getColumn(2).setResizable(false);
            table_islemler.getColumnModel().getColumn(3).setResizable(false);
        }

        comboBoxGun.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gün", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        comboBoxGun.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                itemChanged(evt);
            }
        });

        comboBoxYil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yıl", "2019", "2020", "2021" }));

        comboBoxGunBitis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gün", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        comboBoxAyBitis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ay", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        comboBoxYilBitis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yıl", "2019", "2020", "2021" }));

        btn_getir.setText("Getir");
        btn_getir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_getirActionPerformed(evt);
            }
        });

        comboBoxAy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ay", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        jLabel19.setText("Başlangıç Tarihi");

        jLabel20.setText("Bitiş Tarihi");

        javax.swing.GroupLayout ekranGelirGiderLayout = new javax.swing.GroupLayout(ekranGelirGider);
        ekranGelirGider.setLayout(ekranGelirGiderLayout);
        ekranGelirGiderLayout.setHorizontalGroup(
            ekranGelirGiderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ekranGelirGiderLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(ekranGelirGiderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ekranGelirGiderLayout.createSequentialGroup()
                        .addGroup(ekranGelirGiderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ekranGelirGiderLayout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(lbl_gelir, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52))
                            .addGroup(ekranGelirGiderLayout.createSequentialGroup()
                                .addGroup(ekranGelirGiderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(ekranGelirGiderLayout.createSequentialGroup()
                                        .addComponent(comboBoxGun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(comboBoxAy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(comboBoxYil, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(74, 74, 74)))
                        .addGroup(ekranGelirGiderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(ekranGelirGiderLayout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_giderler, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)
                                .addComponent(lbl_giderler1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_toplam, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ekranGelirGiderLayout.createSequentialGroup()
                                .addGroup(ekranGelirGiderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(ekranGelirGiderLayout.createSequentialGroup()
                                        .addComponent(comboBoxGunBitis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(comboBoxAyBitis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(comboBoxYilBitis, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_getir, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(lbl_dateMesaj, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(ekranGelirGiderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ekranGelirGiderLayout.setVerticalGroup(
            ekranGelirGiderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ekranGelirGiderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_dateMesaj, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ekranGelirGiderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ekranGelirGiderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxGun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxYil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxGunBitis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxAyBitis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxYilBitis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxAy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_getir))
                .addGap(18, 18, 18)
                .addGroup(ekranGelirGiderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_giderler, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_gelir, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_giderler1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_toplam, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addContainerGap())
        );

        panel_centre.add(ekranGelirGider, "card2");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Adet(Stok):");
        jLabel10.setPreferredSize(new java.awt.Dimension(75, 20));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Ürün Adı:");
        jLabel11.setPreferredSize(new java.awt.Dimension(75, 20));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Satış Fiyatı:");
        jLabel12.setPreferredSize(new java.awt.Dimension(75, 20));

        btn_urunKaydet.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_urunKaydet.setText("Ürünü Kaydet");
        btn_urunKaydet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_urunKaydetActionPerformed(evt);
            }
        });

        lbl_mesaj.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Birim Maliyeti:");

        jLabel21.setText("(Fiyatlarda Nokta kullanın. Örn: 0.5)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(219, 219, 219)
                            .addComponent(btn_urunKaydet, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(textField_stok, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                                        .addComponent(textField_urunAd))
                                    .addGap(31, 31, 31)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(lbl_mesaj, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(textField_fiyat, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                                .addComponent(txtField_maliyet)))))
                .addGap(0, 19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                        .addComponent(textField_urunAd)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(textField_fiyat, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField_stok, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtField_maliyet, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(53, 53, 53)
                .addComponent(btn_urunKaydet, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(lbl_mesaj, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout ekranYeniEkleLayout = new javax.swing.GroupLayout(ekranYeniEkle);
        ekranYeniEkle.setLayout(ekranYeniEkleLayout);
        ekranYeniEkleLayout.setHorizontalGroup(
            ekranYeniEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ekranYeniEkleLayout.setVerticalGroup(
            ekranYeniEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ekranYeniEkleLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 88, Short.MAX_VALUE))
        );

        panel_centre.add(ekranYeniEkle, "card3");

        tableUrunler.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ürün Kodu", "Ürün Adı", "Fiyat", "Stok"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableUrunler.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tableUrunler);
        if (tableUrunler.getColumnModel().getColumnCount() > 0) {
            tableUrunler.getColumnModel().getColumn(0).setResizable(false);
            tableUrunler.getColumnModel().getColumn(1).setResizable(false);
            tableUrunler.getColumnModel().getColumn(2).setResizable(false);
            tableUrunler.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("        ID:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Ürün Adı:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("      Stok:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("      Fiyat:");

        btn_degisiklikUygula.setBackground(new java.awt.Color(128, 240, 136));
        btn_degisiklikUygula.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_degisiklikUygula.setText("Değişiklikleri Uygula");
        btn_degisiklikUygula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_degisiklikUygulaActionPerformed(evt);
            }
        });

        lbl_mesajDuzen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_mesajDuzen.setText("Mesaj");

        btn_guncelle.setToolTipText("Tabloyu yenile");
        btn_guncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guncelleActionPerformed(evt);
            }
        });

        btn_urunSil.setBackground(new java.awt.Color(198, 0, 0));
        btn_urunSil.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_urunSil.setText("Ürünü Kayıtlardan Sil");
        btn_urunSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_urunSilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ekranUrunDuzenleLayout = new javax.swing.GroupLayout(ekranUrunDuzenle);
        ekranUrunDuzenle.setLayout(ekranUrunDuzenleLayout);
        ekranUrunDuzenleLayout.setHorizontalGroup(
            ekranUrunDuzenleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ekranUrunDuzenleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(ekranUrunDuzenleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ekranUrunDuzenleLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(ekranUrunDuzenleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_degisiklikUygula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_urunSil, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)))
                    .addGroup(ekranUrunDuzenleLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btn_guncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ekranUrunDuzenleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ekranUrunDuzenleLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(textField_id, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ekranUrunDuzenleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ekranUrunDuzenleLayout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(textField_ad, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ekranUrunDuzenleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ekranUrunDuzenleLayout.createSequentialGroup()
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(textField_fiyat2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(ekranUrunDuzenleLayout.createSequentialGroup()
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(textField_stok2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(lbl_mesajDuzen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 21, Short.MAX_VALUE)))
                .addContainerGap())
        );
        ekranUrunDuzenleLayout.setVerticalGroup(
            ekranUrunDuzenleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ekranUrunDuzenleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ekranUrunDuzenleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ekranUrunDuzenleLayout.createSequentialGroup()
                        .addGroup(ekranUrunDuzenleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ekranUrunDuzenleLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(ekranUrunDuzenleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textField_id)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)))
                            .addComponent(btn_guncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(ekranUrunDuzenleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField_ad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(ekranUrunDuzenleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                            .addComponent(textField_fiyat2))
                        .addGap(24, 24, 24)
                        .addGroup(ekranUrunDuzenleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField_stok2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_mesajDuzen, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_degisiklikUygula, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_urunSil, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        panel_centre.add(ekranUrunDuzenle, "card4");

        tableUrunler2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Urun Kod", "Urun Adı", "Stok"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane2.setViewportView(tableUrunler2);
        if (tableUrunler2.getColumnModel().getColumnCount() > 0) {
            tableUrunler2.getColumnModel().getColumn(0).setResizable(false);
            tableUrunler2.getColumnModel().getColumn(1).setResizable(false);
            tableUrunler2.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Ürün Kodu:");

        lbl_urunKodu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_urunKodu.setText("urun");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Ürün Adı: ");

        lbl_urunAd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_urunAd.setText("urun");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setText("Alınan Adet:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("Toplam Fiyat: ");

        btn_onayla.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_onayla.setText("Alımı Onayla");
        btn_onayla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_onaylaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ekranAlimLayout = new javax.swing.GroupLayout(ekranAlim);
        ekranAlim.setLayout(ekranAlimLayout);
        ekranAlimLayout.setHorizontalGroup(
            ekranAlimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ekranAlimLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(ekranAlimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ekranAlimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ekranAlimLayout.createSequentialGroup()
                            .addGap(97, 97, 97)
                            .addComponent(btn_onayla, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(ekranAlimLayout.createSequentialGroup()
                            .addGap(34, 34, 34)
                            .addGroup(ekranAlimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel17)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel15))
                            .addGap(18, 18, 18)
                            .addGroup(ekranAlimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbl_urunAd, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtField_adet, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_urunKodu, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(ekranAlimLayout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addComponent(jLabel18)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtField_toplam, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(ekranAlimLayout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(lbl_mesajYeni, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        ekranAlimLayout.setVerticalGroup(
            ekranAlimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ekranAlimLayout.createSequentialGroup()
                .addGroup(ekranAlimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ekranAlimLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE))
                    .addGroup(ekranAlimLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(ekranAlimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_urunKodu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(ekranAlimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_urunAd, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(ekranAlimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                            .addComponent(txtField_adet))
                        .addGap(50, 50, 50)
                        .addGroup(ekranAlimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtField_toplam, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_mesajYeni, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_onayla, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        panel_centre.add(ekranAlim, "card5");

        getContentPane().add(panel_centre, java.awt.BorderLayout.CENTER);

        menuHesap.setText("Hesap");

        itemCikis.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        itemCikis.setText("Çıkış Yap");
        itemCikis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCikisActionPerformed(evt);
            }
        });
        menuHesap.add(itemCikis);

        itemSifre.setText("Şifre Değiştir");
        itemSifre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSifreActionPerformed(evt);
            }
        });
        menuHesap.add(itemSifre);

        jMenuBar1.add(menuHesap);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_urunKaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_urunKaydetActionPerformed

        String ad = textField_urunAd.getText();
        Double fiyat = Double.parseDouble(textField_fiyat.getText());
        int stok = Integer.parseInt(textField_stok.getText());
        Double maliyet = Double.parseDouble(txtField_maliyet.getText());

        String yanit = urunB.urunEkle(ad, fiyat, stok, maliyet);

        lbl_mesaj.setText(yanit);
        lbl_mesaj.setForeground(Color.BLUE);
        
    }//GEN-LAST:event_btn_urunKaydetActionPerformed

    public String sifreAl() { //Herhangi bir üründe kayıt yapılak ise güvenlik amaçlı şifre ister.
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Değişikliği uygulamak istediğinize emin misiniz? \nİşlem Kalıcı Olacaktır.");
        JPasswordField pass = new JPasswordField(10);
        panel.add(label);
        panel.add(pass);
        String[] options = new String[]{"Onayla", "İptal"};
        int option = JOptionPane.showOptionDialog(null, panel, "Onayla",
                JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options[1]);

        char[] password = null;
        if (option == 0) // pressing OK button
        {
            password = pass.getPassword();
        }
        return new String(password);
    }

    private void btn_degisiklikUygulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_degisiklikUygulaActionPerformed
        String password = sifreAl(); //değişiklik yapılırken şifre alınır

        if (password.equals(personel.getSifre())) {
            int selectedRow = tableUrunler.getSelectedRow();
            int id = (int) model.getValueAt(selectedRow, 0);

            Urun gelenUrun = urunB.getFromId(id);
            Urun yedek = new Urun(gelenUrun.getKod(), gelenUrun.getAd(), gelenUrun.getFiyat(), gelenUrun.getStok());

            gelenUrun.setKod(Integer.parseInt(textField_id.getText()));
            gelenUrun.setAd(textField_ad.getText());
            gelenUrun.setFiyat(Double.parseDouble(textField_fiyat2.getText()));
            gelenUrun.setStok(Integer.parseInt(textField_stok2.getText()));

            String mesaj = urunB.guncelle(gelenUrun, yedek);
            lbl_mesajDuzen.setText(mesaj);
        } else {
            lbl_mesajDuzen.setText("Şifre Hatalı.");
        }
    }//GEN-LAST:event_btn_degisiklikUygulaActionPerformed

    private void btn_guncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guncelleActionPerformed
        model.setRowCount(0);
        
        urunler = urunB.getAll();   //Tüm ürünler yeniden listelenir
        for (Urun urun : urunler)
            model.addRow(new Object[]{urun.getKod(), urun.getAd(), urun.getFiyat(), urun.getStok()});
        
        textField_ad.setText("");
        textField_id.setText("");
        textField_fiyat2.setText("");
        textField_stok2.setText("");
    }//GEN-LAST:event_btn_guncelleActionPerformed

    private void itemChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_itemChanged

    }//GEN-LAST:event_itemChanged

    private void btn_getirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_getirActionPerformed
        Date baslangic = null;
        Date bitis = null;
        Double gelir = 0.0;
        Double gider = 0.0;
        
        //combobox'lar ile tarih alınır.
        try {
            int gunBas = Integer.parseInt(comboBoxGun.getSelectedItem().toString());
            int ayBas = Integer.parseInt(comboBoxAy.getSelectedItem().toString());
            int yilBas = Integer.parseInt(comboBoxYil.getSelectedItem().toString());
            baslangic = new Date(yilBas, ayBas, gunBas);

            int gunBit = Integer.parseInt(comboBoxGunBitis.getSelectedItem().toString());
            int ayBit = Integer.parseInt(comboBoxYilBitis.getSelectedItem().toString());
            int yilBit = Integer.parseInt(comboBoxYilBitis.getSelectedItem().toString());
            bitis = new Date(yilBit, ayBit, gunBit);
        } catch (DateTimeException e) {
            lbl_dateMesaj.setText("Doğru tarih seçtiğinize emin olun.");
        }

        modelIslemler.setRowCount(0);

        List<Islem> byDate = islemlerBusiness.getByDate(baslangic, bitis);
        for(Islem islem : byDate){
            modelIslemler.addRow(new Object[]{islem.getId(), islem.getTip(), islem.getKullanici_adi(), islem.getToplam(), islem.getDate()});
            if(islem.getToplam() > 0)
                gelir += islem.getToplam();
            else
                gider += islem.getToplam();
        }
        
        lbl_gelir.setText("" +gelir);
        lbl_giderler.setText("" + gider);
        Double toplam = gelir + gider;
        lbl_toplam.setText("" +toplam);
    }//GEN-LAST:event_btn_getirActionPerformed

    private void cardUrunDuzenleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cardUrunDuzenleMouseClicked
        seciliPanel.setVisible(false); //Ekran değişmesi ve bazı grafiksel işlemler
        seciliPanel = ekranUrunDuzenle;
        ekranUrunDuzenle.setVisible(true);
        renkDegis(cardUrunDuzenle);

        lbl_mesajDuzen.setText("");
        model.setRowCount(0);

        urunler = urunB.getAll();   //Tüm ürünler listelenir

        for (Urun urun : urunler) {
            model.addRow(new Object[]{urun.getKod(), urun.getAd(), urun.getFiyat(), urun.getStok()});
        }
    }//GEN-LAST:event_cardUrunDuzenleMouseClicked

    private void cardYeniEkleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cardYeniEkleMouseClicked
        ekranYeniEkle.setVisible(true);
        seciliPanel.setVisible(false);

        seciliPanel = ekranYeniEkle;
        renkDegis(cardYeniEkle);
    }//GEN-LAST:event_cardYeniEkleMouseClicked

    private void cardGelirGiderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cardGelirGiderMouseClicked

        seciliPanel.setVisible(false);
        seciliPanel = ekranGelirGider;
        ekranGelirGider.setVisible(true);

        renkDegis(cardGelirGider);
        
        modelIslemler.setRowCount(0);

        double gider = islemlerBusiness.getGider();
        double gelir = islemlerBusiness.getGelir();

        List<Islem> all = islemlerBusiness.getAll();
        for (Islem islem : all) 
            modelIslemler.addRow(new Object[]{islem.getId(), islem.getTip(), islem.getKullanici_adi(), islem.getToplam(), islem.getDate()});

        lbl_giderler.setText(gider + "");
        lbl_giderler.setForeground(Color.red);

        lbl_gelir.setText(gelir + "");
        lbl_gelir.setForeground(Color.GREEN);
    }//GEN-LAST:event_cardGelirGiderMouseClicked

    private void cardAlimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cardAlimMouseClicked
        seciliPanel.setVisible(false); //Ekran değişmesi ve bazı grafiksel işlemler
        seciliPanel = ekranAlim;
        seciliPanel.setVisible(true);
        renkDegis(cardAlim);

        lbl_urunAd.setText("");
        lbl_urunKodu.setText("");
        txtField_adet.setText("");
        txtField_toplam.setText("");
        table2model.setRowCount(0);

        urunler = urunB.getAll();   //Tüm ürünler listelenir
        for (Urun urun : urunler) 
            table2model.addRow(new Object[]{urun.getKod(), urun.getAd(), urun.getStok()});

        tableUrunler2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int selectedRow = tableUrunler2.getSelectedRow();
                String id = table2model.getValueAt(selectedRow, 0).toString();
                String ad = table2model.getValueAt(selectedRow, 1).toString();

                lbl_urunAd.setText(ad);
                lbl_urunKodu.setText(id);
            }
        });

        tableUrunler2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tableUrunler2.getSelectedRow();
                String id = table2model.getValueAt(selectedRow, 0).toString();
                String ad = table2model.getValueAt(selectedRow, 1).toString();

                lbl_urunAd.setText(ad);
                lbl_urunKodu.setText(id);
            }
        });
    }//GEN-LAST:event_cardAlimMouseClicked

    private void btn_onaylaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_onaylaActionPerformed

        int selectedRow = tableUrunler2.getSelectedRow();
        int seciliID = Integer.parseInt(table2model.getValueAt(selectedRow, 0).toString());

        double toplam = Double.parseDouble("-"+txtField_toplam.getText());
        int adet = Integer.parseInt(txtField_adet.getText());

        Urun fromId = urunB.getFromId(seciliID);
        
        String mesaj = islemlerBusiness.alimYap(seciliID, personel.getKullaniciAdi(), toplam, adet);

        lbl_mesajYeni.setText(mesaj);
        table2model.setRowCount(0);
        urunler = urunB.getAll();   //Tüm ürünler listelenir
        for (Urun urun : urunler) 
            table2model.addRow(new Object[]{urun.getKod(), urun.getAd(), urun.getStok()});

    }//GEN-LAST:event_btn_onaylaActionPerformed

    private void btn_urunSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_urunSilActionPerformed

        String password = sifreAl();
        if (password.equals(personel.getSifre())) {
            int selectedRow = tableUrunler.getSelectedRow();
            int seciliId = Integer.parseInt(model.getValueAt(selectedRow, 0).toString());

            String urunSil = urunB.urunSil(urunB.getFromId(seciliId));
            lbl_mesajDuzen.setText(urunSil);
        } else {
            lbl_mesajDuzen.setText("Şifre Hatalı!");
        }
    }//GEN-LAST:event_btn_urunSilActionPerformed

    private void itemSifreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSifreActionPerformed
        new SifreDegis(this, true, personel).setVisible(true);
    }//GEN-LAST:event_itemSifreActionPerformed

    private void itemCikisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCikisActionPerformed
        new GirisEkrani().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_itemCikisActionPerformed

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
            java.util.logging.Logger.getLogger(YetkiliEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(YetkiliEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(YetkiliEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(YetkiliEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new YetkiliEkrani(personel).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MenuPaneli;
    private javax.swing.JPanel UstPanel;
    private javax.swing.JButton btn_degisiklikUygula;
    private javax.swing.JButton btn_getir;
    private javax.swing.JButton btn_guncelle;
    private javax.swing.JButton btn_onayla;
    private javax.swing.JButton btn_urunKaydet;
    private javax.swing.JButton btn_urunSil;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel cardAlim;
    private javax.swing.JPanel cardGelirGider;
    private javax.swing.JPanel cardUrunDuzenle;
    private javax.swing.JPanel cardYeniEkle;
    private javax.swing.JComboBox<String> comboBoxAy;
    private javax.swing.JComboBox<String> comboBoxAyBitis;
    private javax.swing.JComboBox<String> comboBoxGun;
    private javax.swing.JComboBox<String> comboBoxGunBitis;
    private javax.swing.JComboBox<String> comboBoxYil;
    private javax.swing.JComboBox<String> comboBoxYilBitis;
    private javax.swing.JPanel ekranAlim;
    private javax.swing.JPanel ekranGelirGider;
    private javax.swing.JPanel ekranUrunDuzenle;
    private javax.swing.JPanel ekranYeniEkle;
    private javax.swing.JMenuItem itemCikis;
    private javax.swing.JMenuItem itemSifre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_dateMesaj;
    private javax.swing.JLabel lbl_gelir;
    private javax.swing.JLabel lbl_giderler;
    private javax.swing.JLabel lbl_giderler1;
    private javax.swing.JLabel lbl_hosgeldin;
    private javax.swing.JLabel lbl_mesaj;
    private javax.swing.JLabel lbl_mesajDuzen;
    private javax.swing.JLabel lbl_mesajYeni;
    private javax.swing.JLabel lbl_tarih;
    private javax.swing.JLabel lbl_toplam;
    private javax.swing.JLabel lbl_urunAd;
    private javax.swing.JLabel lbl_urunKodu;
    private javax.swing.JMenu menuHesap;
    private javax.swing.JPanel panel_centre;
    private javax.swing.JTable tableUrunler;
    private javax.swing.JTable tableUrunler2;
    private javax.swing.JTable table_islemler;
    private javax.swing.JTextField textField_ad;
    private javax.swing.JTextField textField_fiyat;
    private javax.swing.JTextField textField_fiyat2;
    private javax.swing.JTextField textField_id;
    private javax.swing.JTextField textField_stok;
    private javax.swing.JTextField textField_stok2;
    private javax.swing.JTextField textField_urunAd;
    private javax.swing.JTextField txtField_adet;
    private javax.swing.JTextField txtField_maliyet;
    private javax.swing.JTextField txtField_toplam;
    // End of variables declaration//GEN-END:variables
}
