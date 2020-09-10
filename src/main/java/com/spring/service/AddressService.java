package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.db.entity.address.Address;
import com.spring.db.repositories.address.AddressRepository;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address get(Long id) {
        return addressRepository.findById(id).get();
    }

    public Address create(Address address) {
        return addressRepository.save(address);
    }

    public Address update(Long id, Address address) {
        address.setId(id);
        return addressRepository.save(address);
    }

    public void delete(Long id) {
        addressRepository.deleteById(id);
    }
}
