package com.child1.hospital;

import com.child1.hospital.model.Appointment;
import com.child1.hospital.model.Doctor;
import com.child1.hospital.repository.DoctorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.List;
import java.util.Optional;

@SpringBootApplication()
public class HospitalApplication {

    DoctorRepository doctorRepository;


	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}


//    public CommandLineRunner init(HospitalApplication hospitalApplication) {
//        return args -> {
//
//                Optional<Doctor> doctor = doctorRepository.findById(1L);
//                if (doctor.isEmpty()) {
//                    System.out.println("Doctor not found");
//                    return;
//                }
//                List<Appointment> appointments = doctor.get().getAppointments();
//                for (Appointment appointment : appointments) {
//                    System.out.println(appointment.getDetails());
//                }
//
//        };
//    }
}
