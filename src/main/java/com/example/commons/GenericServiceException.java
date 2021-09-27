package com.example.commons;

public class GenericServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	public GenericServiceException() {
		super();
	}

	public GenericServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public GenericServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public GenericServiceException(String message) {
		super(message);
	}

	public GenericServiceException(Throwable cause) {
		super(cause);
	}

}
