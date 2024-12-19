package com.example.QuizApplication.Features.Session.Model;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import com.example.QuizApplication.Features.User.Model.ResUser;

@Document(collection = "sessions")
public class Session {
    @Id
    private String id;

    @NotEmpty(message = "Session ID is required")
    private String sessionId;

//     @NotEmpty(message = "Time log in is required")
     private LocalDateTime  timeLogIn;
     private LocalDateTime timeLogOut;

    @DocumentReference(lazy = true)
    @NotEmpty(message = "User ID is required")
    private ResUser userId;

    public Session(String sessionId, LocalDateTime  timeLogIn, ResUser uId) {
        this.sessionId = sessionId;
        this.timeLogIn = timeLogIn;
        this.userId = uId;
    }

    public Session(String userId, LocalDateTime now, String sessionId) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public LocalDateTime  getTimeLogIn() {
        return timeLogIn;
    }

    public void setTimeLogIn(LocalDateTime  timeLogIn) {
        this.timeLogIn = timeLogIn;
    }

    public LocalDateTime  getTimeLogOut() {
        return timeLogOut;
    }

    public void setTimeLogOut(LocalDateTime  timeLogOut) {
        this.timeLogOut = timeLogOut;
    }

    public ResUser getUserId() {
        return userId;
    }

    public void setUserId(ResUser uId) {
        this.userId = uId;
    }

    @Override
    public String toString() {
        return "Session{" +
                "id='" + id + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", timeLogIn=" + timeLogIn +
                ", timeLogOut=" + timeLogOut +
                ", uId=" + userId +
                '}';
    }
}
