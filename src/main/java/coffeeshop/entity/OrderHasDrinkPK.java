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
public class OrderHasDrinkPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "order_id")
    private int orderId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "drink_id")
    private int drinkId;

    public OrderHasDrinkPK() {
    }

    public OrderHasDrinkPK(int orderId, int drinkId) {
        this.orderId = orderId;
        this.drinkId = drinkId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getDrinkId() {
        return drinkId;
    }

    public void setDrinkId(int drinkId) {
        this.drinkId = drinkId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) orderId;
        hash += (int) drinkId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderHasDrinkPK)) {
            return false;
        }
        OrderHasDrinkPK other = (OrderHasDrinkPK) object;
        if (this.orderId != other.orderId) {
            return false;
        }
        if (this.drinkId != other.drinkId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "coffeeshop.entity.OrderHasDrinkPK[ orderId=" + orderId + ", drinkId=" + drinkId + " ]";
    }
    
}
