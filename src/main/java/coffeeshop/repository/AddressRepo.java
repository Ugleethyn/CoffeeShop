
package coffeeshop.repository;

import coffeeshop.entity.Address;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository

public interface AddressRepo extends JpaRepository<Address, Integer>{
    
    
    @Query(value = "SELECT a FROM Address a JOIN FETCH a.accountid ac WHERE ac.id = :accountid")
    List<Address> findByAccount(@Param("accountid")int accountId);
   

}
