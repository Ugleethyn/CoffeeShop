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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "cat_a")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatA.findAll", query = "SELECT c FROM CatA c")
    , @NamedQuery(name = "CatA.findById", query = "SELECT c FROM CatA c WHERE c.id = :id")
    , @NamedQuery(name = "CatA.findByCatAName", query = "SELECT c FROM CatA c WHERE c.catAName = :catAName")})
public class CatA implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "cat_a_name")
    private String catAName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catAId")
    private List<Product> productList;

    public CatA() {
    }

    public CatA(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCatAName() {
        return catAName;
    }

    public void setCatAName(String catAName) {
        this.catAName = catAName;
    }

    @XmlTransient
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
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
        if (!(object instanceof CatA)) {
            return false;
        }
        CatA other = (CatA) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "coffeeshop.entity.CatA[ id=" + id + " ]";
    }
    
}
