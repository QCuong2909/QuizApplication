package com.example.QuizApplication.Common.Services;

import com.example.QuizApplication.Features.User.Model.ResUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JsonConverterService {

    private final ObjectMapper objectMapper;

    // Constructor to inject ObjectMapper (Spring provides this automatically)
    @Autowired
    public JsonConverterService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
     * Convert a JSON string to a User model.
     *
     * @param jsonResponse the JSON string to convert
     * @return the User object
     * @throws JsonProcessingException if the JSON is invalid or cannot be converted
     */
//    public ResUser getUserFromJson(String jsonResponse) throws JsonProcessingException {
//        return objectMapper.readValue(jsonResponse, ResUser.class);
//    }

    // You can also use this method for other models
    public <T> T getModelFromJson(String jsonResponse, Class<T> modelClass) throws JsonProcessingException {
        return objectMapper.readValue(jsonResponse, modelClass);
    }
}
