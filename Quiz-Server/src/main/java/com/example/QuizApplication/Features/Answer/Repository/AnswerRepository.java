package com.example.QuizApplication.Features.Answer.Repository;

import com.example.QuizApplication.Features.Answer.Model.Answer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AnswerRepository extends MongoRepository<Answer, String> {
}
