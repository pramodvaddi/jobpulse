package com.pramodvaddiraju.jobpulse.controller;

import com.pramodvaddiraju.jobpulse.entity.JobApplication;
import com.pramodvaddiraju.jobpulse.service.JobApplicationService;
import com.pramodvaddiraju.jobpulse.service.JobApplicationServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobApplicationController {

    private JobApplicationService jobApplicationService;

    public JobApplicationController(JobApplicationService jobApplicationService){
        this.jobApplicationService = jobApplicationService;
    }

    // Get all
    @GetMapping
    public ResponseEntity<List<JobApplication>> getAll(){
        return ResponseEntity.ok(jobApplicationService.getAllJobs());
    }

    // Get by id
    @GetMapping("/{id}")
    public ResponseEntity<JobApplication> getById(@PathVariable Long id){
        JobApplication job = jobApplicationService.getJobById(id);
        return (job!= null)? ResponseEntity.ok(job) : ResponseEntity.notFound().build();
    }

    // Post/Create
    @PostMapping
    public ResponseEntity<JobApplication> create(@RequestBody JobApplication job) {
        return ResponseEntity.ok(jobApplicationService.createJob(job)); // Return saved job with 200 OK
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<JobApplication> update(@PathVariable Long id, @RequestBody JobApplication job){
        JobApplication updated = jobApplicationService.updateJob(id,job);
        return (updated != null)? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<JobApplication> delete(@PathVariable Long id){
        jobApplicationService.deleteJob(id);
        return ResponseEntity.noContent().build();
    }






}
