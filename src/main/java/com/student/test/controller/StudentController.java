package com.student.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.test.entity.GenericRes;
import com.student.test.entity.Student;
import com.student.test.service.StudentServiceImpl;

@RestController
@RequestMapping("/api/")
public class StudentController {
	@Autowired
	StudentServiceImpl studentServiceImpl;

	@PostMapping("student")
	public GenericRes<?> saveStudent(@RequestBody Student student) {
		return studentServiceImpl.createStudent(student);
	}

	@GetMapping("student/{id}")
	public GenericRes<?> findStudent(@PathVariable Long id) {
		return studentServiceImpl.findStudent(id);
	}

	@PutMapping("student/{id}")
	public GenericRes<?> updatestudent(@PathVariable Long id, @RequestBody Student student) {
		return studentServiceImpl.updateStudent(id, student);
	}

	@PutMapping("remove-student/{id}")
	public GenericRes<?> deleteStudent(@PathVariable Long id) {
		return studentServiceImpl.deleteStudent(id);
	}
	@GetMapping("/")
	public String home() {
		return "<h1> Welcome </h1>";
	}
	@GetMapping("/user")
	public String user() {
		return "<h1> Hi User </h1>";
	}
	@GetMapping("/admin")
	public String admin() {
		return "<h1> Hi Admin </h1>";
	}

}
