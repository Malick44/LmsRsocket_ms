package com.appUser;

import com.appUser.controller.UserController;
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
import reactor.core.publisher.Flux;
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


	// set up the RSocketRequester object for connecting to the RSocket server
	@BeforeAll
	public void setup(){
		requester = builder
				.transport(TcpClientTransport.create("localhost", 7001));
	}

	@Test
	void createUser(){
// implement the createUser() method
		UserDto userDto = new UserDto();
		userDto.setFirstName("John");
		userDto.setLastName("Doe");
		userDto.setEmail("grii@gd.com");
		Mono<UserDto> mono = this.requester.route("user.create")
				.data(userDto)
				.retrieveMono(UserDto.class)
				.doOnNext(System.out::println)
				.onErrorReturn(new UserDto());

		StepVerifier.create(mono)
				.expectNextCount(1)
				.verifyComplete();
	}
	@Test
	void getAllCourses(){
		Flux<UserDto> flux= this.requester.route("user.get.all")
				.retrieveFlux(UserDto.class)
				.onErrorReturn(new UserDto())
				.doOnNext(System.out::println)
				.take(1);

		StepVerifier.create(flux)
				.expectNextCount(1)
				.verifyComplete();
	}

	// implement the createCourse() method
//	CourseMetaDataDto mockdto= random.nextObject(CourseMetaDataDto.class);
//	Mono<CourseMetaDataDto> mono = this.requester.route("course.create")
//			.data(mockdto)
//			.retrieveMono(CourseMetaDataDto.class)
//			.doOnNext(System.out::println)
//			.onErrorReturn(new CourseMetaDataDto());
//
//		StepVerifier.create(mono)
//			.expectNextCount(1)
//				.verifyComplete();


}
