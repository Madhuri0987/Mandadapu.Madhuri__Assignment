package com.example.employeespring.dao;

import com.example.employeespring.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public int save(Employee employee) {
        String sql = "INSERT INTO employee (id,name,department) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql,employee.getId(), employee.getName(), employee.getDepartment());
    }
    public List<Employee> getAll() {
        return jdbcTemplate.query("SELECT * FROM employee",
                (rs, rowNum) -> {
                    Employee e = new Employee();
                    e.setId(rs.getInt("id"));
                    e.setName(rs.getString("name"));
                    e.setDepartment(rs.getString("department"));
                    return e;
                });
    }
    public int update(Employee emp) {
        String sql = "UPDATE employee SET name=?, department=? WHERE id=?";
        return jdbcTemplate.update(sql,emp.getName(), emp.getDepartment(), emp.getId());
    }

    public int delete(int id) {
        String sql = "DELETE FROM employee WHERE id=?";
        return jdbcTemplate.update(sql, id);
    }


}
