package com.appUser.service;

import com.appUser.dto.AppUserDto;
import com.appUser.repository.UserRepository;
import com.appUser.util.ModelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Flux<AppUserDto> getAllUsers() {
        return this.userRepository.findAll()
                .map(ModelUtil::toDto);

    }
        public Mono<AppUserDto>getUserById(final String userId) {
       return this.userRepository.findById(userId)
               .map(ModelUtil::toDto);

        }
        public Mono<AppUserDto> createUser(Mono<AppUserDto> userDto){
                     return userDto
                             .map(ModelUtil::toEntity)
                             .flatMap(this.userRepository::save)
                             .map(ModelUtil::toDto);

        }

        public Mono<AppUserDto> updateUser(String id, Mono<AppUserDto> userDtoMono){

        return this.userRepository.findById(id)
                .flatMap(u -> userDtoMono.map(ModelUtil::toEntity)
                        .doOnNext(
                        e -> e.setId(id)))
                .flatMap(this.userRepository::save)
                .map(ModelUtil::toDto);

        }

        public Mono<Void> deleteUser(String userId){
                   return this.userRepository.deleteById(userId);


        }

    }


