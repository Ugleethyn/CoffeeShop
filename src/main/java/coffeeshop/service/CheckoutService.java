package coffeeshop.service;

import javax.servlet.http.HttpSession;

public interface CheckoutService {

    double getPriceForCheckOut(HttpSession session);

}
