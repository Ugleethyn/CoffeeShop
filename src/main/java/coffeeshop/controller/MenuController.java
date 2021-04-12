package coffeeshop.controller;

import coffeeshop.entity.Category;
import coffeeshop.entity.Product;
import coffeeshop.service.CategoryService;
import coffeeshop.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    public String showMenu() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "menu";
        }
        return "redirect:/user/menu";
    }

    @ModelAttribute("coffeeTypes")
    public List<Product> getCoffeeTypes() {
        return productService.findAllCoffees();
    }

    @ModelAttribute("snackTypes")
    public List<Product> getSnackTypes() {
        return productService.findAllSnacks();
    }

    @ModelAttribute("drinkTypes")
    public List<Product> getDrinkTypes() {
        return productService.findAllDrinks();
    }

    @ModelAttribute("ingredients")
    public List<Category> getIngredients() {
        return categoryService.findAllIngredients();
    }

    @ModelAttribute("coffeeSugar")
    public List<Category> getCoffeeSugar() {
        return categoryService.findAllSugars();
    }

}
