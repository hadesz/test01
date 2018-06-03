package eu.hadesz.test1;

import eu.hadesz.test1.dto.PhoneNumberDto;
import eu.hadesz.test1.service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/phoneNumber")
public class PhoneResource {

    private final PhoneNumberService phoneNumberService;

    @Autowired
    public PhoneResource(PhoneNumberService phoneNumberService) {
        this.phoneNumberService = phoneNumberService;
    }

    /**
     * Get all {@link eu.hadesz.test1.entity.PhoneNumber}
     *
     * @return collection of {@link PhoneNumberDto}
     */
    @GetMapping("/")
    public Collection<PhoneNumberDto> getAll() {
        return phoneNumberService.getAll();
    }

    /**
     * Get all {@link eu.hadesz.test1.entity.PhoneNumber} for the given {@link eu.hadesz.test1.entity.Customer}
     *
     * @param customerId id of customer
     * @return collection of {@link PhoneNumberDto}
     */
    @GetMapping("/customer/{customerId}")
    public Collection<PhoneNumberDto> getForCustomer(@PathVariable("customerId") Long customerId) {
        return phoneNumberService.getByCustomerId(customerId);
    }

    /**
     * Sets the 'active' flag for the {@link eu.hadesz.test1.entity.PhoneNumber}
     *
     * @param id id of the phone number
     * @return true if succeed, false otherwise
     */
    @PutMapping("/activate/{id}")
    public boolean activate(@PathVariable("id") long id) {
        return phoneNumberService.activate(id);
    }
}
