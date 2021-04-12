package coffeeshop.repository;

import coffeeshop.entity.CatA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatARepo extends JpaRepository<CatA, Integer>{
    
}
