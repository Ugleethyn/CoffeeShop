package coffeeshop.controller;

import coffeeshop.entity.Account;
import coffeeshop.service.AccountService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/register")
    public String register(@ModelAttribute("account") Account account) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "register-form";
        }
        return "redirect:/user";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("account") Account account, BindingResult result) {
        if (result.hasErrors()) {
            return "register-form";
        }
        accountService.saveUser(account);
        return "redirect:/login?register";
    }
}
