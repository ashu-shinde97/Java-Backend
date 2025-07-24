package com.example.management.service;

import com.example.management.Repository.EmployeeRepository;
import com.example.management.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeerepository;

    public Employee createUser(Employee employee) {
        return employeerepository.save(employee);
    }
}
