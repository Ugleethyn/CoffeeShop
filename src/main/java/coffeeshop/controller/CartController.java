package coffeeshop.controller;

import coffeeshop.entity.Item;
import coffeeshop.service.ProductService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("user/cart")
public class CartController {

    @Autowired
    private ProductService productService;

    
//    >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>..
//    public String cart() {
//        return "user/user-cart";
//    }

//    @RequestMapping(value = "buy/{id}", method = RequestMethod.GET)
//    public String cartBuy(@PathVariable("id") int id, ModelMap modelMap, HttpSession session) {
//        if (session.getAttribute("cart") == null) {
//            List<Item> cart = new ArrayList();
//            cart.add(new Item(productService.findById(id), 1));
//            session.setAttribute("cart", cart);
//        } else {
//            List<Item> cart = (List<Item>) session.getAttribute("cart");
//            int index = isExists(id, cart);
//            if (index == -1) {
//                cart.add(new Item(productService.findById(id), 1));
//            } else {
//                int quantity = cart.get(index).getQuantity() + 1;
//                cart.get(index).setQuantity(quantity);
//            }
//            session.setAttribute("cart", cart);
//        }
//        return "redirect:user/menu";
//    }

//    private int isExists(int id, List<Item> cart) {
//        for (int i = 0; i < cart.size(); i++) {
//            if (cart.get(i).getProduct().getId() == id) {
//                return i;
//            }
//        }
//        return -1;
//    }
    
    
//    >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    
    @GetMapping
    public String showCart(Model model, HttpSession session) {
        model.addAttribute("total", total(session));
        return "user-cart";
    }

    @GetMapping(value = "buy/{id}")
    public String buy(@PathVariable("id") int id, Model model, HttpSession session) {

        if (session.getAttribute("cart") == null) {
            List<Item> items = new ArrayList();
            items.add(new Item(productService.findById(id), 1));
            session.setAttribute("cart", items);
        } else {
            List<Item> items = (List<Item>) session.getAttribute("cart");
            int index = checkIfExists(id, items);
            if (index == -1) {
                items.add(new Item(productService.findById(id), 1));
            } else {
                int quantity = items.get(index).getQuantity() + 1;
                items.get(index).setQuantity(quantity);
            }
        }
        return "redirect:/user-cart";
    }

    @PostMapping(value = "update")
    public String update(HttpServletRequest request, HttpSession session) {

        String[] quantities = request.getParameterValues("quantity");
        List<Item> items = (List<Item>) session.getAttribute("cart");
        for (int i = 0; i < items.size(); i++) {
            items.get(i).setQuantity(Integer.parseInt(quantities[i]));
        }
        session.setAttribute("cart", items);
        return "redirect:/user-cart";
    }

    @GetMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") int id, HttpSession session) {

        List<Item> items = (List<Item>) session.getAttribute("cart");
        int index = checkIfExists(id, items);
        items.remove(index);
        session.setAttribute("cart", items);
        return "redirect:/user-cart";
    }
    
    private int checkIfExists(int id, List<Item> items) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getProduct().getId() == id) {
                return i;
            }
        }
        return -1;
    }
    
    private double total(HttpSession session) {
        List<Item> items = (List<Item>) session.getAttribute("cart");
        double s = 0;
        for (int i = 0; i < items.size(); i++) {
            s = s + (items.get(i).getQuantity() * items.get(i).getProduct().getBaseprice());
        }
        return s;
    }

}
