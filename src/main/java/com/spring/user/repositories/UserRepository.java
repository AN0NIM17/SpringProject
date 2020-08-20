package com.spring.user.repositories;

import org.springframework.data.repository.CrudRepository;

import com.spring.user.models.User;

public interface UserRepository extends CrudRepository<User, Long>{

}
