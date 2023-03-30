package org.xlms.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.xlms.app.controller.UserClient;
import org.xlms.app.dto.UserDto;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class XlmsApplicationTests {

	@Autowired
	public UserClient userClient;

	@Test
	void createUser() {
		UserDto userDto = new UserDto();
		userDto.setFirstName("John");
		userDto.setLastName("Doe");
		userDto.setEmail("grii@gd.com");
		Mono<UserDto> mono = Mono.just(userDto);
		Mono<UserDto> userDtoMono = userClient.createUser(mono);
		System.out.println(userDto);

		StepVerifier.create(userDtoMono)
				.expectNextCount(1)
				.verifyComplete();

	}

}
