package com.spring.api.transformer;

import com.spring.api.dto.UserDto;
import com.spring.db.entity.user.User;

public class UserDtoTransformer {
    public static User transform(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .firstName(userDto.getFirstName())
                .middleName(userDto.getMiddleName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .build();
    }

    public static User transform(UserDto userDto, Long id) {
        return User.builder()
                .id(id)
                .firstName(userDto.getFirstName())
                .middleName(userDto.getMiddleName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .build();
    }

    public static UserDto transform(User user) {
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .middleName(user.getMiddleName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();
    }
}
