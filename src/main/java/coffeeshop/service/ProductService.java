/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeeshop.service;

import coffeeshop.entity.Product;
import java.util.List;

/**
 *
 * @author Ugleethyn
 */
public interface ProductService {

    public List<Product> findAllCoffees();

    public List<Product> findAllDrinks();

    public List<Product> findAllSnacks();
}
