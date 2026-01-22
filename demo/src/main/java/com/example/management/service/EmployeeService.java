package com.example.management.service;

import com.example.management.Exception.MissingInputException;
import com.example.management.Exception.ResourceNotFoundException;
import com.example.management.Repository.EmployeeRepository;
import com.example.management.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public ResponseEntity<Employee> EmployeeById(Integer id) throws ResourceNotFoundException {
        if (id<=0||id==null){
            throw new ResourceNotFoundException("User is not present");
        }
        return new ResponseEntity<>(employeerepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User not found with id: " + id)), HttpStatus.OK);
    }

    public ResponseEntity<List<Employee>> GetAllEmpoyee() {
        return new ResponseEntity<>(employeerepository.findAll(),HttpStatus.OK);
    }
}
