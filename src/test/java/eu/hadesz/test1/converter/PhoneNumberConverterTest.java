package eu.hadesz.test1.converter;

import eu.hadesz.test1.dto.CustomerDto;
import eu.hadesz.test1.dto.PhoneNumberDto;
import eu.hadesz.test1.entity.Customer;
import eu.hadesz.test1.entity.PhoneNumber;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class PhoneNumberConverterTest {

    @Test
    public void toEntity() {
        // GIVEN
        PhoneNumberDto dto = PhoneNumberDto.builder().id(1L).phoneNumber("123456").active(false).customer(CustomerDto.builder().build()).build();
        // WHEN
        PhoneNumber result = PhoneNumberConverter.toEntity(dto);
        // THEN

        assertNotEquals(null, result);
    }

    @Test
    public void toDto() {
        // GIVEN
        PhoneNumber entity = PhoneNumber.builder().id(1L).phoneNumber("123456").active(false).customer(Customer.builder().build()).build();
        // WHEN
        PhoneNumberDto result = PhoneNumberConverter.toDto(entity);
        // THEN

        assertNotEquals(null, result);
    }
}