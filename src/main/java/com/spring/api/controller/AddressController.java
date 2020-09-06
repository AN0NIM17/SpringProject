package com.spring.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.api.dto.AddressDto;
import com.spring.api.transformer.AddressDtoTransformer;
import com.spring.db.entity.address.Address;
import com.spring.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@GetMapping("/{id}")
	public ResponseEntity<Address> get(@PathVariable Long id) {
		Address address = addressService.get(id);
		return ResponseEntity.ok(address);
	}

	@PostMapping
	public ResponseEntity<Address> create(@RequestBody AddressDto addressDto) {
		Address address = AddressDtoTransformer.transform(addressDto);
		address = addressService.create(address);
		return ResponseEntity.status(HttpStatus.CREATED).body(address);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Address> update(@PathVariable Long id, @RequestBody AddressDto addressDto) {
		addressDto.setId(id);
		Address address =  AddressDtoTransformer.transform(addressDto);
		address = addressService.update(id, address);
		return ResponseEntity.ok(address);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		addressService.delete(id);
		ResponseEntity.ok();
	}
}