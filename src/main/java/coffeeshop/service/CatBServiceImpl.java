package coffeeshop.service;

import coffeeshop.entity.CatB;
import coffeeshop.repository.CatBRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CatBServiceImpl implements CatBService {

    @Autowired
    private CatBRepo catBRepo;

    @Override
    public List<CatB> getAllCatB() {
        return catBRepo.findAll();
    }

}
