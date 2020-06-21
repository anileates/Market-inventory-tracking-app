/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anil.marketApp.Business;

import com.anil.marketApp.DataAccess.UrunDal;
import com.anil.marketApp.Entities.Urun;
import java.util.List;

/**
 *
 * @author anila
 */
public class UrunBusiness {

    UrunDal urunDal;
    List<Urun> urunler;

    public UrunBusiness() {
        this.urunDal = new UrunDal();
    }

    public List<Urun> getAll() {
        urunler = urunDal.getAll();
        return urunler;
    }

    public String urunEkle(String urunAd, double fiyat, int stok, double maliyet) {
        if ((!urunAd.trim().equals("") && urunAd != null) && fiyat > 0 && stok >= 0) { //Ürün adı, fiyatı ve stoğu kontrol edildikten sonra DAO'ya gönderilir.
            urunDal.add(new Urun(0, urunAd, fiyat, stok));
            return "Ürün Eklendi";
        } else if (urunAd.trim().equals("") || urunAd == null) {
            return "Ürün adı boş olamaz.";
        } else if (fiyat <= 0 || stok < 0) {
            return "Ürün fiyatı ve stok 0 olamaz.";
        } else {
            return "";
        }
    }

    public String urunSil(Urun urun) {
        urunDal.delete(urun);
        return "Silindi.";
    }

    public String stokGuncelle(Urun urun, int stok) {
        if (stok >= 0) {
            urun.setStok(stok);
            urunDal.update(urun);
            return "Stok Güncellendi";
        } else {
            return "Geçersiz stok.";
        }
    }

    public Urun getFromId(int id) {
        Urun urun = urunDal.getById(id);
        return urun;
    }

    public boolean varMi(Urun urun, Urun yedek) {
        for (int i = 0; i < urunler.size(); i++) {
            if (urun.getKod() == urunler.get(i).getKod()) {
                System.out.println("Gelen Urun Kodu: " + urun.getKod() + " Yedek Urun Kodu: " + yedek.getKod());

                if (urun.getKod() == yedek.getKod()) {
                    return false;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public String guncelle(Urun urun, Urun yedek) {

        if (varMi(urun, yedek)) {
            return "Ürün kodu eşsiz olmalı.";
        } else {
            if ((!urun.getAd().trim().equals("") && urun.getAd() != null) && urun.getFiyat() > 0 && urun.getStok() >= 0) {
                urunDal.update(urun);
                return "Ürün Güncellendi";
            } else if (urun.getAd().trim().equals("") || urun.getAd() == null) {
                return "Ürün adı boş olamaz.";
            } else if (urun.getFiyat() <= 0 || urun.getStok() < 0) {
                return "Ürün fiyatı ve stok 0 olamaz.";
            } else {
                return "";
            }

        }

    }
}
