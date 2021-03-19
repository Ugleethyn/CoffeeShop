package coffeeshop.repository;

import coffeeshop.entity.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepo extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE p.catAId.id = :cat_a_id")
    public List<Product> findAllByCatAId(@Param("cat_a_id") int id);
}
