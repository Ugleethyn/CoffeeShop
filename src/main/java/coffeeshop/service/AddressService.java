package coffeeshop.service;

import coffeeshop.entity.Address;
import java.util.List;

public interface AddressService {

    Address addAddress(Address address);

    List<Address> getAddresses(int accountId);
}
