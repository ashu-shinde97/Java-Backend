package com.example.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.management.Exception.CustomException;
import com.example.management.Exception.ResourceNotFoundExeption;
import com.example.management.Repository.EmployeeRepository;
import com.example.management.model.Employee;

@RestController
@RequestMapping("/api/v1")
public class employeeController {
	
	@Autowired
	private EmployeeRepository employeerepository;
	
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployee(){
		return employeerepository.findAll();
	}
	
	@GetMapping(value = "/employees/{id}")
	public Employee employeeById(@PathVariable Integer id ) {
//		Employee employeebyId = employeerepository.findById(id).orElseThrow(() -> new ResourceNotFoundExeption("Employee not found by id" + id));
//		return ResponseEntity.ok(employeebyId);
		//.....id.
		return employeerepository.findById(id).get();
	}    
	
	@GetMapping("/test/{number}")
    public String test(@PathVariable int number) {
        if (number < 0) {
            throw new CustomException("Number cannot be negative!");
        }
        return "Valid number: " + number;
    }
	
	@PostMapping("/CreateUser")
    public ResponseEntity<Employee> createUser(@RequestBody Employee employee) {
		Employee saved = employeerepository.save(employee);
		return ResponseEntity.ok(saved);
    }
	
	@PutMapping("/updateUser")
	public ResponseEntity<Employee> updateUser(@RequestBody Employee employee) {
		Employee updatedUser = employeerepository.save(employee); // If ID exists, it updates
	    return ResponseEntity.ok(updatedUser);
	}
	@GetMapping("/card-type/{cardNumber}")
    public ResponseEntity<String> getCardType(@PathVariable String cardNumber) {
        if (cardNumber == null || cardNumber.isEmpty()) {
            return ResponseEntity.badRequest().body("Card number is required");
        }

        char firstDigit = cardNumber.charAt(0);

        String cardType;
        if (firstDigit == '4' || firstDigit == '5') {
            cardType = "Credit Card";
        } else if (firstDigit == '6') {
            cardType = "Debit Card";
        } else {
            cardType = "Unknown Card Type";
        }

        return ResponseEntity.ok(cardType);
	}

}
