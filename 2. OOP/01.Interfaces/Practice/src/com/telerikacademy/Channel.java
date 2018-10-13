package com.telerikacademy;

import java.util.ArrayList;

public class Channel {
    private String name;
    private ArrayList<Message> messages;
    private ArrayList<Likable> likableMessages;
    private ArrayList<Downloadable> downloadableMessages;

    public Channel(String name) {
        this.name = name;
        messages = new ArrayList<>();
        likableMessages = new ArrayList<>();
        downloadableMessages = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void postText(String author, String timestamp, String text) {
        TextMessage message = new TextMessage(author, timestamp, text);
        messages.add(message);
        likableMessages.add(message);

    }

    public void postImage(String author, String timestamp, String imageName) {
        ImageMessage message = new ImageMessage(author, timestamp, imageName);
        messages.add(message);
        likableMessages.add(message);
        downloadableMessages.add(message);
    }

    public void postIcon(String author, String timestamp, EmotIcon icon) {
        IconMessage message = new IconMessage(author, timestamp, icon);
        messages.add(message);
    }

    public void postFile(String author, String timestamp, String fileName) {
        FileMessage message = new FileMessage(author, timestamp, fileName);
        messages.add(message);
        downloadableMessages.add(message);
    }

    public void listHistory() {
        for (Message message : messages) {
            message.show();
        }
    }

    public void clearHistory() {
        messages.clear();
        likableMessages.clear();
        downloadableMessages.clear();
    }

    public void likeMessage(String timestamp, String username) {
        for (Likable message : likableMessages) {
            if (((Message) message).getTimestamp().equals(timestamp)) {
                message.like(username);
            }
        }
    }

    public void downloadMessage(String timestamp, String targetPath) {
        for (Downloadable message : downloadableMessages) {
            if (((Message) message).getTimestamp().equals(timestamp)) {
                message.download(targetPath);
            }
        }
    }
}
