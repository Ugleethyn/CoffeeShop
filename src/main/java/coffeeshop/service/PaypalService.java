package coffeeshop.service;

import java.math.BigDecimal;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

public interface PaypalService {

    Payment createPayment(BigDecimal total, String method, String description)
            throws PayPalRESTException;

    Payment executePayment(String paymentId, String payerId) throws PayPalRESTException;

}
