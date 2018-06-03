package eu.hadesz.test1.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InMemoryPhoneNumberRepositoryTest {

    @Autowired
    private PhoneNumberRepository underTest;

    @Test
    public void save() {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void get() {
    }

    @Test
    public void findByCustomerId() {
    }
}