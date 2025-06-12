package com.pramodvaddiraju.jobpulse.dto;

public class JobApplicationRequestDTO {

    private String jobTitle;
    private String company;
    private String location;
    private String status;


    // Constructors
    public JobApplicationRequestDTO(){

    }

    public JobApplicationRequestDTO(String jobTitle, String company, String location, String status) {
        this.jobTitle = jobTitle;
        this.company = company;
        this.location = location;
        this.status = status;
    }

    // Getters and Setters
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
