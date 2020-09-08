package com.spring.api.transformer;

import com.spring.api.dto.UserDto;
import com.spring.db.entity.user.User;

public class UserDtoTransformer {
	public static User transform(UserDto userDto) {
		return User.builder()
				.firstname(userDto.getFirstname())
				.middlename(userDto.getMiddlename())
				.lastname(userDto.getLastname())
				.email(userDto.getEmail())
				.build();
	}
	
	public static UserDto transform(User user) {
        return UserDto.builder()
                .firstname(user.getFirstname())
                .middlename(user.getMiddlename())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .build();
    }
}
