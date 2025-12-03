package com.child1;


import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "laptops")
@Component
public class Laptop {


    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "serial_number", nullable = false, unique = true)

    private String serialNumber;

    @Column(name = "brand", nullable = false)

    private String brand;
    @Column(name = "model")
    private String model;

    @Column(name = "ram_size")
    private int ramSize; // in GB
    @Column(name = "storage_size")
    private int storageSize; // in GB


    @OneToOne(mappedBy = "hasLaptop")
    private Student student;

    // Default constructor
    public Laptop() {}

    public Laptop(String serialNumber, String brand, String model, int ramSize, int storageSize) {
        this.serialNumber = serialNumber;
        this.brand = brand;
        this.model = model;
        this.ramSize = ramSize;
        this.storageSize = storageSize;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    // Getters and setters for serialNumber
    public String getSerialNumber() {
        return serialNumber;
    }
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    // Getters and setters
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRamSize() {
        return ramSize;
    }

    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }

    public int getStorageSize() {
        return storageSize;
    }

    public void setStorageSize(int storageSize) {
        this.storageSize = storageSize;
    }


    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", serialNumber='" + serialNumber + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", ramSize=" + ramSize +
                ", storageSize=" + storageSize +
                '}';
    }

}
