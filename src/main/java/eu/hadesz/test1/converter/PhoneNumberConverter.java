package eu.hadesz.test1.converter;

import eu.hadesz.test1.dto.PhoneNumberDto;
import eu.hadesz.test1.entity.PhoneNumber;

import java.util.Collection;
import java.util.stream.Collectors;

public class PhoneNumberConverter {

    public static PhoneNumber toEntity(PhoneNumberDto dto) {
        return PhoneNumber.builder()
                .id(dto.getId())
                .phoneNumber(dto.getPhoneNumber())
                .build();
    }

    public static Collection<PhoneNumber> toEntity(Collection<PhoneNumberDto> dtos) {
        return dtos.stream().map(PhoneNumberConverter::toEntity).collect(Collectors.toList());
    }

    public static PhoneNumberDto toDto(PhoneNumber entity) {
        return PhoneNumberDto.builder()
                .id(entity.getId())
                .phoneNumber(entity.getPhoneNumber())
                .build();
    }

    public static Collection<PhoneNumberDto> toDto(Collection<PhoneNumber> entities) {
        return entities.stream().map(PhoneNumberConverter::toDto).collect(Collectors.toList());
    }
}
