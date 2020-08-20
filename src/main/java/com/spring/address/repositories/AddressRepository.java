package com.spring.address.repositories;

import org.springframework.data.repository.CrudRepository;

import com.spring.address.models.Address;

public interface AddressRepository extends CrudRepository<Address, Long>{

}
