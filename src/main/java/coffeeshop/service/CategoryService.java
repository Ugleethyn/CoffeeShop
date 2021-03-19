/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeeshop.service;

import coffeeshop.entity.Category;
import java.util.List;

/**
 *
 * @author Ugleethyn
 */
public interface CategoryService {

    public List<Category> findAllIngredients();

    public List<Category> findAllSugars();

    public List<Category> findAllSizes();
}
