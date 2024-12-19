package org.example.Features.Register.Screen;

import org.example.Features.Register.Services.RegisterService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class RegisterForm {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton registerButton;
    RegisterService registerService;
    public static RegisterForm instance;
    public RegisterForm() {
        // Initialize the JFrame
        frame = new JFrame("Register Form");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));

        // Title
        JLabel titleLabel = new JLabel("Register", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(0, 123, 255));

        // Panel for form inputs
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Form Fields
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        // Register Button
        registerButton = new JButton("Register");
        registerButton.setFont(new Font("Arial", Font.BOLD, 16));
        registerButton.setBackground(new Color(0, 123, 255));
        registerButton.setForeground(Color.WHITE);
        registerButton.setFocusPainted(false);
        registerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Add components to the panel
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel(""));
        panel.add(registerButton);

        // Add title and form panel to the frame
        frame.add(titleLabel, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);

        // Button ActionListener
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Both fields are required.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    boolean success = registerService.registerUser(username, password);
                    if (success) {
                        JOptionPane.showMessageDialog(frame, "User registered successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        frame.dispose(); // Close the form after successful registration
                    } else {
                        JOptionPane.showMessageDialog(frame, "Registration failed. Try again.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // Set frame size and center it
        frame.setSize(400, 250);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Singleton pattern - getInstance method
    public static RegisterForm getInstance() {
        if (instance == null) {
            instance = new RegisterForm();
        }
        return instance;
    }

    // Main method for testing
    public static void main(String[] args) {
        new RegisterForm();
    }
}
