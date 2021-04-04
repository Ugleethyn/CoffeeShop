package coffeeshop.service;

import coffeeshop.entity.Account;
import coffeeshop.entity.OrderDetails;
import coffeeshop.entity.Orders;
import coffeeshop.repository.OrderDetailsRepo;
import coffeeshop.repository.OrdersRepo;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrdersRepo ordersRepo;
    @Autowired
    private AccountService accountService;
    @Autowired
    private OrderDetailsRepo orderDetailsRepo;

    public List<Orders> getAllOrders() {
        List<Orders> orders = ordersRepo.findAll();
        return orders;
    }

    @Override
    public Orders create(Orders order) {
        order.setDateCreated(LocalDateTime.now());
        return this.ordersRepo.save(order);
    }

    public void setOrder(Orders order, HttpSession session) {
        List<OrderDetails> cart = (List<OrderDetails>) session.getAttribute("cart");
        //Set account to order
        order = setAccountToOrder(order);
        //Set date of the order
        LocalDateTime lt = LocalDateTime.now();
        order.setDateCreated(lt);
        //Set final price to Order
        BigDecimal finalprice = getPriceForCheckOut(session);
        order.setPrice(finalprice);
        //Save Order to Currently order details and save OrderDetails
        setOrderToOrderDetails(order, cart);
        ordersRepo.save(order);
        //clear cart
        cart.clear();
        session.setAttribute("cart", cart);
    }
    
    public List<Orders> findByStatus(int status){
        return ordersRepo.findAllByStatus(status);
    }

    public BigDecimal getPriceForCheckOut(HttpSession session) {
        List<OrderDetails> cart = (List<OrderDetails>) session.getAttribute("cart");
        BigDecimal finalprice = BigDecimal.ZERO;
        for (OrderDetails orderDetails : cart) {
            finalprice = finalprice.add(orderDetails.getUnitPrice());
        }
        return finalprice;
    }

    private Orders setAccountToOrder(Orders order) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Account account = accountService.getCurrentlyLoggedInAccount(authentication);
        order.setAccountid(account);
        return order;
    }

    private void setOrderToOrderDetails(Orders order, List<OrderDetails> cart) {
        for (OrderDetails orderDetail : cart) {
            orderDetail.setOrder(order);
            orderDetailsRepo.save(orderDetail);
        }
    }

    @Override
    public Orders getAddress(int addressid) {
        return ordersRepo.findByAddressId(addressid);
    }

    @Override
    public List<Orders> getOrdersByAccount(int accountid) {
        return ordersRepo.findByAccountId(accountid);
    }
    
    public Orders save (Orders order){
        return ordersRepo.save(order);
    }
    
    public Orders findById(int id){
        return ordersRepo.findById(id).get();
    }

}
