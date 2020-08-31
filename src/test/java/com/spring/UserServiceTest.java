package com.spring;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.spring.user.db.models.User;
import com.spring.user.db.repositories.UserRepository;
import com.spring.user.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@InjectMocks
	private UserService userService;

	@Mock
	private UserRepository userRepository;

	private User user;

	@Test
	public void get_getId_userReturned() {
		user = User.builder().id(1L).firstname("first").middlename("mid").lastname("last").build();
	    Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));
	    User returedUser = userService.get(1L);
	    assertThat(returedUser).isEqualTo(user);
	}

	@Test
	public void create_getUser_idReturned() {
		user = User.builder().id(7L).firstname("first").middlename("mid").lastname("last").build();
		Mockito.when(userRepository.save(user)).thenReturn(user);
		User returedUser = userService.create(user);
		assertThat(returedUser).isEqualTo(7L);
	}
	
	@Test
	public void update_getIdAndUser_userReturned() {
		user = User.builder().id(1L).firstname("first").middlename("mid").lastname("last").build();
		Mockito.when(userRepository.save(user)).thenReturn(user);
		Mockito.when(userRepository.existsById(1L)).thenReturn(true);
		User returedUser = userService.update(1L, user);
		assertThat(returedUser).isEqualTo(user);
	}
}
