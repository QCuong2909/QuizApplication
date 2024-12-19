package com.example.QuizApplication.Features.Session.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.QuizApplication.Features.Session.Model.Session;

public interface SessionRepository extends MongoRepository<Session, String> {
    Optional<Session> findBySessionId(String sessionId);

    Optional<Session> findByUserId(String uId);
}
