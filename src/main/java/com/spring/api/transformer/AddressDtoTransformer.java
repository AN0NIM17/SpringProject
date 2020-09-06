package com.spring.api.transformer;

import com.spring.api.dto.AddressDto;
import com.spring.db.entity.address.Address;

public class AddressDtoTransformer {
	public static Address transform(AddressDto addressDto) {
		return Address.builder()
				.town(addressDto.getTown())
				.street(addressDto.getStreet())
				.houseNumber(addressDto.getHouseNumber())
				.build();
	}
}
