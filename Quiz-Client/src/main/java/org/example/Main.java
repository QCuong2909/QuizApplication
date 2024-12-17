package org.example;

import org.example.Features.Plash.SplashScreen;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Run the application on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            new SplashScreen(); // Show the splash screen
        });
    }
}
