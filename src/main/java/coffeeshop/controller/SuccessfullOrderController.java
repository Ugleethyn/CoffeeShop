package coffeeshop.controller;

import coffeeshop.entity.OrderDetails;
import coffeeshop.service.CartService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Ugleethyn
 */
@Controller
@RequestMapping("user/successfull")
public class SuccessfullOrderController {

    @GetMapping
    public String showSuccessfull() {
        return "user/user-ordersuccess";
    }

}
