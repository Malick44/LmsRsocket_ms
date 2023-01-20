package com.courseMetadata;

import com.courseMetadata.dto.CourseMetaDataDto;
import io.rsocket.transport.netty.client.TcpClientTransport;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.rsocket.RSocketRequester;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Objects;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestCourseMetadata {


	private RSocketRequester requester;

	@Autowired
	private RSocketRequester.Builder builder;

	@BeforeAll
	public void setup(){
		this.requester = this.builder
				.transport(TcpClientTransport.create("localhost", 6565));
	}
	@Test
    void getAllCourses(){
		Flux<CourseMetaDataDto> flux= this.requester.route("get.all")
				.retrieveFlux(CourseMetaDataDto.class)
				.onErrorReturn(new CourseMetaDataDto())
				.doOnNext(System.out::println)
						.take(2);

		StepVerifier.create(flux)
				.expectNextCount(2)
				.verifyComplete();
	}

//	void getByAutorId(){
//
//
//		Mono<CourseMetaDataDto> mono=requester.route("get.Smith")
//				.retrieveMono(CourseMetaDataDto.class)
//				.doOnNext(System.out::println);
//
//
//		StepVerifier.create(mono)
//				.expectNextCount(1)
//				.verifyComplete();
//	}

}
