package com.awslab.portfolioapp.work;

public class WorkItem {

    private String companyAndDuration;
    private String position;
    private String description;

    public WorkItem(String companyAndDuration, String description) {
        this.companyAndDuration = companyAndDuration;
        this.description = description;
    }

    public WorkItem() {
    }

    public String getCompanyAndDuration() {
        return companyAndDuration;
    }

    public void setCompanyAndDuration(String companyAndDuration) {
        this.companyAndDuration = companyAndDuration;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
