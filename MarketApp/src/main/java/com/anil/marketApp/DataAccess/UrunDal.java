package com.anil.marketApp.DataAccess;

import com.anil.marketApp.Entities.Urun;
import java.io.File;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * 
 * @author anila
 *  
 * Bu sınıfta veriitabanındaki urun tablosuna erişim ile ilgili işlemler yapılır.
 * Daha sonra bu sınıfı Business katmanındaki UrunBusiness sınıfı kullanacak. * 
 * 
 * */
public class UrunDal {

    SessionFactory factory;
    /**
     * Constructor  ile bir SessionFactory oluşturulur.
     */
    public UrunDal() {
        factory = new Configuration()
                .configure(new File("src/resources/hibernate.cfg.xml"))
                .addAnnotatedClass(Urun.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
    }
    
    public void closeFactory(){
        factory.close();      
    }

    public List<Urun> getAll() {    //Tüm Urunleri DB'den alan metod.
        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            List<Urun> urunler = session.createQuery("from Urun").getResultList();

            session.getTransaction().commit();
            return urunler;
        } finally {
            session.close();
        }
    }

    public boolean add(Urun urun) {
        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.save(urun);

            session.getTransaction().commit();
            return true; //İşlem başarılı ise true döndürür.
        } finally {
            session.close();
        }
    }
    
    public boolean delete(Urun urun){
        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.delete(urun);

            session.getTransaction().commit();
            return true;
        } finally {
            session.close();
        }        
    }

    public Urun getById(int id) {
        Session session = null;
        Urun get;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("***TEST*** GEÇTİ");

            get = session.get(Urun.class, id);
            session.getTransaction().commit();
            return get;
        } finally {
            session.close();
        }
    }

    public boolean update(Urun urun) {
        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.update(urun);
            session.getTransaction().commit();
            return true;
        } finally {
            session.close();
        }
    }

}
