/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeeshop.controller;

import coffeeshop.entity.Account;
import coffeeshop.entity.OrderDetails;
import coffeeshop.entity.Orders;
import coffeeshop.service.AccountService;
import coffeeshop.service.OrderDetailsService;
import coffeeshop.service.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
