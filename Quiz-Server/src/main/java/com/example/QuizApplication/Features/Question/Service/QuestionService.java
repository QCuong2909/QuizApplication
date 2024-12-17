package com.example.QuizApplication.Features.Question.Service;

import com.example.QuizApplication.Features.Question.Model.Question;
import com.example.QuizApplication.Features.Question.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public Optional<Question> getById(String id) {
        return questionRepository.findById(id);
    }

    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    public Question create(Question question) {
        return questionRepository.save(question);
    }

    public Question update(String id, Question updateQuestion) {
        Optional<Question> question = getById(id);
        if (question.isPresent()) {
            Question existingQuestion = question.get();
            existingQuestion.setQuestionText(updateQuestion.getQuestionText());
            existingQuestion.setType(updateQuestion.getType());
            existingQuestion.setLevel(updateQuestion.getLevel());
            existingQuestion.setCorrectAnswer(updateQuestion.getCorrectAnswer());
            existingQuestion.setanswerOption(updateQuestion.getanswerOption());
            return questionRepository.save(existingQuestion);
        } else {
            throw new RuntimeException("Question not found with id: " + id);
        }
    }
    public void delete(String id) {
        questionRepository.deleteById(id);
    }




}
