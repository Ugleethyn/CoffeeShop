package coffeeshop.repository;

import coffeeshop.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrdersRepo  extends JpaRepository<Orders, Integer>{
    

    
//    Orders save(Orders order);
    
//    // get orders by accountId
//    List<Orders> findOrderByAccount_AccountId(int accountId);
    
}
