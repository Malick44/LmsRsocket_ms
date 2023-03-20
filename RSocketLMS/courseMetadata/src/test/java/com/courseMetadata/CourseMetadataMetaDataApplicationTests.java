package com.courseMetadata;

import com.courseMetadata.dto.CourseMetaDataDto;
import com.courseMetadata.service.CourseMetaDataService;
import io.rsocket.transport.netty.client.TcpClientTransport;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.rsocket.RSocketRequester;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class TestCourseMetadata {
	@Autowired
	 CourseMetaDataService service;
	private RSocketRequester requester;
	EasyRandom random = new EasyRandom();

	@Autowired
	private RSocketRequester.Builder builder;
	// set up the RSocketRequester object for connecting to the RSocket server
	@BeforeAll
	public void setup(){
		requester = builder
				.transport(TcpClientTransport.create("localhost", 6565));

	}

	@Test
    void getAllCourses(){
		Flux<CourseMetaDataDto> flux= this.requester.route("course.get.all")
				.retrieveFlux(CourseMetaDataDto.class)
				.onErrorReturn(new CourseMetaDataDto())
				.doOnNext(System.out::println)
						.take(2);

		StepVerifier.create(flux)
				.expectNextCount(2)
				.verifyComplete();
	}
@Test
	void getById(){
		//CourseMetaDataDto expected = new CourseMetaDataDto();
				//expected.setCourseId("63cc61a0b1338d3c1b8279c9");
		String courseId = "63cc61a0b1338d3c1b8279c9";

		//when(this.service.getCourseById(courseId)).thenReturn(Mono.just(expected));
	Mono<CourseMetaDataDto> mono =requester.route("course.get.{id}", courseId)
			    .retrieveMono(CourseMetaDataDto.class)
				.doOnNext(System.out::println)
				//.onErrorReturn(new CourseMetaDataDto())
				;

		StepVerifier.create(mono)
				.expectNextMatches(d -> d.getCourseId().equals("63cc61a0b1338d3c1b8279c9"))
				.verifyComplete();
	}


	@Test
	void createCourse(){
// implement the createCourse() method


		CourseMetaDataDto mockdto= random.nextObject(CourseMetaDataDto.class);
		//Mono<CourseMetaDataDto> monodto = Mono.just(new CourseMetaDataDto());
		//when(this.service.createCourse(Mono.just(mockdto))).thenReturn(monodto);
		Mono<CourseMetaDataDto> mono = this.requester.route("course.create")
				.data(mockdto)
				.retrieveMono(CourseMetaDataDto.class)
				.doOnNext(System.out::println)
				.onErrorReturn(new CourseMetaDataDto());

		StepVerifier.create(mono)
				.expectNextCount(1)
				.verifyComplete();
	}

}
