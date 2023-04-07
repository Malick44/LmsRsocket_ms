package org.xlms.xlmsgateway;

import io.rsocket.RSocketErrorException;
import io.rsocket.transport.netty.client.TcpClientTransport;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.messaging.rsocket.RSocketStrategies;
import org.springframework.messaging.rsocket.service.RSocketServiceProxyFactory;
import reactor.util.retry.Retry;
import java.time.Duration;
import java.util.function.Predicate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class XlmsGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(XlmsGatewayApplication.class, args);
	}
RSocketRequester requester;

	public RSocketServiceProxyFactory rSocketServiceProxyFactory(RSocketRequester.Builder builder,String host, int port) {
// strategy
		RSocketStrategies strategies = RSocketStrategies.builder()
				.encoder(new Jackson2JsonEncoder())
				.decoder(new Jackson2JsonDecoder())
				.build();
		// RetyStrategy
		Predicate<Throwable> rSocketExceptionPredicate = throwable -> throwable instanceof RSocketErrorException;

		requester  = builder
				.rsocketStrategies(strategies)
				.rsocketConnector(connector -> connector.reconnect(Retry.backoff(3, Duration.ofSeconds(1)).filter(rSocketExceptionPredicate)))
				.transport(TcpClientTransport.create(host, port));

		return RSocketServiceProxyFactory.builder(requester).build();
	}

	@Bean
	public RSocketServiceProxyFactory courseMetaApiRSocketServiceProxyFactory(RSocketRequester.Builder builder) {
		return rSocketServiceProxyFactory(builder, "localhost", 6565);
	}
	@Bean
	public RSocketServiceProxyFactory assessmentApiRSocketServiceProxyFactory(RSocketRequester.Builder builder) {
		return rSocketServiceProxyFactory(builder, "localhost", 7003);
	}
	@Bean
	public RSocketServiceProxyFactory userApiRSocketServiceProxyFactory(RSocketRequester.Builder builder) {
		return rSocketServiceProxyFactory(builder, "localhost", 7001);
	}



//	@Bean
//	public HelloClient helloClient(RSocketServiceProxyFactory courseMetaApiRSocketServiceProxyFactory) {
//		return courseMetaApiRSocketServiceProxyFactory.createClient(HelloClient.class);
//}
//	@Bean
//	public UserClient userClient(RSocketServiceProxyFactory userApiRSocketServiceProxyFactory) {
//		return userApiRSocketServiceProxyFactory.createClient(UserClient.class);
//	}
}
