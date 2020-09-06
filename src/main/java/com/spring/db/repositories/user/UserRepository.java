package com.spring.db.repositories.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.db.entity.user.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
