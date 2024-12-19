package com.example.QuizApplication.Features.User.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class ResUser {
    @Id
    private String id;

    private String userName;
    private String password;
    private boolean isAdmin;

    public ResUser(String id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.isAdmin = false;
    }
    // Constructors, getters, setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override
    public String toString() {
        return "ResUser{" +
                "id='" + id + '\'' +
                ", username='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
