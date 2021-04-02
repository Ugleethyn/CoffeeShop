package coffeeshop.repository;

import coffeeshop.entity.Account;
import coffeeshop.entity.OrderDetails;
import coffeeshop.entity.Orders;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepo extends JpaRepository<OrderDetails, Integer> {

//    public List<OrderDetails> findByOrders(Orders order);
//    //find order details by orderId
//    List<OrderDetails> findByOrders_OrderId(int orderId);
    @Query(value = "SELECT *"
            + " FROM order_details od"
            + " JOIN product p"
            + " ON od.product_id = p.id"
            + " LEFT OUTER JOIN details_categories odc"
            + " ON od.id = odc.order_details_id"
            + " LEFT OUTER JOIN category cat"
            + " ON odc.category_id = cat.id"
            + " WHERE od.order_id = :orderid", nativeQuery = true)
    List<OrderDetails> findByFk(@Param("orderid") int orderid);

    OrderDetails findById(int id);

    @Query(value = "INSERT INTO details_categories (order_details_id, category_id) VALUES (:orderDetails, :category);", nativeQuery = true)
    void saveOrderDetailsCategory(@Param("orderDetails") int orderDetailsId, @Param("category") int categoryId);

}
