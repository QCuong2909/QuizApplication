package com.example.QuizApplication.Features.User.Controller;

import com.example.QuizApplication.Features.User.Model.ResUser;
import com.example.QuizApplication.Features.User.Service.ResUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private ResUserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody ResUser user) {
        try {
            ResUser newUser = userService.registerUser(user);
            return ResponseEntity.ok(Map.of("message", "User registered successfully", "userId", newUser.getId()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", "User registration failed"));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String, String> loginRequest) {
        String userName = loginRequest.get("userName");
        String password = loginRequest.get("password");

        return userService.loginUser(userName, password)
                .map(user -> ResponseEntity.ok(Map.of("message", "Login successful", "userId", user.getId())))
                .orElse(ResponseEntity.status(401).body(Map.of("error", "Invalid username or password")));
    }
}
