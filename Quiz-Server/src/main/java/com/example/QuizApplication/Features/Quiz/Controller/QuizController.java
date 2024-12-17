package com.example.QuizApplication.Features.Quiz.Controller;

import com.example.QuizApplication.Features.Quiz.Model.Quiz;
import com.example.QuizApplication.Features.Quiz.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    // Endpoint to get all quizzes
    @GetMapping("/")
    public List<Quiz> getAllQuizzes() {
        return quizService.getAll();
    }

    // Endpoint to get a quiz by its ID
    @GetMapping("/{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable("id") String id) {
        Optional<Quiz> quiz = quizService.getById(id);
        return quiz.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(null));
    }

    // Endpoint to create a new quiz
    @PostMapping("/")
    public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz) {
        Quiz createdQuiz = quizService.create(quiz);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdQuiz);
    }

    // Endpoint to update an existing quiz
    @PutMapping("/{id}")
    public ResponseEntity<Quiz> updateQuiz(@PathVariable("id") String id, @RequestBody Quiz updateQuiz) {
        try {
            Quiz updatedQuiz = quizService.update(id, updateQuiz);
            return ResponseEntity.ok(updatedQuiz);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    // Endpoint to delete a quiz by its ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuiz(@PathVariable("id") String id) {
        quizService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
