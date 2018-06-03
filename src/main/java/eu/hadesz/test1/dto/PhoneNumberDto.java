package eu.hadesz.test1.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PhoneNumberDto {
    private Long id;

    private CustomerDto customer;

    private boolean active;

    private String phoneNumber;
}
