package com.anil.marketApp.DataAccess;

import com.anil.marketApp.Entities.Personel;
import java.io.File;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author anila
 * 
 * Bu sınıf veritabanıdaki Personel ile ilgili tüm işlemleri yapar.
 */
public class PersonelDal {

    private SessionFactory factory;
    private List<Personel> personeller;

    public PersonelDal() {
        factory = new Configuration()
                .configure(new File("src/resources/hibernate.cfg.xml"))
                .addAnnotatedClass(Personel.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
    }

    public List<Personel> getAll() {
        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            //Select * from personel
            personeller = session.createQuery("from Personel").getResultList();

            session.getTransaction().commit();
            return personeller;
        } finally {
            session.close();
        }
    }

    public Personel getFromId(int id) {
        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            Personel personel = session.get(Personel.class, id);

            session.getTransaction().commit();
            return personel;
        } finally {
            session.close();
        }
    }

    public boolean update(Personel personel) {
        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            session.update(personel);
            session.getTransaction().commit();
            return true;
        } finally {
            session.close();
        }
    }

}
