package com.example.management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.management.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
