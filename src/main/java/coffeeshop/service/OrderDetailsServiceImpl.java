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
    public List<OrderDetails> getOrderDetailsByOrder(Orders order) {
        return orderDetailsRepo.findByOrders_OrderId(order.getId());
    }

    

}
