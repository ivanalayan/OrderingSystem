package com.ordering.dao;

import com.ordering.exceptions.LoginFailedException;
import com.ordering.exceptions.OrderingSystemDBException;
import com.ordering.exceptions.UsernameAlreadyExistException;
import com.ordering.models.Customer;

public interface CustomerDAO {

	public void addCustomer(Customer customer)
			throws OrderingSystemDBException, UsernameAlreadyExistException;
 
	public Customer getCustomerDetailsAccountOf(String username, String password) throws OrderingSystemDBException, LoginFailedException;
}
