/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeeshop.service;

import coffeeshop.entity.Orders;
import java.util.List;

/**
 *
 * @author gkolo
 */
public interface OrderService {
    
    List<Orders> getAllOrders();
    
    Orders create(Orders order);
    
    void update(Orders order);
    
    Orders getAddress(int addressid);
}
