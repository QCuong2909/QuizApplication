package com.example.QuizApplication.Features.Session.Model;

import com.example.QuizApplication.Features.Answer.Model.Answer;
import com.example.QuizApplication.Features.User.Model.ResUser;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.Date;

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
    private ResUser uId;

    public Session(String sessionId, LocalDateTime  timeLogIn, ResUser uId) {
        this.sessionId = sessionId;
        this.timeLogIn = timeLogIn;
        this.uId = uId;
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

    public ResUser getuId() {
        return uId;
    }

    public void setuId(ResUser uId) {
        this.uId = uId;
    }

    @Override
    public String toString() {
        return "Session{" +
                "id='" + id + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", timeLogIn=" + timeLogIn +
                ", timeLogOut=" + timeLogOut +
                ", uId=" + uId +
                '}';
    }
}
