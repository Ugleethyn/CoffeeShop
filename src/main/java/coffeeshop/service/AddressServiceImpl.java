package coffeeshop.service;

import coffeeshop.entity.Account;
import coffeeshop.entity.Address;
import coffeeshop.repository.AddressRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepo addressRepo;

    @Override
    public List<Address> findAllByAccount(Account account) {
        return addressRepo.findAllByAccount(account);
    }

}
