package com.telerikacademy.springiocdemo;


public class ConsoleLogger implements Logger {
    @Override
    public void logMessage(String message) {
        System.out.println(message);
    }
}
