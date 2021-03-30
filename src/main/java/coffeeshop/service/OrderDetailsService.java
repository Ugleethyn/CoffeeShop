package coffeeshop.service;

import coffeeshop.entity.OrderDetails;
import java.util.List;

public interface OrderDetailsService {

    public List<OrderDetails> getOrderDetailsByOrder(int id);

    public OrderDetails saveOrderDetails(OrderDetails orderDetail);

    public OrderDetails findById(int id);
}
