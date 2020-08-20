package com.spring.address.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.address.models.Address;
import com.spring.address.repositories.AddressRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/address")
@Slf4j
public class AddressController {

	@Autowired
	private AddressRepository addressRepository;

	@GetMapping("/{id}")
	public Address get(@PathVariable Long id) {
		try {
			return addressRepository.findById(id).orElseThrow();
		} catch (NoSuchElementException e) {
			log.error(e.toString());
			return null;
		}
	}

	@PostMapping
	public Long create(@RequestBody Address address) {
		Address address1 = addressRepository.save(address);
		return address1.getId();
	}

	@PutMapping("/{id}")
	public Long update(@PathVariable Long id, @RequestBody Address address) {
		address.setId(id);
		if (addressRepository.existsById(id)) {
			return addressRepository.save(address).getId();
		} else {
			return null;
		}
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		addressRepository.deleteById(id);
	}
}