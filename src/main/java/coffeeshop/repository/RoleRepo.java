package coffeeshop.repository;

import coffeeshop.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {

    @Query("SELECT r FROM Role r WHERE r.rname = :rname")
    public Role findByRname(@Param("rname") String rname);

}
