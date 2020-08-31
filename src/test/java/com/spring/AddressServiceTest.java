package com.spring;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.spring.address.db.models.Address;
import com.spring.address.db.repositories.AddressRepository;
import com.spring.address.service.AddressService;

@ExtendWith(MockitoExtension.class)
public class AddressServiceTest {
	
	@InjectMocks
	private AddressService addressService;
	
	@Mock 
	private AddressRepository addressRepository;
	
	private Address address;
	
	@Test
	public void get_getId_addressReturned() {
		address = Address.builder().id(1L).town("Khm").street("Prospect").houseNumber("34").build();
		Mockito.when(addressRepository.findById(1L)).thenReturn(Optional.of(address));
		Address returnedAddress = addressService.get(1L);
		assertNotNull(returnedAddress);
	}
	
//	@Test
//	public void create_getAddress_idReturned() {
//		address = Address.builder().id(1L).town("Khm").street("Prospect").houseNumber("34").build();
//		Mockito.when(addressRepository.save(address)).thenReturn(address);
//		Address returnedAddress = addressService.create(address);
//	}
//	
}
