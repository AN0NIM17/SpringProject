package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.db.entity.user.User;
import com.spring.db.repositories.user.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User get(Long id) {
		return userRepository.findById(id).get();
	}

	public User create(User user) {
		return userRepository.save(user);
	}

	public User update(Long id, User user) {
		user.setId(id);
		return userRepository.save(user);
	}

	public void delete(Long id) {
		userRepository.deleteById(id);
	}
}
