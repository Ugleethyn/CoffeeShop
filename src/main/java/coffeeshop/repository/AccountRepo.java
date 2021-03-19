/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeeshop.repository;

import coffeeshop.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ugleethyn
 */
@Repository
public interface AccountRepo extends JpaRepository<Account, Integer> {

    @Query(value = "SELECT a FROM Account a WHERE a.username = :username")
    public Account findByUsername(@Param("username") String username);

}
