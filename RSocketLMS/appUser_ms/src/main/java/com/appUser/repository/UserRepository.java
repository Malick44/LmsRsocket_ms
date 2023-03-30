package com.appUser.repository;

import com.appUser.dto.UserDto;
import com.appUser.model.User;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.Optional;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User,String>
{
    Flux<User> findByIsActiveTrue(PageRequest of);

    Flux<User> findByIsVerifiedTrue(PageRequest of);

    Flux<User> findByEnrolledCoursesContaining(String courseId, PageRequest of);
    Flux<User> findAllByFirstName(String name, int page, int size, String sortBy);

}
