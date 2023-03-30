package org.xlms.app.controller;

import org.bson.codecs.UuidCodec;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xlms.app.dto.UserDto;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping
public class UserClientController {
    private final UserClient userClient;
    public UserClientController(UserClient userClient) {
        this.userClient = userClient;
    }

    @MessageMapping("user.create")
    public Mono<UserDto> creatUser(Mono<UserDto> monoUserDto){
        return userClient.createUser(monoUserDto)
                .doOnNext(userDto -> {
                    System.out.println("User created: " + userDto);
                });

    }
}
