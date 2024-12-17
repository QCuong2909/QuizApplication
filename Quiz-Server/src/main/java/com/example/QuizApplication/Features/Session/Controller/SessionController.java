package com.example.QuizApplication.Features.Session.Controller;

import com.example.QuizApplication.Features.Session.Model.Session;
import com.example.QuizApplication.Features.Session.Service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/sessions")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    // Endpoint to create a session
    @PostMapping("/start")
    public ResponseEntity<?> startSession(@RequestParam String userId, @RequestParam String sessionId) {
        Session session = sessionService.create(userId, sessionId);
        return ResponseEntity.ok(session);
    }

    // Endpoint to end a session
    @PostMapping("/end")
    public ResponseEntity<?> endSession(@RequestParam String sessionId) {
        Session session = sessionService.endSession(sessionId);
        return ResponseEntity.ok(session);
    }

    // Endpoint to get a session by session ID
    @GetMapping("/{sessionId}")
    public ResponseEntity<?> getSessionById(@PathVariable String sessionId) {
        Optional<Session> session = sessionService.getById(sessionId);
        return session.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint to get a session by user ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getSessionByUserId(@PathVariable String userId) {
        Optional<Session> session = sessionService.getByUserId(userId);
        return session.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
