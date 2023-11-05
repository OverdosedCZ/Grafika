package org.example;

import java.util.List;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyPaint extends JFrame {

    // Define constants for the various dimensions
    public static final int CANVAS_WIDTH = 500;
    public static final int CANVAS_HEIGHT = 300;
    public static final Color LINE_COLOR = Color.RED;


    // Lines drawn, consists of a List of PolyLine instances
    private List<PolyLine> lines = new ArrayList<PolyLine>();
    private PolyLine currentLine;


    // Constructor to set up the GUI components and event handlers
    public MyPaint(){
        DrawCanvas canvas = new DrawCanvas();
        canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt){
                currentLine = new PolyLine();
                lines.add(currentLine);
                currentLine.addPoint(evt.getX(), evt.getY());
            }
        });

        canvas.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent evt) {
                currentLine.addPoint(evt.getX(), evt.getY());
                repaint(); // invoke paintComponent()
            }
        });

        setContentPane(canvas);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Paint");
        pack();
        setVisible(true);

    }

    // Define inner class DrawCanvas, which is a JPanel used for custom drawing
    private class DrawCanvas extends JPanel{
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(LINE_COLOR);
            for (PolyLine line: lines){
                line.draw(g);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyPaint();
            }
        });
    }
}