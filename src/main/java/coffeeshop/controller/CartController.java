/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeeshop.controller;

import coffeeshop.entity.Item;
import coffeeshop.service.ProductService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Ugleethyn
 */
@Controller
@RequestMapping("user/cart")
public class CartController {

    @Autowired
    private ProductService productService;

    public String cart() {
        return "user/user-cart";
    }

    @RequestMapping(value = "buy/{id}", method = RequestMethod.GET)
    public String cartBuy(@PathVariable("id") int id, ModelMap modelMap, HttpSession session) {
        if (session.getAttribute("cart") == null) {
            List<Item> cart = new ArrayList();
            cart.add(new Item(productService.findById(id), 1));
            session.setAttribute("cart", cart);
        } else {
            List<Item> cart = (List<Item>) session.getAttribute("cart");
            int index = isExists(id, cart);
            if (index == -1) {
                cart.add(new Item(productService.findById(id), 1));
            } else {
                int quantity = cart.get(index).getQuantity() + 1;
                cart.get(index).setQuantity(quantity);
            }
            session.setAttribute("cart", cart);
        }
        return "redirect:user/menu";
    }

    private int isExists(int id, List<Item> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProduct().getId() == id) {
                return i;
            }
        }
        return -1;
    }

}
