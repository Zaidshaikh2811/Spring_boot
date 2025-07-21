package com.child1.controller;


import com.child1.modal.Job;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class JobController {

    private static final Logger log = LoggerFactory.getLogger(JobController.class);
    private List<Job> jobList = new ArrayList<>();


    @RequestMapping({"/","/home"})
    public String getJobDetails() {

        return "home";
    }


    @GetMapping("/createJob")
    public String showCreateForm() {
        System.out.println("showCreateForm called");
        return "addjob";
    }

    @PostMapping("/createJob")
    public String createJob(
            @RequestParam("title") String jobTitle,
            @RequestParam("description") String jobDescription
    ) {
        System.out.println("createJob called with jobTitle: " + jobTitle + ", jobDescription: " + jobDescription);
        if (jobTitle == null || jobTitle.isEmpty() || jobDescription == null || jobDescription.isEmpty()) {
            return "error"; // you can have a simple error.jsp if needed
        }

        jobList.add(new Job(jobTitle, jobDescription));

        // ✅ Redirect to list page
        return "redirect:/viewalljobs";
    }

    @RequestMapping("viewalljobs")
    public String viewJob(Model model) {
        model.addAttribute("jobs", jobList);

        System.out.println("viewJob called, jobList size: " + jobList.size());
        if (jobList.isEmpty()) {
            model.addAttribute("message", "No jobs available");
        } else {
            model.addAttribute("message", "List of Jobs");
        }
        System.out.println("Job List: " + jobList);
        for (Job job : jobList) {
            log.info("Job Title: {}, Description: {}", job.getTitle(), job.getDescription());
        }


        return "viewalljobs";
    }


}
