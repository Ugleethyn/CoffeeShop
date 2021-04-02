package coffeeshop.service;

import javax.servlet.http.HttpSession;

public interface CheckoutService {

    public double getPriceForCheckOut(HttpSession session);

}
