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
@Table(name = "order_has_drink")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderHasDrink.findAll", query = "SELECT o FROM OrderHasDrink o")
    , @NamedQuery(name = "OrderHasDrink.findByOrderId", query = "SELECT o FROM OrderHasDrink o WHERE o.orderHasDrinkPK.orderId = :orderId")
    , @NamedQuery(name = "OrderHasDrink.findByDrinkId", query = "SELECT o FROM OrderHasDrink o WHERE o.orderHasDrinkPK.drinkId = :drinkId")
    , @NamedQuery(name = "OrderHasDrink.findByQuant", query = "SELECT o FROM OrderHasDrink o WHERE o.quant = :quant")})
public class OrderHasDrink implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrderHasDrinkPK orderHasDrinkPK;
    @Column(name = "quant")
    private Integer quant;
    @JoinColumn(name = "drink_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Drink drink;
    @JoinColumn(name = "order_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Orders orders;

    public OrderHasDrink() {
    }

    public OrderHasDrink(OrderHasDrinkPK orderHasDrinkPK) {
        this.orderHasDrinkPK = orderHasDrinkPK;
    }

    public OrderHasDrink(int orderId, int drinkId) {
        this.orderHasDrinkPK = new OrderHasDrinkPK(orderId, drinkId);
    }

    public OrderHasDrinkPK getOrderHasDrinkPK() {
        return orderHasDrinkPK;
    }

    public void setOrderHasDrinkPK(OrderHasDrinkPK orderHasDrinkPK) {
        this.orderHasDrinkPK = orderHasDrinkPK;
    }

    public Integer getQuant() {
        return quant;
    }

    public void setQuant(Integer quant) {
        this.quant = quant;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderHasDrinkPK != null ? orderHasDrinkPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderHasDrink)) {
            return false;
        }
        OrderHasDrink other = (OrderHasDrink) object;
        if ((this.orderHasDrinkPK == null && other.orderHasDrinkPK != null) || (this.orderHasDrinkPK != null && !this.orderHasDrinkPK.equals(other.orderHasDrinkPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "coffeeshop.entity.OrderHasDrink[ orderHasDrinkPK=" + orderHasDrinkPK + " ]";
    }
    
}
