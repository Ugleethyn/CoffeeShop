package coffeeshop.service;

import coffeeshop.entity.OrderDetails;
import java.util.List;
import javax.servlet.http.HttpSession;

public interface CartService {

    List<OrderDetails> addToCart(OrderDetails orderDetails, HttpSession session);

    void removeFromCart(OrderDetails orderDetails, HttpSession session);

    void quantityDown(OrderDetails orderDetails, HttpSession session);

    void quantityUp(OrderDetails orderDetails, HttpSession session);
}
