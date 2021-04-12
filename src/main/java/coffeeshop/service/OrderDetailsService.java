package coffeeshop.service;

import coffeeshop.entity.OrderDetails;
import java.util.List;

public interface OrderDetailsService {

    List<OrderDetails> getOrderDetailsByOrder(int id);

    OrderDetails saveOrderDetails(OrderDetails orderDetail);

    OrderDetails findById(int id);
}
