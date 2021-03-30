package coffeeshop.service;

import coffeeshop.entity.Orders;
import java.util.List;

/**
 *
 * @author gkolo
 */
public interface OrderService {
    
    List<Orders> getAllOrders();
    
    Orders create(Orders order);
    
    void update(Orders order);
}
