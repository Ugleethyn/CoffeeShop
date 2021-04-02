package coffeeshop.controller;

import coffeeshop.entity.Account;
import coffeeshop.entity.Address;
import coffeeshop.service.AccountService;
import coffeeshop.service.AddressService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user/settings")
public class UserSettingsController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public String showSettings() {
        return "user/user-settings";
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

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("settings") Account accountNew,
            BindingResult result, RedirectAttributes attributes) {
        accountService.update(accountNew);
        String minima = "Your details updated successfully!";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/user/settings";
    }

    @PostMapping
    public String addAddress(@Valid @ModelAttribute("newAddress") Address addressNew,
            BindingResult result, RedirectAttributes attributes) {
        addressService.addAddress(addressNew);
        return "redirect:/user/settings";
    }

}
