//package coffeeshop;
//
//import coffeeshop.entity.Account;
//import coffeeshop.entity.OrderDetails;
//import coffeeshop.entity.Product;
//import coffeeshop.repository.OrderDetailsRepo;
//import java.util.List;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.annotation.Rollback;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Rollback(false)
//public class ShoppingCartTests {
//    
//    @Autowired
//    private OrderDetailsRepo orderDetailsRepo;
//    
//    @Autowired
//    private TestEntityManager entityManager;
//    
////___________________κάνω save στη βάση τα παρακάτω_________________________________________
////    @Test
////    public void testAddOneCartItem() {
////        Product product = entityManager.find(Product.class, 9);
////        Account account = entityManager.find(Account.class, 3);
////        
////        OrderDetails newOrderDetails = new OrderDetails();
////        newOrderDetails.setAccount(account);
////        newOrderDetails.setProduct(product);
////        newOrderDetails.setQuantity(2);
////        newOrderDetails.setUnitprice((float) 2.50);
////        
////        OrderDetails savedNewOrderDetails = orderDetailsRepo.save(newOrderDetails);
////        assertTrue(savedNewOrderDetails.getId() > 0);
////    }
//    
//    
////_______εκτιμώ πόσες φορές εμφανίζεται στον πίνακα orderDetails το account_id που έδωσα επάνω_______
//    @Test
//    public void testGetOrderDetails() {
//        Account account = new Account();
//        account.setId(1);
//        
//        List<OrderDetails> orderDetails = orderDetailsRepo.findByAccount(account);
//        assertEquals(0, orderDetails.size());
//    }
//}
