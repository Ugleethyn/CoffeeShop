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
    List<Product> findAllByCatAId(@Param("cat_a_id") int id);
    
    //find the products by categories name
    List<Product> findByCategory_Cname(String categoryName);
    
    Product save(Product product);
    
    //find products by order details
    List<Product> findByOrderDetails_Orders_Account_AccountId(int accountId);
    
    //find the products by orderId --testing
    List<Product> findByOrderDetails_Orders_OrderId(int orderId);
}
