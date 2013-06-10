package com.ordering.exceptions;

public class UsernameAlreadyExistException extends RegistrationFailedException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsernameAlreadyExistException() {
		super();
	}

	public UsernameAlreadyExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public UsernameAlreadyExistException(String message) {
		super(message);
	}

	public UsernameAlreadyExistException(Throwable cause) {
		super(cause);
	}

	
}
