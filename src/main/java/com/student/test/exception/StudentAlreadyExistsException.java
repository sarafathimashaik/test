package com.student.test.exception;

public class StudentAlreadyExistsException  extends RuntimeException {

	public StudentAlreadyExistsException(String message) {
		super(message);

	}

	public StudentAlreadyExistsException() {
		}

	
}
