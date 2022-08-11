/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package po;


import Encje.Klient;
import Encje.Usluga;
import Encje.Zamowienie;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author damia
 */
public class baza {
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;


    public void connectToDb() {

        entityManagerFactory = Persistence.createEntityManagerFactory("AppPU");
        entityManager = entityManagerFactory.createEntityManager();

    }


    //Pozyskiwanie id_zamówienia
    public List<Integer> getId(){
        String hql = "SELECT idZamowienia FROM Zamowienie";
        Query query = entityManager.createQuery(hql);
        List<Integer> r = query.getResultList();
        return r;

    }
    
    // Dodawanie us³ugi do bazy danych
    public Usluga InsertUsl(double cena1, double cena2, double cena3, double suma){
        Usluga usl = new Usluga();
        //Klient ok = new Klient(); 
        usl.setGrafikaKomputerowa(false);
        usl.setStronaInternetowa(false);
        usl.setAplikacjaMobilna(false);
        if (cena1>0){
            usl.setGrafikaKomputerowa(true);
        }
        if (cena2>0){
            usl.setStronaInternetowa(true);
        }
        if (cena3>0){
            usl.setAplikacjaMobilna(true);
        }
        usl.setCena(suma);
        
        entityManager.getTransaction().begin();
        entityManager.persist(usl);
        entityManager.getTransaction().commit();
        return usl;
    }
    
    // Dodawanie klienta do bazy danych
    public Klient InsertOs(String imie, String nazwisko, String eMail, int tel, int a){
        System.out.println(imie +" " + nazwisko + " " + eMail + " " + tel + " " + a);
        Klient ok = new Klient();      
        
        Usluga usluga  = new Usluga(a);
        
        ok.setImie(imie);
        ok.setNazwisko(nazwisko);
        ok.setTelefon(tel);
        ok.setEmail(eMail);
        
        ok.setIdUslugi(usluga);
        
        entityManager.getTransaction().begin();
        entityManager.persist(ok);
        entityManager.getTransaction().commit();
        
        return ok;
    }
    
    // Dodawanie zamówienia do bazy danych
    public List FindUslByCena(double cena){
        String hql = "SELECT idUslugi FROM Usluga WHERE cena = :cena";
        Query query = entityManager.createQuery(hql).setParameter("cena", cena);
        List<Integer> rr = query.getResultList();
        return rr;
    }
    
    // Dodawanie zamówienia
    public void InsertZam(int idKl, int idUsl, int rabat){
        Zamowienie zam = new Zamowienie();
        Klient kl = new Klient(idKl);
        Usluga usl = new Usluga(idUsl);
        zam.setIdKlienta(kl);
        zam.setIdUslugi(usl);
        zam.setRabat(rabat);
        zam.setStanRealizacji("Oczekuje na kontakt");
        
        entityManager.getTransaction().begin();
        entityManager.persist(zam);
        entityManager.getTransaction().commit();
    }
    
    // Edytowanie oraz usuwanie danych
    public void Edit(int id, String stanRealizacji){
        Zamowienie zam = entityManager.find(Zamowienie.class, id);
        entityManager.getTransaction().begin();
        zam.setStanRealizacji(stanRealizacji);
        entityManager.getTransaction().commit();


    }
    
    // Usuwanie zamówienia
    public void Delete(int id){
        
        Zamowienie zam = entityManager.find(Zamowienie.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(zam);
        entityManager.getTransaction().commit();
    }
    
    // Wyœwietlanie tabeli
    public List<Object[]> SelectToTable(){
        String hql = "SELECT z.idZamowienia , u.grafikaKomputerowa, u.aplikacjaMobilna, u.stronaInternetowa, u.cena, k.imie, k.nazwisko, k.telefon, k.email, z.stanRealizacji  FROM Zamowienie z "+
                "INNER JOIN z.idKlienta k "+
                "INNER JOIN z.idUslugi u ";
        Query query = entityManager.createQuery(hql);
        List<Object[]> rr = query.getResultList();
        return rr;
    }
    
    
    

}
