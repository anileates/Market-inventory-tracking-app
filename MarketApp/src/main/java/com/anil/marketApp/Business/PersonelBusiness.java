/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anil.marketApp.Business;

import com.anil.marketApp.DataAccess.PersonelDal;
import com.anil.marketApp.Entities.Personel;
import java.util.List;

/**
 *
 * @author anila
 */
public class PersonelBusiness {

    PersonelDal personelDal;
    List<Personel> personeller;

    public PersonelBusiness() {
        this.personelDal = new PersonelDal();
    }

    public List<Personel> getPersoneller() {
        personeller = personelDal.getAll();
        return personeller;
    }

    public String sifreDegis(Personel personel, String sifre) {
        /**
         * Yine arayüz ve veritabanından bağımsız olarak şifre uzunluğu kontrolü.
         * ÖRN. Sistemin arayüz veya veritabanı altyapıları değişse bile bu kontrol 'mantıksal' olarak sabittir.
         */
        if (sifre.length() > 16) {
            return "Şifre 16 karakterden fazla olamaz.";
        } else {
            personel.setSifre(sifre);
            personelDal.update(personel);
            return "Şifre değişti.";
        }

    }
}
