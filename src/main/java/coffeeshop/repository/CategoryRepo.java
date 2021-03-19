/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeeshop.repository;

import coffeeshop.entity.Category;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ugleethyn
 */
@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {

    @Query("SELECT c FROM Category c WHERE c.catBId.id = :cat_b_id")
    public List<Category> findAllByCatBId(@Param("cat_b_id") int id);

}
