package com.telerikacademy;

public class Circle extends GraphicalElement implements Movable {
    private Point center;
    private int radius;

    public Circle(Color color, int x, int y, int radius) {
        super(color);
        center = new Point(x, y);
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.printf("I am a %s circle with center (%d, %d) and radius %d\n",
                getColor(), center.getX(), center.getY(), radius);
    }

    @Override
    public boolean select(Point topLeft, Point bottomRight) {
        return center.select(topLeft, bottomRight);
    }

    @Override
    public void move(int x, int y) {
        center.move(x, y);
    }
}
