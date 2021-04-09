package coffeeshop.entity;

import java.io.Serializable;
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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "address")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a")
    , @NamedQuery(name = "Address.findById", query = "SELECT a FROM Address a WHERE a.id = :id")
    , @NamedQuery(name = "Address.findByStreet", query = "SELECT a FROM Address a WHERE a.street = :street")
    , @NamedQuery(name = "Address.findByNumber", query = "SELECT a FROM Address a WHERE a.number = :number")
    , @NamedQuery(name = "Address.findByCity", query = "SELECT a FROM Address a WHERE a.city = :city")
    , @NamedQuery(name = "Address.findByZipcode", query = "SELECT a FROM Address a WHERE a.zipcode = :zipcode")
    , @NamedQuery(name = "Address.findByFloor", query = "SELECT a FROM Address a WHERE a.floor = :floor")
    , @NamedQuery(name = "Address.findByDoorbell", query = "SELECT a FROM Address a WHERE a.doorbell = :doorbell")})
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @NotEmpty(message="Must not be empty")
    @NotNull
    @Size(min=3, max = 45)
    @Column(name = "street")
    private String street;
    @NotEmpty(message="Must not be empty")
    @NotNull
    @Pattern(regexp="^[0-9]{1,4}", message = "Invalid Number")
    @Column(name = "number")
    private String number;
    @NotEmpty(message="Must not be empty")
    @NotNull
    @Size(min = 3,max = 45)
    @Column(name = "city")
    private String city;
    @Pattern(regexp="^[0-9]{5}", message = "Invalid Zip Code")
    @NotEmpty(message="Must not be empty")
    @NotNull
    @Column(name = "zipcode")
    private String zipcode;
    @Size(max = 15)
    @Column(name = "floor")
    private String floor;
    @Size(max = 30)
    @Column(name = "doorbell")
    private String doorbell;
    @JoinColumn(name = "Account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Account accountid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addressid")
    private List<Orders> orders;

    public Address() {
    }

    public Address(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getDoorbell() {
        return doorbell;
    }

    public void setDoorbell(String doorbell) {
        this.doorbell = doorbell;
    }

    public Account getAccountid() {
        return accountid;
    }

    public void setAccountid(Account accountid) {
        this.accountid = accountid;
    }

    @XmlTransient
    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
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
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "coffeeshop.entity.Address[ id=" + id + " ]";
    }
    
}
