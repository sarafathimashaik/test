package com.student.test.exception;

import org.springframework.http.HttpStatus;

public class StudentException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8239349377414150392L;
	private final String message;
	private final HttpStatus httpStatus;

	public StudentException(String message, HttpStatus httpStatus) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;

	}

	@Override
	public String getMessage() {
		return message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

}
