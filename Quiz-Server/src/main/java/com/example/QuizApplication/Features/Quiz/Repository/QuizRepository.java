package com.example.QuizApplication.Features.Quiz.Repository;

import com.example.QuizApplication.Features.Quiz.Model.Quiz;
import com.mongodb.client.MongoDatabase;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuizRepository extends MongoRepository <Quiz, String> {
}
