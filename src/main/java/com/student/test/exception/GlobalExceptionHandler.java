package com.student.test.exception;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(StudentException.class)
	public void handleCustomException(HttpServletResponse res, StudentException ex) throws IOException {
		res.sendError(ex.getHttpStatus().value(), ex.getMessage());
	}

	@ExceptionHandler(Exception.class)
	public void handleException(HttpServletResponse res) throws IOException {
		res.sendError(HttpStatus.BAD_REQUEST.value(), "Something Went Wrong");
	}

}
