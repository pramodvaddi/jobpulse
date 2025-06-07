package com.pramodvaddiraju.jobpulse.service;

import com.pramodvaddiraju.jobpulse.entity.JobApplication;
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
        return jobApplicationRepository.findById(id).orElse(null);
    }

    @Override
    public List<JobApplication> getAllJobs() {
        return jobApplicationRepository.findAll();
    }

    @Override
    public JobApplication updateJob(Long id, JobApplication job) {
        Optional<JobApplication> optional = jobApplicationRepository.findById(id);
        if(optional.isPresent()){
            JobApplication existing = optional.get();
            existing.setCompanyName(job.getCompanyName());
            existing.setJobTitle(job.getJobTitle());
            existing.setStatus(job.getStatus());
            existing.setAppliedDate(job.getAppliedDate());
            return jobApplicationRepository.save(existing);

        }
        return null;
    }

    @Override
    public void deleteJob(Long id) {
        jobApplicationRepository.deleteById(id);

    }
}
