package com.child1.hospital.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;

@Configuration
public class EventConfig {

    @Bean
    public ApplicationEventMulticaster applicationEventPublisherBean() {
        SimpleApplicationEventMulticaster eventMulticaster = new SimpleApplicationEventMulticaster();
        eventMulticaster.setErrorHandler(
                throwable -> {
                    System.err.println("Error occurred in event listener: " + throwable.getMessage());
                }
        );

        return eventMulticaster;
    }

}
