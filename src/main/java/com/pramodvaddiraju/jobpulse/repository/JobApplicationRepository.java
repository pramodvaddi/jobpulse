package com.pramodvaddiraju.jobpulse.repository;

import com.pramodvaddiraju.jobpulse.entity.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
    // No need to write anything — inherits CRUD methods from JpaRepository
}
