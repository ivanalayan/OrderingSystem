package com.ordering.exceptions;

public class OrderFailedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrderFailedException() {
		super();
	}

	public OrderFailedException(String message, Throwable cause) {
		super(message, cause);
	}

	public OrderFailedException(String message) {
		super(message);
	}

	public OrderFailedException(Throwable cause) {
		super(cause);
	}

	
}
