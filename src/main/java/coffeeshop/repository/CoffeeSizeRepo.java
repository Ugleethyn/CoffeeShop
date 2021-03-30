package coffeeshop.repository;

import coffeeshop.entity.CoffeeSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeSizeRepo extends JpaRepository<CoffeeSize, Integer> {


}
