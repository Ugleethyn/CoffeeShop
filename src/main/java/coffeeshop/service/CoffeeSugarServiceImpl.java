/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeeshop.service;

import coffeeshop.entity.Sugar;
import coffeeshop.repository.CoffeeSugarRepo;
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
public class CoffeeSugarServiceImpl implements CoffeeSugarService {

    @Autowired
    private CoffeeSugarRepo coffeeSugarRepo;

    public List<Sugar> findAll() {
        return coffeeSugarRepo.findAll();
    }

}
