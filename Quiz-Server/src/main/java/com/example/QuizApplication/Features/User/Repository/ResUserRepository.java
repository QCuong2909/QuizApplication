package com.example.QuizApplication.Features.User.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.QuizApplication.Features.User.Model.ResUser;

@Repository
public interface ResUserRepository extends MongoRepository<ResUser, String> {
    Optional<ResUser> findByuserName(String userName);
}
