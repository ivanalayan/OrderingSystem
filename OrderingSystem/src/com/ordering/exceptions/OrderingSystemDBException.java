package com.ordering.exceptions;

import java.sql.SQLException;

public class OrderingSystemDBException extends SQLException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4228291893057359638L;

	public OrderingSystemDBException() {
		super();
	}

	public OrderingSystemDBException(String reason, String sqlState,
			int vendorCode, Throwable cause) {
		super(reason, sqlState, vendorCode, cause);
	}

	public OrderingSystemDBException(String reason, String SQLState,
			int vendorCode) {
		super(reason, SQLState, vendorCode);
	}

	public OrderingSystemDBException(String reason, String sqlState,
			Throwable cause) {
		super(reason, sqlState, cause);
	}

	public OrderingSystemDBException(String reason, String SQLState) {
		super(reason, SQLState);
	}

	public OrderingSystemDBException(String reason, Throwable cause) {
		super(reason, cause);
	}

	public OrderingSystemDBException(String reason) {
		super(reason);
	}

	public OrderingSystemDBException(Throwable cause) {
		super(cause);
	}

}
