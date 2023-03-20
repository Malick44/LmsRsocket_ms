package com.appUser;

import com.appUser.controller.RSocketUserController;
import com.appUser.dto.UserDto;
import com.appUser.repository.UserRepository;
import com.appUser.service.UserService;
import io.rsocket.transport.netty.client.TcpClientTransport;
import lombok.RequiredArgsConstructor;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.rsocket.RSocketRequester;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import static org.junit.jupiter.api.Assertions.assertEquals;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
class UserApplicationTests {
	@Autowired
	UserService userService;
	private RSocketRequester requester;
	EasyRandom random = new EasyRandom();

	@Autowired
	private RSocketRequester.Builder builder;

	UserApplicationTests() {
	}

	// set up the RSocketRequester object for connecting to the RSocket server
	@BeforeAll
	public void setup(){
		requester = builder
				.transport(TcpClientTransport.create("localhost", 7001));

	}

	@Test
	public void testCreateUser() {

		UserDto MokUserDto = random.nextObject(UserDto.class);
		Mono<UserDto> mono = this.requester.route("user.create")
				.data(MokUserDto)
				.retrieveMono(UserDto.class)
				.doOnNext(System.out::println)
				.onErrorReturn(new UserDto());


		StepVerifier.create(mono)
				.expectNextCount(1)
				.verifyComplete();


//		StepVerifier.create(userRepository.findAll())
//				.expectNextMatches(user -> {
//					assertEquals(userDto.getFirstName(), user.getFirstName());
//					assertEquals(userDto.getLastName(), user.getLastName());
//					assertEquals(userDto.getEmail(), user.getEmail());
//					return true;
//				})
//				.verifyComplete();
	}
//@Test
//void testCreateAUser(){
//		UserDto userDto = new UserDto();
//		userDto.setFirstName("John");
//		userDto.setLastName("Doe");
//		userDto.setEmail("johndoe@example.com");
//		requesterBuilder
//				.route("createUser")
//		.data(Mono.just(userDto), UserDto.class);
//	rSocketUserController.createUser(Mono.just(userDto));
//}

}
