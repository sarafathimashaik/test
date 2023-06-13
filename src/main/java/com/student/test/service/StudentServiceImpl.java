package com.student.test.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.test.entity.GenericRes;
import com.student.test.entity.Student;
import com.student.test.entity.StudentEx;
import com.student.test.exception.StudentException;
import com.student.test.repository.StudentRepository;

@Service
public class StudentServiceImpl extends StudentEx implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public GenericRes<?> createStudent(Student student) {
		String email = student.getEmail();
		student.setStatus("Active");
		Student findByEmail = studentRepository.findByEmail(email);
		if (findByEmail != null) {
			return error("email is already exists please give another email");
		}
		if (student.getStudentName() == "") {
			return error("StudentName Should not be empty");
		}
		Student save = studentRepository.save(student);
		return success(save);

	}

	@Override
	public GenericRes<?> findStudent(Long id) throws StudentException {
		Optional<Student> findById = studentRepository.findById(id);
		if (findById.isEmpty()) {
			return error("Student not exits in our data base");
		}
		return success(findById.get());
	}

	@Override
	public GenericRes<?> updateStudent(Long id, Student student) {
		GenericRes<?> findStudent = findStudent(id);
		if (findStudent.getCode().equals("200")) {
			if (findStudent.getData() instanceof Student) {
				Student cast = Student.class.cast(findStudent.getData());
				cast.setStudentName(student.getStudentName());
				cast.setStudentClass(student.getStudentClass());
				return success(studentRepository.save(cast));
			}

		}
		return error("Student not exits in our data base");
	}

	@Override
	public GenericRes<?> deleteStudent(Long id) throws StudentException {
		GenericRes<?> findStudent = findStudent(id);
		if (findStudent.getCode().equals("200")) {
			if (findStudent.getData() instanceof Student) {
				Student cast = Student.class.cast(findStudent.getData());
				cast.setStatus("In-Actived");
				studentRepository.save(cast);
				return success("Student deleted successfully");
			}

		}
		return error("Student not exits in our data base");
	}

}
