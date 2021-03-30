package coffeeshop.service;

import coffeeshop.entity.Account;
import coffeeshop.entity.OrderDetails;
import coffeeshop.entity.Orders;
import coffeeshop.repository.OrderDetailsRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderDetailsServiceImpl implements OrderDetailsService {
    
    @Autowired
    private OrderDetailsRepo orderDetailsRepo;
    
    @Override
    public List<OrderDetails> getOrderDetailsByOrder(int id) {
        return orderDetailsRepo.findByFk(id);
    }
    
    public OrderDetails saveOrderDetails(OrderDetails orderDetail) {
        return orderDetailsRepo.save(orderDetail);
    }

    public OrderDetails findById(int id) {
        return orderDetailsRepo.findById(id);
    }
    
}
