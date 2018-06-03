package eu.hadesz.test1.repository;

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

    public PhoneNumber save(PhoneNumber phoneNumber) {
        return null;
    }

    public Collection<PhoneNumber> findAll() {
        return null;
    }

    public Collection<PhoneNumber> get(Long id) {
        return null;
    }

    public Collection<PhoneNumber> findByCustomerId(Long id) {
        return null;
    }

    public InMemoryPhoneNumberRepository() {
        PhoneNumber phoneNumber = createInitialPhoneNumber("123456");
        phoneNumbers.put(phoneNumber.getId(), phoneNumber);
        phoneNumber = createInitialPhoneNumber("654321");
        phoneNumbers.put(phoneNumber.getId(), phoneNumber);

    }

    private PhoneNumber createInitialPhoneNumber(String s) {
        return PhoneNumber.builder().id(idCounter.incrementAndGet()).phoneNumber(s).build();
    }
}
