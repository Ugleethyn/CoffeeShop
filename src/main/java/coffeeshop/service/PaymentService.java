package coffeeshop.service;

import coffeeshop.entity.Payment;
import java.util.List;

public interface PaymentService {

    List<Payment> findAll();

}
