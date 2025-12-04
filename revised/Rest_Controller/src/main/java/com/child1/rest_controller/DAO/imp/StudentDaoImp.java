package com.child1.rest_controller.DAO.imp;


import com.child1.rest_controller.DAO.StudentDao;
import com.child1.rest_controller.model.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDaoImp implements StudentDao {

    final private EntityManager em;

    @Autowired
    public StudentDaoImp(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional
    public void saveStudent(Student student) {
        em.persist(student);
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        em.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudent(Student student) {
        em.remove(student);
    }

    @Override
    public List<Student> findAllStudents() {
        return em.createQuery("from Student", Student.class).getResultList();
    }

    @Override
    public Student findStudentById(int id) {
        return em.find(Student.class, id);
    }

    @Override
    public Student findStudentByName(String name) {
        return em.find(Student.class, name);
    }

    @Override
    public Student findStudentByEmail(String email) {
        return em.find(Student.class, email);
    }

    @Override
    public Student findStudentByPhone(String phone) {
        return em.find(Student.class, phone);
    }


    public Student queryStudent(String name){
        return em.createQuery("from Student s where s.name=:name", Student.class).setParameter("name", name).getSingleResult();

    }

}
