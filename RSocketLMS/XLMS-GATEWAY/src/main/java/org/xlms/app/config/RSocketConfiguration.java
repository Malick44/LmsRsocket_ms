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
import org.xlms.app.dto.UserDto;
import org.xlms.app.service.entinties.AppUserClient;
import reactor.core.publisher.Mono;

@Configuration
@Slf4j
public class RSocketConfiguration {

    private final String userApiHost;
    private final int userApiPort;
    private final RSocketRequester.Builder rSocketRequesterBuilder;

    public RSocketConfiguration(RSocketRequester.Builder rSocketRequesterBuilder,
                                @Value("${userapi.host}") String userApiHost,
                                @Value("${userapi.port}") int userApiPort) {
        this.rSocketRequesterBuilder = rSocketRequesterBuilder;
        this.userApiHost = userApiHost;
        this.userApiPort = userApiPort;
        log.info("userApiHost: " + userApiHost);
        log.info("userApiPort: " + userApiPort);
    }

    @Bean
    public RSocketServiceProxyFactory rSocketServiceProxyFactory() {
        RSocketStrategies rStrategies = RSocketStrategies.builder()
                .encoder(new Jackson2JsonEncoder())
                .decoder(new Jackson2JsonDecoder())
                .build();

        RSocketRequester rSocketRequester = rSocketRequesterBuilder
                .rsocketStrategies(rStrategies)
                .dataMimeType(MediaType.APPLICATION_JSON)
                .metadataMimeType(MediaType.APPLICATION_JSON)
                .connect(TcpClientTransport.create(userApiHost, userApiPort))
                .block();

        return RSocketServiceProxyFactory.builder(rSocketRequester).build();
    }



//    public <T> T createClient(Class<T> clientClass, RSocketServiceProxyFactory rSocketServiceProxyFactory) {
//        return rSocketServiceProxyFactory.createClient(clientClass);
//    }

@Bean
   public AppUserClient initClients(RSocketServiceProxyFactory factory) {
       //RSocketServiceProxyFactory userApiProxyFactory = rSocketServiceProxyFactory(rSocketRequesterBuilder, userApiHost, userApiPort);
          return factory.createClient(AppUserClient.class);
        // Use appUserClient here or assign it to an instance variable for later use
    }

    @Bean
    public ApplicationRunner appUserClientRunner(AppUserClient appUserClient) {
        return args -> {

            appUserClient.createUser(Mono.just(UserDto.builder()
                    .firstName("John")
                    .middleName("Doe")
                    .lastName("Doe")
                    .organization("XLMS")
                    .designation("Software Engineer")
                    .username("johndoe")
                    .password("password")
                    .email("huiiu@gjgg.com")
                    .phoneNumber("1234567890")
                    .build())).block();
                   // .subscribe(System.out::println);
        };
    }
}
