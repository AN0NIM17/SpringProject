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
	public ResponseEntity<AddressDto> get(@PathVariable Long id) {
		AddressDto addressDto = AddressDtoTransformer.transform(addressService.get(id));
		return ResponseEntity.ok(addressDto);
	}

	@PostMapping
	public ResponseEntity<AddressDto> create(@RequestBody AddressDto addressDto) {
		Address address = AddressDtoTransformer.transform(addressDto);
		address = addressService.create(address);
		addressDto = AddressDtoTransformer.transform(address);
		return ResponseEntity.status(HttpStatus.CREATED).body(addressDto);
	}

	@PutMapping("/{id}")
	public ResponseEntity<AddressDto> update(@PathVariable Long id, @RequestBody AddressDto addressDto) {
		addressDto.setId(id);
		Address address =  AddressDtoTransformer.transform(addressDto);
		address = addressService.update(id, address);
		addressDto = AddressDtoTransformer.transform(address);
		return ResponseEntity.ok(addressDto);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		addressService.delete(id);
		ResponseEntity.ok();
	}
}