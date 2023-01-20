package com.appUser.repository;

import com.appUser.model.AppUser;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ReactiveMongoRepository<AppUser,String>
{

}
