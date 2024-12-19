package org.example.Features.Home.Screen;

import org.example.Features.LeaderBoard.Screen.LeaderboardScreen;
import org.example.Features.Login.Screen.LoginForm;
import org.example.Features.Quiz.Screen.QuizScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeScreen {
    private JFrame frame;
    private JButton leaderboardButton;
    private JButton quizButton;
    private JButton logoutButton;
    private JLabel welcomeLabel;

    // Singleton instance
    private static HomeScreen instance;

    // Private constructor
    private HomeScreen() {
        // Initialize JFrame
        frame = new JFrame("Home - Quiz Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set layout manager for flexibility
        frame.setLayout(new BorderLayout(10, 10));

        // Create a panel for the home screen UI
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));
        panel.setBackground(new Color(255, 255, 255)); // White background
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Padding

        // Welcome label
        welcomeLabel = new JLabel("Welcome to the Quiz Application", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        welcomeLabel.setForeground(new Color(0, 123, 255));  // Friendly blue color

        // Buttons for navigation
        leaderboardButton = new JButton("Leaderboard");
        leaderboardButton.setFont(new Font("Arial", Font.BOLD, 16));
        leaderboardButton.setBackground(new Color(0, 123, 255));
        leaderboardButton.setForeground(Color.WHITE);
        leaderboardButton.setFocusPainted(false);
        leaderboardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        quizButton = new JButton("Start Quiz");
        quizButton.setFont(new Font("Arial", Font.BOLD, 16));
        quizButton.setBackground(new Color(0, 123, 255));
        quizButton.setForeground(Color.WHITE);
        quizButton.setFocusPainted(false);
        quizButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Logout Button
        logoutButton = new JButton("Logout");
        logoutButton.setFont(new Font("Arial", Font.BOLD, 16));
        logoutButton.setBackground(new Color(220, 53, 69)); // Red color for logout
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setFocusPainted(false);
        logoutButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Add components to the panel
        panel.add(welcomeLabel);
        panel.add(leaderboardButton);
        panel.add(quizButton);
        panel.add(logoutButton);

        // Add the panel to the frame
        frame.add(panel, BorderLayout.CENTER);

        // Button ActionListener for leaderboard button
        leaderboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Navigate to leaderboard screen
                LeaderboardScreen.getInstance();
                frame.dispose(); // Close home screen
            }
        });

        // Button ActionListener for quiz button
        quizButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Navigate to quiz screen
                QuizScreen.getInstance();
                frame.dispose(); // Close home screen
            }
        });

        // Button ActionListener for logout button
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the current frame and open the login screen
                LoginForm.getInstance(); // Navigate back to the login screen
                frame.dispose(); // Close home screen
            }
        });

        // Set the size of the frame based on screen size (60% width, 50% height)
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) (screenSize.width * 0.6);  // 60% of screen width
        int height = (int) (screenSize.height * 0.5);  // 50% of screen height
        frame.setSize(width, height);  // Set the size of the frame
        frame.setLocationRelativeTo(null);  // Center on screen

        // Make the frame resize dynamically
        frame.setResizable(true);

        // Display the frame
        frame.setVisible(true);
    }

    // Singleton pattern - getInstance method
    public static HomeScreen getInstance() {
        if (instance == null) {
            instance = new HomeScreen();
        }
        return instance;
    }

    // Main method for testing
    public static void main(String[] args) {
        HomeScreen.getInstance(); // Show the home screen
    }
}
