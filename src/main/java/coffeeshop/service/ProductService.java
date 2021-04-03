package coffeeshop.service;

import coffeeshop.entity.Product;
import java.util.List;

public interface ProductService {
    
    List<Product> getAllProducts();

    List<Product> findAllCoffees();

    List<Product> findAllDrinks();

    List<Product> findAllSnacks();
    
    List<Product> findAllDisabledProducts();

    Product findById(int id);
    
    Product save(Product product);
     
    Product update(Product product); 
}
