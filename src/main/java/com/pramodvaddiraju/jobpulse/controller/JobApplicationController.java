package com.pramodvaddiraju.jobpulse.controller;

import com.pramodvaddiraju.jobpulse.dto.JobApplicationRequestDTO;
import com.pramodvaddiraju.jobpulse.dto.JobApplicationResponseDTO;
import com.pramodvaddiraju.jobpulse.entity.JobApplication;
import com.pramodvaddiraju.jobpulse.mapper.JobMapper;
import com.pramodvaddiraju.jobpulse.service.JobApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/jobs")
public class JobApplicationController {

    private final JobApplicationService service;
    private final JobMapper mapper;

    public JobApplicationController(JobApplicationService service, JobMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<JobApplicationResponseDTO> create(@RequestBody JobApplicationRequestDTO requestDTO) {
        JobApplication jobEntity = mapper.toEntity(requestDTO);
        JobApplication savedJob = service.createJob(jobEntity);
        JobApplicationResponseDTO responseDTO = mapper.toResponse(savedJob);
        return ResponseEntity.ok(responseDTO);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<JobApplicationResponseDTO> getById(@PathVariable Long id) {
        JobApplication job = service.getJobById(id);
        if (job == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(mapper.toResponse(job));
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<JobApplicationResponseDTO>> getAll() {
        List<JobApplication> jobs = service.getAllJobs();
        List<JobApplicationResponseDTO> responseList = jobs.stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseList);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<JobApplicationResponseDTO> update(@PathVariable Long id, @RequestBody JobApplicationRequestDTO requestDTO) {
        JobApplication updatedEntity = mapper.toEntity(requestDTO);
        JobApplication updatedJob = service.updateJob(id, updatedEntity);
        if (updatedJob == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(mapper.toResponse(updatedJob));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteJob(id);
        return ResponseEntity.noContent().build();
    }
}
