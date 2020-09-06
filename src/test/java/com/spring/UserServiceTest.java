package com.spring;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.spring.db.entity.user.User;
import com.spring.db.repositories.user.UserRepository;
import com.spring.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@InjectMocks
	private UserService userService;

	@Mock
	private UserRepository userRepository;

	private final User user = User.builder()
			.id(1L)
			.firstname("first")
			.middlename("mid")
			.lastname("last")
			.build();

	@Test
	public void get_getId_userReturned() {
		Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));
		User returedUser = userService.get(1L);
		assertThat(returedUser).isEqualTo(user);
	}

	@Test
	public void create_getUser_idReturned() {
		Mockito.when(userRepository.save(user)).thenReturn(user);
		User returedUser = userService.create(user);
		assertThat(returedUser).isEqualTo(user);
	}

	@Test
	public void update_getIdAndUser_userReturned() {
		Mockito.when(userRepository.save(user)).thenReturn(user);
		User returedUser = userService.update(1L, user);
		assertThat(returedUser).isEqualTo(user);
	}

	@Test
	public void delete() {
		userService.delete(1L);
		Mockito.verify(userRepository).deleteById(1L);
	}
}
