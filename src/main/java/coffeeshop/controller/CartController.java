package coffeeshop.controller;

import coffeeshop.entity.OrderDetails;
import coffeeshop.entity.Orders;
import coffeeshop.service.CartService;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("user/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping
    public String showCart() {
        return "user/user-cart";
    }

    @PostMapping("/process")
    public String buy(@ModelAttribute("orderDetails") @Valid OrderDetails orderDetails, Model model, HttpSession session) {
        List<OrderDetails> cart = cartService.addToCart(orderDetails, session);
        model.addAttribute("cart", cart);
        return "redirect:/user/menu";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("orderDetails") @Valid OrderDetails orderDetails, Model model, HttpSession session) {
        cartService.removeFromCart(orderDetails, session);
        return "redirect:/user/cart";
    }

}
