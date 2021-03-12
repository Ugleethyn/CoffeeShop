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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gkolo
 */
@Entity
@Table(name = "drink")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Drink.findAll", query = "SELECT d FROM Drink d")
    , @NamedQuery(name = "Drink.findById", query = "SELECT d FROM Drink d WHERE d.id = :id")
    , @NamedQuery(name = "Drink.findByIquant", query = "SELECT d FROM Drink d WHERE d.iquant = :iquant")})
public class Drink implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "iquant")
    private Integer iquant;
    @JoinColumn(name = "drinkstype_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Drinkstype drinkstypeId;
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Orders orderId;

    public Drink() {
    }

    public Drink(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIquant() {
        return iquant;
    }

    public void setIquant(Integer iquant) {
        this.iquant = iquant;
    }

    public Drinkstype getDrinkstypeId() {
        return drinkstypeId;
    }

    public void setDrinkstypeId(Drinkstype drinkstypeId) {
        this.drinkstypeId = drinkstypeId;
    }

    public Orders getOrderId() {
        return orderId;
    }

    public void setOrderId(Orders orderId) {
        this.orderId = orderId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Drink)) {
            return false;
        }
        Drink other = (Drink) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "coffeeshop.entity.Drink[ id=" + id + " ]";
    }
    
}
