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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "klient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Klient.findAll", query = "SELECT k FROM Klient k"),
    @NamedQuery(name = "Klient.findByIdKlienta", query = "SELECT k FROM Klient k WHERE k.idKlienta = :idKlienta"),
    @NamedQuery(name = "Klient.findByImie", query = "SELECT k FROM Klient k WHERE k.imie = :imie"),
    @NamedQuery(name = "Klient.findByNazwisko", query = "SELECT k FROM Klient k WHERE k.nazwisko = :nazwisko"),
    @NamedQuery(name = "Klient.findByTelefon", query = "SELECT k FROM Klient k WHERE k.telefon = :telefon"),
    @NamedQuery(name = "Klient.findByEmail", query = "SELECT k FROM Klient k WHERE k.email = :email")})
public class Klient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_klienta")
    private Integer idKlienta;
    @Basic(optional = false)
    @Column(name = "imie")
    private String imie;
    @Basic(optional = false)
    @Column(name = "nazwisko")
    private String nazwisko;
    @Basic(optional = false)
    @Column(name = "telefon")
    private int telefon;
    @Column(name = "email")
    private String email;
    @OneToMany(mappedBy = "idKlienta")
    private List<Zamowienie> zamowienieList;
    @JoinColumn(name = "id_uslugi", referencedColumnName = "id_uslugi")
    @ManyToOne
    private Usluga idUslugi;

    public Klient() {
    }

    public Klient(Integer idKlienta) {
        this.idKlienta = idKlienta;
    }

    public Klient(Integer idKlienta, String imie, String nazwisko, int telefon) {
        this.idKlienta = idKlienta;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.telefon = telefon;
    }

    public Integer getIdKlienta() {
        return idKlienta;
    }

    public void setIdKlienta(Integer idKlienta) {
        this.idKlienta = idKlienta;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public List<Zamowienie> getZamowienieList() {
        return zamowienieList;
    }

    public void setZamowienieList(List<Zamowienie> zamowienieList) {
        this.zamowienieList = zamowienieList;
    }

    public Usluga getIdUslugi() {
        return idUslugi;
    }

    public void setIdUslugi(Usluga idUslugi) {
        this.idUslugi = idUslugi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKlienta != null ? idKlienta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Klient)) {
            return false;
        }
        Klient other = (Klient) object;
        if ((this.idKlienta == null && other.idKlienta != null) || (this.idKlienta != null && !this.idKlienta.equals(other.idKlienta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Encje.Klient[ idKlienta=" + idKlienta + " ]";
    }
    
}
