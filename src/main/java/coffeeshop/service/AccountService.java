package coffeeshop.service;

import coffeeshop.entity.Account;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AccountService extends UserDetailsService {

    Account findByUsername(String username);

    Account saveUser(Account account);

    List<Account> getAdmins();

    List<Account> getUsers();

}
