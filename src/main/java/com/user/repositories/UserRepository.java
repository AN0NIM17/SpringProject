package com.user.repositories;

import org.springframework.data.repository.CrudRepository;

import com.user.models.User;

public interface UserRepository extends CrudRepository<User, Long>{

}
