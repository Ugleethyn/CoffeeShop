/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeeshop.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Ugleethyn
 */
@Embeddable
public class OrderHasCoffeePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "order_id")
    private int orderId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "coffee_id")
    private int coffeeId;

    public OrderHasCoffeePK() {
    }

    public OrderHasCoffeePK(int orderId, int coffeeId) {
        this.orderId = orderId;
        this.coffeeId = coffeeId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCoffeeId() {
        return coffeeId;
    }

    public void setCoffeeId(int coffeeId) {
        this.coffeeId = coffeeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) orderId;
        hash += (int) coffeeId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderHasCoffeePK)) {
            return false;
        }
        OrderHasCoffeePK other = (OrderHasCoffeePK) object;
        if (this.orderId != other.orderId) {
            return false;
        }
        if (this.coffeeId != other.coffeeId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "coffeeshop.entity.OrderHasCoffeePK[ orderId=" + orderId + ", coffeeId=" + coffeeId + " ]";
    }
    
}
