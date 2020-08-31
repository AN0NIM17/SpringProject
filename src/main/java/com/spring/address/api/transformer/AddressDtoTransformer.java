package com.spring.address.api.transformer;

import com.spring.address.api.dto.AddressDto;
import com.spring.address.db.models.Address;

public class AddressDtoTransformer {
	public static Address transform(AddressDto addressDto) {
		return Address.builder()
				.town(addressDto.getTown())
				.street(addressDto.getStreet())
				.houseNumber(addressDto.getHouseNumber())
				.build();
	}
}
