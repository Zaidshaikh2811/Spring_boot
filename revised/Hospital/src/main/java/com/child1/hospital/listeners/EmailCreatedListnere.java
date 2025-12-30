package com.child1.hospital.listeners;


import com.child1.hospital.events.GetAllDoctors;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EmailCreatedListnere {

    @EventListener
    public void handleDoctorsEvents(GetAllDoctors event) {
        System.out.println("Handling GetAllDoctors event in EmailCreatedListnere");
    }
}
