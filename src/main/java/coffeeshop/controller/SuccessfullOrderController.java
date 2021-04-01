package coffeeshop.controller;

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
