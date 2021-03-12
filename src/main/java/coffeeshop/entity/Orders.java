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
 * @author gkolo
 */
@Entity
@Table(name = "order")
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
    @Column(name = "status")
    private Integer status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderId")
    private List<Snack> snackList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderId")
    private List<Drink> drinkList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderId")
    private List<Coffee> coffeeList;
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Account accountId;
    @JoinColumn(name = "address_idAddress", referencedColumnName = "idAddress")
    @ManyToOne(optional = false)
    private Address addressidAddress;
    @JoinColumn(name = "payment_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Payment paymentId;
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Store storeId;

    public Orders() {
    }

    public Orders(Integer id) {
        this.id = id;
    }

    public Orders(Integer id, Date odate, BigDecimal totalprice) {
        this.id = id;
        this.odate = odate;
        this.totalprice = totalprice;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @XmlTransient
    public List<Snack> getSnackList() {
        return snackList;
    }

    public void setSnackList(List<Snack> snackList) {
        this.snackList = snackList;
    }

    @XmlTransient
    public List<Drink> getDrinkList() {
        return drinkList;
    }

    public void setDrinkList(List<Drink> drinkList) {
        this.drinkList = drinkList;
    }

    @XmlTransient
    public List<Coffee> getCoffeeList() {
        return coffeeList;
    }

    public void setCoffeeList(List<Coffee> coffeeList) {
        this.coffeeList = coffeeList;
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
