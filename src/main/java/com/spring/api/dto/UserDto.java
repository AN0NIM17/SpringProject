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
	@NotEmpty(message = "Enter your firstname")
	private String firstname;
	@NotEmpty(message = "Enter your middlename")
	private String middlename;
	@NotNull
	private String lastname;
	@Email(message = "Enter Valid Email")
	@NotNull
	private String email;
}
