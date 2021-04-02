package coffeeshop.repository;

import coffeeshop.entity.Category;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {

    @Query("SELECT c FROM Category c WHERE c.catBId.id = :cat_b_id")
    List<Category> findAllByCatBId(@Param("cat_b_id") int id);

}
