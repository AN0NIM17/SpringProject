package com.spring.user.db.repositories;

import org.springframework.data.repository.CrudRepository;

import com.spring.user.db.models.User;

public interface UserRepository extends CrudRepository<User, Long>{

}
