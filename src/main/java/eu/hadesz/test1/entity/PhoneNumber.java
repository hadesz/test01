package eu.hadesz.test1.entity;


import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(exclude = {"active", "phoneNumber"})
public class PhoneNumber {
    private Long id;

    private Customer customer;

    private boolean active;

    private String phoneNumber;
}
