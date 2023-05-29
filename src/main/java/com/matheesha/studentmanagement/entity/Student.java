package com.matheesha.studentmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String firstName;
    private String lastName;
    private String fullName;
    private int grade;
    private Date registrationDate;
    private String admissionNumber;

    public String getFullName() {
        return fullName;
    }

    public void setFullName() {
        this.fullName = this.firstName + " " + this.lastName;
    }
}
