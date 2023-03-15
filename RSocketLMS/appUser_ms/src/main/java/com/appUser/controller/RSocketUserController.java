package com.appUser.controller;

import com.appUser.dto.UserDto;
import com.appUser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("rSocket/user/")
public class RSocketUserController {

    private final UserService userService;

    @Autowired
    public RSocketUserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping ("createUser")
    public Mono<UserDto> createUser(@RequestBody Mono<UserDto> userDto) {
        return userService.createUser(userDto);
    }

    @MessageMapping("getUserById")
    public Mono<UserDto> getUserById(String id) {
        return userService.getUserById(id);
    }

    @MessageMapping("getAllUsers")
    public Flux<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @MessageMapping("updateUser")
    public Mono<UserDto> updateUser(String id, Mono<UserDto> userDto) {
        return userService.updateUser(id, userDto);
    }

    @MessageMapping("deleteUser")
    public Mono<Void> deleteUser(String id) {
        return userService.deleteUser(id);
    }

    @MessageMapping("getUsersByPage")
    public Flux<UserDto> getUsersByPage(int pageNumber, int pageSize) {
        return userService.getUsersByPage(pageNumber, pageSize);
    }

    @MessageMapping("getActiveUsersByPage")
    public Flux<UserDto> getActiveUsersByPage(int pageNumber, int pageSize) {
        return userService.getActiveUsersByPage(pageNumber, pageSize);
    }

    @MessageMapping("getVerifiedUsersByPage")
    public Flux<UserDto> getVerifiedUsersByPage(int pageNumber, int pageSize) {
        return userService.getVerifiedUsersByPage(pageNumber, pageSize);
    }

    @MessageMapping("getEnrolledUsersByCourseIdByPage")
    public Flux<UserDto> getEnrolledUsersByCourseIdByPage(String courseId, int pageNumber, int pageSize) {
        return userService.getEnrolledUsersByCourseIdByPage(courseId, pageNumber, pageSize);
    }

}
