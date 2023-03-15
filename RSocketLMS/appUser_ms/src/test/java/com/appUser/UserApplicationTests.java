package com.appUser;

import com.appUser.controller.RSocketUserController;
import com.appUser.dto.UserDto;
import com.appUser.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.rsocket.RSocketRequester;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@RequiredArgsConstructor
//@AutoConfigureRSocketClient
class UserApplicationTests {


	@Autowired
	private RSocketRequester.Builder requesterBuilder;

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RSocketUserController rSocketUserController;

	@Test
	public void testCreateUser() {
		UserDto userDto = new UserDto();
		userDto.setFirstName("John");
		userDto.setLastName("Doe");
		userDto.setEmail("johndoe@example.com");

		requesterBuilder.tcp("localhost", 7001)
				.route("createUser")
				.data(Mono.just(userDto), UserDto.class)
				.retrieveMono(UserDto.class)
				.doOnNext(user -> {
					assertEquals(userDto.getFirstName(), user.getFirstName());
					assertEquals(userDto.getLastName(), user.getLastName());
					assertEquals(userDto.getEmail(), user.getEmail());
				})
				.subscribe();

		StepVerifier.create(userRepository.findAll())
				.expectNextMatches(user -> {
					assertEquals(userDto.getFirstName(), user.getFirstName());
					assertEquals(userDto.getLastName(), user.getLastName());
					assertEquals(userDto.getEmail(), user.getEmail());
					return true;
				})
				.verifyComplete();
	}
@Test
void testCreateAUser(){
		UserDto userDto = new UserDto();
		userDto.setFirstName("John");
		userDto.setLastName("Doe");
		userDto.setEmail("johndoe@example.com");

		requesterBuilder.tcp("localhost", 7001)
				.route("createUser")
		.data(Mono.just(userDto), UserDto.class);
	rSocketUserController.createUser(Mono.just(userDto));
}

}
