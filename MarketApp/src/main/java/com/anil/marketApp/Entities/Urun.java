package com.anil.marketApp.Entities;

import javax.persistence.*;

/**
 *
 * @author anila
 */


@Entity
@Table(name = "urunler")
public class Urun {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "kod")
    private int kod;
    
    @Column(name = "ad")
    private String ad;
    
    @Column(name = "fiyat")
    private double fiyat;
    
    @Column(name = "stok")
    private int stok;
    
    
    public Urun() {
    }

    public Urun(int kod, String ad, double fiyat, int stok) {
        this.kod = kod;
        this.ad = ad;
        this.fiyat = fiyat;
        this.stok = stok;
    }
    

    /**
     * @return the kod
     */
    public int getKod() {
        return kod;
    }

    /**
     * @param kod the kod to set
     */
    public void setKod(int kod) {
        this.kod = kod;
    }

    /**
     * @return the ad
     */
    public String getAd() {
        return ad;
    }

    /**
     * @param ad the ad to set
     */
    public void setAd(String ad) {
        this.ad = ad;
    }

    /**
     * @return the fiyat
     */
    public double getFiyat() {
        return fiyat;
    }

    /**
     * @param fiyat the fiyat to set
     */
    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }

    /**
     * @return the stok
     */
    public int getStok() {
        return stok;
    }

    /**
     * @param stok the stok to set
     */
    public void setStok(int stok) {
        this.stok = stok;
    }

    /**
     * @return the id
     */

    
}
