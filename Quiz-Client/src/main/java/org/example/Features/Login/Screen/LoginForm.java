package org.example.Features.Login.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm {
    private JFrame frame;
    private JTextField userNameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    // Singleton instance
    private static LoginForm instance;

    // Private constructor
    private LoginForm() {
        // Initialize JFrame
        frame = new JFrame("Login Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set layout manager for flexibility
        frame.setLayout(new BorderLayout(10, 10));

        // Create a panel for the form with rounded corners and background color
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));
        panel.setBackground(new Color(255, 255, 255)); // White background for the form
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Padding

        // UI Components
        JLabel userNameLabel = new JLabel("Username:");
        userNameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        userNameField = new JTextField();
        userNameField.setFont(new Font("Arial", Font.PLAIN, 14));

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));

        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        loginButton.setBackground(new Color(0, 123, 255));  // Friendly blue color
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Add components to the panel
        panel.add(userNameLabel);
        panel.add(userNameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel("")); // Empty space
        panel.add(loginButton);

        // Add the panel to the frame
        frame.add(panel, BorderLayout.CENTER);

        // Button ActionListener
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = userNameField.getText();
                String password = new String(passwordField.getPassword());
                JOptionPane.showMessageDialog(frame, "Username: " + userName + "\nPassword: " + password);
            }
        });

        // Make the window size flexible based on screen size (40% width, 30% height)
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) (screenSize.width * 0.4);  // 40% of screen width
        int height = (int) (screenSize.height * 0.3);  // 30% of screen height
        frame.setSize(width, height);  // Set the size of the frame
        frame.setLocationRelativeTo(null);  // Center on screen

        // Display the frame
        frame.setVisible(true);
    }

    // Singleton pattern - getInstance method
    public static LoginForm getInstance() {
        if (instance == null) {
            instance = new LoginForm();
        }
        return instance;
    }

    // Main method for testing
    public static void main(String[] args) {
        LoginForm.getInstance(); // Show the login form
    }
}
