package eu.hadesz.test1.repository;

import eu.hadesz.test1.entity.Customer;
import eu.hadesz.test1.entity.PhoneNumber;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InMemoryPhoneNumberRepositoryTest {

    @Autowired
    private PhoneNumberRepository underTest;

    @Autowired
    private InMemoryPhoneNumberRepository inMemoryPhoneNumberRepository;

    @Before
    public void init() {
        inMemoryPhoneNumberRepository.initStartData();
    }

    @Test
    public void save() {
        // GIVEN
        PhoneNumber number = PhoneNumber.builder().phoneNumber("3456789").build();

        // WHEN
        PhoneNumber result = underTest.save(number);
        // THEN

        assertNotEquals(null, result);
        assertNotEquals(null, result.getId());

    }

    @Test
    public void findAll() {
        // GIVEN

        // WHEN
        Collection<PhoneNumber> result = underTest.findAll();
        // THEN

        assertNotEquals(null, result);
        assertEquals(3, result.size());
    }

    @Test
    public void get() {
        // GIVEN

        // WHEN
        PhoneNumber result = underTest.get(1L);
        // THEN

        assertNotEquals(null, result);
        assertEquals(1L, (long) result.getId());
    }

    @Test
    public void findByCustomerId() {
        // GIVEN
        Customer customer = Customer.builder().id(-1L).build();

        // WHEN
        Collection<PhoneNumber> result = underTest.findByCustomer(customer);
        // THEN

        assertNotEquals(null, result);
        assertEquals(2, result.size());
    }
}