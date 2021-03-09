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
@Table(name = "order_has_coffee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderHasCoffee.findAll", query = "SELECT o FROM OrderHasCoffee o")
    , @NamedQuery(name = "OrderHasCoffee.findByOrderId", query = "SELECT o FROM OrderHasCoffee o WHERE o.orderHasCoffeePK.orderId = :orderId")
    , @NamedQuery(name = "OrderHasCoffee.findByCoffeeId", query = "SELECT o FROM OrderHasCoffee o WHERE o.orderHasCoffeePK.coffeeId = :coffeeId")
    , @NamedQuery(name = "OrderHasCoffee.findByQuant", query = "SELECT o FROM OrderHasCoffee o WHERE o.quant = :quant")})
public class OrderHasCoffee implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrderHasCoffeePK orderHasCoffeePK;
    @Column(name = "quant")
    private Integer quant;
    @JoinColumn(name = "coffee_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Coffee coffee;
    @JoinColumn(name = "order_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Orders orders;

    public OrderHasCoffee() {
    }

    public OrderHasCoffee(OrderHasCoffeePK orderHasCoffeePK) {
        this.orderHasCoffeePK = orderHasCoffeePK;
    }

    public OrderHasCoffee(int orderId, int coffeeId) {
        this.orderHasCoffeePK = new OrderHasCoffeePK(orderId, coffeeId);
    }

    public OrderHasCoffeePK getOrderHasCoffeePK() {
        return orderHasCoffeePK;
    }

    public void setOrderHasCoffeePK(OrderHasCoffeePK orderHasCoffeePK) {
        this.orderHasCoffeePK = orderHasCoffeePK;
    }

    public Integer getQuant() {
        return quant;
    }

    public void setQuant(Integer quant) {
        this.quant = quant;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
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
        hash += (orderHasCoffeePK != null ? orderHasCoffeePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderHasCoffee)) {
            return false;
        }
        OrderHasCoffee other = (OrderHasCoffee) object;
        if ((this.orderHasCoffeePK == null && other.orderHasCoffeePK != null) || (this.orderHasCoffeePK != null && !this.orderHasCoffeePK.equals(other.orderHasCoffeePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "coffeeshop.entity.OrderHasCoffee[ orderHasCoffeePK=" + orderHasCoffeePK + " ]";
    }
    
}
