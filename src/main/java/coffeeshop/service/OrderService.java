package coffeeshop.service;

import coffeeshop.entity.Orders;
import java.util.List;
import javax.servlet.http.HttpSession;

public interface OrderService {

    List<Orders> getAllOrders();

    Orders create(Orders order);

    Orders getAddress(int addressid);

    void setOrder(Orders order, HttpSession session);

    Orders getAddress(int addressid);

    List<Orders> getOrdersByAccount(int accountid);
}
