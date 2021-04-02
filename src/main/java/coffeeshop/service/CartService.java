package coffeeshop.service;

import coffeeshop.entity.OrderDetails;
import java.util.List;
import javax.servlet.http.HttpSession;

public interface CartService {

    public List<OrderDetails> addToCart(OrderDetails orderDetails, HttpSession session);

    public void removeFromCart(OrderDetails orderDetail, HttpSession session);
}
