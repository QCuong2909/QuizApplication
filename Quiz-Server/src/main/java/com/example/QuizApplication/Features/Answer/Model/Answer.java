package com.example.QuizApplication.Features.Answer.Model;

import com.example.QuizApplication.Features.User.Model.ResUser;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Document(collection = "answer")

public class Answer {
    @Id
    private String id;

    @NotEmpty(message = "Answer text is required")
    private String answerText;

    public Answer(String id, String answerText) {
        this.id = id;
        this.answerText = answerText;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id='" + id + '\'' +
                ", answerText='" + answerText + '\'' +
                '}';
    }
}
