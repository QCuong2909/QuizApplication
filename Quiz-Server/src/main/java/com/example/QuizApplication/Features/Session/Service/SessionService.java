package com.example.QuizApplication.Features.Session.Service;


import com.example.QuizApplication.Features.Session.Model.Session;
import com.example.QuizApplication.Features.Session.Repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    public Optional<Session> getById(String id) {
        return sessionRepository.findBySessionId(id);
    }
    public Optional<Session> getByUserId(String userId){
        return sessionRepository.findByUserId(userId);
    };

    public List<Session> getAll() {
        return sessionRepository.findAll();
    }

    public Session create(String userId,String sessionId) {
        Session session = new Session(
                userId, LocalDateTime.now(),sessionId
        );

        return sessionRepository.save(session);
    }
    // Update session with logout time
    public Session endSession(String sessionId) {
        Optional<Session> optionalSession = sessionRepository.findBySessionId(sessionId);

        if (optionalSession.isPresent()) {
            Session session = optionalSession.get();
            session.setTimeLogOut(LocalDateTime.now());
            return sessionRepository.save(session);
        } else {
            throw new RuntimeException("Session not found");
        }
    }
    public void delete(String id) {
        sessionRepository.deleteById(id);
    }

}
