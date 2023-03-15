package com.appUser.service;

import com.appUser.dto.UserDto;
import com.appUser.model.User;
import com.appUser.repository.UserRepository;
import com.appUser.util.ModelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Flux<UserDto> getAllUsers() {
        return this.userRepository.findAll()
                .map(ModelUtil::toDto);

    }
        public Mono<UserDto> getUserById(final String userId) {
       return this.userRepository.findById(userId)
               .map(ModelUtil::toDto);

        }
        public Mono<UserDto> createUser(Mono<UserDto> userDto){
                     return userDto
                             .map(ModelUtil::toEntity)
                             .flatMap(this.userRepository::save)
                             .map(ModelUtil::toDto)
                             .map(user -> {
                                 System.out.println("User created successfully");
                                 return user;
                             });
//            System.out.println("User created successfully");

        }

        public Mono<UserDto> updateUser(String id, Mono<UserDto> userDtoMono){

        return this.userRepository.findById(id)
                .flatMap(u -> userDtoMono.map(ModelUtil::toEntity)
                        .doOnNext(
                        e -> e.setId(id)))
                .flatMap(this.userRepository::save)
                .map(ModelUtil::toDto);

        }
    public Mono<UserDto> updateUserField
            (String id, UserDto userDto) {
        User newUser = ModelUtil.toEntity(userDto);
        return userRepository.findById(id)
                .flatMap(existingUser -> {
                    existingUser.setFirstName(newUser.getFirstName());
                    existingUser.setMiddleName(newUser.getMiddleName());
                    existingUser.setLastName(newUser.getLastName());
                    existingUser.setOrganization(newUser.getOrganization());
                    existingUser.setDesignation(newUser.getDesignation());
                    existingUser.setUsername(newUser.getUsername());
                    existingUser.setPassword(newUser.getPassword());
                    existingUser.setEmail(newUser.getEmail());
                    existingUser.setPhoneNumber(newUser.getPhoneNumber());
                    existingUser.setAddress(newUser.getAddress());
                    existingUser.setProfilePic(newUser.getProfilePic());
                    existingUser.setBio(newUser.getBio());
                    existingUser.setLinkedInUrl(newUser.getLinkedInUrl());
                    existingUser.setTwitterUrl(newUser.getTwitterUrl());
                    existingUser.setFacebookUrl(newUser.getFacebookUrl());
                    existingUser.setAdmin(newUser.isAdmin());
                    existingUser.setAuthor(newUser.isAuthor());
                    existingUser.setStudent(newUser.isStudent());
                    existingUser.setActive(newUser.isActive());
                    existingUser.setVerified(newUser.isVerified());
                    existingUser.setEmailVerified(newUser.isEmailVerified());
                    existingUser.setPhoneVerified(newUser.isPhoneVerified());
                    existingUser.setEnrolledCourses(newUser.getEnrolledCourses());
                    return userRepository.save(existingUser);
                })
                .map(ModelUtil::toDto);
    }

        public Mono<Void> deleteUser(String userId){
                   return this.userRepository.deleteById(userId);


        }
    public Flux<UserDto> getUsersByPage(int pageNumber, int pageSize) {
        return userRepository.findAll()
                .map(ModelUtil::toDto);
    }

    public Flux<UserDto> getActiveUsersByPage(int pageNumber, int pageSize) {
        return userRepository.findByIsActiveTrue(PageRequest.of(pageNumber, pageSize))
                .map(ModelUtil::toDto);
    }

    public Flux<UserDto> getVerifiedUsersByPage(int pageNumber, int pageSize) {
        return userRepository.findByIsVerifiedTrue(PageRequest.of(pageNumber, pageSize))
                .map(ModelUtil::toDto);
    }

    public Flux<UserDto> getEnrolledUsersByCourseIdByPage(String courseId, int pageNumber, int pageSize) {
        return userRepository.findByEnrolledCoursesContaining(courseId, PageRequest.of(pageNumber, pageSize))
                .map(ModelUtil::toDto);
    }


}


