package coffeeshop.service;

import coffeeshop.entity.Orders;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.http.HttpSession;

public interface OrderService {

    List<Orders> getAllOrders();

    Orders create(Orders order);

    void setOrder(Orders order, HttpSession session);

    Orders getAddress(int addressid);

    List<Orders> getOrdersByAccount(int accountid);

    BigDecimal getPriceForCheckOut(HttpSession session);

    List<Orders> findByStatus(int status);

    Orders save(Orders order);

    Orders findById(int id);
}
