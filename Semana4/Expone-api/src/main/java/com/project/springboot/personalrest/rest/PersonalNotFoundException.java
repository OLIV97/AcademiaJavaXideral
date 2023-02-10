package com.project.springboot.personalrest.rest;

public class PersonalNotFoundException extends RuntimeException {

	public PersonalNotFoundException() {
	}

	public PersonalNotFoundException(String message) {
		super(message);
	}

	public PersonalNotFoundException(Throwable cause) {
		super(cause);
	}

	public PersonalNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public PersonalNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
