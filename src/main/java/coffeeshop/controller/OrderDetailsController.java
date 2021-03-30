package coffeeshop.controller;


import coffeeshop.service.AccountService;
import coffeeshop.service.OrderDetailsService;
import coffeeshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Ugleethyn
 */
@Controller
@RequestMapping("/user")
public class OrderDetailsController {

    @Autowired
    private OrderDetailsService orderDetailsService;

    @Autowired
    private AccountService accountService;
    @Autowired
    private OrderService orderService;

//    @GetMapping("/cart")
//    public String showCart(Model model) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        Account account = accountService.getCurrentlyLoggedInAccount(authentication);
//        Orders order = orderService.create(order);
//        List<OrderDetails> cartItems = orderDetailsService.getOrderDetailsByOrder(order);
//        model.addAttribute("cartItems", cartItems);
//        return "user/user-cart";
//    }
    
    
    
    

}
