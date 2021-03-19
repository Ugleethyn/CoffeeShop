package coffeeshop.service;

import coffeeshop.entity.Account;
import coffeeshop.entity.Role;
import coffeeshop.repository.AccountRepo;
import coffeeshop.repository.RoleRepo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepo accountRepo;
    @Autowired
    RoleRepo roleRepo;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Account findByUsername(String username) {
        return accountRepo.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Account account = findByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException("Invalid Username");
        } else {
            List<GrantedAuthority> authorities = convertRolesToGrantedAuthorities(account.getRoles());
            User userOfSpringSecurity = new User(account.getUsername(), account.getPassword(), authorities);
            return userOfSpringSecurity;
        }
    }

    private List<GrantedAuthority> convertRolesToGrantedAuthorities(List<Role> roles) {
        List<GrantedAuthority> authorities = new ArrayList();
        for (Role r : roles) {
            GrantedAuthority authority = new SimpleGrantedAuthority(r.getRname());
            authorities.add(authority);
        }
        return authorities;
    }

    @Override
    public Account saveUser(Account account) {
        String plainPassword = account.getPassword();
        String hashedPassword = passwordEncoder.encode(plainPassword);
        account.setPassword(hashedPassword);
        Role role = roleRepo.findByRname("ROLE_USER");
        account.addRole(role);
        account = accountRepo.save(account);
        return account;
    }

}
