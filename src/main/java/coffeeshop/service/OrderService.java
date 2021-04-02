package coffeeshop.service;

import coffeeshop.entity.OrderDetails;
import coffeeshop.entity.Orders;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gkolo
 */
public interface OrderService {

    List<Orders> getAllOrders();

    Orders create(Orders order);

    void update(Orders order);

    public void setOrder(Orders order, List<OrderDetails> orderDetails, HttpSession session);
}
