package coffeeshop.service;

import coffeeshop.entity.Account;
import coffeeshop.entity.OrderDetails;
import java.util.List;

public interface CartService {
    
     public List<OrderDetails> listOfItems(Account account);
     
     
}