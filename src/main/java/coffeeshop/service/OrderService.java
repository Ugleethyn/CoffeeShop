package coffeeshop.service;

import coffeeshop.entity.Orders;
import java.util.List;
import javax.servlet.http.HttpSession;

public interface OrderService {

    List<Orders> getAllOrders();

    Orders create(Orders order);

    void update(Orders order);

    public void setOrder(Orders order, HttpSession session);

    Orders getAddress(int addressid);

    List<Orders> getOrdersByAccount(int accountid);
}
