package com.awslab.portfolioapp.work;

public class WorkItem {

    private String title;
    private String description;

    public WorkItem(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public WorkItem() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
