package com.pramodvaddiraju.jobpulse.service;

import com.pramodvaddiraju.jobpulse.entity.JobApplication;
import com.pramodvaddiraju.jobpulse.exception.ResourceNotFoundException;
import com.pramodvaddiraju.jobpulse.repository.JobApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobApplicationServiceImpl implements JobApplicationService{

    @Autowired
    private JobApplicationRepository jobApplicationRepository;

    public JobApplicationServiceImpl(JobApplicationRepository jobApplicationRepository){
        this.jobApplicationRepository = jobApplicationRepository;
    }


    @Override
    public JobApplication createJob(JobApplication job) {
        return jobApplicationRepository.save(job);
    }

    @Override
    public JobApplication getJobById(Long id) {
        return jobApplicationRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Job with this id not exists: " + id));
    }

    @Override
    public List<JobApplication> getAllJobs() {
        return jobApplicationRepository.findAll();
    }
    public JobApplication updateJob(Long id, JobApplication job) {
        JobApplication existing = jobApplicationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Job with ID " + id + " not found"));

        existing.setCompanyName(job.getCompanyName());
        existing.setJobTitle(job.getJobTitle());
        existing.setStatus(job.getStatus());
        existing.setAppliedDate(job.getAppliedDate());
        return jobApplicationRepository.save(existing);
    }

    @Override
    public void deleteJob(Long id) {
        JobApplication job = jobApplicationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Job with this id not found to delete" + id));
        jobApplicationRepository.delete(job);
    }
}
