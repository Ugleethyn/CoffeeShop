package coffeeshop.repository;

import coffeeshop.entity.Account;
import coffeeshop.entity.OrderDetails;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepo extends JpaRepository<OrderDetails, Integer>{
    
    public List<OrderDetails> findByAccount(Account account);

}
