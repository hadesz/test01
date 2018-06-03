package eu.hadesz.test1.repository;

import eu.hadesz.test1.entity.Customer;
import eu.hadesz.test1.entity.PhoneNumber;

import java.util.Collection;

public interface PhoneNumberRepository {
    PhoneNumber save(PhoneNumber phoneNumber);

    Collection<PhoneNumber> findAll();

    PhoneNumber get(Long id);

    Collection<PhoneNumber> findByCustomer(Customer customer);
}
