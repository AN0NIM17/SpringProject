package com.spring.db.repositories.address;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.db.entity.address.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long>{

}