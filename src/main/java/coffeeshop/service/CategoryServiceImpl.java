package coffeeshop.service;

import coffeeshop.entity.Category;
import coffeeshop.repository.CategoryRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public List<Category> findAllIngredients() {
        return categoryRepo.findAllByCatBId(1);
    }

    @Override
    public List<Category> findAllSugars() {
        return categoryRepo.findAllByCatBId(2);
    }

    @Override
    public Category findById(int id) {
        return categoryRepo.findById(id).get();
    }

}
