package coffeeshop.repository;

import coffeeshop.entity.Orders;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepo extends JpaRepository<Orders, Integer> {

    @Query(value = "SELECT DISTINCT a.*, o.*"
            + " FROM address a"
            + " JOIN orders o"
            + " ON a.id = o.Address_id"
            + " WHERE o.Address_id = :addressid", nativeQuery = true)
    Orders findByAddressId(@Param("addressid") int addressid);

    @Query(value = "SELECT *"
            + " FROM orders o"
            + " JOIN account a"
            + " ON o.Account_id = a.id"
            + " WHERE o.Account_id= :accountid"
            + " ORDER BY o.odate DESC;", nativeQuery = true)
    List<Orders> findByAccountId(@Param("accountid") int accountid);

    @Query("SELECT o FROM Orders o WHERE o.status = :status")
    List<Orders> findAllByStatus(@Param("status") int status);

}
