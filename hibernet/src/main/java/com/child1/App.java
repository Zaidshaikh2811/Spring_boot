package com.child1;

import org.h2.tools.Server;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;




public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");






        SessionFactory factory = null;
        Session session = null;
        Transaction transaction = null;
        Server webServer = null;
        try {

            webServer = Server.createWebServer("-web", "-webAllowOthers", "-webPort", "9090");
            webServer.start();
            System.out.println("H2 Console started at: http://localhost:9090");


            // Configure Hibernate
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");
            factory = cfg.buildSessionFactory();

            // Open session and begin transaction
            session = factory.openSession();
            transaction = session.beginTransaction();

            // Create a Laptop instance
            Laptop laptop = new Laptop("SN12345", "Dell", "XPS 15", 16, 512);
            // Create a Student instance with the Laptop
            Student student = new Student("John Doe", "john@gmail.com", laptop);
            // Save the Laptop and Student instances
            session.persist(laptop); // Save Laptop first
            session.persist(student);





            // Commit transaction
            transaction.commit();
            session.close();
            System.out.println("Data saved successfully!");



            // Query the saved data to verify

//            @SuppressWarnings("unchecked")
//            List<Student> students = session.createQuery("FROM Student").list();
//            transaction.commit();

//            System.out.println("\nSaved Students:");
//            System.out.println("Total students: " + students.size());
//            for (Student student : students) {
//                System.out.println("ID: " + student.getId() +
//                        ", Name: " + student.getName() +
//                        ", Email: " + student.getEmail());
//            }

//            transaction = session.beginTransaction();
//            Student stu= session.get(Student.class, 1);
//            System.out.println("\nRetrieved Student:"  );
//            System.out.println("ID: " + stu.getId() +
//                    ", Name: " + stu.getName() +
//                    ", Email: " + stu.getEmail());
//
//
//            transaction.commit();






        } catch (Exception e) {
            // Rollback transaction in case of error
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            // Close resources properly
            if (session != null) {
                session.close();
            }
            if (factory != null) {
                factory.close();
            }
        }
    }
}