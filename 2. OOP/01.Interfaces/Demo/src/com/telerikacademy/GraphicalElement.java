package com.telerikacademy;

public abstract class GraphicalElement {
    private Color color;

    public GraphicalElement() {
        this.color = Color.BLACK;
    }

    public GraphicalElement(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public abstract void draw();
}
