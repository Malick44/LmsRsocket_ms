package com.appUser;


import com.appUser.controller.RSocketUserController;
import com.appUser.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ApplicationRunner implements CommandLineRunner {
    @Autowired
private final RSocketUserController rSocketUserController;
    @Override
    public void run(String... args) throws Exception {
        UserDto userDto = new UserDto();
        userDto.setFirstName("John");
        userDto.setLastName("Doe");
        userDto.setEmail("johndoe@example.com");
        System.out.println(userDto);

        rSocketUserController.createUser(Mono.just(userDto));

      //  System.out.println("created user+ " + userDto);
    }
}
