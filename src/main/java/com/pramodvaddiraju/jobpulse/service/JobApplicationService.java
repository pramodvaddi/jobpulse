package com.pramodvaddiraju.jobpulse.service;

import com.pramodvaddiraju.jobpulse.entity.JobApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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

     // Pagination and sorting
     Page<JobApplication> getJobsPage(Pageable pageable);



}
