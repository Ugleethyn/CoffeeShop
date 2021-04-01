/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeeshop.service;

import javax.servlet.http.HttpSession;

/**
 *
 * @author Ugleethyn
 */
public interface CheckoutService {

    public double getPriceForCheckOut(HttpSession session);

}
