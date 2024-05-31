package com.matheesha.studentmanagement;

import com.matheesha.studentmanagement.entity.Enrollment;
import com.matheesha.studentmanagement.entity.Student;
import com.matheesha.studentmanagement.repository.ModuleRepository;
import com.matheesha.studentmanagement.repository.StudentRepository;
import com.matheesha.studentmanagement.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class StudentManagementApplicationTests {

	@Autowired
	private StudentService studentService;

	@MockBean
	private StudentRepository studentRepository;

	@MockBean
	private ModuleRepository moduleRepository;

//	@Test
//	void contextLoads() {
//	}

	@Test
	public void getAllStudentsByGradeTest() {
		int grade = 2;
		List<String> list = new ArrayList<String>();
		list.add("Namal");
		list.add( "Mahinda");
		when(studentRepository.getStudentsByGrade(grade)).thenReturn(list);
		assertEquals(2, studentService.getAllStudentsByGrade(grade).size());
	}

	@Test
	public void saveStudentTest() {
		String admission = "10501";
		Student student = new Student(21, "Nimal", "Perera", "Nimal Perera", 3, new Date(), admission);
		when(studentRepository.save(student)).thenReturn(student);
		assertEquals(student, studentService.registerStudent(student));
	}

	@Test
	public void saveEnrollmentTest() {
		String admission = "10501";
//		Student student = new Student(21, "Nimal", "Perera", "Nimal Perera", 3, new Date(), admission);
		Enrollment enrollment = new Enrollment(admission, "701, 502");
		when(moduleRepository.save(enrollment)).thenReturn(enrollment);
		assertEquals(enrollment, moduleRepository.save(enrollment));
	}

	@Test
	public void deleteStudentTest() {
		String admission = "10501";
		Enrollment enrollment = new Enrollment(admission, "701, 502");
		Student student = new Student(21, "Nimal", "Perera", "Nimal Perera", 3, new Date(), admission);
		studentService.deleteStudent("10501");
		moduleRepository.deleteById(admission);
		verify(studentRepository, times(1)).delete(student);
		verify(moduleRepository, times(1)).delete(enrollment);
	}

}
