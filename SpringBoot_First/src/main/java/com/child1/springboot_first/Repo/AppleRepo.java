package com.child1.springboot_first.Repo;


import org.springframework.stereotype.Repository;

@Repository
public class AppleRepo {


    public void saveAppleDevice(String model) {
        System.out.println("Saving Apple device with model: " + model);
    }


    public String findAppleDeviceByModel(String model) {
        return "Found Apple device with model: " + model;
    }
}
