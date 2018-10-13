package com.telerikacademy;

public abstract class Message {
    private String author, timestamp;

    public Message(String author, String timestamp) {
        this.author = author;
        this.timestamp = timestamp;
    }

    public String getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return String.format("[%s](%s)", timestamp, author);
    }

    public abstract void show();
}
