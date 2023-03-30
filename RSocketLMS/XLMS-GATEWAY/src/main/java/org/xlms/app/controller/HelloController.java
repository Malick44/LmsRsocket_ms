package org.xlms.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicReference;

import static reactor.core.publisher.Flux.just;

@RestController
@RequestMapping
public class HelloController {
    @Autowired
    HelloClient helloClient;
    @GetMapping("/hello")
    public String helloy(){
       StringBuffer result = new StringBuffer();
      return helloClient
                .hello()
                .doOnNext(gr -> {
                    System.out.println("Hello there"+ gr);
                })
                .subscribe().toString();



    }

}
