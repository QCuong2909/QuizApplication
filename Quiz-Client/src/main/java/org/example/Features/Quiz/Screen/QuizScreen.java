package org.example.Features.Quiz.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.example.Features.Home.Screen.HomeScreen;  // Correct import for HomeScreen

public class QuizScreen {
    private JFrame frame;
    private JLabel questionLabel;
    private JRadioButton option1, option2, option3, option4;
    private JButton nextButton;
    private ButtonGroup optionsGroup;

    // Singleton instance
    private static QuizScreen instance;

    // Private constructor
    private QuizScreen() {
        // Initialize JFrame
        frame = new JFrame("Quiz - Quiz Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set layout manager for flexibility
        frame.setLayout(new BorderLayout(10, 10));

        // Create a panel for the quiz screen UI
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1, 10, 10));
        panel.setBackground(new Color(255, 255, 255)); // White background
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Padding

        // Quiz question label
        questionLabel = new JLabel("What is the capital of France?", JLabel.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 18));
        questionLabel.setForeground(new Color(0, 123, 255));  // Friendly blue color

        // Answer options
        option1 = new JRadioButton("Berlin");
        option2 = new JRadioButton("Madrid");
        option3 = new JRadioButton("Paris");
        option4 = new JRadioButton("Rome");

        // Group the radio buttons
        optionsGroup = new ButtonGroup();
        optionsGroup.add(option1);
        optionsGroup.add(option2);
        optionsGroup.add(option3);
        optionsGroup.add(option4);

        // Next button
        nextButton = new JButton("Next");
        nextButton.setFont(new Font("Arial", Font.BOLD, 16));
        nextButton.setBackground(new Color(0, 123, 255));
        nextButton.setForeground(Color.WHITE);
        nextButton.setFocusPainted(false);
        nextButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Add components to the panel
        panel.add(questionLabel);
        panel.add(option1);
        panel.add(option2);
        panel.add(option3);
        panel.add(option4);
        panel.add(nextButton);

        // Add the panel to the frame
        frame.add(panel, BorderLayout.CENTER);

        // Button ActionListener for next button
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // For simplicity, we just display a message (you can add more complex logic here)
                if (option3.isSelected()) {
                    JOptionPane.showMessageDialog(frame, "Correct Answer!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Wrong Answer!");
                }
                // Move to the next question (for now, just refresh the same screen)
                // You can replace this with actual quiz logic for question navigation
                QuizScreen.getInstance();
                frame.dispose(); // Close the quiz screen
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
    public static QuizScreen getInstance() {
        if (instance == null) {
            instance = new QuizScreen();
        }
        return instance;
    }

    // Main method for testing
    public static void main(String[] args) {
        QuizScreen.getInstance(); // Show the quiz screen
    }
}
