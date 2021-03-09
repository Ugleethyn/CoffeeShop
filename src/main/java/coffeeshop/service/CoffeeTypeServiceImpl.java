/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeeshop.service;

import coffeeshop.entity.CoffeeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import coffeeshop.repository.CoffeeTypeRepo;
import java.util.List;

/**
 *
 * @author Ugleethyn
 */
@Service
@Transactional
public class CoffeeTypeServiceImpl {

    @Autowired
    private CoffeeTypeRepo coffeeTypeRepo;
    
    public List<CoffeeType> findAll(){
        return coffeeTypeRepo.findAll();
    }

}
