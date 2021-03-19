/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeeshop.service;

import coffeeshop.entity.Category;
import coffeeshop.repository.CategoryRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ugleethyn
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public List<Category> findAllIngredients() {
        return categoryRepo.findAllByCatBId(2);
    }

    @Override
    public List<Category> findAllSugars() {
        return categoryRepo.findAllByCatBId(3);
    }

    @Override
    public List<Category> findAllSizes() {
        return categoryRepo.findAllByCatBId(1);
    }

}
