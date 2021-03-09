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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ugleethyn
 */
@Entity
@Table(name = "coffee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Coffee.findAll", query = "SELECT c FROM Coffee c")
    , @NamedQuery(name = "Coffee.findById", query = "SELECT c FROM Coffee c WHERE c.id = :id")})
public class Coffee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @JoinTable(name = "coffee_has_ingredients", joinColumns = {
        @JoinColumn(name = "Coffee_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "Ingredients_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Ingredients> ingredientsList;
    @JoinColumn(name = "size_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CoffeeSize sizeId;
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CoffeeType typeId;
    @JoinColumn(name = "sugar_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Sugar sugarId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coffee")
    private List<OrderHasCoffee> orderHasCoffeeList;

    public Coffee() {
    }

    public Coffee(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public List<Ingredients> getIngredientsList() {
        return ingredientsList;
    }

    public void setIngredientsList(List<Ingredients> ingredientsList) {
        this.ingredientsList = ingredientsList;
    }

    public CoffeeSize getSizeId() {
        return sizeId;
    }

    public void setSizeId(CoffeeSize sizeId) {
        this.sizeId = sizeId;
    }

    public CoffeeType getTypeId() {
        return typeId;
    }

    public void setTypeId(CoffeeType typeId) {
        this.typeId = typeId;
    }

    public Sugar getSugarId() {
        return sugarId;
    }

    public void setSugarId(Sugar sugarId) {
        this.sugarId = sugarId;
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
        if (!(object instanceof Coffee)) {
            return false;
        }
        Coffee other = (Coffee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "coffeeshop.entity.Coffee[ id=" + id + " ]";
    }
    
}
