package coffeeshop.service;

import coffeeshop.entity.Account;
import coffeeshop.entity.Role;
import coffeeshop.repository.AccountRepo;
import coffeeshop.repository.RoleRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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
    
    
    public List<Account> getAllAccounts(){
        return accountRepo.findAll();
    }

    @Override
    public Account findByUsername(String username) {
        return accountRepo.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Account account = findByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException("Invalid Username");
        }
        return new MyUserDetails(account);
    }

//    private List<GrantedAuthority> convertRolesToGrantedAuthorities(List<Role> roles) {
//        List<GrantedAuthority> authorities = new ArrayList();
//        for (Role r : roles) {
//            GrantedAuthority authority = new SimpleGrantedAuthority(r.getRname());
//            authorities.add(authority);
//        }
//        return authorities;
//    }
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

    public Account getCurrentlyLoggedInAccount(Authentication authentication) {
        if (authentication == null) {
            return null;
        }
        Account account = null;
        account = ((MyUserDetails) authentication.getPrincipal()).getAccount();
        return account;
    }


    public List<Account> getAdmins() {
        return accountRepo.findByRoleId(1);
    }
    
    public List<Account> getUsers() {
        return accountRepo.findByRoleId(2);
    }

}
