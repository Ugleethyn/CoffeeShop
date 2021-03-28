package coffeeshop.repository;

import coffeeshop.entity.Account;
import coffeeshop.entity.OrderDetails;
import coffeeshop.entity.Orders;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepo extends JpaRepository<OrderDetails, Integer>{
    
//    public List<OrderDetails> findByOrders(Orders order);
    
//    //find order details by orderId
//    List<OrderDetails> findByOrders_OrderId(int orderId);

}
