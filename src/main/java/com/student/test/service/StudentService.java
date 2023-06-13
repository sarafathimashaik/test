package com.student.test.service;

import java.util.Optional;

import com.student.test.entity.GenericRes;
import com.student.test.entity.Student;

public interface StudentService {
	
 	public GenericRes<?> createStudent(Student student);
 	public GenericRes<?> findStudent(Long id);
	public GenericRes<?> updateStudent(Long id,Student student);
	public GenericRes<?> deleteStudent(Long id);
		 	
}



