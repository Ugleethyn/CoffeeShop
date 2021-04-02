package coffeeshop.service;

import coffeeshop.entity.Account;
import coffeeshop.entity.Address;
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
    private AccountService accountService;

    @Override
    public Address addAddress(Address address) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Account account = accountService.getCurrentlyLoggedInAccount(authentication);
        address.setAccountid(account);
        return addressRepo.save(address);
    }

    @Override
    public List<Address> getAddresses(int accountId) {
        return addressRepo.findByAccount(accountId);
    }

}
