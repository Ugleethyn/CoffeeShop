
package coffeeshop.service;

import coffeeshop.entity.Address;
import java.util.List;


public interface AddressService {
    
    List<Address> getAddresses(int accountId);
    
}
