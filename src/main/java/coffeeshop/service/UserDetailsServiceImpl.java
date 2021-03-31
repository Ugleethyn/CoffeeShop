/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeeshop.service;

import coffeeshop.entity.Account;
import coffeeshop.entity.MyUserDetails;
import coffeeshop.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author Ugleethyn
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AccountRepo accountRepo;
    

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account= accountRepo.findByUsername(username);
        if(account==null){
            throw new UsernameNotFoundException("Could not find user");
        }
        return new MyUserDetails(account);
    }

}
