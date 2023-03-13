package com.appUser.repository;

import com.appUser.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Service
public abstract class UserRepositoryImpl {
    private final ReactiveMongoTemplate mongoTemplate;

    public Flux<User> findAllByPage(int page, int size, String sortBy) {
        Query query = new Query();
        query.with(PageRequest.of(page, size));
        return mongoTemplate.find(query, User.class);
    }

}
