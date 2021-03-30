package coffeeshop.service;

import coffeeshop.entity.Account;
import coffeeshop.entity.OrderDetails;
import coffeeshop.entity.Orders;
import java.util.List;

public interface OrderDetailsService {
    
     List<OrderDetails> getOrderDetailsByOrder(int id);
     
     
   
     
     
}