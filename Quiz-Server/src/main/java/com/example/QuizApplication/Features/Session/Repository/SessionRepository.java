package com.example.QuizApplication.Features.Session.Repository;

import com.example.QuizApplication.Features.Quiz.Model.Quiz;
import com.example.QuizApplication.Features.Session.Model.Session;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SessionRepository extends MongoRepository<Session, String> {
    Optional<Session> findBySessionId(String sessionId);

    Optional<Session> findByUserId(String userId);
}
