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

    @Query(value = "SELECT * FROM ACCOUNT ac JOIN ACCOUNT_HAS_ROLE ahc ON ac.ID = ahc.account_id AND ahc.role_id = :roleid", nativeQuery = true)
    List<Account> findByRoleId(@Param("roleid") int id);
    
    
    @Query(value = "SELECT *" +
                        " FROM account a" +
                        " JOIN orders o" +
                        " ON a.id = o.Account_id" +
                        " WHERE a.id = :aid", nativeQuery = true)
    Account findByOrder(@Param("aid") int id);
    

}
