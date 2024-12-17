package org.example.Features.Plash;

import org.example.Features.Login.Screen.LoginForm;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class SplashScreen {
    private JFrame frame;

    public SplashScreen() {
        // Create a JFrame for the splash screen
        frame = new JFrame("Splash Screen");
        frame.setSize(500, 300);
        frame.setUndecorated(true); // Remove title bar
        frame.setLocationRelativeTo(null); // Center the splash screen on the screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add a panel with a soft background color
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(243, 243, 243)); // Soft background color

        // Add logo or welcome text
        JLabel logoLabel = new JLabel("Welcome to Quiz App", SwingConstants.CENTER);
        logoLabel.setFont(new Font("Arial", Font.BOLD, 32));
        logoLabel.setForeground(new Color(0, 123, 255)); // Friendly color for the text
        panel.add(logoLabel, BorderLayout.CENTER);

        // Add a loading message
        JLabel loadingLabel = new JLabel("Loading...", SwingConstants.CENTER);
        loadingLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        loadingLabel.setForeground(Color.GRAY);
        panel.add(loadingLabel, BorderLayout.SOUTH);

        // Set padding for the panel
        panel.setBorder(new EmptyBorder(50, 50, 50, 50));

        // Add panel to the frame
        frame.add(panel);
        frame.setVisible(true);

        // Use a timer to delay the splash screen for 3 seconds
        new Timer(3000, e -> {
            frame.dispose(); // Close splash screen
            LoginForm.getInstance(); // Open the login form
        }).start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SplashScreen::new); // Initialize SplashScreen
    }
}
