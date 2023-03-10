package com.example.springbootudemy.SpringJPA;

import com.example.springbootudemy.SpringJPA.JPAmodel.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class JPARepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Employee employee) {
        entityManager.merge(employee);
    }

    public Employee findById(long id) {
        return entityManager.find(Employee.class, id);
    }

    public void deleteById(long id) {
        Employee employee = entityManager.find(Employee.class,id);
        entityManager.remove(employee);
    }
}
