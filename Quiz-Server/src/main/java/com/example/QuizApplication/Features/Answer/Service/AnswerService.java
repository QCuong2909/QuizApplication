package com.example.QuizApplication.Features.Answer.Service;


import com.example.QuizApplication.Features.Answer.Model.Answer;
import com.example.QuizApplication.Features.Answer.Repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    public Optional<Answer> getById(String id) {
        return answerRepository.findById(id);
    }

    public List<Answer> getAll() {
        return answerRepository.findAll();
    }

    public Answer create(Answer answer) {
        return answerRepository.save(answer);
    }

    public Answer update(String id, Answer updateAnswer) {
        Optional<Answer> answer = getById(id);
        if (answer.isPresent()) {
            Answer existingAnswer = answer.get();
            existingAnswer.setAnswerText(updateAnswer.getAnswerText());
            return answerRepository.save(existingAnswer);
        } else {
            throw new RuntimeException("Answer not found with id: " + id);
        }
    }
    public void delete(String id) {
        answerRepository.deleteById(id);
    }

}
