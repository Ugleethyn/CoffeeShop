/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeeshop.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ugleethyn
 */
@Entity
@Table(name = "coffee_size")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoffeeSize.findAll", query = "SELECT c FROM CoffeeSize c")
    , @NamedQuery(name = "CoffeeSize.findById", query = "SELECT c FROM CoffeeSize c WHERE c.id = :id")
    , @NamedQuery(name = "CoffeeSize.findBySname", query = "SELECT c FROM CoffeeSize c WHERE c.sname = :sname")})
public class CoffeeSize implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "sname")
    private String sname;
    @Column(name = "sizeprice")
    private int sizeprice;

    public CoffeeSize() {
    }

    public CoffeeSize(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    public int getSizeprice() {
        return sizeprice;
    }

    public void setSizeprice(int sizeprice) {
        this.sizeprice = sizeprice;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoffeeSize)) {
            return false;
        }
        CoffeeSize other = (CoffeeSize) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "coffeeshop.entity.CoffeeSize[ id=" + id + " ]";
    }

}
