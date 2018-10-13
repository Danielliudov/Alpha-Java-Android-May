package com.telerikacademy;

public class Main {

    public static void main(String[] args) {
        Application slack = new Application();

        slack.createChannel("Default");
        slack.getCurrentChannel().postText("Pesho", "10:15", "Hello :)");
        slack.getCurrentChannel().postIcon("Pesho", "10:16", EmotIcon.SMILE);
        slack.getCurrentChannel().listHistory();

        slack.getCurrentChannel().likeMessage("10:16", "Pesho");
        slack.getCurrentChannel().listHistory();

        slack.getCurrentChannel().postImage("Gosho", "10:20", "Mountain");
        slack.getCurrentChannel().likeMessage("10:20", "Pesho");
        slack.getCurrentChannel().downloadMessage("10:20", "c:\\images");
        slack.getCurrentChannel().listHistory();
    }
}
