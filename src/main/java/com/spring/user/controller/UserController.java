package com.spring.user.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.user.models.User;
import com.spring.user.repositories.UserRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/{id}")
	public User get(@PathVariable Long id, User user) {
		try {
			return userRepository.findById(id).orElseThrow();
		} catch (NoSuchElementException e) {
			log.error(e.toString());
			return null;
		}

	}

	@PostMapping
	public Long create(@RequestBody User user) {
		return userRepository.save(user).getId();
	}

	@PutMapping("/{id}")
	public Long update(@PathVariable Long id, @RequestBody User user) {
		user.setId(id);
		if (userRepository.existsById(id)) {
			return userRepository.save(user).getId();
		} else {
			return null;
		}
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		userRepository.deleteById(id);
	}
}
