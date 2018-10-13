package com.telerikacademy;

import java.util.LinkedList;

public class TextMessage extends Message implements Likable {
    private String text;
    private int likesCount;

    public TextMessage(String author, String timestamp, String text) {
        super(author, timestamp);
        this.text = text;
        likesCount = 0;
    }

    @Override
    public void show() {
        System.out.printf("%s: %s (%d likes)\n", super.toString(), text, likesCount);
    }

    @Override
    public void like(String username) {
        likesCount++;
        System.out.printf("%s liked %s.\n", username, text);
    }

    @Override
    public int getLikesCount() {
        return likesCount;
    }
}
