package coffeeshop.service;

import coffeeshop.entity.Store;
import coffeeshop.repository.StoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StoreServiceImpl implements StoreService{

    @Autowired
    private StoreRepo storrRepo;
    
    @Override
    public Store getStore() {
        return storrRepo.findById(1).get();
    }
    
}
