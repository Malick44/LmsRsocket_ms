package org.xlms.app.config;

import io.rsocket.transport.netty.client.TcpClientTransport;
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
public class RSocketConfiguration {

    @Value("${userapi.host}")
    private String userApiHost;

    @Value("${userapi.port}")
    private int userApiPort;

    @Autowired
    RSocketRequester.Builder rSocketRequesterBuilder;

    @Bean
    public RSocketServiceProxyFactory rSocketServiceProxyFactory(RSocketRequester.Builder rSocketRequesterBuilder, String userApiHost, int userApiPort) {
        RSocketStrategies rStrategies = RSocketStrategies.builder()
                .encoder(new Jackson2JsonEncoder())
                .decoder(new Jackson2JsonDecoder())
                .build();

        RSocketRequester rSocketRequester = this.rSocketRequesterBuilder
                .rsocketStrategies(rStrategies)
                .dataMimeType(MediaType.APPLICATION_JSON)
                .metadataMimeType(MediaType.APPLICATION_JSON)
                .connect(TcpClientTransport.create(this.userApiHost, this.userApiPort))
                .block();

        return RSocketServiceProxyFactory.builder(rSocketRequester).build();
    }

//    @Bean
//    public <T> T createClient(Class<T> clientClass, RSocketServiceProxyFactory rSocketServiceProxyFactory) {
//        return rSocketServiceProxyFactory.createClient(clientClass);
//    }

    @Autowired
    public void initClients(RSocketRequester.Builder rSocketRequesterBuilder, RSocketServiceProxyFactory rSocketServiceProxyFactory) {
       RSocketServiceProxyFactory userApiProxyFactory = rSocketServiceProxyFactory(rSocketRequesterBuilder, userApiHost, userApiPort);
        AppUserClient appUserClient = createClient(AppUserClient.class, userApiProxyFactory);
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
                    .build())).subscribe(System.out::println);
        };
    }
}
