package coffeeshop.controller;

import coffeeshop.entity.Category;
import coffeeshop.entity.OrderDetails;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user/cart")
public class CartController {

    @GetMapping
    public String showCart() {
        return "user/user-cart";
    }

    @PostMapping("/process")
    public String buy(@ModelAttribute("orderDetails") @Valid OrderDetails orderDetails, Model model, HttpSession session) {
        List<OrderDetails> cart = new ArrayList();
        double unitprice = (orderDetails.getProduct().getBaseprice()) * orderDetails.getQuantity();
        if (orderDetails.getCoffeeSize() != null) {
            double price = (unitprice) + (orderDetails.getCoffeeSize().getSizeprice());
            unitprice = price;
        }
        orderDetails.setUnitPrice(unitprice);

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
                unitprice = cart.get(index).getUnitPrice()+cart.get(index).getProduct().getBaseprice();
                cart.get(index).setUnitPrice(unitprice);
            }
        }
        model.addAttribute("cart", cart);
        return "redirect:/user/menu";
    }

    private int checkIfExists(List<OrderDetails> orderDetails, OrderDetails orderDetail) {
        for (int i = 0; i < orderDetails.size(); i++) {
            if (orderDetails.get(i).getProduct().getId() == orderDetail.getProduct().getId()) {
                return i;
            }
        }
        return -1;
    }

}
