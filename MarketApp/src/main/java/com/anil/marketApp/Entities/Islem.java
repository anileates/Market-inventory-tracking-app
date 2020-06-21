
package com.anil.marketApp.Entities;

import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author anila
 */


@Entity
@Table(name = "islemler")
public class Islem {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
   
    @Column(name = "tip")
    private String tip;
    
    @Column(name = "kullanici")
    private String kullanici_adi;
    
    @Column(name = "toplam")
    private double toplam;
    
    @Column(name = "tarih_saat")
    private Date date;

    public Islem() {
    }

    public Islem(int id, String tip, String kullanici_adi, double toplam, Date date) {
        this.id = id;
        this.tip = tip;
        this.kullanici_adi = kullanici_adi;
        this.toplam = toplam;
        this.date = date;
    }
    
    

    public Date getDate() {
        return date;
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
     * @return the tip
     */
    public String getTip() {
        return tip;
    }

    /**
     * @param tip the tip to set
     */
    public void setTip(String tip) {
        this.tip = tip;
    }

    /**
     * @return the kullanici_adi
     */
    public String getKullanici_adi() {
        return kullanici_adi;
    }

    /**
     * @param kullanici_adi the kullanici_adi to set
     */
    public void setKullanici_adi(String kullanici_adi) {
        this.kullanici_adi = kullanici_adi;
    }

    /**
     * @return the toplam
     */
    public double getToplam() {
        return toplam;
    }

    /**
     * @param toplam the toplam to set
     */
    public void setToplam(double toplam) {
        this.toplam = toplam;
    }
    
}
