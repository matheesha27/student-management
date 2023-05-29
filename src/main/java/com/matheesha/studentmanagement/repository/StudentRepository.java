package com.matheesha.studentmanagement.repository;

import com.matheesha.studentmanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByFirstName(String name);

    Student findByAdmissionNumber(String admission);

    @Query(value = "SELECT d.name FROM Students d WHERE d.grade = :grade", nativeQuery = true)
    List<String> getStudentsByGrade(@Param("grade") int grade);

//    @Modifying
//    @Query(value = "DELETE FROM Students d WHERE d.id = (SELECT s.id FROM Students s WHERE s.admissionNumber = :admission)", nativeQuery = true)
//    void deleteStudent(String admission);

    void deleteByAdmissionNumber(String admission);
}
