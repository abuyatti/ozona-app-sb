package com.example.commons;

public class ValidateServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	public ValidateServiceException() {
		super();
	}

	public ValidateServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ValidateServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ValidateServiceException(String message) {
		super(message);
	}

	public ValidateServiceException(Throwable cause) {
		super(cause);
	}

}
