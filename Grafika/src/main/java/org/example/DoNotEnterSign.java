package org.example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DoNotEnterSign extends JPanel {
    //The drawing is defined as JPanel using javax.swing.
    //It is a component you can draw in.
    private static final long serialVersionUID = 7148504528835036003L;

    public void paintComponent(Graphics g){

        //Every time the system detects that a component needs to be painted (e.g., it is made visible for the first time, or its window was resized),
        //It calls its paintComponent method and passes it a Graphics object.
        super.paintComponent(g);

        //Setting up the variables
        //You can read the component’s current size at any time with the graphics object’s getWidth() and getHeight() methods.
        var center = new Point(getWidth() / 2, getHeight() / 2);
        var radius = Math.min(getWidth() / 2, getHeight() / 2) - 5;
        var diameter = radius * 2;
        var innerRadius = (int)(radius * 0.9);
        var innerDiameter = innerRadius * 2;
        var barWidth = (int)(innerRadius * 1.4);
        var barHeight = (int)(innerRadius * 0.35);


        //Drawing the sign using the variables (the window resizes the drawing dynamically).
        g.setColor(Color.WHITE);
        g.fillOval(center.x - radius, center.y - radius, diameter, diameter);
        g.setColor(Color.RED);
        g.fillOval(center.x - innerRadius, center.y - innerRadius, innerDiameter, innerDiameter);
        g.setColor(Color.WHITE);
        g.fillRect(center.x - barWidth/2, center.y - barHeight/2, barWidth, barHeight);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            var panel = new DoNotEnterSign();
            panel.setBackground(Color.GREEN.darker());
            var frame = new JFrame("A simple graphics program");
            frame.setSize(400,300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(panel, BorderLayout.CENTER);
            frame.setVisible(true);
        });
    }
}