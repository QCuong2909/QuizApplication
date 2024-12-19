package org.example.Features.Register.Services;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class RegisterService {

    public boolean registerUser(String username, String password) {
        try {
            // Backend API endpoint
            URL url = new URL("http://localhost:8080/register");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            // JSON payload
            String payload = String.format(
                    "{\"userName\":\"%s\",\"password\":\"%s\"}",
                    username, password
            );

            // Send the request
            conn.setDoOutput(true);
            try (OutputStream os = conn.getOutputStream()) {
                os.write(payload.getBytes());
                os.flush();
            }

            // Handle response
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
