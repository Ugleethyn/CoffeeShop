package coffeeshop.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o")
    , @NamedQuery(name = "Orders.findById", query = "SELECT o FROM Orders o WHERE o.id = :id")
    , @NamedQuery(name = "Orders.findByOdate", query = "SELECT o FROM Orders o WHERE o.odate = :odate")
    , @NamedQuery(name = "Orders.findByOrderprice", query = "SELECT o FROM Orders o WHERE o.orderprice = :orderprice")
    , @NamedQuery(name = "Orders.findByComments", query = "SELECT o FROM Orders o WHERE o.comments = :comments")})
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "odate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date odate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "orderprice")
    private float orderprice;
    @Size(max = 150)
    @Column(name = "comments")
    private String comments;

    @JoinColumn(name = "Order_Details_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private OrderDetails orderDetails;

    @JoinColumn(name = "Account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Account accountid;
    @JoinColumn(name = "Address_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Address addressid;
    @JoinColumn(name = "Payment_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Payment paymentid;
    @JoinColumn(name = "Store_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Store storeid;

    public Orders() {
    }

    public Orders(Integer id) {
        this.id = id;
    }

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
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

    public float getOrderprice() {
        return orderprice;
    }

    public void setOrderprice(float orderprice) {
        this.orderprice = orderprice;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Account getAccountid() {
        return accountid;
    }

    public void setAccountid(Account accountid) {
        this.accountid = accountid;
    }

    public Address getAddressid() {
        return addressid;
    }

    public void setAddressid(Address addressid) {
        this.addressid = addressid;
    }

    public Payment getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(Payment paymentid) {
        this.paymentid = paymentid;
    }

    public Store getStoreid() {
        return storeid;
    }

    public void setStoreid(Store storeid) {
        this.storeid = storeid;
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
