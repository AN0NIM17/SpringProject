package com.spring.address.db.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.address.db.models.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long>{

}