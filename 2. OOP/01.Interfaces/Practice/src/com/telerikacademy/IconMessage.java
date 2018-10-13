package com.telerikacademy;

public class IconMessage extends Message {
    private EmotIcon iconType;

    public IconMessage(String author, String timestamp, EmotIcon iconType) {
        super(author, timestamp);
        this.iconType = iconType;
    }

    @Override
    public void show() {
        System.out.printf("%s: %s emot icon\n", super.toString(), iconType);
    }
}
