package com.example.management.service;

import com.example.management.Exception.MissingInputException;
import com.example.management.Repository.EmployeeRepository;
import com.example.management.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeerepository;

    public Employee createUser(Employee employee) throws MissingInputException {
        String validationResult = ValidateUser(employee);
        if (validationResult != null) {
            throw new MissingInputException(validationResult);
        }
        return employeerepository.save(employee);
    }

    public String ValidateUser(Employee employee){
        StringBuilder valid = new StringBuilder();
        if (employee.getFirstname()==null||"".equals(employee.getFirstname())){
            valid.append("FirstName");
        }
        if (employee.getLastname()==null||"".equals(employee.getLastname())) {
            valid.append("LastName");
        }

        return valid.length()>0 ? valid.toString():null;

    }
}
