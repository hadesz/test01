package eu.hadesz.test1.entity;

import lombok.Builder;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
public class Customer {

    private Long id;

    private String name;

    private Set<PhoneNumber> phoneNumbers = new HashSet<>();
}
