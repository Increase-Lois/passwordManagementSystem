package com.semicolon.africa.passwordproject.Data.Repositories;

import com.semicolon.africa.passwordproject.Data.Models.Url;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepository extends MongoRepository<Url, String> {
    Optional <Url> findUrlByUrlAddress(String urlAddress);

//    Optional<Url> findUrlByUrlAddress(String urlAddress);
//
//    Optional<Url> findUrlByUsername(String username);
}
