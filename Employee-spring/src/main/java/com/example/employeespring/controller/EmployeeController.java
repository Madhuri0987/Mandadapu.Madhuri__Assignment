package com.example.employeespring.controller;

import com.example.employeespring.model.Employee;
import com.example.employeespring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;
    @PostMapping
    public String save(@RequestBody Employee emp) {
        service.save(emp);
        return "Employee saved";
    }

    @GetMapping
    public List<Employee> getAll() {
        return service.getAll();
    }

    @PutMapping
    public String update(@RequestBody Employee emp) {
        service.update(emp);
        return "Employee updated";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        service.delete(id);
        return "Employee deleted";
    }
}
