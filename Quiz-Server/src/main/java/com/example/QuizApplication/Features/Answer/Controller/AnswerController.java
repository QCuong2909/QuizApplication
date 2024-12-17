package com.example.QuizApplication.Features.Answer.Controller;

import com.example.QuizApplication.Features.Answer.Model.Answer;
import com.example.QuizApplication.Features.Answer.Service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/answer")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    // Endpoint to get all answers
    @GetMapping("/")
    public List<Answer> getAllAnswers() {
        return answerService.getAll();
    }

    // Endpoint to get an answer by its ID
    @GetMapping("/{id}")
    public ResponseEntity<Answer> getAnswerById(@PathVariable("id") String id) {
        Optional<Answer> answer = answerService.getById(id);
        return answer.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(null));
    }

    // Endpoint to create a new answer
    @PostMapping("/")
    public ResponseEntity<Answer> createAnswer(@RequestBody Answer answer) {
        Answer createdAnswer = answerService.create(answer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAnswer);
    }

    // Endpoint to update an existing answer
    @PutMapping("/{id}")
    public ResponseEntity<Answer> updateAnswer(@PathVariable("id") String id, @RequestBody Answer updateAnswer) {
        try {
            Answer updatedAnswer = answerService.update(id, updateAnswer);
            return ResponseEntity.ok(updatedAnswer);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    // Endpoint to delete an answer by its ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnswer(@PathVariable("id") String id) {
        answerService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
