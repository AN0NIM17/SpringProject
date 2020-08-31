package com.spring.address.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.address.api.dto.AddressDto;
import com.spring.address.api.transformer.AddressDtoTransformer;
import com.spring.address.db.models.Address;
import com.spring.address.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@GetMapping("/{id}")
	public Address get(@PathVariable Long id) {
			return addressService.get(id);
	}

	@PostMapping
	public Address create(@RequestBody AddressDto addressDto) {
		return addressService.create(AddressDtoTransformer.transform(addressDto));
	}

	@PutMapping("/{id}")
	public Address update(@PathVariable Long id, @RequestBody AddressDto addressDto) {
		return addressService.update(id, AddressDtoTransformer.transform(addressDto));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		addressService.delete(id);
	}
}