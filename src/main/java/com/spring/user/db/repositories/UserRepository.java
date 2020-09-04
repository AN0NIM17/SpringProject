package com.spring.user.db.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.user.db.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
