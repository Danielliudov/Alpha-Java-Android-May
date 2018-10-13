package com.telerikacademy;

public class ImageMessage extends Message implements Likable, Downloadable {
    private String imageName;
    private int likesCount;

    public ImageMessage(String author, String timestamp, String imageName) {
        super(author, timestamp);
        this.imageName = imageName;
        likesCount = 0;
    }


    @Override
    public void show() {
        System.out.printf("%s: %s image (%d likes) [Download]\n", super.toString(), imageName, likesCount);
    }

    @Override
    public void like(String username) {
        likesCount++;
        System.out.printf("%s liked %s.\n", username, imageName);
    }

    @Override
    public int getLikesCount() {
        return likesCount;
    }

    @Override
    public void download(String targetPath) {
        System.out.printf("%s image was downloaded to %s.\n", imageName, targetPath);
    }
}
