package coffeeshop.service;

import coffeeshop.entity.Account;
import coffeeshop.entity.OrderDetails;
import coffeeshop.repository.OrderDetailsRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CartServiceImpl implements CartService{
    
    @Autowired
    private OrderDetailsRepo orderDetailsRepo;

    public List<OrderDetails> listOfItems(Account account) {
        return orderDetailsRepo.findByAccount(account);
    }

}