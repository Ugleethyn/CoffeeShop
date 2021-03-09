/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeeshop.entity;

import java.io.Serializable;
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
@Table(name = "sugar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sugar.findAll", query = "SELECT s FROM Sugar s")
    , @NamedQuery(name = "Sugar.findById", query = "SELECT s FROM Sugar s WHERE s.id = :id")
    , @NamedQuery(name = "Sugar.findBySdescr", query = "SELECT s FROM Sugar s WHERE s.sdescr = :sdescr")})
public class Sugar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "sdescr")
    private String sdescr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sugarId", fetch = FetchType.LAZY)
    private List<Coffee> coffeeList;

    public Sugar() {
    }

    public Sugar(Integer id) {
        this.id = id;
    }

    public Sugar(Integer id, String sdescr) {
        this.id = id;
        this.sdescr = sdescr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSdescr() {
        return sdescr;
    }

    public void setSdescr(String sdescr) {
        this.sdescr = sdescr;
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
        if (!(object instanceof Sugar)) {
            return false;
        }
        Sugar other = (Sugar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "coffeeshop.entity.Sugar[ id=" + id + " ]";
    }
    
}
