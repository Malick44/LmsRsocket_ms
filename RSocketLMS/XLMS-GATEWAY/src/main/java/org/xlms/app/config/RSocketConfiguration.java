package org.xlms.app.config;

import io.rsocket.transport.netty.client.TcpClientTransport;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.messaging.rsocket.RSocketStrategies;
import org.springframework.messaging.rsocket.service.RSocketServiceProxyFactory;

@Configuration
public class RSocketConfiguration {

    @Value("${userapi.host}")
    private String userApiHost;

    @Value("${userapi.port}")
    private int userApiPort;

    @Value("${userapi.route}")
    private String userApiRoute;

    @Bean
    public RSocketServiceProxyFactory rSocketServiceProxyFactory(RSocketRequester.Builder rSocketRequesterBuilder) {
        RSocketStrategies rSocketStrategies = RSocketStrategies.builder()
                .encoder(new Jackson2JsonEncoder())
                .decoder(new Jackson2JsonDecoder())
                .build();

        RSocketRequester rSocketRequester = rSocketRequesterBuilder
                .rsocketConnector()
                .rsocketConnector(connector -> connector
                        .dataMimeType(MediaType.APPLICATION_JSON_VALUE)
                        .metadataMimeType(MediaType.APPLICATION_JSON_VALUE)
                        .connect(TcpClientTransport.create(userApiHost, userApiPort)))
                .rsocketStrategies(rSocketStrategies).build();


        return new RSocketServiceProxyFactory(rSocketRequester);
    }

}
