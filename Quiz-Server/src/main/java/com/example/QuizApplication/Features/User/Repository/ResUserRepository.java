package com.example.QuizApplication.Features.User.Repository;

import com.example.QuizApplication.Features.User.Model.ResUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ResUserRepository extends MongoRepository<ResUser, String> {
    Optional<ResUser> findByUserName(String userName);
}
