package com.student.test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.Objects;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.student.test.entity.GenericRes;
import com.student.test.entity.Student;
import com.student.test.exception.StudentException;
import com.student.test.repository.StudentRepository;
import com.student.test.service.StudentService;

@SpringBootTest
class StudentTest {

	@MockBean
	private StudentRepository repository;

	

	@Autowired
	private StudentService service;

	@Test
	@DisplayName("Test find student by Id Success")
	void testFindStudentById() {
		// Setup our mock repository
		Student mockedStudent = new Student(1234L, "Fatima", "CSE", "Fatima@gmail.com","ACTIVE");
		doReturn(Optional.of(mockedStudent)).when(repository).findById(1234L);
		// Execute the service call
		GenericRes<?> student = service.findStudent(1834L);
		// Assert the response
		Assertions.assertTrue(Objects.nonNull(student.getData()), "Student was not found");
		Assertions.assertSame(student.getData(), mockedStudent, "The Student returned was not the same as the mock");
	}

	@Test
	@DisplayName("Test create student")
	void testCreateStudent() {
		// Setup our mock repository
		Student mockedStudent = new Student(1l, "Fatima", "CSE", "Fatima@gmail.com","INACTIVE");
		doReturn(mockedStudent).when(repository).save(any());
		// Execute the service call
		GenericRes<?> genericResponse = service.createStudent(mockedStudent);
		// Assert the response
		Assertions.assertTrue(Objects.nonNull(genericResponse.getData()), "Student was not found");
	}

	@Test
	@DisplayName("Test find student by Id failure")
	void testFindStudentByIdFailure() {
		when(repository.findById(10L)).thenThrow(StudentException.class);
		assertThrows(StudentException.class, () -> {
			service.findStudent(10L);
		});
	}

}

