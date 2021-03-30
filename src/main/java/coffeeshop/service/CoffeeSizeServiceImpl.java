package coffeeshop.service;

import coffeeshop.entity.CoffeeSize;
import coffeeshop.repository.CoffeeSizeRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CoffeeSizeServiceImpl implements CoffeeSizeService {

    @Autowired
    private CoffeeSizeRepo coffeeSizeRepo;

    @Override
    public List<CoffeeSize> findAll() {
        return coffeeSizeRepo.findAll();
    }

}
