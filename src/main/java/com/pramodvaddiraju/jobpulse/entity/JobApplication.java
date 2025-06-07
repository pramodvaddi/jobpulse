package com.pramodvaddiraju.jobpulse.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="job_application")
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    private String jobTitle;
    private String status;
    private LocalDate appliedDate;

    // No args constructor
    public JobApplication(){

    }
    // Args constructor
    public JobApplication(String companyName, String jobTitle, String status, LocalDate appliedDate) {
        this.companyName = companyName;
        this.jobTitle = jobTitle;
        this.status = status;
        this.appliedDate = appliedDate;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(LocalDate appliedDate) {
        this.appliedDate = appliedDate;
    }

    // To String
    @Override
    public String toString() {
        return "JobApplication{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", status='" + status + '\'' +
                ", appliedDate=" + appliedDate +
                '}';
    }
}
