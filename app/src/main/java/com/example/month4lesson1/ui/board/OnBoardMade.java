package com.example.month4lesson1.ui.board;
public class OnBoardMade {
    private String title, decription;
    private int image;

    public OnBoardMade(String title, String decription, int image) {
        this.title = title;
        this.decription = decription;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getDecription() {
        return decription;
    }

    public int getImage() {
        return image;
    }
}
