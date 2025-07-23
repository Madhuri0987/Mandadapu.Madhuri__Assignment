package com.example.springbootjpa.service;

import com.example.springbootjpa.entity.Employee;
import com.example.springbootjpa.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee save(Employee employee) {
        System.out.println("Saving: " + employee.getId() + ", " + employee.getName() + ", " + employee.getDepartment());
        return employeeRepository.save(employee);
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
    public Employee update(Employee employee) {
        return employeeRepository.save(employee);
    }
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }
}
