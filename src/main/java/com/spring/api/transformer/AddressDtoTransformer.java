package com.spring.api.transformer;

import com.spring.api.dto.AddressDto;
import com.spring.db.entity.address.Address;

public class AddressDtoTransformer {
    public static Address transform(AddressDto addressDto) {
        return Address.builder()
                .id(addressDto.getId())
                .city(addressDto.getCity())
                .address(addressDto.getAddress())
                .build();
    }

    public static Address transform(AddressDto addressDto, Long id) {
        return Address.builder()
                .id(id)
                .city(addressDto.getCity())
                .address(addressDto.getAddress())
                .build();
    }

    public static AddressDto transform(Address address) {
        return AddressDto.builder()
                .id(address.getId())
                .city(address.getCity())
                .address(address.getAddress())
                .build();
    }
}
