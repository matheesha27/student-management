package com.matheesha.studentmanagement.controller;

import com.matheesha.studentmanagement.dto.StudentDto;
import com.matheesha.studentmanagement.entity.Student;
import com.matheesha.studentmanagement.service.StudentService;
import com.matheesha.studentmanagement.util.CommonUtil;
import com.matheesha.studentmanagement.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private DateUtil dateUtil;

    @Autowired
    private CommonUtil commonUtil;

    @PostMapping("/register")
    public Student registerStudent(@RequestParam(name = "first-name") String firstName,
                                   @RequestParam(name = "last-name") String lastName,
                                   @RequestParam(name = "grade") int grade) {
        Student newStudent = new Student();
        newStudent.setFirstName(firstName);
        newStudent.setLastName(lastName);
        newStudent.setFullName();
        newStudent.setGrade(grade);
        newStudent.setRegistrationDate(dateUtil.getCurrentDateTime());
        newStudent.setAdmissionNumber(commonUtil.generateAdmissionNumber(firstName, lastName));
        return studentService.registerStudent(newStudent);
    }

    @GetMapping("/name")
    public List<StudentDto> getStudentDetailsByName(@RequestParam(name = "first-name") String firstName) {
        return studentService.getStudentDetailsByName(firstName);
    }

    @GetMapping("/admission")
    public StudentDto getStudentDetailsByAdmission(@RequestParam(name = "admission") String admission) {
        return studentService.getStudentDetailsByAdmission(admission);
    }

    @GetMapping("/grade/{grade}")
    public List<String> getAllStudentsByGrade(@PathVariable(name = "grade") int grade) {
        return studentService.getAllStudentsByGrade(grade);
    }

    @DeleteMapping("/remove/{admission}")
    public String removeStudent(@PathVariable(name = "admission") String admission) {
        return studentService.deleteStudent(admission);
    }
}
