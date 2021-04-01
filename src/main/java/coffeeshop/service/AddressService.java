package coffeeshop.service;

import coffeeshop.entity.Account;
import coffeeshop.entity.Address;
import java.util.List;

public interface AddressService {

    public List<Address> findAllByAccount(Account account);

}
