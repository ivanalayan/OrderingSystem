package com.ordering.exceptions;

public class LoginFailedException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5276865246483501472L;

	public LoginFailedException() {
		super();
	}

	public LoginFailedException(String message, Throwable cause) {
		super(message, cause);
	}

	public LoginFailedException(String message) {
		super(message);
	}

	public LoginFailedException(Throwable cause) {
		super(cause);
	}

	
}
