package com.lyecdevelopers.learncomputers.models;

public class Notes {

    String title;
    String descrpiton;

    public Notes(String title, String descrpiton) {
        this.title = title;
        this.descrpiton = descrpiton;
    }

    public Notes() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
