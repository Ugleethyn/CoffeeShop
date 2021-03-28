package coffeeshop.controller;

import coffeeshop.entity.Account;
import coffeeshop.entity.Orders;
import coffeeshop.entity.Product;
import coffeeshop.service.AccountService;
import coffeeshop.service.OrderService;
import coffeeshop.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private AccountService accountService;

    @GetMapping
    public String adminHome() {
        return "admin/admin-home";
    }
    
    @GetMapping ("/products")
    public String showProducts(Model model){
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "admin/admin-products";
    }
    
    @GetMapping ("/orders")
    public String showOrders(Model model){
        List<Orders> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "admin/admin-orders";
    }
    
    @GetMapping("/admins")
    public String showAdmins(Model model){
        List<Account> admins = accountService.getAdmins();
        model.addAttribute("admins", admins);
        return "admin/admin-accounts";
    }
    
    @GetMapping("/users")
    public String showUders(Model model){
        List<Account> users = accountService.getUsers();
        model.addAttribute("users", users);
        return "admin/admin-accounts";
    }
    
}
