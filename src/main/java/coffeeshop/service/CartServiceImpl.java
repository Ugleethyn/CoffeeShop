package coffeeshop.service;

import coffeeshop.entity.OrderDetails;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ugleethyn
 */
@Service
@Transactional
public class CartServiceImpl implements CartService{

    public List<OrderDetails> addToCart(OrderDetails orderDetails, HttpSession session) {
        orderDetails.setUnitPrice(calculateUnitPrice(orderDetails));
        List<OrderDetails> cart = new ArrayList();
        if (session.getAttribute("cart") == null) {
            cart.add(orderDetails);
            session.setAttribute("cart", cart);
        } else {
            cart = (List<OrderDetails>) session.getAttribute("cart");
            int index = checkIfExists(cart, orderDetails);
            if (index == -1) {
                cart.add(orderDetails);
            } else {
                int quantity = cart.get(index).getQuantity() + 1;
                cart.get(index).setQuantity(quantity);
                cart.get(index).setUnitPrice(calculateUnitPrice(cart.get(index)));
            }
        }
        return cart;
    }

    private int checkIfExists(List<OrderDetails> orderDetails, OrderDetails orderDetail) {
        for (int i = 0; i < orderDetails.size(); i++) {
            if (orderDetails.get(i) == orderDetail) {
                return i;
            }
        }
        return -1;
    }

    private double calculateUnitPrice(OrderDetails orderDetails) {
        return (orderDetails.getProduct().getBaseprice()) * orderDetails.getQuantity();
    }
}
