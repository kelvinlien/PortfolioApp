package com.awslab.portfolioapp.work;

public class WorkItem {

    private String companyAndDuration;
    private String jobTitle;
    private CharSequence description;

    public WorkItem(String companyAndDuration, String jobTitle, CharSequence description) {
        this.companyAndDuration = companyAndDuration;
        this.jobTitle = jobTitle;
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

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public CharSequence getDescription() {
        return description;
    }

    public void setDescription(CharSequence description) {
        this.description = description;
    }
}
