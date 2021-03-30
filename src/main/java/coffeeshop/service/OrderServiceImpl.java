package coffeeshop.service;

import coffeeshop.entity.Orders;
import coffeeshop.repository.OrdersRepo;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author gkolo
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService{
    
    @Autowired
    OrdersRepo ordersRepo;

   
    public List<Orders> getAllOrders() {
        List<Orders> orders = ordersRepo.findAll();
        return orders;
    }

    @Override
    public Orders create(Orders order) {
        order.setDateCreated(LocalDateTime.now());
        return this.ordersRepo.save(order);
    }

    @Override
    public void update(Orders order) {
        this.ordersRepo.save(order);
    }
    
    
    
}
