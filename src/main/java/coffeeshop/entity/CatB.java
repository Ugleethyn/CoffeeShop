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
@Table(name = "cat_b")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatB.findAll", query = "SELECT c FROM CatB c")
    , @NamedQuery(name = "CatB.findById", query = "SELECT c FROM CatB c WHERE c.id = :id")
    , @NamedQuery(name = "CatB.findByCatBName", query = "SELECT c FROM CatB c WHERE c.catBName = :catBName")})
public class CatB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "cat_b_name")
    private String catBName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catBId")
    private List<Category> categoryList;

    public CatB() {
    }

    public CatB(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCatBName() {
        return catBName;
    }

    public void setCatBName(String catBName) {
        this.catBName = catBName;
    }

    @XmlTransient
    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
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
        if (!(object instanceof CatB)) {
            return false;
        }
        CatB other = (CatB) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "coffeeshop.entity.CatB[ id=" + id + " ]";
    }
    
}
