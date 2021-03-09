/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeeshop.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ugleethyn
 */
@Entity
@Table(name = "order_has_snack")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderHasSnack.findAll", query = "SELECT o FROM OrderHasSnack o")
    , @NamedQuery(name = "OrderHasSnack.findByOrderId", query = "SELECT o FROM OrderHasSnack o WHERE o.orderHasSnackPK.orderId = :orderId")
    , @NamedQuery(name = "OrderHasSnack.findBySnackId", query = "SELECT o FROM OrderHasSnack o WHERE o.orderHasSnackPK.snackId = :snackId")
    , @NamedQuery(name = "OrderHasSnack.findByQuant", query = "SELECT o FROM OrderHasSnack o WHERE o.quant = :quant")})
public class OrderHasSnack implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrderHasSnackPK orderHasSnackPK;
    @Column(name = "quant")
    private Integer quant;
    @JoinColumn(name = "order_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Orders orders;
    @JoinColumn(name = "snack_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Snack snack;

    public OrderHasSnack() {
    }

    public OrderHasSnack(OrderHasSnackPK orderHasSnackPK) {
        this.orderHasSnackPK = orderHasSnackPK;
    }

    public OrderHasSnack(int orderId, int snackId) {
        this.orderHasSnackPK = new OrderHasSnackPK(orderId, snackId);
    }

    public OrderHasSnackPK getOrderHasSnackPK() {
        return orderHasSnackPK;
    }

    public void setOrderHasSnackPK(OrderHasSnackPK orderHasSnackPK) {
        this.orderHasSnackPK = orderHasSnackPK;
    }

    public Integer getQuant() {
        return quant;
    }

    public void setQuant(Integer quant) {
        this.quant = quant;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Snack getSnack() {
        return snack;
    }

    public void setSnack(Snack snack) {
        this.snack = snack;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderHasSnackPK != null ? orderHasSnackPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderHasSnack)) {
            return false;
        }
        OrderHasSnack other = (OrderHasSnack) object;
        if ((this.orderHasSnackPK == null && other.orderHasSnackPK != null) || (this.orderHasSnackPK != null && !this.orderHasSnackPK.equals(other.orderHasSnackPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "coffeeshop.entity.OrderHasSnack[ orderHasSnackPK=" + orderHasSnackPK + " ]";
    }
    
}
