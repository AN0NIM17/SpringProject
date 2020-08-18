package com.user.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.models.User;
import com.user.repositories.UserRepository;


@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/user/{id}")
	public Optional<User> userGet(@PathVariable(value = "id") Long id, User user) {
		Optional<User> getUser = userRepository.findById(id);
		return getUser;
	}
	
	@PostMapping("/user")
	public Long userCreate(@RequestBody User user) {
		Long id = userRepository.save(user).getId();
		return id;
	}
	
	
	@PutMapping("/user/{id}")
	public Long userUpdate(@PathVariable(value = "id") Long id, @RequestBody User user) {
		user.setId(id);
		userRepository.save(user);
		return id;
	}
	
	@DeleteMapping("/user/{id}")
	public void userDelete(@PathVariable(value = "id") Long id) {
		userRepository.deleteById(id);
	}
	
	
}
