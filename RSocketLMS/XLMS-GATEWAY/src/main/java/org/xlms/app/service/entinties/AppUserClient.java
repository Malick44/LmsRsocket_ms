package org.xlms.app.service.entinties;

import org.springframework.messaging.rsocket.service.RSocketExchange;
import org.xlms.app.dto.UserDto;
import reactor.core.publisher.Mono;

public interface AppUserClient {
    @RSocketExchange("user.create")
    public Mono<UserDto> createUser(Mono<UserDto> userDto);

}
