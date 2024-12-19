package org.example.Features.LeaderBoard.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.example.Features.Home.Screen.HomeScreen;  // Correct import for HomeScreen

public class LeaderboardScreen {
    private JFrame frame;
    private JLabel leaderboardLabel;
    private JTextArea leaderboardTextArea;
    private JButton backButton;

    // Singleton instance
    private static LeaderboardScreen instance;

    // Private constructor
    private LeaderboardScreen() {
        // Initialize JFrame
        frame = new JFrame("Leaderboard - Quiz Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set layout manager for flexibility
        frame.setLayout(new BorderLayout(10, 10));

        // Create a panel for the leaderboard screen UI
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));
        panel.setBackground(new Color(255, 255, 255)); // White background
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Padding

        // Leaderboard label
        leaderboardLabel = new JLabel("Leaderboard", JLabel.CENTER);
        leaderboardLabel.setFont(new Font("Arial", Font.BOLD, 20));
        leaderboardLabel.setForeground(new Color(0, 123, 255));  // Friendly blue color

        // Text area for displaying leaderboard
        leaderboardTextArea = new JTextArea();
        leaderboardTextArea.setFont(new Font("Arial", Font.PLAIN, 14));
        leaderboardTextArea.setEditable(false);
        leaderboardTextArea.setText("1. User A - 100 points\n2. User B - 90 points\n3. User C - 85 points\n...");

        // Back button to return to home screen
        backButton = new JButton("Back to Home");
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.setBackground(new Color(0, 123, 255));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Add components to the panel
        panel.add(leaderboardLabel, BorderLayout.NORTH);
        panel.add(new JScrollPane(leaderboardTextArea), BorderLayout.CENTER);
        panel.add(backButton, BorderLayout.SOUTH);

        // Add the panel to the frame
        frame.add(panel, BorderLayout.CENTER);

        // Button ActionListener
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Return to home screen
                HomeScreen.getInstance();
                frame.dispose(); // Close the leaderboard screen
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
    public static LeaderboardScreen getInstance() {
        if (instance == null) {
            instance = new LeaderboardScreen();
        }
        return instance;
    }

    // Main method for testing
    public static void main(String[] args) {
        LeaderboardScreen.getInstance(); // Show the leaderboard screen
    }
}
