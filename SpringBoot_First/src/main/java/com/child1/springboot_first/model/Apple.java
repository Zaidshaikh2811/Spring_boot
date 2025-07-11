package com.child1.springboot_first.model;

import org.springframework.stereotype.Component;

@Component
public class Apple implements Mobile {


            private String model;

                 public String getModel() {
                return model;
                   }

            public void setModel(String model) {
                this.model = model;
            }

    @Override
    public void call() {
        System.out.println("Calling from Apple");
    }

}
