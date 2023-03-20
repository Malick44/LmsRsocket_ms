package com.appUser;


import com.appUser.controller.RSocketUserController;
import com.appUser.dto.UserDto;
import com.appUser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Configuration
public class ApplicationRunner implements org.springframework.boot.ApplicationRunner {
  @Autowired
    RSocketUserController rSocketUserController;

    public void run(ApplicationArguments args) throws Exception {

        UserDto userDto = new UserDto();
        userDto.setFirstName("John");
        userDto.setLastName("Doe");
        userDto.setEmail("grii@gd.com");
        Mono<UserDto> mono = Mono.just(userDto);
        rSocketUserController.createUser(mono).subscribe();
        System.out.println(userDto);




    }
}
