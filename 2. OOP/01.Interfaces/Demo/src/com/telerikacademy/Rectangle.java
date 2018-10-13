package com.telerikacademy;

public class Rectangle extends GraphicalElement implements Movable {
    private Point topLeftCorner;
    private int width, height;

    public Rectangle(Color color, int x, int y, int width, int height) {
        super(color);
        topLeftCorner = new Point(x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.printf("I am a %s rectangle with top left corner (%d, %d) and dimensions (%d, %d)\n",
                getColor(), topLeftCorner.getX(), topLeftCorner.getY(), width, height);
    }

    @Override
    public boolean select(Point topLeft, Point bottomRight) {
        return topLeftCorner.select(topLeft, bottomRight);
    }

    @Override
    public void move(int x, int y) {
        topLeftCorner.move(x, y);
    }
}
