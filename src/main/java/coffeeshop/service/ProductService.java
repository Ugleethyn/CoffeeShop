package coffeeshop.service;

import coffeeshop.entity.Product;
import java.util.List;

public interface ProductService {

     List<Product> findAllCoffees();

     List<Product> findAllDrinks();

     List<Product> findAllSnacks();

     Product findById(int id);
    
     Product save(Product product);
}
