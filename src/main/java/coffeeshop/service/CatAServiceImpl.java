package coffeeshop.service;

import coffeeshop.entity.CatA;
import coffeeshop.repository.CatARepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CatAServiceImpl implements CatAService{
    
    @Autowired
    private CatARepo catARepo;

    @Override
    public List<CatA> getAllCatA() {
        return catARepo.findAll();
    }
    
}
