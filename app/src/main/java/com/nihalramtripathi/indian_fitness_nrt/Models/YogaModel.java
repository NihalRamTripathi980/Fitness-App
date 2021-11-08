package com.nihalramtripathi.indian_fitness_nrt.Models;

public class YogaModel {
    int image;
    String textView;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTextView() {
        return textView;
    }

    public void setTextView(String textView) {
        this.textView = textView;
    }

    public YogaModel(int image, String textView) {
        this.image = image;
        this.textView = textView;
    }
}
