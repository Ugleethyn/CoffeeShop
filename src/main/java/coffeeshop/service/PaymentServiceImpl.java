package coffeeshop.service;

import coffeeshop.entity.Payment;
import coffeeshop.repository.PaymentRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;

    @Override
    public List<Payment> findAll() {
        return paymentRepo.findAll();
    }

}
