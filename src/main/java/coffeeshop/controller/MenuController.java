/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeeshop.controller;

import coffeeshop.service.CoffeeSizeService;
import coffeeshop.service.CoffeeSugarService;
import coffeeshop.service.CoffeeTypeService;
import coffeeshop.service.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Ugleethyn
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private CoffeeTypeService coffeeTypeService;
    @Autowired
    private CoffeeSizeService coffeeSizeService;
    @Autowired
    private CoffeeSugarService coffeeSugarService;
    @Autowired
    private IngredientsService ingredientsService;

    @RequestMapping
    public ModelAndView showTrainers(ModelAndView modelAndView) {
        modelAndView.addObject("coffeeTypes", coffeeTypeService.findAll());
        modelAndView.addObject("coffeeSizes", coffeeSizeService.findAll());
        modelAndView.addObject("coffeeSugar", coffeeSugarService.findAll());
        modelAndView.addObject("Ingredients", ingredientsService.findAll());
        modelAndView.setViewName("menu");
        return modelAndView;
    }

}
