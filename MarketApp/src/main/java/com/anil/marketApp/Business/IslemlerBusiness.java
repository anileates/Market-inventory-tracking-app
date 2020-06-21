package com.anil.marketApp.Business;

import com.anil.marketApp.DataAccess.IslemlerDal;
import com.anil.marketApp.Entities.Islem;
import com.anil.marketApp.Entities.Urun;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;

/**
 *
 * @author anila
 *
 * Bu sınıf, ilgili veritabanı işlemleri için bir kontrol noktasıdır. Gelen
 * verileri ve gidecek veriler üzerinde işlemler ve kontroller yaparız.
 *
 */
public class IslemlerBusiness {

    private IslemlerDal dal;
    private List<Islem> islemler;

    public IslemlerBusiness() { //Bu sınıf çağırıldığı anda tüm İşlem verileri alınır.
        dal = new IslemlerDal();
        islemler = dal.getAlIslem();
    }

    public List<Islem> getAll() {
        islemler = dal.getAlIslem();
        return islemler;
    }

    /**
     * getGider() metodu business katmanını anlamak için iyi bir örnektir,
     * Veritabanından aldığımız tüm işlem tutarları üzerinde hangi verinin gider
     * hangi verinin gelir olduğunu burada kontrol ediyor ve gider olanları
     * döndürüyoruz.
     *
     * Bu, programın 'mantıksal' kısımlarını veritabanından ve arayüzden
     * bağımsız olarak yapmamızı sağlar
     *
     * @return gider
     */
    public double getGider() {
        double gider = 0;
        for (Islem islem : islemler) {
            if (islem.getToplam() < 0) {
                gider += islem.getToplam();
            }
        }
        return gider;
    }

    public double getGelir() {
        double gelir = 0;
        for (Islem islem : islemler) {
            if (islem.getToplam() > 0) {
                gelir += islem.getToplam();
            }
        }
        return gelir;
    }

    public List<Islem> getByDate(Date baslangic, Date bitis) {  //İşlemleri tarih aralığına göre döndürüyoruz.
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String baslangicDate = formatter.format(baslangic);
        String bitisDate = formatter.format(bitis);

        ArrayList<Islem> islemS = new ArrayList<>();

        for (Islem islem : islemler) {
            String islemDate = formatter.format(islem.getDate());
            System.out.println(islemDate + " " + baslangicDate + " " + bitisDate);
            if ((islemDate.compareTo(baslangicDate) > 0 || islemDate.compareTo(baslangicDate) == 0) && (islemDate.compareTo(bitisDate) < 0 || islemDate.compareTo(bitisDate) == 0)) {
                islemS.add(islem);
            }
        }
        return islemS;
    }

    public String satisYap(String kullaniciAd, Double fiyat, HashMap<Integer, Integer> urunKodlari) {
        /**
         * Satış yapıldığında işlem kaydını tutar ve -Hashmap olarak gelen-
         * satılan ürünlerin stok işlemlerini yapar
         */
        Date date = new Date();
        Islem islem = new Islem(0, "Satış", kullaniciAd, fiyat, date);
        dal.ekle(islem);

        UrunBusiness urunB = new UrunBusiness();

        for (int kod : urunKodlari.keySet()) {
            Urun urun = urunB.getFromId(kod);
            urunB.stokGuncelle(urun, urun.getStok() - urunKodlari.get(kod));
        }
        return "Satış Yapıldı.";
    }

    public String alimYap(int id, String kullaniciAd, Double fiyat, int stok) {
        try {
            Date date = new Date();
            Islem islem = new Islem(0, "Satın Alım", kullaniciAd, fiyat, date);
            dal.ekle(islem);

            UrunBusiness urunB = new UrunBusiness();

            Urun urun = urunB.getFromId(id);
                       
            urunB.stokGuncelle(urun, urun.getStok() + stok);
            return "Alım Yapıldı.";
        } catch (Exception e) {
            return "Lütfen verilerinizi kontrol edin.";
        }
    }
}
