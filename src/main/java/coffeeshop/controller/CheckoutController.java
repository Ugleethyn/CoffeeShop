/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeeshop.controller;

import coffeeshop.entity.Account;
import coffeeshop.entity.Address;
import coffeeshop.entity.OrderDetails;
import coffeeshop.entity.Orders;
import coffeeshop.entity.Payment;
import coffeeshop.service.AccountService;
import coffeeshop.service.AddressService;
import coffeeshop.service.CheckoutService;
import coffeeshop.service.OrderService;
import coffeeshop.service.PaymentService;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Ugleethyn
 */
@Controller
@RequestMapping("user/checkout")
public class CheckoutController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private CheckoutService checkoutService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public String showCart() {
        return "user/user-checkout";
    }

    @ModelAttribute("account")
    public Account showAccount() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return accountService.getCurrentlyLoggedInAccount(authentication);
    }

    @ModelAttribute("address")
    public List<Address> showAddresses() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Account account = accountService.getCurrentlyLoggedInAccount(authentication);
        return addressService.findAllByAccount(account);
    }

    @ModelAttribute("finalprice")
    public double showFinalPrice(HttpSession session) {
        return checkoutService.getPriceForCheckOut(session);
    }

    @ModelAttribute("payment")
    public List<Payment> showPayments() {
        return paymentService.findAll();
    }

    @PostMapping()
    public String buy(@ModelAttribute("order") @Valid Orders order, RedirectAttributes attributes, HttpSession session) {
        List<OrderDetails> cart = (List<OrderDetails>) session.getAttribute("cart");
        orderService.setOrder(order, cart, session);
        if(order==null){
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>FALSE");
        }else{
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>TRUE");
        }
        attributes.addFlashAttribute("cart", cart);
        attributes.addFlashAttribute("order", order);
        return "redirect:/user/successfull";
    }
}
