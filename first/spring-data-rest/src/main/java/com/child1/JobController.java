package com.child1;

import com.child1.modal.JobModal;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    private final List<JobModal> jobList = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public JobController() {
        // Dummy data
        jobList.add(new JobModal(idGenerator.getAndIncrement(), "Java Developer", "Develop Java applications",
                "Mumbai", "Full-Time", "TechCorp", "We build tech", "6-10 LPA", "Java, Spring Boot", "Health insurance", "2025-12-31"));

        jobList.add(new JobModal(idGenerator.getAndIncrement(), "Frontend Developer", "Work on UI/UX",
                "Pune", "Part-Time", "DesignHub", "Creative agency", "4-8 LPA", "React, CSS", "Flexible hours", "2025-11-30"));
    }

    @GetMapping
    public List<JobModal> getAllJobs() {
        return jobList;
    }

    @PostMapping
    public JobModal addJob(@RequestBody JobModal job) {
        job.setId(idGenerator.getAndIncrement());
        jobList.add(job);
        return job;
    }


    @GetMapping("/{id}")
    public JobModal getJobById(@PathVariable Long id) {
        return jobList.stream()
                .filter(job -> Objects.equals(job.getId(), id))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Job with ID " + id + " not found."));
    }

    @PutMapping("/{id}")
    public JobModal updateJob(@PathVariable Long id, @RequestBody JobModal updatedJob) {
        for (int i = 0; i < jobList.size(); i++) {
            if (Objects.equals(jobList.get(i).getId(), id)) {
                updatedJob.setId(id);
                jobList.set(i, updatedJob);
                return updatedJob;
            }
        }
        throw new NoSuchElementException("Job with ID " + id + " not found.");
    }

    @DeleteMapping("/{id}")
    public String deleteJob(@PathVariable Long id) {
        boolean removed = jobList.removeIf(job -> Objects.equals(job.getId(), id));
        if (removed) {
            return "Job with ID " + id + " deleted.";
        } else {
            return "Job with ID " + id + " not found.";
        }
    }
}
