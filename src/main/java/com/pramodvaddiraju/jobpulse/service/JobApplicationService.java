package com.pramodvaddiraju.jobpulse.service;

import com.pramodvaddiraju.jobpulse.entity.JobApplication;

import java.util.List;

public interface JobApplicationService {

     // PostMapping()
     JobApplication createJob(JobApplication job);

     // GetMapping("/{id}")
     JobApplication getJobById(Long id);

     // GetMapping()
     List<JobApplication> getAllJobs();

     // PutMapping("/{id}")
     JobApplication updateJob(Long id, JobApplication job);

     // DeleteMapping("/{id}")
     void deleteJob(Long id);

}
