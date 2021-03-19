/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeeshop.service;

import coffeeshop.entity.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author Ugleethyn
 */
public interface AccountService extends UserDetailsService {

    public Account findByUsername(String username);

    public Account saveUser(Account account);
}
