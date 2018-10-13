package com.telerikacademy;

import java.util.ArrayList;

public class Canvas {
    private ArrayList<GraphicalElement> allElements;
    private ArrayList<Movable> selectableElements;
    private ArrayList<Movable> selectedElements;

    public Canvas() {
        allElements = new ArrayList<>();
        selectableElements = new ArrayList<>();
        selectedElements = new ArrayList<>();
    }

    public void addCircle(Color color, int x, int y, int radius) {
        Circle c = new Circle(color, x, y, radius);
        allElements.add(c);
        selectableElements.add(c);
    }

    public void addRectangle(Color color, int x, int y, int width, int height) {
        Rectangle r = new Rectangle(color, x, y, width, height);
        allElements.add(r);
        selectableElements.add(r);
    }

    public void addCurve(Color color, int weight) {
        allElements.add(new Curve(color, weight));
    }

    public void render() {
        for (GraphicalElement e : allElements) {
            e.draw();
        }
    }

    public void select(int topLeftX, int topLeftY, int bottomRightX, int bottomRightY) {
        selectedElements.clear();
        for (Movable element : selectableElements) {
            if (element.select(new Point(topLeftX, topLeftY),
                    new Point(bottomRightX, bottomRightY))) {
                selectedElements.add(element);
            }
        }
    }

    public void move(int x, int y) {
        for (Movable element : selectedElements) {
            element.move(x, y);
        }
    }
}
