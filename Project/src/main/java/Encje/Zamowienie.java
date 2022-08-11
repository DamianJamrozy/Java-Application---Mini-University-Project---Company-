/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Encje;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import static org.hibernate.engine.internal.Cascade.cascade;
import static org.hibernate.engine.internal.Cascade.cascade;

/**
 *
 * @author damia
 */
@Entity
@Table(name = "zamowienie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zamowienie.findAll", query = "SELECT z FROM Zamowienie z"),
    @NamedQuery(name = "Zamowienie.findByIdZamowienia", query = "SELECT z FROM Zamowienie z WHERE z.idZamowienia = :idZamowienia"),
    @NamedQuery(name = "Zamowienie.findByRabat", query = "SELECT z FROM Zamowienie z WHERE z.rabat = :rabat"),
    @NamedQuery(name = "Zamowienie.findByStanRealizacji", query = "SELECT z FROM Zamowienie z WHERE z.stanRealizacji = :stanRealizacji")})
public class Zamowienie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_zamowienia")
    private Integer idZamowienia;
    @Column(name = "rabat")
    private Integer rabat;
    @Column(name = "stan_realizacji")
    private String stanRealizacji;
    @JoinColumn(name = "id_klienta", referencedColumnName = "id_klienta")
    @ManyToOne(cascade = CascadeType.REMOVE)
    private Klient idKlienta;
    @JoinColumn(name = "id_uslugi", referencedColumnName = "id_uslugi")
    @ManyToOne(cascade = CascadeType.REMOVE)
    private Usluga idUslugi;

    public Zamowienie() {
    }

    public Zamowienie(Integer idZamowienia) {
        this.idZamowienia = idZamowienia;
    }

    public Integer getIdZamowienia() {
        return idZamowienia;
    }

    public void setIdZamowienia(Integer idZamowienia) {
        this.idZamowienia = idZamowienia;
    }

    public Integer getRabat() {
        return rabat;
    }

    public void setRabat(Integer rabat) {
        this.rabat = rabat;
    }

    public String getStanRealizacji() {
        return stanRealizacji;
    }

    public void setStanRealizacji(String stanRealizacji) {
        this.stanRealizacji = stanRealizacji;
    }

    public Klient getIdKlienta() {
        return idKlienta;
    }

    public void setIdKlienta(Klient idKlienta) {
        this.idKlienta = idKlienta;
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
        hash += (idZamowienia != null ? idZamowienia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zamowienie)) {
            return false;
        }
        Zamowienie other = (Zamowienie) object;
        if ((this.idZamowienia == null && other.idZamowienia != null) || (this.idZamowienia != null && !this.idZamowienia.equals(other.idZamowienia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Encje.Zamowienie[ idZamowienia=" + idZamowienia + " ]";
    }
    
}
