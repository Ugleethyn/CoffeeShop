/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeeshop.service;

import coffeeshop.entity.CoffeeSize;
import coffeeshop.repository.CoffeeSizeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 *
 * @author Ugleethyn
 */
@Service
@Transactional
public class CoffeeSizeServiceImpl implements CoffeeSizeService{

    @Autowired
    private CoffeeSizeRepo coffeeSizeRepo;
    
    public List<CoffeeSize> findAll(){
        return coffeeSizeRepo.findAll();
    }

}
