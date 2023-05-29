package com.matheesha.studentmanagement.service.impl;

import com.matheesha.studentmanagement.dto.StudentDto;
import com.matheesha.studentmanagement.entity.Student;
import com.matheesha.studentmanagement.repository.StudentRepository;
import com.matheesha.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student registerStudent(Student newStudent) {
        studentRepository.save(newStudent);
        return newStudent;
    }

    public List<StudentDto> getStudentDetailsByName(String name) {
        List<Student> students = studentRepository.findByFirstName(name);
        List<StudentDto> studentDtoList = new ArrayList<>();
        for (Student student : students) {
            StudentDto studentDto = new StudentDto();
            studentDto.setFirstName(student.getFirstName());
            studentDto.setLastName(student.getLastName());
            studentDto.setFullName();
            studentDto.setGrade(student.getGrade());
            studentDto.setRegistrationDate(student.getRegistrationDate());
            studentDto.setAdmissionNumber(student.getAdmissionNumber());
            studentDtoList.add(studentDto);
        }
        return studentDtoList;
    }

    public StudentDto getStudentDetailsByAdmission(String admission) {
        Student student = studentRepository.findByAdmissionNumber(admission);
        StudentDto studentDto = new StudentDto();
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setFullName();
        studentDto.setGrade(student.getGrade());
        studentDto.setRegistrationDate(student.getRegistrationDate());
        studentDto.setAdmissionNumber(admission);
        return studentDto;
    }

    public List<String> getAllStudentsByGrade(int grade) {
        return studentRepository.getStudentsByGrade(grade);
    }

    @Transactional
    public String deleteStudent(String admission) {
        studentRepository.deleteByAdmissionNumber(admission);
        return "Deleted the student entry with admission number: " + admission;
    }
}
