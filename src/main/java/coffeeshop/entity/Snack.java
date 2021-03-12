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
@Table(name = "snack")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Snack.findAll", query = "SELECT s FROM Snack s")
    , @NamedQuery(name = "Snack.findById", query = "SELECT s FROM Snack s WHERE s.id = :id")
    , @NamedQuery(name = "Snack.findBySquant", query = "SELECT s FROM Snack s WHERE s.squant = :squant")})
public class Snack implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "squant")
    private Integer squant;
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Orders orderId;
    @JoinColumn(name = "snacktype_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Snacktype snacktypeId;

    public Snack() {
    }

    public Snack(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSquant() {
        return squant;
    }

    public void setSquant(Integer squant) {
        this.squant = squant;
    }

    public Orders getOrderId() {
        return orderId;
    }

    public void setOrderId(Orders orderId) {
        this.orderId = orderId;
    }

    public Snacktype getSnacktypeId() {
        return snacktypeId;
    }

    public void setSnacktypeId(Snacktype snacktypeId) {
        this.snacktypeId = snacktypeId;
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
        if (!(object instanceof Snack)) {
            return false;
        }
        Snack other = (Snack) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "coffeeshop.entity.Snack[ id=" + id + " ]";
    }
    
}
