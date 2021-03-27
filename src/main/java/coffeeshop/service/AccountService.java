package coffeeshop.service;

import coffeeshop.entity.Account;
import java.util.List;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AccountService extends UserDetailsService {
    
    public List<Account> getAllAccounts();

    public Account findByUsername(String username);

    public Account saveUser(Account account);

    public Account getCurrentlyLoggedInAccount(Authentication authentication);
}
