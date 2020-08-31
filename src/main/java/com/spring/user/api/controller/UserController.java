package com.spring.user.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.user.api.dto.UserDto;
import com.spring.user.api.transformer.UserDtoTransformer;
import com.spring.user.db.models.User;
import com.spring.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/{id}")
	public User get(@PathVariable Long id) {
			return userService.get(id);
	}

	@PostMapping
	public User create(@RequestBody UserDto userDto) {
		return userService.create(UserDtoTransformer.transform(userDto));
	}

	@PutMapping("/{id}")
	public User update(@PathVariable Long id, @RequestBody UserDto userDto) {
		return userService.update(id, UserDtoTransformer.transform(userDto));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		userService.delete(id);
	}
}
