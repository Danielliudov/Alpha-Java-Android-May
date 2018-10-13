package com.telerikacademy;

public class Point implements Movable {
    private int x, y;

    public Point() {
        this(0, 0);
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean select(Point topLeft, Point bottomRight) {
        return topLeft.getX() <= x &&
                x <= bottomRight.getX() &&
                bottomRight.getY() <= y &&
                y <= topLeft.getY();
    }

    @Override
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }
}
