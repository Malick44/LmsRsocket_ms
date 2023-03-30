package org.xlms.app.controller;

import org.springframework.messaging.rsocket.service.RSocketExchange;
import reactor.core.publisher.Mono;

public interface HelloClient
{
 // hello world
    @RSocketExchange("course.hello")
    public Mono<String> hello();

}