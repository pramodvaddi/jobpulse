package com.pramodvaddiraju.jobpulse.mapper;

import com.pramodvaddiraju.jobpulse.dto.JobApplicationRequestDTO;
import com.pramodvaddiraju.jobpulse.dto.JobApplicationResponseDTO;
import com.pramodvaddiraju.jobpulse.entity.JobApplication;
import org.springframework.stereotype.Component;

@Component
public class JobMapper {

    // Convert RequestDTO to Entity
    public JobApplication toEntity(JobApplicationRequestDTO dto) {
        JobApplication job = new JobApplication();
        job.setJobTitle(dto.getJobTitle());
        job.setCompany(dto.getCompany());
        job.setLocation(dto.getLocation());
        job.setStatus(dto.getStatus());
        return job;
    }

    // Convert Entity to ResponseDTO
    public JobApplicationResponseDTO toResponse(JobApplication entity) {
        return new JobApplicationResponseDTO(
                entity.getId(),
                entity.getJobTitle(),
                entity.getCompany(),
                entity.getLocation(),
                entity.getStatus()
        );
    }
}
