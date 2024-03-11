package com.example.employeecrud.dao;

import com.example.employeecrud.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmpoloyeeDAOImpl implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmpoloyeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);

        List<Employee> listOfEmployees = query.getResultList();

        return listOfEmployees;
    }

    @Override
    public Employee findById(int id) {

        Employee employee = entityManager.find(Employee.class,id);

        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        Employee savedEmployee= entityManager.merge(employee);

        return savedEmployee;
    }

    @Override
    public void deleteById(int id) {

        Employee employee = entityManager.find(Employee.class,id);

        entityManager.remove(employee);
    }
}
