package com.student.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.test.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	Student findByEmail(String email);

}
