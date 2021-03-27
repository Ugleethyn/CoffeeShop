package coffeeshop.repository;

import coffeeshop.entity.Account;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Account, Integer> {

    @Query(value = "SELECT a FROM Account a WHERE a.username = :username")
    Account findByUsername(@Param("username") String username);
    
    
//    @Query("SELECT a FROM Account a WHERE a.id IN"
//        + " (SELECT r.account_id FROM account_has_role as r WHERE r.role_id = :roleid)")
//    List<Account> findByRoleId(@Param("roleid") int id);

}
