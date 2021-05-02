package com.awslab.portfolioapp.project;

import java.io.Serializable;

public class ProjectItem implements Serializable {

    private int image;
    private String title;
    private CharSequence description;

    public ProjectItem(){
    }

    public ProjectItem(int image) {
        this.image = image;
    }

    public ProjectItem(int image, String title) {
        this.image = image;
        this.title = title;
    }

    public ProjectItem(int image, String title, CharSequence description) {
        this.image = image;
        this.title = title;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CharSequence getDescription() {
        return description;
    }

    public void setDescription(CharSequence description) {
        this.description = description;
    }
}
