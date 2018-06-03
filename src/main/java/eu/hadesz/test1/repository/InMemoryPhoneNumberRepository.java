package eu.hadesz.test1.repository;

import eu.hadesz.test1.entity.Customer;
import eu.hadesz.test1.entity.PhoneNumber;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryPhoneNumberRepository implements PhoneNumberRepository {

    private AtomicLong idCounter = new AtomicLong();

    private Map<Long, PhoneNumber> phoneNumbers = new HashMap<>();

    @Override
    public PhoneNumber save(PhoneNumber phoneNumber) {
        return null;
    }

    @Override
    public Collection<PhoneNumber> findAll() {
        return null;
    }

    @Override
    public PhoneNumber get(Long id) {
        return null;
    }

    @Override
    public Collection<PhoneNumber> findByCustomer(Customer customer) {
        return null;
    }

    public InMemoryPhoneNumberRepository() {
        Customer customer = Customer.builder().id(-1L).build();
        PhoneNumber phoneNumber = createInitialPhoneNumber("123456", customer);
        phoneNumbers.put(phoneNumber.getId(), phoneNumber);
        phoneNumber = createInitialPhoneNumber("654321", customer);
        phoneNumbers.put(phoneNumber.getId(), phoneNumber);

    }

    private PhoneNumber createInitialPhoneNumber(String s, Customer customer) {
        return PhoneNumber.builder().id(idCounter.incrementAndGet()).phoneNumber(s).customer(customer).build();
    }
}
