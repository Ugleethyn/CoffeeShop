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
 * @author gkolo
 */
@Entity
@Table(name = "drinkstype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Drinkstype.findAll", query = "SELECT d FROM Drinkstype d")
    , @NamedQuery(name = "Drinkstype.findById", query = "SELECT d FROM Drinkstype d WHERE d.id = :id")
    , @NamedQuery(name = "Drinkstype.findByDname", query = "SELECT d FROM Drinkstype d WHERE d.dname = :dname")
    , @NamedQuery(name = "Drinkstype.findByDunitprice", query = "SELECT d FROM Drinkstype d WHERE d.dunitprice = :dunitprice")
    , @NamedQuery(name = "Drinkstype.findByImgsrc", query = "SELECT d FROM Drinkstype d WHERE d.imgsrc = :imgsrc")})
public class Drinkstype implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "dname")
    private String dname;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "dunitprice")
    private BigDecimal dunitprice;
    @Size(max = 45)
    @Column(name = "imgsrc")
    private String imgsrc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "drinkstypeId")
    private List<Drink> drinkList;

    public Drinkstype() {
    }

    public Drinkstype(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public BigDecimal getDunitprice() {
        return dunitprice;
    }

    public void setDunitprice(BigDecimal dunitprice) {
        this.dunitprice = dunitprice;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    @XmlTransient
    public List<Drink> getDrinkList() {
        return drinkList;
    }

    public void setDrinkList(List<Drink> drinkList) {
        this.drinkList = drinkList;
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
        if (!(object instanceof Drinkstype)) {
            return false;
        }
        Drinkstype other = (Drinkstype) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "coffeeshop.entity.Drinkstype[ id=" + id + " ]";
    }
    
}
