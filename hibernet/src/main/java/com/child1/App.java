package com.child1;

import org.h2.tools.Server;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        SessionFactory factory = null;
        Session session = null;
        Transaction transaction = null;
        Server webServer = null;


        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");


        HelloWorld obj =context.getBean(HelloWorld.class);

//        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
//        helloWorld.getMessage();

//        try {
//            // Start H2 Web Console
//            webServer = Server.createWebServer("-web", "-webAllowOthers", "-webPort", "9090");
//            webServer.start();
//            System.out.println("H2 Console started at: http://localhost:9090");
//
//            // Configure Hibernate
//            Configuration cfg = new Configuration();
//            cfg.configure("hibernate.cfg.xml");
//            factory = cfg.buildSessionFactory();
//
//            // ====== SAVE DATA ======
//            session = factory.openSession();
//            transaction = session.beginTransaction();
//
//            // Create instances
//            Laptop laptop = new Laptop("SN12345", "Dell", "XPS 15", 16, 512);
//            Student student = new Student("John Doe", "john@gmail.com", laptop);
//
//            // Save entities (laptop will be saved automatically due to CASCADE)
//            session.persist(student);
//
//            // Commit and close
//            transaction.commit();
//            session.close();
//            System.out.println("Data saved successfully!");
//
//            // ====== QUERY DATA ======
//            Session querySession = factory.openSession();
//            transaction = querySession.beginTransaction();
//
//            // Create query with proper typing
//            Query<Student> query = querySession.createQuery("FROM Student", Student.class);
//
//            // Execute query and get results
//            List<Student> students = query.getResultList();
//
//            // Display results
//            System.out.println("\nSaved Students:");
//            System.out.println("Total students: " + students.size());
//
//            for (Student retrievedStudent : students) {
//                System.out.println("=== Student Details ===");
//                System.out.println("ID: " + retrievedStudent.getId());
//                System.out.println("Name: " + retrievedStudent.getName());
//                System.out.println("Email: " + retrievedStudent.getEmail());
//
//                // Display laptop information if available
//                if (retrievedStudent.getHasLaptop() != null) {
//                    Laptop studentLaptop = retrievedStudent.getHasLaptop();
//                    System.out.println("Laptop: " + studentLaptop.getBrand() + " " + studentLaptop.getModel());
//                    System.out.println("RAM: " + studentLaptop.getRamSize() + "GB");
//                    System.out.println("Storage: " + studentLaptop.getStorageSize() + "GB");
//                    System.out.println("Serial Number: " + studentLaptop.getSerialNumber());
//                } else {
//                    System.out.println("Laptop: Not assigned");
//                }
//                System.out.println("========================\n");
//            }
//
//            // Commit and close
//            transaction.commit();
//            querySession.close();
//
//        } catch (Exception e) {
//            // Rollback transaction in case of error
//            if (transaction != null) {
//                transaction.rollback();
//                System.err.println("Transaction rolled back due to error");
//            }
//            e.printStackTrace();
//        } finally {
//            // Close resources properly
//            if (session != null && session.isOpen()) {
//                session.close();
//            }
//            if (factory != null) {
//                factory.close();
//            }
//            if (webServer != null && webServer.isRunning(false)) {
//                webServer.stop();
//                System.out.println("H2 Console stopped");
//            }
//        }
    }
}