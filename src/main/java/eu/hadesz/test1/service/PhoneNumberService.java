package eu.hadesz.test1.service;

import eu.hadesz.test1.converter.PhoneNumberConverter;
import eu.hadesz.test1.dto.PhoneNumberDto;
import eu.hadesz.test1.entity.Customer;
import eu.hadesz.test1.entity.PhoneNumber;
import eu.hadesz.test1.repository.PhoneNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PhoneNumberService {

    private final PhoneNumberRepository phoneNumberRepository;

    @Autowired
    public PhoneNumberService(PhoneNumberRepository phoneNumberRepository) {
        this.phoneNumberRepository = phoneNumberRepository;
    }

    public Collection<PhoneNumberDto> getAll() {
        return PhoneNumberConverter.toDto(phoneNumberRepository.findAll());
    }

    public Collection<PhoneNumberDto> getByCustomerId(Long id) {
        return PhoneNumberConverter.toDto(phoneNumberRepository.findByCustomer(Customer.builder().id(id).build()));
    }

    public boolean activate(Long id) {
        PhoneNumber phoneNumber = phoneNumberRepository.get(id);
        phoneNumber.setActive(true);
        phoneNumberRepository.save(phoneNumber);
        return true;
    }
}
