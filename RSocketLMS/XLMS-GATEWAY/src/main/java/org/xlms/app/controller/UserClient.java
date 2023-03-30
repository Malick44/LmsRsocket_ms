package org.xlms.app.controller;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.rsocket.service.RSocketExchange;
import reactor.core.publisher.Mono;
import org.xlms.app.dto.UserDto;
public interface UserClient {
    @RSocketExchange("user.create")
    public Mono<UserDto> createUser(Mono<UserDto> monoUserDto);
}
