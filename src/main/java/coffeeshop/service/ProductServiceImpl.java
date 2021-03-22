package coffeeshop.service;

import coffeeshop.entity.Product;
import coffeeshop.repository.ProductsRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductsRepo productRepo;

    public List<Product> findAllCoffees() {
        return productRepo.findAllByCatAId(1);
    }

    public List<Product> findAllSnacks() {
        return productRepo.findAllByCatAId(2);
    }

    public List<Product> findAllDrinks() {
        return productRepo.findAllByCatAId(3);
    }

}