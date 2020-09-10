package com.spring.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.api.dto.UserDto;
import com.spring.api.transformer.UserDtoTransformer;
import com.spring.db.entity.user.User;
import com.spring.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/{id}")
	public ResponseEntity<UserDto> get(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(UserDtoTransformer.transform(userService.get(id)));
	}

	@PostMapping
	public ResponseEntity<UserDto> create(@RequestBody @Valid UserDto userDto) {
		User user = userService.create(UserDtoTransformer.transform(userDto));
		return ResponseEntity.status(HttpStatus.CREATED).body(UserDtoTransformer.transform(user));
	}

	@PutMapping("/{id}")
	public ResponseEntity<UserDto> update(@PathVariable Long id, @RequestBody UserDto userDto) {
		User user = userService.update(id, UserDtoTransformer.transform(userDto, id));
		return ResponseEntity.status(HttpStatus.OK).body(UserDtoTransformer.transform(user));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		userService.delete(id);
	}
}
