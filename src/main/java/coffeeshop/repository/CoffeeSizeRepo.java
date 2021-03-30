package coffeeshop.repository;

import coffeeshop.entity.CoffeeSize;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeSizeRepo extends JpaRepository<CoffeeSize, Integer> {


}
