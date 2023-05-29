package com.matheesha.studentmanagement.service;

import com.matheesha.studentmanagement.dto.StudentDto;
import com.matheesha.studentmanagement.entity.Student;

import java.util.List;

public interface StudentService {

    Student registerStudent(Student newStudent);

    List<StudentDto> getStudentDetailsByName(String name);

    StudentDto getStudentDetailsByAdmission(String admission);

    List<String> getAllStudentsByGrade(int grade);
}
