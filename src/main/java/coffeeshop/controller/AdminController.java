package coffeeshop.controller;

import coffeeshop.entity.Account;
import coffeeshop.entity.OrderDetails;
import coffeeshop.entity.Orders;
import coffeeshop.entity.Product;
import coffeeshop.service.AccountService;
import coffeeshop.service.OrderDetailsService;
import coffeeshop.service.OrderService;
import coffeeshop.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @Autowired
    private OrderDetailsService orderDetailsservice;

    @GetMapping
    public String adminHome() {
        return "admin/admin-home";
    }
    
//    @GetMapping ("/products")
//    public String showProducts(Model model){
//        List<Product> products = productService.getAllProducts();
//        model.addAttribute("products", products);
//        return "admin/admin-products";
//    }
    
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
        return "admin/admin-admins";
    }
    
    @GetMapping("/users")
    public String showUsers(Model model){
        List<Account> users = accountService.getUsers();
        model.addAttribute("users", users);
        return "admin/admin-users";
    }
    
    @GetMapping("/coffees")
    public String showCoffees(Model model){
        List<Product> coffees = productService.findAllCoffees();
        model.addAttribute("coffees", coffees);
        return "admin/admin-coffees";
    }
    
    @GetMapping("/drinks")
    public String showDrinks(Model model){
        List<Product> drinks = productService.findAllDrinks();
        model.addAttribute("drinks", drinks);
        return "admin/admin-drinks";
    }
    
    @GetMapping("/snacks")
    public String showSnacks(Model model){
        List<Product> snacks = productService.findAllSnacks();
        model.addAttribute("snacks", snacks);
        return "admin/admin-snacks";
    }
    
    
    @GetMapping("/orderdetails/{id}")
    public String showOrderDetails(@PathVariable(name = "id") int id, Model model){
        List<OrderDetails> orderDetails = orderDetailsservice.getOrderDetailsByOrder(id);
        model.addAttribute("orderDetails", orderDetails);
        return ("admin/admin-orderdetails");
    }
    
}
