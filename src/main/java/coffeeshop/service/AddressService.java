package coffeeshop.service;

import coffeeshop.entity.Account;
import coffeeshop.entity.Address;
import java.util.List;

public interface AddressService {

    List<Address> findAllByAccount(Account account);

    Address addAddress(Address address);
}
