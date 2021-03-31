package coffeeshop.service;

import coffeeshop.entity.Category;
import java.util.List;

public interface CategoryService {

    public List<Category> findAllIngredients();

    public List<Category> findAllSugars();

}
