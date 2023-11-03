package org.example;

import java.awt.BorderLayout;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;


public class Capitalizer {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            var initialText = "Hello, can you speak english?";
            var area = new JTextArea(initialText, 8, 50);

            //Sets up the buttons
            var lowerCaseButton = new JButton("To lowercase");
            var upperCaseButton = new JButton("To uppercase");
            lowerCaseButton.addActionListener(e -> area.setText(area.getText().toLowerCase()));
            upperCaseButton.addActionListener(e -> area.setText(area.getText().toUpperCase()));

            //Sets up the panel
            var buttonPanel = new JPanel();
            buttonPanel.add(lowerCaseButton);
            buttonPanel.add(upperCaseButton);

            //Sets up the text on the frame
            var frame = new JFrame("Capitalizer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new JScrollPane(area), BorderLayout.CENTER);
            frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
            frame.pack();
            frame.setVisible(true);
        });
    }
}