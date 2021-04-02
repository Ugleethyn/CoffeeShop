package coffeeshop.service;

import coffeeshop.entity.OrderDetails;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CheckoutServiceImpl implements CheckoutService {

    public double getPriceForCheckOut(HttpSession session) {
        List<OrderDetails> cart = (List<OrderDetails>) session.getAttribute("cart");
        double finalprice = 0;
        for (OrderDetails orderDetails : cart) {
            finalprice = finalprice + orderDetails.getUnitPrice();
        }
        return finalprice;
    }

}
