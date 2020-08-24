package com.spring.user.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.user.models.User;
import com.spring.user.repositories.UserRepository;

public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User get(Long id) {
		return userRepository.findById(id).orElseThrow();
	}

	public Long create(User user) {
		return userRepository.save(user).getId();
	}

	public User update(Long id, User user) {
		user.setId(id);
		if (userRepository.existsById(id)) {
			return userRepository.save(user);
		} else {
			return null;
		}
	}

	public void delete(Long id) {
		userRepository.deleteById(id);
	}
}
