package coffeeshop.controller;

import coffeeshop.entity.Account;
import coffeeshop.entity.Product;
import coffeeshop.service.AccountService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/settings")
public class UserSettingsController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public String showSettings(Model model) {
        
        return "user/user-settings";
    }

}
