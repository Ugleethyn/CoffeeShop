package coffeeshop.service;

import coffeeshop.entity.OrderDetails;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CartServiceImpl implements CartService {

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
            if (orderDetails.get(i).equals(orderDetail)) {
                return i;
            }
        }
        return -1;
    }

    private BigDecimal calculateUnitPrice(OrderDetails orderDetails) {
        BigDecimal itemCost = orderDetails.getProduct().getBaseprice().multiply(new BigDecimal(orderDetails.getQuantity()));
        return itemCost;
    }

    public void removeFromCart(OrderDetails orderDetails, HttpSession session) {
        List<OrderDetails> cart = (List<OrderDetails>) session.getAttribute("cart");
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).equals(orderDetails)) {
                cart.remove(i);
            }
        }
        session.setAttribute("cart", cart);
    }

    public void quantityUp(OrderDetails orderDetails, HttpSession session) {
        List<OrderDetails> cart = (List<OrderDetails>) session.getAttribute("cart");
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).equals(orderDetails)) {
                int quantity = cart.get(i).getQuantity();
                cart.get(i).setQuantity(quantity + 1);
                cart.get(i).setUnitPrice(calculateUnitPrice(cart.get(i)));

            }
        }
        session.setAttribute("cart", cart);
    }

    public void quantityDown(OrderDetails orderDetails, HttpSession session) {
        List<OrderDetails> cart = (List<OrderDetails>) session.getAttribute("cart");
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).equals(orderDetails)) {
                int quantity = cart.get(i).getQuantity();
                if (quantity != 1) {
                    cart.get(i).setQuantity(quantity - 1);
                    cart.get(i).setUnitPrice(calculateUnitPrice(cart.get(i)));
                }
            }
        }
        session.setAttribute("cart", cart);
    }

}
