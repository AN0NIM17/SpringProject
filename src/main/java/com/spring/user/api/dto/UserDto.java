package com.spring.user.api.dto;

import javax.validation.constraints.Email;

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
	private String firstname;
	private String middlename;
	private String lastname;
	@Email(message = "Enter Valid Email")
	private String email;
}
