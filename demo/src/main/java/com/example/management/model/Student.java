package com.example.management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer StudId;
    private String Stud_FirstName;
    private String Stud_LastName;
    private String Stud_Department;
    private String Stud_Address;
    private String Stud_Email;
}
