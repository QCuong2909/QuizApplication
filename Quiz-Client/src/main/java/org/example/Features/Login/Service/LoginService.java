package org.example.Features.Login.Service;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class LoginService {

     public String loginUser(String userName, String password) {
        try {
            // Create URL object with the backend endpoint
            URL url = new URL("http://localhost:8080/login"); // Update with your actual backend URL

            // Open connection and set properties
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            // Create JSON payload
            JSONObject loginRequest = new JSONObject();
            loginRequest.put("userName", userName);
            loginRequest.put("password", password);

            // Send the request
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = loginRequest.toString().getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            // Get the response
            int statusCode = connection.getResponseCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    String inputLine;
                    StringBuilder response = new StringBuilder();
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    return response.toString();  // Return response as string
                }
            } else {
                return "{\"error\":\"Invalid username or password\"}";  // Handle error
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "{\"error\":\"An error occurred while processing the request\"}"; // Error message
        }
    }

}
