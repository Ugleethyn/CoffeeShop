package coffeeshop.controller;

import coffeeshop.entity.Account;
import coffeeshop.entity.Address;
import coffeeshop.entity.Orders;
import coffeeshop.service.AccountService;
import coffeeshop.service.AddressService;
import coffeeshop.service.OrderService;
import java.util.List;
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
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private OrderService ordersService;

    @GetMapping
    public String userHome() {
        return "user/user-home";
    }

    @RequestMapping("/about")
    public String about() {
        return "user/user-about";
    }

    @RequestMapping("/contact")
    public String contact() {
        return "user/user-contact";
    }

    @RequestMapping("/payment")
    public String payment() {
        return "user/user-payment";
    }

    @GetMapping("/settings")
    public String showSettings() {
        return "user/user-settings";
    }

    @GetMapping("/successfull")
    public String showSuccessfull() {
        return "user/user-ordersuccess";
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

    @PostMapping("/settings/update")
    public String update(@Valid @ModelAttribute("settings") Account accountNew,
            BindingResult result, RedirectAttributes attributes) {
        accountService.update(accountNew);
        String minima = "Your details updated successfully!";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/user/settings";
    }

    @PostMapping("/settings")
    public String addAddress(@Valid @ModelAttribute("newAddress") Address addressNew,
            BindingResult result, RedirectAttributes attributes) {
        addressService.addAddress(addressNew);
        return "redirect:/user/settings";
    }

    @GetMapping("/history")
    public String userOrderHistory() {
        return "user/user-orderhistory";
    }

    @ModelAttribute("orders")
    public List<Orders> showUserHistory() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Account account = accountService.getCurrentlyLoggedInAccount(authentication);
        return ordersService.getOrdersByAccount(account.getId());
    }

}
