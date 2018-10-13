package com.telerikacademy;

import java.util.ArrayList;

public class Application {
    private ArrayList<Channel> channels;
    private Channel currentChannel;

    public Application() {
        channels = new ArrayList<>();
    }

    public Channel getCurrentChannel() {
        return currentChannel;
    }

    public void createChannel(String name) {
        Channel channel = new Channel(name);
        channels.add(channel);
        currentChannel = channel;
    }

    public void changeCurrentChannel(String name) {
        for (Channel channel : channels) {
            if (channel.getName().equals(name)) {
                currentChannel = channel;
                break;
            }
        }
    }
}
