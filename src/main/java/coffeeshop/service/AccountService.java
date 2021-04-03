package coffeeshop.service;

import coffeeshop.entity.Account;
import java.util.List;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AccountService extends UserDetailsService {

    List<Account> getAllAccounts();

    List<Account> getAdmins();

    List<Account> getUsers();

    Account getCurrentlyLoggedInAccount(Authentication authentication);

    Account update(Account account);

    Account getUserByOrder(int accountid);

    Account findByUsername(String username);

    Account saveUser(Account account);

}
