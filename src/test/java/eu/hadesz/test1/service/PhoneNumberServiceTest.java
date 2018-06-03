package eu.hadesz.test1.service;

import eu.hadesz.test1.dto.PhoneNumberDto;
import eu.hadesz.test1.repository.InMemoryPhoneNumberRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PhoneNumberServiceTest {

    @Autowired
    private PhoneNumberService underTest;

    @Autowired
    private InMemoryPhoneNumberRepository inMemoryPhoneNumberRepository;

    @Before
    public void init() {
        inMemoryPhoneNumberRepository.initStartData();
    }

    @Test
    public void getAll() {
        // GIVEN

        // WHEN
        Collection<PhoneNumberDto> result = underTest.getAll();

        // THEN
        Assert.assertNotEquals(null, result);
        Assert.assertEquals(3, result.size());
    }

    @Test
    public void getByCustomerId() {
        // GIVEN

        // WHEN
        Collection<PhoneNumberDto> result = underTest.getByCustomerId(-1L);

        // THEN
        assertNotEquals(null, result);
        assertEquals(2, result.size());
    }

    @Test
    public void activate() {
        // GIVEN
        // WHEN
        boolean activated = underTest.activate(1L);

        // THEN
        assertTrue(activated);
    }
}