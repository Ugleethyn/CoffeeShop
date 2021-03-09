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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ugleethyn
 */
@Entity
@Table(name = "snack")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Snack.findAll", query = "SELECT s FROM Snack s")
    , @NamedQuery(name = "Snack.findById", query = "SELECT s FROM Snack s WHERE s.id = :id")
    , @NamedQuery(name = "Snack.findBySname", query = "SELECT s FROM Snack s WHERE s.sname = :sname")
    , @NamedQuery(name = "Snack.findBySunitprice", query = "SELECT s FROM Snack s WHERE s.sunitprice = :sunitprice")
    , @NamedQuery(name = "Snack.findByImgsrc", query = "SELECT s FROM Snack s WHERE s.imgsrc = :imgsrc")})
public class Snack implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "sname")
    private String sname;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "sunitprice")
    private BigDecimal sunitprice;
    @Size(max = 45)
    @Column(name = "imgsrc")
    private String imgsrc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "snack", fetch = FetchType.LAZY)
    private List<OrderHasSnack> orderHasSnackList;

    public Snack() {
    }

    public Snack(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public BigDecimal getSunitprice() {
        return sunitprice;
    }

    public void setSunitprice(BigDecimal sunitprice) {
        this.sunitprice = sunitprice;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    @XmlTransient
    public List<OrderHasSnack> getOrderHasSnackList() {
        return orderHasSnackList;
    }

    public void setOrderHasSnackList(List<OrderHasSnack> orderHasSnackList) {
        this.orderHasSnackList = orderHasSnackList;
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
        if (!(object instanceof Snack)) {
            return false;
        }
        Snack other = (Snack) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "coffeeshop.entity.Snack[ id=" + id + " ]";
    }
    
}
