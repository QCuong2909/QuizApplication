package com.example.QuizApplication.Features.User.Service;

import com.example.QuizApplication.Features.User.Model.ResUser;
import com.example.QuizApplication.Features.User.Repository.ResUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResUserService {

    @Autowired
    private ResUserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public ResUser registerUser(ResUser user) {
        // Encode the password before saving to database
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public Optional<ResUser> loginUser(String userName, String password) {
        Optional<ResUser> user = userRepository.findByUserName(userName);
        if (user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())) {
            return user;
        }
        return Optional.empty();
    }
}
