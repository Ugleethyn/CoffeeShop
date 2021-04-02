package coffeeshop.service;

import coffeeshop.entity.Account;
import coffeeshop.entity.Address;
import coffeeshop.repository.AccountRepo;
import coffeeshop.repository.AddressRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepo addressRepo;
    
        @Autowired
    private AccountService  accountService;

    @Override
    public List<Address> findAllByAccount(Account account) {
        return addressRepo.findAllByAccount(account);
    }

    @Override
    public Address addAddress(Address address) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Account account = accountService.getCurrentlyLoggedInAccount(authentication);
        
        return addressRepo.save(address);
    }

}
