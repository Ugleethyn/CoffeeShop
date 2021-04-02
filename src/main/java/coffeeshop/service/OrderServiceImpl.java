package coffeeshop.service;

import coffeeshop.entity.Account;
import coffeeshop.entity.OrderDetails;
import coffeeshop.entity.Orders;
import coffeeshop.repository.OrderDetailsRepo;
import coffeeshop.repository.OrdersRepo;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author gkolo
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrdersRepo ordersRepo;

    @Autowired
    private OrderDetailsRepo orderDetailsRepo;

    @Autowired
    private AccountService accountService;

    @Autowired
    private CheckoutService checkoutService;

    public List<Orders> getAllOrders() {
        List<Orders> orders = ordersRepo.findAll();
        return orders;
    }

    @Override
    public Orders create(Orders order) {
        order.setDateCreated(LocalDateTime.now());
        return this.ordersRepo.save(order);
    }

    @Override
    public void update(Orders order) {
        this.ordersRepo.save(order);
    }

    public void setOrder(Orders order, List<OrderDetails> orderDetails, HttpSession session) {
        //Set account to order
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Account account = accountService.getCurrentlyLoggedInAccount(authentication);
        order.setAccountid(account);
        //Set date of the order
        LocalDateTime lt = LocalDateTime.now();
        order.setDateCreated(lt);
        //Save Order to Currently order details
        for (OrderDetails orderDetail : orderDetails) {
            orderDetail.setOrder(order);
            orderDetailsRepo.save(orderDetail);
        }
        //Set final price to Order
        double finalprice = checkoutService.getPriceForCheckOut(session);
        order.setPrice(finalprice);
        ordersRepo.save(order);
    }
}
