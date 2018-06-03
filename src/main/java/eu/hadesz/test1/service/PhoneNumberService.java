package eu.hadesz.test1.service;

import eu.hadesz.test1.dto.PhoneNumberDto;
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
        return null;
    }

    public Collection<PhoneNumberDto> getByCustomerId(Long id) {
        return null;
    }

    public boolean activate(Long id) {
        return false;
    }
}
