package com.example.QuizApplication.Features.Quiz.Model;

import com.example.QuizApplication.Features.User.Model.ResUser;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.List;

@Document(collection = "quiz")
public class Quiz {

    @Id
    private String id;

    @NotEmpty(message = "Title is required")
    private String title;

    @NotEmpty(message = "Summary is required")
    private String summary;

    @Positive(message = "Score must be positive")
    private int score;

    @NotEmpty(message = "List question must no empty")
    private List<String> listQuestion;

    private boolean isPublish;

    @DocumentReference(lazy = true)
    private ResUser host;

    public Quiz(String id, String title, String summary, int score, List<String> listQuestion, boolean isPublish, ResUser host) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.score = score;
        this.listQuestion = listQuestion;
        this.isPublish = isPublish;
        this.host = host;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<String> getListQuestion() {
        return listQuestion;
    }

    public void setListQuestion(List<String> listQuestion) {
        this.listQuestion = listQuestion;
    }

    public boolean getPublish() {
        return isPublish;
    }

    public void setPublish(boolean isPublish) {
        this.isPublish = isPublish;
    }

    public ResUser getHost() {
        return host;
    }

    public void setHost(ResUser host) {
        this.host = host;
    }


}
