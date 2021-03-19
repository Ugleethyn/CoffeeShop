package coffeeshop.controller;

import coffeeshop.service.CategoryService;
import coffeeshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping
    public ModelAndView showTrainers(ModelAndView modelAndView) {
        modelAndView.addObject("coffeeTypes", productService.findAllCoffees());
        modelAndView.addObject("snackTypes", productService.findAllSnacks());
        modelAndView.addObject("drinkTypes", productService.findAllDrinks());
        modelAndView.addObject("ingredients", categoryService.findAllIngredients());
        modelAndView.addObject("coffeeSizes", categoryService.findAllSizes());
        modelAndView.addObject("coffeeSugar", categoryService.findAllSugars());
        modelAndView.setViewName("menu");
        return modelAndView;
    }

}
