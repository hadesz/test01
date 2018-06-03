package eu.hadesz.test1.dto;

import lombok.Builder;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
public class CustomerDto {

    private Long id;

    private String name;

    private Set<PhoneNumberDto> phoneNumbers = new HashSet<>();
}
