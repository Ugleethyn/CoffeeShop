/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeeshop.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ugleethyn
 */
@Entity
@Table(name = "orders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o")
    , @NamedQuery(name = "Orders.findById", query = "SELECT o FROM Orders o WHERE o.id = :id")
    , @NamedQuery(name = "Orders.findByOdate", query = "SELECT o FROM Orders o WHERE o.odate = :odate")
    , @NamedQuery(name = "Orders.findByTotalprice", query = "SELECT o FROM Orders o WHERE o.totalprice = :totalprice")
    , @NamedQuery(name = "Orders.findByStatus", query = "SELECT o FROM Orders o WHERE o.status = :status")})
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "odate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date odate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "totalprice")
    private BigDecimal totalprice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private short status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orders", fetch = FetchType.LAZY)
    private List<OrderHasDrink> orderHasDrinkList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orders", fetch = FetchType.LAZY)
    private List<OrderHasSnack> orderHasSnackList;
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Account accountId;
    @JoinColumn(name = "address_idAddress", referencedColumnName = "idAddress")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Address addressidAddress;
    @JoinColumn(name = "payment_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Payment paymentId;
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Store storeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orders", fetch = FetchType.LAZY)
    private List<OrderHasCoffee> orderHasCoffeeList;

    public Orders() {
    }

    public Orders(Integer id) {
        this.id = id;
    }

    public Orders(Integer id, Date odate, BigDecimal totalprice, short status) {
        this.id = id;
        this.odate = odate;
        this.totalprice = totalprice;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOdate() {
        return odate;
    }

    public void setOdate(Date odate) {
        this.odate = odate;
    }

    public BigDecimal getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    @XmlTransient
    public List<OrderHasDrink> getOrderHasDrinkList() {
        return orderHasDrinkList;
    }

    public void setOrderHasDrinkList(List<OrderHasDrink> orderHasDrinkList) {
        this.orderHasDrinkList = orderHasDrinkList;
    }

    @XmlTransient
    public List<OrderHasSnack> getOrderHasSnackList() {
        return orderHasSnackList;
    }

    public void setOrderHasSnackList(List<OrderHasSnack> orderHasSnackList) {
        this.orderHasSnackList = orderHasSnackList;
    }

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    public Address getAddressidAddress() {
        return addressidAddress;
    }

    public void setAddressidAddress(Address addressidAddress) {
        this.addressidAddress = addressidAddress;
    }

    public Payment getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Payment paymentId) {
        this.paymentId = paymentId;
    }

    public Store getStoreId() {
        return storeId;
    }

    public void setStoreId(Store storeId) {
        this.storeId = storeId;
    }

    @XmlTransient
    public List<OrderHasCoffee> getOrderHasCoffeeList() {
        return orderHasCoffeeList;
    }

    public void setOrderHasCoffeeList(List<OrderHasCoffee> orderHasCoffeeList) {
        this.orderHasCoffeeList = orderHasCoffeeList;
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
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "coffeeshop.entity.Orders[ id=" + id + " ]";
    }
    
}
