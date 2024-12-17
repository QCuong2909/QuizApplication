package com.example.QuizApplication.Features.Question.Controller;

import com.example.QuizApplication.Features.Question.Model.Question;
import com.example.QuizApplication.Features.Question.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    // Endpoint to get all questions
    @GetMapping("/")
    public List<Question> getAllQuestions() {
        return questionService.getAll();
    }

    // Endpoint to get a question by its ID
    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable("id") String id) {
        Optional<Question> question = questionService.getById(id);
        return question.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(null));
    }

    // Endpoint to create a new question
    @PostMapping("/")
    public ResponseEntity<Question> createQuestion(@RequestBody Question question) {
        Question createdQuestion = questionService.create(question);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdQuestion);
    }

    // Endpoint to update an existing question
    @PutMapping("/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable("id") String id, @RequestBody Question updateQuestion) {
        try {
            Question updatedQuestion = questionService.update(id, updateQuestion);
            return ResponseEntity.ok(updatedQuestion);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    // Endpoint to delete a question by its ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable("id") String id) {
        questionService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
