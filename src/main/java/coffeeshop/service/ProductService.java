package coffeeshop.service;

import coffeeshop.entity.Product;
import java.util.List;

public interface ProductService {

    public List<Product> findAllCoffees();

    public List<Product> findAllDrinks();

    public List<Product> findAllSnacks();
}
