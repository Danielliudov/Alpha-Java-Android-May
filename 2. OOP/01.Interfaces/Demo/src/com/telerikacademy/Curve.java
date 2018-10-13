package com.telerikacademy;

public class Curve extends GraphicalElement {
    private int weight;

    public Curve(Color color, int weight) {
        super(color);
        this.weight = weight;
    }

    @Override
    public void draw() {
        System.out.printf("I am a %s curve with weight %d\n",
                getColor(), weight);
    }
}
