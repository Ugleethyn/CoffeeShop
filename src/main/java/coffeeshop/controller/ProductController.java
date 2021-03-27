/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeeshop.controller;

import coffeeshop.entity.Product;
import coffeeshop.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author gkolo
 */
@Controller
public class ProductController {
    
    @Autowired
    ProductService productService;
    
    
    @ModelAttribute("products")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }
    
    @GetMapping ("/viewProducts")
    public String showProducts(){
        return "admin/admin-products";
    }
    
//    @RequestMapping(value = "/create", method = RequestMethod.POST)
//    public String create(Product product, RedirectAttributes attributes){
//        productService.addProduct(product);
//        String minima = "Product " + product.getPdescr() + " successfully created";
//        attributes.addFlashAttribute("message", minima);
//        return "redirect:/product";
//    }
//    
//    @GetMapping(value = "/delete")
//    public String delete(@RequestParam(value = "id") int id, RedirectAttributes attributes){
//        productService.deleteProduct(id);
//        String minima = "Product succesfully deleted";
//        attributes.addFlashAttribute("message", minima);
//        return "redirect:/product";
//    }
//    
//    @GetMapping("/update/{pcode}")
//    public String showFormUpdate(@PathVariable(name = "pcode") int pcode, Model model){
//        Product product = productService.getProductById(pcode);
//        model.addAttribute("productToEdit", product);
//        return "productForm";
//    }
//    
//    @PostMapping("/update")
//    public String update(Product product, RedirectAttributes attributes){
//        productService.updateProduct(product);
//        String minima = "Product updated succesfully";
//        attributes.addFlashAttribute("message", minima);
//        return "redirect:/product";
//    }
    
}
