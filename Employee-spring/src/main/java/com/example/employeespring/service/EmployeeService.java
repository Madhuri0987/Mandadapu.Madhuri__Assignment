package com.example.employeespring.service;

import com.example.employeespring.dao.EmployeeDAO;
import com.example.employeespring.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDAO employeeDAO;

    public int save(Employee emp) {
        return employeeDAO.save(emp);
    }

    public List<Employee> getAll() {
        return employeeDAO.getAll();
    }

    public int update(Employee emp) {
        return employeeDAO.update(emp);
    }

    public int delete(int id) {
        return employeeDAO.delete(id);
    }
}
