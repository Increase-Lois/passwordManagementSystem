package com.semicolon.africa.passwordproject.Data.Repositories;

import com.semicolon.africa.passwordproject.Data.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    //Optional<User> findUserByUserName(String username);

    Optional<User> findUserByEmailAddress(String emailAddress);

//    User findUserByUsername(String username);
}
