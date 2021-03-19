/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeeshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Ugleethyn
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public String userHome() {
        return "user/user-home";
    }

}
