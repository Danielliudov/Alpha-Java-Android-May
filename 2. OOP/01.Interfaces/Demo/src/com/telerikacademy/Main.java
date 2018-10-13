package com.telerikacademy;

public class Main {

    public static void main(String[] args) {
        Canvas canvas = new Canvas();

        canvas.addCircle(Color.RED, 1, 1, 2);
        canvas.addRectangle(Color.GREEN, -1, 1, 2, 3);
        canvas.addCurve(Color.BLACK, 2);

        canvas.render();

        canvas.select(0, 2, 2, 0);
        canvas.move(1, 1);

        canvas.render();
    }
}
