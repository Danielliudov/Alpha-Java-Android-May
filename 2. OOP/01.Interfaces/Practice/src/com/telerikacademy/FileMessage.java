package com.telerikacademy;

public class FileMessage extends Message implements Downloadable {
    private String fileName;

    public FileMessage(String author, String timestamp, String fileName) {
        super(author, timestamp);
        this.fileName = fileName;
    }

    @Override
    public void show() {
        System.out.printf("%s: %s file [Download]\n", super.toString(), fileName);
    }

    @Override
    public void download(String targetPath) {
        System.out.printf("%s file was downloaded to %s.\n", fileName, targetPath);
    }
}
