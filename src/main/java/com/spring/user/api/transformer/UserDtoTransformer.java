package com.spring.user.api.transformer;

import com.spring.user.api.dto.UserDto;
import com.spring.user.db.models.User;

public class UserDtoTransformer {

	public static User transform(UserDto userDto) {
		return User.builder()
				.firstname(userDto.getFirstname())
				.middlename(userDto.getMiddlename())
				.lastname(userDto.getLastname())
				.build();
	}
}
