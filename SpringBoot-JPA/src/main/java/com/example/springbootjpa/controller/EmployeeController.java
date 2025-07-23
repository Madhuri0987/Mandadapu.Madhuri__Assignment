package com.example.springbootjpa.controller;

import com.example.springbootjpa.entity.Employee;
import com.example.springbootjpa.service.EmployeeService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public String save(@RequestBody Employee employee) {
        employeeService.save(employee);
        return "Employee saved successfully";
    }

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAll();
    }
    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody Employee employee) {
        employee.setId(id);
        employeeService.update(employee);
        return "Employee updated successfully";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        employeeService.delete(id);
        return "Employee deleted successfully";
    }

}
