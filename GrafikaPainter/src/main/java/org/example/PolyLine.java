package org.example;

import java.awt.Graphics;
import java.util.*;

public class PolyLine {
    private List<Integer> xList;
    private  List<Integer> yList;

    //Constructor
    public PolyLine(){
        xList = new ArrayList<Integer>();
        yList = new ArrayList<Integer>();
    }

    //Adds a point to this PolyLine
    public void addPoint(int x, int y){
        xList.add(x);
        yList.add(y);
    }

    //This PolyLine draws itself given the content in Graphics
    public void draw (Graphics g){
        for (int i = 0; i < xList.size() - 1; i++) {
            g.drawLine((int)xList.get(i), (int)yList.get(i), (int)xList.get(i+1), (int)yList.get(i+1));
        }
    }
}
