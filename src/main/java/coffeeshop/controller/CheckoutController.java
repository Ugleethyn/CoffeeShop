package coffeeshop.controller;

import coffeeshop.entity.Account;
import coffeeshop.entity.Address;
import coffeeshop.entity.Orders;
import coffeeshop.entity.Payment;
import coffeeshop.service.AccountService;
import coffeeshop.service.AddressService;
import coffeeshop.service.OrderService;
import coffeeshop.service.PaymentService;
import coffeeshop.service.PaypalServiceImpl;
import com.paypal.api.payments.Links;
import com.paypal.base.rest.PayPalRESTException;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user/checkout")
public class CheckoutController {

    @Autowired
    private PaypalServiceImpl payPalService;
    @Autowired
    private AccountService accountService;

    @Autowired
    private AddressService addressService;

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
    public BigDecimal showFinalPrice(HttpSession session) {
        return orderService.getPriceForCheckOut(session);
    }

    @ModelAttribute("payment")
    public List<Payment> showPayments() {
        return paymentService.findAll();
    }

    @PostMapping("/process")
    public String payment(@ModelAttribute("order") Orders order, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return "/user/checkout";
        }
        if ("cash".equalsIgnoreCase(order.getPaymentid().getType())) {
            orderService.setOrder(order, session);
            return "redirect:/user/successfull";
        }
        try {
            com.paypal.api.payments.Payment payment = payPalService.createPayment(orderService.getPriceForCheckOut(session), order.getPayment().getType(), order.getComments());
            for (Links link : payment.getLinks()) {
                if (link.getRel().equals("approval_url")) {
                    orderService.setOrder(order, session);
                    return "redirect:" + link.getHref();
                }
            }

        } catch (PayPalRESTException e) {

            e.printStackTrace();
        }
        return "redirect:/user/successfull";
    }

    @PostMapping("/address")
    public String addAddress(@Valid @ModelAttribute("details") Address address, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            
            List<ObjectError> errors = result.getAllErrors();
            for (ObjectError e : errors) {
                System.out.println(">>>>>>error" + e);
            }
            String message = "*Invalid Address Inputs";
            attr.addFlashAttribute("message", message);
            return "redirect:/user/checkout";
        }
        addressService.addAddress(address);
        String minima = "*Address added successfully";
        attr.addFlashAttribute("message", minima);
            return "redirect:/user/checkout";
    }
    
}
