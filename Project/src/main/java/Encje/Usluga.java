/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Encje;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author damia
 */
@Entity
@Table(name = "usluga")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usluga.findAll", query = "SELECT u FROM Usluga u"),
    @NamedQuery(name = "Usluga.findByIdUslugi", query = "SELECT u FROM Usluga u WHERE u.idUslugi = :idUslugi"),
    @NamedQuery(name = "Usluga.findByAplikacjaMobilna", query = "SELECT u FROM Usluga u WHERE u.aplikacjaMobilna = :aplikacjaMobilna"),
    @NamedQuery(name = "Usluga.findByStronaInternetowa", query = "SELECT u FROM Usluga u WHERE u.stronaInternetowa = :stronaInternetowa"),
    @NamedQuery(name = "Usluga.findByGrafikaKomputerowa", query = "SELECT u FROM Usluga u WHERE u.grafikaKomputerowa = :grafikaKomputerowa"),
    @NamedQuery(name = "Usluga.findByCena", query = "SELECT u FROM Usluga u WHERE u.cena = :cena")})
public class Usluga implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_uslugi")
    private Integer idUslugi;
    @Basic(optional = false)
    @Column(name = "aplikacja_mobilna")
    private boolean aplikacjaMobilna;
    @Basic(optional = false)
    @Column(name = "strona_internetowa")
    private boolean stronaInternetowa;
    @Basic(optional = false)
    @Column(name = "grafika_komputerowa")
    private boolean grafikaKomputerowa;
    @Basic(optional = false)
    @Column(name = "cena")
    private double cena;
    @OneToMany(mappedBy = "idUslugi")
    private List<Zamowienie> zamowienieList;
    @OneToMany(mappedBy = "idUslugi")
    private List<Klient> klientList;

    public Usluga() {
    }

    public Usluga(Integer idUslugi) {
        this.idUslugi = idUslugi;
    }

    public Usluga(Integer idUslugi, boolean aplikacjaMobilna, boolean stronaInternetowa, boolean grafikaKomputerowa, double cena) {
        this.idUslugi = idUslugi;
        this.aplikacjaMobilna = aplikacjaMobilna;
        this.stronaInternetowa = stronaInternetowa;
        this.grafikaKomputerowa = grafikaKomputerowa;
        this.cena = cena;
    }

    public Integer getIdUslugi() {
        return idUslugi;
    }

    public void setIdUslugi(Integer idUslugi) {
        this.idUslugi = idUslugi;
    }

    public boolean getAplikacjaMobilna() {
        return aplikacjaMobilna;
    }

    public void setAplikacjaMobilna(boolean aplikacjaMobilna) {
        this.aplikacjaMobilna = aplikacjaMobilna;
    }

    public boolean getStronaInternetowa() {
        return stronaInternetowa;
    }

    public void setStronaInternetowa(boolean stronaInternetowa) {
        this.stronaInternetowa = stronaInternetowa;
    }

    public boolean getGrafikaKomputerowa() {
        return grafikaKomputerowa;
    }

    public void setGrafikaKomputerowa(boolean grafikaKomputerowa) {
        this.grafikaKomputerowa = grafikaKomputerowa;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    @XmlTransient
    public List<Zamowienie> getZamowienieList() {
        return zamowienieList;
    }

    public void setZamowienieList(List<Zamowienie> zamowienieList) {
        this.zamowienieList = zamowienieList;
    }

    @XmlTransient
    public List<Klient> getKlientList() {
        return klientList;
    }

    public void setKlientList(List<Klient> klientList) {
        this.klientList = klientList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUslugi != null ? idUslugi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usluga)) {
            return false;
        }
        Usluga other = (Usluga) object;
        if ((this.idUslugi == null && other.idUslugi != null) || (this.idUslugi != null && !this.idUslugi.equals(other.idUslugi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Encje.Usluga[ idUslugi=" + idUslugi + " ]";
    }
    
}
