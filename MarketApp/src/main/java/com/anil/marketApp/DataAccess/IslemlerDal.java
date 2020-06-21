/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anil.marketApp.DataAccess;

import com.anil.marketApp.Entities.Islem;
import java.io.File;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author anila
 * 
 * Veritabanındaki işlemler ile ilgili işlemleri yapan sınıftır.
 * Son kullanıcının yani arayüzü tasarlarken bu sınıflara(DAO) katmanı ile doğrudan bir işimiz olmayacaktır.
 * 
 */
public class IslemlerDal {

    SessionFactory factory;

    public IslemlerDal() {
        factory = new Configuration()
                .configure(new File("src/resources/hibernate.cfg.xml"))
                .addAnnotatedClass(Islem.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
    }

    public List<Islem> getAlIslem() {
        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            List<Islem> islemler = session.createQuery("from Islem").getResultList();

            session.getTransaction().commit();
            return islemler;

        } finally {
            session.close();
        }
    }

    public void ekle(Islem islem) {
        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.save(islem);
            session.getTransaction().commit();
        } finally {
            session.close();
        }

    }
}
