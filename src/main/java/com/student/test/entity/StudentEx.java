package com.student.test.entity;

public abstract class StudentEx {
	
	
	public <T> GenericRes<T> error(String message) {
		return GenericRes.<T>builder().message(message).code("404").build();

	}

	public <T> GenericRes<T> success(T t) {
		return GenericRes.<T>builder().message("success").data(t).code("200").build();

	}

}
