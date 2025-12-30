package com.child1.hospital.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class cornJob {

    @Scheduled(fixedRate = 5000)
    public void scheduled() {
        System.out.println("Scheduled task executed");
    }
}
