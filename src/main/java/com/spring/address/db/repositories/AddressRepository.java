package com.spring.address.db.repositories;

import org.springframework.data.repository.CrudRepository;

import com.spring.address.db.models.Address;

public interface AddressRepository extends CrudRepository<Address, Long>{

}