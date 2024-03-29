package com.appUser.controller;

import com.appUser.dto.UserDto;
import com.appUser.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@RequiredArgsConstructor
@Controller
@MessageMapping ("user")
public class UserController {

  @Autowired
  public UserService userService;

    @MessageMapping("create")
    public Mono<UserDto> createUser( Mono<UserDto> dtoMono){

        return this.userService.createUser(dtoMono);
    }

    @MessageMapping("get.{id}")
    public Mono<UserDto> getUserById(@DestinationVariable String id) {
        return userService.getUserById(id);
    }

    @MessageMapping("get.all")
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
