package com.anil.marketApp.Entities;

import javax.persistence.*;


/**
 *
 * @author anila
 */
@Entity
@Table(name = "personel")
public class Personel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "yetki")
    private String yetki;
    
    @Column(name = "kullanici_adi")
    private String kullaniciAdi;
    
    @Column(name = "sifre")
    private String sifre;
    
    @Column(name = "ad_soyad")
    private String adSoyad;

    public Personel() {
    }

    public Personel(int id, String yetki, String kullaniciAdi, String sifre, String adSoyad) {
        this.id = id;
        this.yetki = yetki;
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
        this.adSoyad = adSoyad;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the yetki
     */
    public String getYetki() {
        return yetki;
    }

    /**
     * @param yetki the yetki to set
     */
    public void setYetki(String yetki) {
        this.yetki = yetki;
    }

    /**
     * @return the kullaniciAdi
     */
    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    /**
     * @param kullaniciAdi the kullaniciAdi to set
     */
    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    /**
     * @return the sifre
     */
    public String getSifre() {
        return sifre;
    }

    /**
     * @param sifre the sifre to set
     */
    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    /**
     * @return the adSoyad
     */
    public String getAdSoyad() {
        return adSoyad;
    }

    /**
     * @param adSoyad the adSoyad to set
     */
    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }
    
    
}
