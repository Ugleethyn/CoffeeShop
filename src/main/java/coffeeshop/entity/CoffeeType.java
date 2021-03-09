/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeeshop.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ugleethyn
 */
@Entity
@Table(name = "coffee_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoffeeType.findAll", query = "SELECT c FROM CoffeeType c")
    , @NamedQuery(name = "CoffeeType.findById", query = "SELECT c FROM CoffeeType c WHERE c.id = :id")
    , @NamedQuery(name = "CoffeeType.findByTname", query = "SELECT c FROM CoffeeType c WHERE c.tname = :tname")
    , @NamedQuery(name = "CoffeeType.findByCunitprice", query = "SELECT c FROM CoffeeType c WHERE c.cunitprice = :cunitprice")
    , @NamedQuery(name = "CoffeeType.findByImgsrc", query = "SELECT c FROM CoffeeType c WHERE c.imgsrc = :imgsrc")})
public class CoffeeType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tname")
    private String tname;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "cunitprice")
    private BigDecimal cunitprice;
    @Size(max = 45)
    @Column(name = "imgsrc")
    private String imgsrc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeId", fetch = FetchType.LAZY)
    private List<Coffee> coffeeList;

    public CoffeeType() {
    }

    public CoffeeType(Integer id) {
        this.id = id;
    }

    public CoffeeType(Integer id, String tname, BigDecimal cunitprice) {
        this.id = id;
        this.tname = tname;
        this.cunitprice = cunitprice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public BigDecimal getCunitprice() {
        return cunitprice;
    }

    public void setCunitprice(BigDecimal cunitprice) {
        this.cunitprice = cunitprice;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    @XmlTransient
    public List<Coffee> getCoffeeList() {
        return coffeeList;
    }

    public void setCoffeeList(List<Coffee> coffeeList) {
        this.coffeeList = coffeeList;
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
        if (!(object instanceof CoffeeType)) {
            return false;
        }
        CoffeeType other = (CoffeeType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "coffeeshop.entity.CoffeeType[ id=" + id + " ]";
    }
    
}
