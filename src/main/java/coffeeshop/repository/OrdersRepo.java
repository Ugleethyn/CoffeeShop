/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeeshop.repository;

import coffeeshop.entity.OrderDetails;
import coffeeshop.entity.Orders;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface OrdersRepo  extends JpaRepository<Orders, Integer>{
    

    
//    Orders save(Orders order);
    
//    // get orders by accountId
//    List<Orders> findOrderByAccount_AccountId(int accountId);
    
}
