package coffeeshop.service;

import coffeeshop.entity.Role;
import coffeeshop.repository.RoleRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{
    
    @Autowired
    private RoleRepo roleRepo;

    @Override
    public List<Role> getAllRoles() {
        return roleRepo.findAll();
    }
    
    
}
