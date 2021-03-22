package coffeeshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

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

    @RequestMapping("/cart")
    public String cart() {
        return "user/user-cart";
    }

    @RequestMapping("/checkout")
    public String checkout() {
        return "user/user-checkout";
    }

    @RequestMapping("/payment")
    public String payment() {
        return "user/user-payment";
    }
}