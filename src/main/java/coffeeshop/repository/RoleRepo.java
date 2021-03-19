/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeeshop.repository;

import coffeeshop.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ugleethyn
 */
@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {

    @Query("SELECT r FROM Role r WHERE r.rname = :rname")
    public Role findByRname(@Param("rname") String rname);

}
