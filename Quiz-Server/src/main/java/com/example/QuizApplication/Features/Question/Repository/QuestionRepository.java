package com.example.QuizApplication.Features.Question.Repository;

import com.example.QuizApplication.Features.Question.Model.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionRepository extends MongoRepository<Question, String> {
}
