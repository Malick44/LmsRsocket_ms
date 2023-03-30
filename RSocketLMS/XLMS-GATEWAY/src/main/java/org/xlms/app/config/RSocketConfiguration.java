package org.xlms.app.config;

import io.rsocket.transport.netty.client.TcpClientTransport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.messaging.rsocket.RSocketStrategies;
import org.springframework.messaging.rsocket.service.RSocketServiceProxyFactory;
import org.xlms.app.controller.HelloClient;
import org.xlms.app.dto.UserDto;
import org.xlms.app.service.entinties.AppUserClient;
import reactor.core.publisher.Mono;
@Configuration
@Slf4j
public class RSocketConfiguration {
    @Bean
    public ApplicationRunner appUserClientRunner(HelloClient helloClient) {
        return args -> {
            helloClient
                    .hello()
                    .doOnNext(gr -> {
                        System.out.println( gr);
                    })
                    .subscribe();




//                    createUser(Mono.just(UserDto.builder()
//                    .firstName("John")
//                    .middleName("Doe")
//                    .lastName("Doe")
//                    .organization("XLMS")
//                    .designation("Software Engineer")
//                    .username("johndoe")
//                    .password("password")
//                    .email("huiiu@gjgg.com")
//                    .phoneNumber("1234567890")
//                    .build())).block();
                   // .subscribe(System.out::println);
        };
    }
}
