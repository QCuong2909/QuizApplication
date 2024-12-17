package com.example.QuizApplication.Features.Question.Model;

import com.example.QuizApplication.Features.Answer.Model.Answer;
import com.example.QuizApplication.Features.User.Model.ResUser;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Document(collection = "question")

public class Question {
    @Id
    private String id;

    @NotEmpty(message = "Level is required")
    private String level;

    @NotEmpty(message = "Type is required")
    private String type;

    @NotEmpty(message = "Question text is required")
    private String questionText;

    @NotEmpty(message = "The option is required")
    private List<String> answerOption;

    @DocumentReference(lazy = true)
    @NotEmpty(message = "The correct answer is required")
    private Answer correctAnswer;

    public Question(String id, String level, String type, String questionText, List<String> answerOption, Answer correctAnswer) {
        this.id = id;
        this.level = level;
        this.type = type;
        this.questionText = questionText;
        this.answerOption = answerOption;
        this.correctAnswer = correctAnswer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<String> getanswerOption() {
        return answerOption;
    }

    public void setanswerOption(List<String> answerOption) {
        this.answerOption = answerOption;
    }



    public Answer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Answer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id='" + id + '\'' +
                ", level='" + level + '\'' +
                ", type='" + type + '\'' +
                ", questionText='" + questionText + '\'' +
                ", option=" + answerOption +
                ", correctAnswer=" + correctAnswer +
                '}';
    }
}
