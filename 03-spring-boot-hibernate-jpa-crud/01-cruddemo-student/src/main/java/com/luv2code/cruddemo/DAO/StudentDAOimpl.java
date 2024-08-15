package com.luv2code.cruddemo.DAO;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOimpl implements StudentDao{

    // DEFINE FIELD FOR ENTITY MANAGER
    private EntityManager entityManager;

    //INJECT ENTITY MANAGER USING CONSTRUCTOR INJECTION
   public StudentDAOimpl(EntityManager entityManager){
       this.entityManager=entityManager;
   }

    //IMPLEMENT SAVE METHOD
    @Override
    @Transactional
    public void save(Student theStudent) {
       entityManager.persist(theStudent);

    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery=entityManager.createQuery("FROM Student  ",Student.class);
        return theQuery.getResultList();

    }

    @Override
    public List<Student> findByLastName(String theLastName) {
       TypedQuery<Student> TheQuery=entityManager.createQuery("FROM Student  WHERE lastName=:theData", Student.class);
        TheQuery.setParameter("theData",theLastName);
        return TheQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
    entityManager.merge(theStudent);
    }
    @Transactional
    @Override
    public void delete(Integer id) {
       Student theStudent=entityManager.find(Student.class,id);
       entityManager.remove(theStudent);

    }
    @Transactional
    @Override
    public int deleteAll() {
       int numRowsDeleted=entityManager.createQuery("DELETE FROM Student ").executeUpdate();


        return numRowsDeleted ;
    }
}
