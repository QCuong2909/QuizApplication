package com.example.QuizApplication.Features.Quiz.Service;


import com.example.QuizApplication.Features.Quiz.Model.Quiz;
import com.example.QuizApplication.Features.Quiz.Repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    public Optional<Quiz> getById(String id) {
        return quizRepository.findById(id);
    }

    public List<Quiz> getAll() {
        return quizRepository.findAll();
    }

    public Quiz create(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public Quiz update(String id, Quiz updateQuiz) {
        Optional<Quiz> quiz = getById(id);
        if (quiz.isPresent()) {
            Quiz existingQuiz = quiz.get();
            existingQuiz.setPublish(updateQuiz.getPublish());
            existingQuiz.setTitle(updateQuiz.getTitle());
            existingQuiz.setSummary(updateQuiz.getSummary());
            existingQuiz.setScore(updateQuiz.getScore());
            existingQuiz.setListQuestion(updateQuiz.getListQuestion());
            existingQuiz.setHost(updateQuiz.getHost());
            return quizRepository.save(existingQuiz);
        } else {
            throw new RuntimeException("Quiz not found with id: " + id);
        }

    }

    ;

    public void delete(String id) {
        quizRepository.deleteById(id);
    }

}
