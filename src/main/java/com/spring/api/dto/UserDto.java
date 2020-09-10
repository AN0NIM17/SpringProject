package com.spring.api.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
	private Long id;
	@NotEmpty
	private String firstName;
	@NotEmpty
	private String middleName;
	@NotNull
	private String lastName;
	@Email
	@NotNull
	private String email;
}
