package eu.hadesz.test1.repository;

import eu.hadesz.test1.entity.Customer;
import eu.hadesz.test1.entity.PhoneNumber;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class InMemoryPhoneNumberRepository implements PhoneNumberRepository {

    private AtomicLong idCounter = new AtomicLong();

    private Map<Long, PhoneNumber> phoneNumbers;

    @Override
    public PhoneNumber save(PhoneNumber phoneNumber) {
        if (phoneNumber.getId() == null) {
            phoneNumber.setId(idCounter.incrementAndGet());
        }
        phoneNumbers.put(phoneNumber.getId(), phoneNumber);
        return phoneNumber;
    }

    @Override
    public Collection<PhoneNumber> findAll() {
        return phoneNumbers.values();
    }

    @Override
    public PhoneNumber get(Long id) {
        return phoneNumbers.get(id);
    }

    @Override
    public Collection<PhoneNumber> findByCustomer(Customer customer) {
        return phoneNumbers.values().parallelStream().filter(phoneNumber -> Objects.equals(phoneNumber.getCustomer(), customer)).collect(Collectors.toList());
    }

    public InMemoryPhoneNumberRepository() {
        initStartData();

    }

    public void initStartData() {
        phoneNumbers = new ConcurrentHashMap<>();
        idCounter.set(0);
        Customer customer = Customer.builder().id(-1L).build();
        PhoneNumber phoneNumber = createInitialPhoneNumber("123456", customer);
        phoneNumbers.put(phoneNumber.getId(), phoneNumber);
        phoneNumber = createInitialPhoneNumber("654321", customer);
        phoneNumbers.put(phoneNumber.getId(), phoneNumber);
        customer = Customer.builder().id(-2L).build();
        phoneNumber = createInitialPhoneNumber("912834", customer);
        phoneNumbers.put(phoneNumber.getId(), phoneNumber);
    }

    private PhoneNumber createInitialPhoneNumber(String s, Customer customer) {
        return PhoneNumber.builder().id(idCounter.incrementAndGet()).phoneNumber(s).customer(customer).build();
    }
}
