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
public class OrderHasSnackPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "order_id")
    private int orderId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "snack_id")
    private int snackId;

    public OrderHasSnackPK() {
    }

    public OrderHasSnackPK(int orderId, int snackId) {
        this.orderId = orderId;
        this.snackId = snackId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getSnackId() {
        return snackId;
    }

    public void setSnackId(int snackId) {
        this.snackId = snackId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) orderId;
        hash += (int) snackId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderHasSnackPK)) {
            return false;
        }
        OrderHasSnackPK other = (OrderHasSnackPK) object;
        if (this.orderId != other.orderId) {
            return false;
        }
        if (this.snackId != other.snackId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "coffeeshop.entity.OrderHasSnackPK[ orderId=" + orderId + ", snackId=" + snackId + " ]";
    }
    
}
