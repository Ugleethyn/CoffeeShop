package coffeeshop.controller;

import coffeeshop.entity.Account;
import coffeeshop.entity.Address;
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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user/checkout")
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
        return addressService.getAddresses(account.getId());
    }

    @ModelAttribute("finalprice")
    public double showFinalPrice(HttpSession session) {
        return checkoutService.getPriceForCheckOut(session);
    }

    @ModelAttribute("payment")
    public List<Payment> showPayments() {
        return paymentService.findAll();
    }

    @PostMapping("/process")
    public String checkout(@ModelAttribute("order") @Valid Orders order, BindingResult result, RedirectAttributes attributes, HttpSession session) {
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return "/user/checkout";
        }
        orderService.setOrder(order, session);
        attributes.addFlashAttribute("order", order);
        return "redirect:/user/successfull";
    }

    @PostMapping("/address")
    public String addAddress(@Valid @ModelAttribute("details") Address addressNew,
            BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return "user/user-checkout";
        }
        addressService.addAddress(addressNew);
        return "redirect:/user/checkout";
    }

}
