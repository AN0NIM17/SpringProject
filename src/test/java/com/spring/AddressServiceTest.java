package com.spring;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.spring.db.entity.address.Address;
import com.spring.db.repositories.address.AddressRepository;
import com.spring.service.AddressService;

@ExtendWith(MockitoExtension.class)
public class AddressServiceTest {
	
	@InjectMocks
	private AddressService addressService;
	
	@Mock 
	private AddressRepository addressRepository;
	
	private final Address address = Address.builder()
			.id(1L).city("Khm")
			.address("Prospect")
			.build();
	
	@Test
	public void get_getId_addressReturned() {
		Mockito.when(addressRepository.findById(1L)).thenReturn(Optional.of(address));
		Address returnedAddress = addressService.get(1L);
		assertNotNull(returnedAddress);
	}
	
	@Test
	public void create_getAddress_idReturned() {
		Mockito.when(addressRepository.save(address)).thenReturn(address);
		Address returnedAddress = addressService.create(address);
		assertThat(returnedAddress).isNotNull();
	}
	
	@Test
	public void update_getAddress_idReturned() {
		Mockito.when(addressRepository.save(address)).thenReturn(address);
		Address retutnedAddress = addressService.update(1L, address);
		assertThat(retutnedAddress).asString().contains("Prospect");
	}
	
	@Test
	public void delete() {
		addressService.delete(1L);
		Mockito.verify(addressRepository).deleteById(1L);
	}
}
